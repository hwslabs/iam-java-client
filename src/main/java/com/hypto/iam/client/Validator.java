package com.hypto.iam.client;

import com.hypto.iam.client.api.UserAuthorizationApi;
import com.hypto.iam.client.exceptions.IamAuthenticationException;
import com.hypto.iam.client.model.ResourceAction;
import com.hypto.iam.client.model.ResourceActionEffect;
import com.hypto.iam.client.model.TokenResponse;
import com.hypto.iam.client.model.ValidationRequest;
import com.hypto.iam.client.model.ValidationResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.regex.Pattern;

import jdk.internal.joptsimple.util.RegexMatcher;
import org.apache.commons.io.IOUtils;
import org.casbin.jcasbin.main.CoreEnforcer;
import org.casbin.jcasbin.main.Enforcer;
import org.casbin.jcasbin.persist.file_adapter.FileAdapter;
import retrofit2.Response;

public class Validator {

    public static class ValidatorConfig {
        private final ApiClient apiClient;
        private final SigningKeyResolver signingKeyResolver;

        private final boolean skipSignatureValidation;

        public ValidatorConfig(
                ApiClient apiClient,
                SigningKeyResolver signingKeyResolver,
                boolean skipSignatureValidation) {
            this.apiClient = apiClient;
            this.signingKeyResolver = signingKeyResolver;
            this.skipSignatureValidation = skipSignatureValidation;
        }

        public ValidatorConfig(ApiClient apiClient, SigningKeyResolver signingKeyResolver) {
            this(apiClient, signingKeyResolver, false);
        }

        public ValidatorConfig(ApiClient apiClient, boolean skipSignatureValidation) {
            this(apiClient, new SigningKeyResolver(apiClient), skipSignatureValidation);
        }

        public ValidatorConfig(ApiClient apiClient) {
            this(apiClient, false);
        }

        public ValidatorConfig() {
            this(new ApiClient());
        }
    }

    private static final String USER_CLAIM = "usr";
    private static final String ENTITLEMENTS_CLAIM = "entitlements";
    private static final String ORGANIZATION_CLAIM = "org";
    private static final String ISSUER = "https://iam.hypto.com";
    private static final String VERSION_NUM = "1.0";
    private static final String VERSION_CLAIM = "ver";
    private static final String casbinModel;

    private static final String RESOURCE_HRN_REGEX =
            "^hrn:(?<organization>[^:\n]+):" +
                    "(?<subOrganization>[^:\n]*):(?<resource>[^:/\n]*)/?(?<resourceInstance>[^/\n:]*)";

    public Claims claims;
    public Enforcer enforcer;

    public String getPrincipal() {
        return principal;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    private String principal;
    private String organizationId;

    private String subOrganizationId;

    public ValidatorConfig config;

    static {
        InputStream in =
                Objects.requireNonNull(Validator.class.getResourceAsStream("/casbin_model.conf"));
        try {
            casbinModel = IOUtils.toString(in, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Validator(String token, ValidatorConfig config) throws IamAuthenticationException {
        this.config = config;
        if (config.skipSignatureValidation) {
            String unsignedToken = token.substring(0, token.lastIndexOf(".") + 1);
            this.claims = Jwts.parserBuilder().build().parseClaimsJwt(unsignedToken).getBody();
        } else {
            Jws<Claims> jws =
                    Jwts.parserBuilder()
                            .setSigningKeyResolver(config.signingKeyResolver)
                            .build()
                            .parseClaimsJws(token);
            this.claims = jws.getBody();
        }

        this.principal = this.claims.get(USER_CLAIM, String.class);
        if (!this.principal.matches(RESOURCE_HRN_REGEX)) {
            throw new IamAuthenticationException("Not a valid hrn string format");
        }
        Pattern resourceHrnPattern = Pattern.compile(RESOURCE_HRN_REGEX);
        this.subOrganizationId = resourceHrnPattern.matcher(this.principal).group(2);
        this.organizationId = this.claims.get(ORGANIZATION_CLAIM, String.class);
        final String entitlements = this.claims.get(ENTITLEMENTS_CLAIM, String.class);

        if (!ISSUER.equals(this.claims.getIssuer())) {
            throw new IamAuthenticationException("Invalid issuer");
        }

        if (!VERSION_NUM.equals(this.claims.get(VERSION_CLAIM, String.class))) {
            throw new IamAuthenticationException("Invalid version");
        }

        this.enforcer =
                new Enforcer(
                        CoreEnforcer.newModel(casbinModel),
                        new FileAdapter(
                                new ByteArrayInputStream(
                                        entitlements.getBytes(StandardCharsets.UTF_8))));
    }

    public Validator(String token) throws IamAuthenticationException {
        this(token, new ValidatorConfig());
    }

    public Validator(TokenResponse tokenResponse) throws IamAuthenticationException {
        this(tokenResponse.getToken());
    }

    public boolean validate(String resourceHrn, String actionHrn, boolean isLocal) {
        return isLocal
                ? validateLocal(resourceHrn, actionHrn)
                : validateRemote(resourceHrn, actionHrn);
    }

    public boolean validate(String resourceHrn, String actionHrn) {
        return validateLocal(resourceHrn, actionHrn);
    }

    boolean validateLocal(String resourceHrn, String actionHrn) {
        return enforcer.enforce(this.principal, resourceHrn, actionHrn);
    }

    public boolean validateRemote(String resourceHrn, String actionHrn) {
        if (this.config.apiClient == null) {
            throw new IllegalStateException("ApiClient is not initialized");
        }

        UserAuthorizationApi apiInstance =
                config.apiClient.createService(UserAuthorizationApi.class);

        ValidationRequest request =
                new ValidationRequest()
                        .addValidationsItem(
                                new ResourceAction().resource(resourceHrn).action(actionHrn));

        try {
            Response<ValidationResponse> response = apiInstance.validate(request).execute();
            if (response.isSuccessful() && response.body() != null) {
                return response.body().getResults().get(0).getEffect()
                        == ResourceActionEffect.EffectEnum.ALLOW;
            }
            return false;
        } catch (IOException e) {
            return false;
        }
    }
}
