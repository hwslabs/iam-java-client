package com.hypto.iam.client;

import com.hypto.iam.client.api.KeyManagementApi;
import com.hypto.iam.client.exceptions.IamApiException;
import com.hypto.iam.client.model.KeyResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.SigningKeyResolverAdapter;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.time.Instant;
import java.util.Base64;
import java.util.HashMap;
import retrofit2.Response;

public class SigningKeyResolver extends SigningKeyResolverAdapter {
    static final int cacheRefreshInterval = 60 * 10; // 10 minutes
    static Instant lastRefreshTime = Instant.now();
    static HashMap<String, Key> keysMap = new HashMap<>();

    private ApiClient apiClient;

    SigningKeyResolver(ApiClient apiClient) {
        if (apiClient != null) {
            this.apiClient = apiClient;
        } else {
            throw new IllegalArgumentException("apiClient cannot be null");
        }
    }

    SigningKeyResolver() {
        this(new ApiClient());
    }

    @Override
    public Key resolveSigningKey(JwsHeader jwsHeader, Claims claims) {
        String keyId = jwsHeader.getKeyId();

        if (lastRefreshTime.plusSeconds(cacheRefreshInterval).isBefore(Instant.now())) {
            keysMap.clear();
            lastRefreshTime = Instant.now();
        }

        if (keysMap.containsKey(keyId)) return keysMap.get(keyId);

        KeyManagementApi apiInstance = this.apiClient.createService(KeyManagementApi.class);
        try {
            Response<KeyResponse> response = apiInstance.getKey(keyId, "der", "public").execute();
            if (!response.isSuccessful() || response.body() == null) {
                throw new IamApiException(response.message());
            }
            KeyResponse result = response.body();
            byte[] encodedPublicKey = Base64.getDecoder().decode(result.getKey());
            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encodedPublicKey);
            Key publicKey = keyFactory.generatePublic(keySpec);
            keysMap.put(keyId, publicKey);
            return publicKey;
        } catch (IamApiException
                | IOException
                | NoSuchAlgorithmException
                | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
}
