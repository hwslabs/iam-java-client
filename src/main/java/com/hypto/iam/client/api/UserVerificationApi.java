package com.hypto.iam.client.api;


import com.hypto.iam.client.CollectionFormats.*;
import com.hypto.iam.client.model.BaseSuccessResponse;
import com.hypto.iam.client.model.VerifyEmailRequest;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserVerificationApi {
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

    @Headers({"Content-Type:application/json"})
    @POST("verifyEmail")
    Call<BaseSuccessResponse> verifyEmail(
            @retrofit2.http.Body VerifyEmailRequest verifyEmailRequest,
            @retrofit2.http.HeaderMap Map<String, String> headers);
}
