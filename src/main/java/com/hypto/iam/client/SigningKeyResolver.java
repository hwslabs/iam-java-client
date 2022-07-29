package com.hypto.iam.client;

import com.hypto.iam.client.api.KeyManagementApi;
import com.hypto.iam.client.model.KeyResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.SigningKeyResolverAdapter;
import io.swagger.annotations.Api;

import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.time.Instant;
import java.util.Base64;
import java.util.HashMap;

public class SigningKeyResolver extends SigningKeyResolverAdapter {
    static final int cacheRefreshInterval = 60 * 10; // 10 minutes
    static Instant lastRefreshTime = Instant.now();
    static HashMap<String, Key> keysMap = new HashMap<>();

    private final ApiClient apiClient;

    SigningKeyResolver(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    SigningKeyResolver() {
        this.apiClient = Configuration.getDefaultApiClient();
    }

    @Override
    public Key resolveSigningKey(JwsHeader jwsHeader, Claims claims) {
        String keyId = jwsHeader.getKeyId();

        if (lastRefreshTime.plusSeconds(cacheRefreshInterval).isBefore(Instant.now())) {
            keysMap.clear();
            lastRefreshTime = Instant.now();
        }

        if (keysMap.containsKey(keyId))
            return keysMap.get(keyId);

        KeyManagementApi apiInstance = new KeyManagementApi(this.apiClient);
        try {
            KeyResponse result = apiInstance.getKey(keyId, "der", "public");
            byte[] encodedPublicKey = Base64.getDecoder().decode(result.getKey());
            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encodedPublicKey);
            Key publicKey = keyFactory.generatePublic(keySpec);
            keysMap.put(keyId, publicKey);
            return publicKey;
        } catch (ApiException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return null;
    }
}
