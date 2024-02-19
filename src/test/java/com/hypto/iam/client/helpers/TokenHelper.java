package com.hypto.iam.client.helpers;

import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.api.KeyManagementApi;
import com.hypto.iam.client.model.KeyResponse;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.KeyPair;
import java.util.Base64;
import java.util.Date;
import org.apache.commons.lang3.RandomStringUtils;
import org.mockito.Mockito;
import retrofit2.mock.Calls;

public class TokenHelper {
    private static final String ISSUER = "https://iam.hypto.com";
    private static final String VERSION_CLAIM = "ver";
    private static final String USER_CLAIM = "usr";
    private static final String ORGANIZATION_CLAIM = "org";
    private static final String ENTITLEMENTS_CLAIM = "entitlements";
    private static final String VERSION_NUM = "1.0";

    private static final KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.ES256);

    private static final String publicKey =
            Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());

    private static final String testKeyId = RandomStringUtils.random(10);

    public static void mockApiClient(ApiClient client) {
        final KeyResponse response =
                new KeyResponse()
                        .key(publicKey)
                        .format(KeyResponse.FormatEnum.DER)
                        .status("SIGNING")
                        .kid(testKeyId);

        final KeyManagementApi mockKeyApi = Mockito.mock(KeyManagementApi.class);
        Mockito.when(mockKeyApi.getKey(Mockito.any(), Mockito.any(), Mockito.any()))
                .thenReturn(Calls.response(response));
        Mockito.when(client.createService(Mockito.eq(KeyManagementApi.class)))
                .thenReturn(mockKeyApi);
    }

    public static String generateJwtToken(
            String userHrn,
            String organizationId,
            String entitlements,
            Date issuedAt,
            Date expiresAt) {
        return Jwts.builder()
                .setIssuer(ISSUER)
                .setHeaderParam(JwsHeader.KEY_ID, testKeyId)
                .setIssuedAt(issuedAt)
                .setExpiration(expiresAt)
                .claim(VERSION_CLAIM, VERSION_NUM)
                .claim(USER_CLAIM, userHrn) // UserId
                .claim(ORGANIZATION_CLAIM, organizationId) // OrganizationId
                .claim(ENTITLEMENTS_CLAIM, entitlements) // Entitlements
                .signWith(keyPair.getPrivate(), SignatureAlgorithm.ES256)
                .compressWith(CompressionCodecs.GZIP)
                .compact();
    }

    public static String generateJwtToken(
            String userHrn, String organizationId, String entitlements) {
        return generateJwtToken(
                userHrn,
                organizationId,
                entitlements,
                new Date(),
                new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24)));
    }
}
