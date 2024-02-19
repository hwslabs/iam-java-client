package com.hypto.iam.client.api;

import com.hypto.iam.client.CollectionFormats.*;
import com.hypto.iam.client.model.AuthProviderPaginatedResponse;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.*;

public interface AuthProvidersApi {
    /**
     * List auth providers List all available auth providers. This is a paginated api which returns
     * the list of auth providers with a next page token.
     *
     * @param nextToken (optional)
     * @param pageSize (optional)
     * @return Call&lt;AuthProviderPaginatedResponse&gt;
     */
    @GET("auth_providers")
    Call<AuthProviderPaginatedResponse> listAuthProviders(
            @retrofit2.http.Query("nextToken") String nextToken,
            @retrofit2.http.Query("pageSize") String pageSize);

    @GET("auth_providers")
    Call<AuthProviderPaginatedResponse> listAuthProviders(
            @retrofit2.http.Query("nextToken") String nextToken,
            @retrofit2.http.Query("pageSize") String pageSize,
            @retrofit2.http.HeaderMap Map<String, String> headers);
}
