package com.hypto.iam.client.helpers;

import com.hypto.iam.client.SigningKeyResolver;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.powermock.reflect.Whitebox;

import java.security.Key;
import java.security.KeyPair;
import java.util.Date;
import java.util.HashMap;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TokenHelper {
    private static final String ISSUER = "https://iam.hypto.com";
    private static final String VERSION_CLAIM = "ver";
    private static final String USER_CLAIM = "usr";
    private static final String ORGANIZATION_CLAIM = "org";
    private static final String ENTITLEMENTS_CLAIM = "entitlements";
    private static final String VERSION_NUM = "1.0";

    public static String generateJwtToken(String userHrn, String organizationId, String entitlements, Date issuedAt, Date expiresAt) {
        KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.ES256);

        String testKeyId = "testKeyId";
        HashMap<String, Key> keysMap = mock(HashMap.class);
        when(keysMap.containsKey(eq(testKeyId))).thenReturn(true);
        when(keysMap.get(eq(testKeyId))).thenReturn(keyPair.getPublic());

        Whitebox.setInternalState(SigningKeyResolver.class, "keysMap", keysMap);

        return
                Jwts.builder()
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

    public static String generateJwtToken(String userHrn, String organizationId, String entitlements) {
        return generateJwtToken(userHrn, organizationId, entitlements, new Date(),
                new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24)));
    }

}
