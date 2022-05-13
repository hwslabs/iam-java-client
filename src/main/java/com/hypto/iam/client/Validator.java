package com.hypto.iam.client;

import com.hypto.iam.client.api.KeyManagementApi;
import com.hypto.iam.client.api.UserAuthorizationApi;
import com.hypto.iam.client.model.KeyResponse;
import com.hypto.iam.client.model.ResourceAction;
import com.hypto.iam.client.model.ResourceActionEffect;
import com.hypto.iam.client.model.TokenResponse;

import com.hypto.iam.client.model.ValidationRequest;
import com.hypto.iam.client.model.ValidationResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SigningKeyResolverAdapter;
import org.casbin.jcasbin.main.Enforcer;
import org.casbin.jcasbin.persist.file_adapter.FileAdapter;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.time.Instant;
import java.util.Base64;
import java.util.HashMap;
import java.util.Objects;


public class Validator {
    static final String USER_CLAIM = "usr";
    static final String ENTITLEMENTS_CLAIM = "entitlements";
    static final String ISSUER = "https://iam.hypto.com";
    static final String VERSION_NUM = "1.0";
    static final String VERSION_CLAIM = "ver";

    static final String modelPath = Objects.requireNonNull(Validator.class.getClassLoader()
            .getResource("casbin_model.conf")).getFile();
    static final SigningKeyResolver signingKeyResolver = new SigningKeyResolver();

    public Jws<Claims> jws;
    public Enforcer enforcer;
    public String principal;

    public Validator(String token){
        this.jws = Jwts.parserBuilder().setSigningKeyResolver(signingKeyResolver).build().parseClaimsJws(token);

        this.principal = jws.getBody().get(USER_CLAIM, String.class);
        String entitlements = jws.getBody().get(ENTITLEMENTS_CLAIM, String.class);

        assert jws.getBody().getIssuer().equals(ISSUER);
        assert jws.getBody().get(VERSION_CLAIM, String.class).equals(VERSION_NUM);

        this.enforcer = new Enforcer(modelPath, new FileAdapter(
                new ByteArrayInputStream(entitlements.getBytes(StandardCharsets.UTF_8))));
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
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        UserAuthorizationApi apiInstance = new UserAuthorizationApi(defaultClient);
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
