package com.hypto.iam.client.api;

import com.hypto.iam.client.model.CreateOrganizationResponse;
import retrofit2.Call;
import retrofit2.http.POST;

import java.util.Map;

public interface CustomOrganizationManagementApi extends OrganizationManagementApi {
    /**
     * This is special case of OrganizationManagementApi.createOrganization where the body is empty.
     * As retrofit does not allow null/empty body, we have to implement this as a separate function.
     * GitHub Issue: <a href="https://github.com/square/retrofit/issues/1488">Issue 1488</a>
     *
     * @return Call&lt;CreateOrganizationResponse&gt;
     */
    @POST("organizations")
    Call<CreateOrganizationResponse> createOrganization();

    @POST("organizations")
    Call<CreateOrganizationResponse> createOrganization(@retrofit2.http.HeaderMap Map<String, String> headers);
}