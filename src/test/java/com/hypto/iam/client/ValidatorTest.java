package com.hypto.iam.client;

import com.hypto.iam.client.api.KeyManagementApi;
import com.hypto.iam.client.api.UserAuthorizationApi;
import com.hypto.iam.client.helpers.TokenHelper;
import com.hypto.iam.client.model.ResourceActionEffect;
import com.hypto.iam.client.model.ValidationRequest;
import com.hypto.iam.client.model.ValidationResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Date;

// PowerMockIgnore is used to ignore the classes as it messes up with some classes
// https://stackoverflow.com/questions/14654639/when-a-trustmanagerfactory-is-not-a-trustmanagerfactory-java
@PowerMockIgnore({"jdk.internal.reflect.*", "javax.net.ssl.*"})
@RunWith(PowerMockRunner.class)
@PrepareForTest({KeyManagementApi.class, UserAuthorizationApi.class})
public class ValidatorTest {

    @Test(expected = MalformedJwtException.class)
    public void failIfWrongToken() {
        Validator validator = new Validator("wrongToken");
    }


    @Test
    public void testGetUserHrn() {
        final String organizationId = "wkqmk8N7EM";
        final String userHrn = String.format("hrn:%s::iam-user/name1",organizationId);
        final String sampleEntitlements = String.format(
                "p, hrn:%1$s::iam-policy/ROOT_USER_POLICY, hrn:%1$s, hrn:%1$s:*, allow\n" +
                "p, hrn:%1$s::iam-policy/ROOT_USER_POLICY, hrn:%1$s::*, hrn:%1$s::*, allow\n\n" +
                "g, %2$s, hrn:%1$s::iam-policy/ROOT_USER_POLICY\n", organizationId, userHrn);

        final String tokenStr = TokenHelper.generateJwtToken(userHrn, organizationId, sampleEntitlements, new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24)), new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24)));

        Validator validator = new Validator(tokenStr);
        assert validator.principal.equals(userHrn);
        assert validator.organizationId.equals(organizationId);
    }

    @Test(expected = ExpiredJwtException.class)
    public void failIfTokenExpired() {
        final String organizationId = "wkqmk8N7EM";
        final String userHrn = String.format("hrn:%s::iam-user/name1",organizationId);
        final String sampleEntitlements = String.format(
                "p, hrn:%1$s::iam-policy/ROOT_USER_POLICY, hrn:%1$s, hrn:%1$s:*, allow\n" +
                "p, hrn:%1$s::iam-policy/ROOT_USER_POLICY, hrn:%1$s::*, hrn:%1$s::*, allow\n\n" +
                "g, %2$s, hrn:%1$s::iam-policy/ROOT_USER_POLICY\n", organizationId, userHrn);

        final String tokenStr = TokenHelper.generateJwtToken(userHrn, organizationId, sampleEntitlements, new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24)), new Date(System.currentTimeMillis() - 100));

        new Validator(tokenStr);
    }

    @Test
    public void testPermissions() {
        final String organizationId = "wkqmk8N7EM";
        final String userHrn = String.format("hrn:%s::iam-user/name1",organizationId);
        final String sampleEntitlements = String.format(
                "p, hrn:%1$s::iam-policy/policy_view_invoice2, hrn:%1$s::invoice/1, hrn:%1$s::invoice$view, deny\n" +
                "p, hrn:%1$s::iam-policy/policy_view_invoice2, hrn:%1$s::invoice/*, hrn:%1$s::invoice$view, allow\n" +
                "g, %2$s, hrn:%1$s::iam-policy/policy_view_invoice2", organizationId, userHrn);

        final String tokenStr = TokenHelper.generateJwtToken(userHrn, organizationId, sampleEntitlements);

        Validator validator = new Validator(tokenStr);
        assert !validator.validate("hrn:wkqmk8N7EM::invoice/1", "hrn:wkqmk8N7EM::invoice$view");
        assert validator.validate("hrn:wkqmk8N7EM::invoice/2", "hrn:wkqmk8N7EM::invoice$view");
    }

    @Test
    public void testRemote() {
        final String organizationId = "wkqmk8N7EM";
        final String userHrn = String.format("hrn:%s::iam-user/name1",organizationId);
        final String sampleEntitlements = String.format(
                "p, hrn:%1$s::iam-policy/policy_view_invoice2, hrn:%1$s::invoice/1, hrn:%1$s::invoice$view, allow\n" +
                "g, %2$s, hrn:%1$s::iam-policy/policy_view_invoice2", organizationId, userHrn);

        final String tokenStr = TokenHelper.generateJwtToken(userHrn, organizationId, sampleEntitlements);

        Validator validator = new Validator(tokenStr);

        PowerMockito.stub(PowerMockito.method(UserAuthorizationApi.class, "validate", ValidationRequest.class))
                .toReturn(new ValidationResponse().addResultsItem(new ResourceActionEffect().effect(ResourceActionEffect.EffectEnum.ALLOW)));

        assert validator.validate("hrn:wkqmk8N7EM::invoice/1", "hrn:wkqmk8N7EM::invoice$view", false);
    }

    @Test
    public void testSkipValidation() {
        final String organizationId = "wkqmk8N7EM";
        final String userHrn = String.format("hrn:%s::iam-user/name1",organizationId);
        final String sampleEntitlements = String.format(
                "p, hrn:%1$s::iam-policy/ROOT_USER_POLICY, hrn:%1$s, hrn:%1$s:*, allow\n" +
                        "p, hrn:%1$s::iam-policy/ROOT_USER_POLICY, hrn:%1$s::*, hrn:%1$s::*, allow\n\n" +
                        "g, %2$s, hrn:%1$s::iam-policy/ROOT_USER_POLICY\n", organizationId, userHrn);

        final String tokenStr = TokenHelper.generateJwtToken(userHrn, organizationId, sampleEntitlements);

        Validator validator = new Validator(tokenStr, true);
        assert validator.organizationId.equals(organizationId);
        assert validator.principal.equals(userHrn);
    }

}