package com.hypto.iam.client.api;

import com.hypto.iam.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import com.hypto.iam.client.model.BaseSuccessResponse;
import com.hypto.iam.client.model.CreateOrganizationRequest;
import com.hypto.iam.client.model.CreateOrganizationResponse;
import com.hypto.iam.client.model.ErrorResponse;
import com.hypto.iam.client.model.Organization;
import com.hypto.iam.client.model.UpdateOrganizationRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OrganizationManagementApi {
  /**
   * Creates an organization.
   * Organization is the top level entity. All resources (like user, actions, policies) are created and managed under an organization. This is a privileged api and only internal applications has access to create an Organization.
   * @param createOrganizationRequest Payload to create organization (required)
   * @return Call&lt;CreateOrganizationResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("organizations")
  Call<CreateOrganizationResponse> createOrganization(
    @retrofit2.http.Body CreateOrganizationRequest createOrganizationRequest
  );

  /**
   * Delete an organization
   * Delete an organization. This is a privileged api and only internal application will have access to delete organization.
   * @param organizationId  (required)
   * @return Call&lt;BaseSuccessResponse&gt;
   */
  @DELETE("organizations/{organization_id}")
  Call<BaseSuccessResponse> deleteOrganization(
    @retrofit2.http.Path("organization_id") String organizationId
  );

  /**
   * Get an organization
   * Get an organization and the metadata for the given organization.
   * @param organizationId  (required)
   * @return Call&lt;Organization&gt;
   */
  @GET("organizations/{organization_id}")
  Call<Organization> getOrganization(
    @retrofit2.http.Path("organization_id") String organizationId
  );

  /**
   * Update an organization
   * Update an organization
   * @param organizationId  (required)
   * @param updateOrganizationRequest Payload to update organization (required)
   * @return Call&lt;Organization&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("organizations/{organization_id}")
  Call<Organization> updateOrganization(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.Body UpdateOrganizationRequest updateOrganizationRequest
  );


  @Headers({
    "Content-Type:application/json"
  })
  @POST("organizations")
  Call<CreateOrganizationResponse> createOrganization(
    @retrofit2.http.Body CreateOrganizationRequest createOrganizationRequest, @retrofit2.http.HeaderMap Map<String, String> headers
  );
  @DELETE("organizations/{organization_id}")
  Call<BaseSuccessResponse> deleteOrganization(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.HeaderMap Map<String, String> headers
  );
  @GET("organizations/{organization_id}")
  Call<Organization> getOrganization(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.HeaderMap Map<String, String> headers
  );
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("organizations/{organization_id}")
  Call<Organization> updateOrganization(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.Body UpdateOrganizationRequest updateOrganizationRequest, @retrofit2.http.HeaderMap Map<String, String> headers
  );
}
