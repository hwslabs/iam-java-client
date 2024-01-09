package com.hypto.iam.client.api;


import com.hypto.iam.client.CollectionFormats.*;
import com.hypto.iam.client.model.GetDelegateTokenRequest;
import com.hypto.iam.client.model.TokenResponse;
import com.hypto.iam.client.model.ValidationRequest;
import com.hypto.iam.client.model.ValidationResponse;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserAuthorizationApi {
    /**
     * Generate a delegate token Generate a token with ad-hoc principal on behalf of an user with
     * permissions to a policy to which the user has delegate rights.
     *
     * @param getDelegateTokenRequest Payload to generate a delegate-able token (required)
     * @return Call&lt;TokenResponse&gt;
     */
    @Headers({"Content-Type:application/json"})
    @POST("delegate_token")
    Call<TokenResponse> getDelegateToken(
            @retrofit2.http.Body GetDelegateTokenRequest getDelegateTokenRequest);

    /**
     * Generate a token Generate a token for the given user credential (same as
     * /organizations/{organization_id}/token at the moment. Might change in future)
     *
     * @return Call&lt;TokenResponse&gt;
     */
    @POST("token")
    Call<TokenResponse> getToken();

    /**
     * Generate a organization_id scoped token Generate a token for the given user credential scoped
     * by the provided organization_id
     *
     * @param organizationId (required)
     * @return Call&lt;TokenResponse&gt;
     */
    @POST("organizations/{organization_id}/token")
    Call<TokenResponse> getTokenForOrg(
            @retrofit2.http.Path("organization_id") String organizationId);

    /**
     * Generate a organization_id scoped token Generate a token for the given user credential scoped
     * by the provided organization_id
     *
     * @param organizationId (required)
     * @param subOrganizationName (required)
     * @return Call&lt;TokenResponse&gt;
     */
    @POST("organizations/{organization_id}/sub_organizations/{sub_organization_name}/token")
    Call<TokenResponse> getTokenForSubOrg(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("sub_organization_name") String subOrganizationName);

    /**
     * Validate an auth request Validate if the caller has access to resource-action in the request
     *
     * @param validationRequest Payload to validate if a user has access to a resource-action
     *     (required)
     * @return Call&lt;ValidationResponse&gt;
     */
    @Headers({"Content-Type:application/json"})
    @POST("validate")
    Call<ValidationResponse> validate(@retrofit2.http.Body ValidationRequest validationRequest);

    @Headers({"Content-Type:application/json"})
    @POST("delegate_token")
    Call<TokenResponse> getDelegateToken(
            @retrofit2.http.Body GetDelegateTokenRequest getDelegateTokenRequest,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @POST("token")
    Call<TokenResponse> getToken(@retrofit2.http.HeaderMap Map<String, String> headers);

    @POST("organizations/{organization_id}/token")
    Call<TokenResponse> getTokenForOrg(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @POST("organizations/{organization_id}/sub_organizations/{sub_organization_name}/token")
    Call<TokenResponse> getTokenForSubOrg(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("sub_organization_name") String subOrganizationName,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @Headers({"Content-Type:application/json"})
    @POST("validate")
    Call<ValidationResponse> validate(
            @retrofit2.http.Body ValidationRequest validationRequest,
            @retrofit2.http.HeaderMap Map<String, String> headers);
}
