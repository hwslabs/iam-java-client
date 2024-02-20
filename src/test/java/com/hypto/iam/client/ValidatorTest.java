package com.hypto.iam.client;

import com.hypto.iam.client.api.UserAuthorizationApi;
import com.hypto.iam.client.exceptions.IamAuthenticationException;
import com.hypto.iam.client.helpers.TokenHelper;
import com.hypto.iam.client.model.ResourceActionEffect;
import com.hypto.iam.client.model.ValidationResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import retrofit2.mock.Calls;

public class ValidatorTest {

    @Test(expected = MalformedJwtException.class)
    public void failIfWrongToken() throws IamAuthenticationException {
        new Validator("wrongToken");
    }

    @Test
    public void testGetUserHrn() throws IamAuthenticationException {
        final String organizationId = "wkqmk8N7EM";
        final String userHrn = String.format("hrn:%s::iam-user/name1", organizationId);
        final String sampleEntitlements =
                String.format(
                        "p, hrn:%1$s::iam-policy/ROOT_USER_POLICY, hrn:%1$s, hrn:%1$s:*, allow\n"
                            + "p, hrn:%1$s::iam-policy/ROOT_USER_POLICY, hrn:%1$s::*, hrn:%1$s::*,"
                            + " allow\n\n"
                            + "g, %2$s, hrn:%1$s::iam-policy/ROOT_USER_POLICY\n",
                        organizationId, userHrn);

        ApiClient client = Mockito.mock(ApiClient.class);
        TokenHelper.mockApiClient(client);
        com.hypto.iam.client.Validator.ValidatorConfig config =
                new Validator.ValidatorConfig(client);

        final String tokenStr =
                TokenHelper.generateJwtToken(
                        userHrn,
                        organizationId,
                        sampleEntitlements,
                        new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24)),
                        new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24)));

        Validator validator = new Validator(tokenStr, config);
        Assert.assertEquals(validator.getPrincipal(), userHrn);
        Assert.assertEquals(validator.getOrganizationId(), organizationId);
    }

    @Test(expected = ExpiredJwtException.class)
    public void failIfTokenExpired() throws IamAuthenticationException {
        final String organizationId = "wkqmk8N7EM";
        final String userHrn = String.format("hrn:%s::iam-user/name1", organizationId);
        final String sampleEntitlements =
                String.format(
                        "p, hrn:%1$s::iam-policy/ROOT_USER_POLICY, hrn:%1$s, hrn:%1$s:*, allow\n"
                            + "p, hrn:%1$s::iam-policy/ROOT_USER_POLICY, hrn:%1$s::*, hrn:%1$s::*,"
                            + " allow\n\n"
                            + "g, %2$s, hrn:%1$s::iam-policy/ROOT_USER_POLICY\n",
                        organizationId, userHrn);

        final String tokenStr =
                TokenHelper.generateJwtToken(
                        userHrn,
                        organizationId,
                        sampleEntitlements,
                        new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24)),
                        new Date(System.currentTimeMillis() - 100));

        new Validator(tokenStr);
    }

    @Test
    public void testPermissions() throws IamAuthenticationException {
        final String organizationId = "wkqmk8N7EM";
        final String userHrn = String.format("hrn:%s::iam-user/name1", organizationId);
        final String sampleEntitlements =
                String.format(
                        "p, hrn:%1$s::iam-policy/policy_view_invoice2, hrn:%1$s::invoice/1,"
                            + " hrn:%1$s::invoice\\$view, deny\n"
                            + "p, hrn:%1$s::iam-policy/policy_view_invoice2, hrn:%1$s::invoice/*,"
                            + " hrn:%1$s::invoice\\$view, allow\n"
                            + "g, %2$s, hrn:%1$s::iam-policy/policy_view_invoice2",
                        organizationId, userHrn);

        final String tokenStr =
                TokenHelper.generateJwtToken(userHrn, organizationId, sampleEntitlements);

        Validator validator = new Validator(tokenStr);
        Assert.assertFalse(
                validator.validate("hrn:wkqmk8N7EM::invoice/1", "hrn:wkqmk8N7EM::invoice$view"));
        Assert.assertTrue(
                validator.validate("hrn:wkqmk8N7EM::invoice/2", "hrn:wkqmk8N7EM::invoice$view"));
    }

    @Test
    public void testRemote() throws IamAuthenticationException {
        final String organizationId = "wkqmk8N7EM";
        final String userHrn = String.format("hrn:%s::iam-user/name1", organizationId);
        final String sampleEntitlements =
                String.format(
                        "p, hrn:%1$s::iam-policy/policy_view_invoice2, hrn:%1$s::invoice/1,"
                                + " hrn:%1$s::invoice$view, allow\n"
                                + "g, %2$s, hrn:%1$s::iam-policy/policy_view_invoice2",
                        organizationId, userHrn);

        final String tokenStr =
                TokenHelper.generateJwtToken(userHrn, organizationId, sampleEntitlements);

        ApiClient client = Mockito.mock(ApiClient.class);
        TokenHelper.mockApiClient(client);

        UserAuthorizationApi mockAuthApi = Mockito.mock(UserAuthorizationApi.class);
        Mockito.when(mockAuthApi.validate(Mockito.any()))
                .thenReturn(
                        Calls.response(
                                new ValidationResponse()
                                        .addResultsItem(
                                                new ResourceActionEffect()
                                                        .effect(
                                                                ResourceActionEffect.EffectEnum
                                                                        .ALLOW))));
        Mockito.when(client.createService(Mockito.eq(UserAuthorizationApi.class)))
                .thenReturn(mockAuthApi);
        com.hypto.iam.client.Validator.ValidatorConfig config =
                new Validator.ValidatorConfig(client);

        Validator validator = new Validator(tokenStr, config);

        Assert.assertTrue(
                validator.validate(
                        "hrn:wkqmk8N7EM::invoice/1", "hrn:wkqmk8N7EM::invoice$view", false));
    }

    @Test
    public void testSkipValidation() throws IamAuthenticationException {
        final String organizationId = "wkqmk8N7EM";
        final String userHrn = String.format("hrn:%s::iam-user/name1", organizationId);
        final String sampleEntitlements =
                String.format(
                        "p, hrn:%1$s::iam-policy/ROOT_USER_POLICY, hrn:%1$s, hrn:%1$s:*, allow\n"
                            + "p, hrn:%1$s::iam-policy/ROOT_USER_POLICY, hrn:%1$s::*, hrn:%1$s::*,"
                            + " allow\n\n"
                            + "g, %2$s, hrn:%1$s::iam-policy/ROOT_USER_POLICY\n",
                        organizationId, userHrn);

        ApiClient client = Mockito.mock(ApiClient.class);
        TokenHelper.mockApiClient(client);

        final String tokenStr =
                TokenHelper.generateJwtToken(userHrn, organizationId, sampleEntitlements);

        Validator validator = new Validator(tokenStr, new Validator.ValidatorConfig(client, true));
        Assert.assertEquals(validator.getOrganizationId(), organizationId);
        Assert.assertEquals(validator.getPrincipal(), userHrn);
    }
}
