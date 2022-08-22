package com.hypto.iam.client;

import com.hypto.iam.client.api.UserAuthorizationApi;
import com.hypto.iam.client.model.ResourceAction;
import com.hypto.iam.client.model.ResourceActionEffect;

import com.hypto.iam.client.model.TokenResponse;
import com.hypto.iam.client.model.ValidationRequest;
import com.hypto.iam.client.model.ValidationResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.apache.commons.io.IOUtils;
import org.casbin.jcasbin.main.CoreEnforcer;
import org.casbin.jcasbin.main.Enforcer;
import org.casbin.jcasbin.model.Model;
import org.casbin.jcasbin.persist.file_adapter.FileAdapter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;


public class Validator {
    static final String USER_CLAIM = "usr";
    static final String ENTITLEMENTS_CLAIM = "entitlements";
    static final String ORGANIZATION_CLAIM = "org";
    static final String ISSUER = "https://iam.hypto.com";
    static final String VERSION_NUM = "1.0";
    static final String VERSION_CLAIM = "ver";
    static final Model model;

    public ApiClient apiClient = Configuration.getDefaultApiClient();
    public Claims claims;
    public Enforcer enforcer;
    public String principal;
    public String organizationId;

    static {
        InputStream in = Objects.requireNonNull(Validator.class.getResourceAsStream("/casbin_model.conf"));
        String casbinModel;
        try {
            casbinModel = IOUtils.toString(in, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        model = CoreEnforcer.newModel(casbinModel);
    }

    public Validator setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
        return this;
    }

    public Validator(String token, boolean skipValidation) {
        if (skipValidation) {
            String unsignedToken = token.substring(0, token.lastIndexOf(".")+1);
            this.claims = Jwts.parserBuilder().build().parseClaimsJwt(unsignedToken).getBody();
        } else {
            SigningKeyResolver signingKeyResolver = new SigningKeyResolver(apiClient);
            Jws<Claims> jws = Jwts.parserBuilder().setSigningKeyResolver(signingKeyResolver).build().parseClaimsJws(token);
            this.claims = jws.getBody();
        }

        this.principal = this.claims.get(USER_CLAIM, String.class);
        this.organizationId = this.claims.get(ORGANIZATION_CLAIM, String.class);
        String entitlements = this.claims.get(ENTITLEMENTS_CLAIM, String.class);

        assert this.claims.getIssuer().equals(ISSUER);
        assert this.claims.get(VERSION_CLAIM, String.class).equals(VERSION_NUM);

        this.enforcer = new Enforcer(model, new FileAdapter(
                new ByteArrayInputStream(entitlements.getBytes(StandardCharsets.UTF_8))));
    }

    public Validator(String token) {
        this(token, false);
    }

    public Validator(TokenResponse tokenResponse) {
        this(tokenResponse.getToken());
    }

    public boolean validate(String resourceHrn, String actionHrn, boolean isLocal) {
        return isLocal?validateLocal(resourceHrn, actionHrn):validateRemote(resourceHrn, actionHrn);
    }

    public boolean validate(String resourceHrn, String actionHrn) {
        return validateLocal(resourceHrn, actionHrn);
    }

    boolean validateLocal(String resourceHrn, String actionHrn) {
        return enforcer.enforce(this.principal, resourceHrn, actionHrn);
    }

    boolean validateRemote(String resourceHrn, String actionHrn) {
        UserAuthorizationApi apiInstance = new UserAuthorizationApi(apiClient);
        ValidationRequest request = new ValidationRequest().addValidationsItem(
                new ResourceAction().resource(resourceHrn).action(actionHrn));

        try {
            ValidationResponse response = apiInstance.validate(request);
            return response.getResults().get(0).getEffect() == ResourceActionEffect.EffectEnum.ALLOW;
        } catch (ApiException e) {
            e.printStackTrace();
            return false;
        }
    }
}
