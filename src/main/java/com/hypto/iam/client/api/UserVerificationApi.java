package com.hypto.iam.client.api;


import com.hypto.iam.client.CollectionFormats.*;
import com.hypto.iam.client.model.BaseSuccessResponse;
import com.hypto.iam.client.model.PasscodePaginatedResponse;
import com.hypto.iam.client.model.ResendInviteRequest;
import com.hypto.iam.client.model.VerifyEmailRequest;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserVerificationApi {
    /**
     * Get organization passcodes Get passcodes for the organization
     *
     * @param organizationId (required)
     * @return Call&lt;PasscodePaginatedResponse&gt;
     */
    @GET("organization/{organization_id}/invites")
    Call<PasscodePaginatedResponse> listInvites(
            @retrofit2.http.Path("organization_id") String organizationId);

    /**
     * Resend organization passcodes Resend passcodes for the organization
     *
     * @param organizationId (required)
     * @param resendInviteRequest Payload to resend invite (required)
     * @return Call&lt;BaseSuccessResponse&gt;
     */
    @Headers({"Content-Type:application/json"})
    @POST("organizations/{organization_id}/invites/resend")
    Call<BaseSuccessResponse> resendInvite(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Body ResendInviteRequest resendInviteRequest);

    /**
     * Verify email Verify email during account opening and resetting password
     *
     * @param verifyEmailRequest Payload to send verification link to email (required)
     * @return Call&lt;BaseSuccessResponse&gt;
     */
    @Headers({"Content-Type:application/json"})
    @POST("verifyEmail")
    Call<BaseSuccessResponse> verifyEmail(
            @retrofit2.http.Body VerifyEmailRequest verifyEmailRequest);

    @GET("organization/{organization_id}/invites")
    Call<PasscodePaginatedResponse> listInvites(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @Headers({"Content-Type:application/json"})
    @POST("organizations/{organization_id}/invites/resend")
    Call<BaseSuccessResponse> resendInvite(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Body ResendInviteRequest resendInviteRequest,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @Headers({"Content-Type:application/json"})
    @POST("verifyEmail")
    Call<BaseSuccessResponse> verifyEmail(
            @retrofit2.http.Body VerifyEmailRequest verifyEmailRequest,
            @retrofit2.http.HeaderMap Map<String, String> headers);
}
