package com.hypto.iam.client.api;

import com.hypto.iam.client.CollectionFormats.*;
import com.hypto.iam.client.model.UserAuthMethodsResponse;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserAuthorizationMethodsManagementApi {
    /**
     * Gets authorization methods of a user entity associated with the organization Get
     * authorization methods of a User
     *
     * @param userName (required)
     * @param organizationId (required)
     * @return Call&lt;UserAuthMethodsResponse&gt;
     */
    @GET("organizations/{organization_id}/users/{user_name}/auth_methods")
    Call<UserAuthMethodsResponse> getUserAuthMethods(
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("organization_id") String organizationId);

    @GET("organizations/{organization_id}/users/{user_name}/auth_methods")
    Call<UserAuthMethodsResponse> getUserAuthMethods(
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.HeaderMap Map<String, String> headers);
}
