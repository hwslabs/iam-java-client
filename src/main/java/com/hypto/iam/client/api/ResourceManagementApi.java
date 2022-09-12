package com.hypto.iam.client.api;

import com.hypto.iam.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import com.hypto.iam.client.model.BaseSuccessResponse;
import com.hypto.iam.client.model.CreateResourceRequest;
import com.hypto.iam.client.model.ErrorResponse;
import com.hypto.iam.client.model.Resource;
import com.hypto.iam.client.model.ResourcePaginatedResponse;
import com.hypto.iam.client.model.UpdateResourceRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ResourceManagementApi {
  /**
   * Create a resource name in an organization.
   * Creates a resource name. Access policies can be associated with the instances of these resources. ex - \\\&quot;Wallet\\\&quot; is a resource name in the organization org - \\\&quot;Org#1\\\&quot; and \\\&quot;wallet#1\\\&quot; is the instance of the resource \\\&quot;Wallet\\\&quot;. Policies on which user to access the wallet#1 can be created by the user having privilege to access the resource.
   * @param organizationId  (required)
   * @param createResourceRequest Payload to create resource (required)
   * @return Call&lt;Resource&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("organizations/{organization_id}/resources")
  Call<Resource> createResource(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.Body CreateResourceRequest createResourceRequest
  );

  /**
   * Delete a resource
   * Delete a resource
   * @param organizationId  (required)
   * @param resourceName  (required)
   * @return Call&lt;BaseSuccessResponse&gt;
   */
  @DELETE("organizations/{organization_id}/resources/{resource_name}")
  Call<BaseSuccessResponse> deleteResource(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.Path("resource_name") String resourceName
  );

  /**
   * Get the resource details
   * Gets the resource details associated with the organization
   * @param organizationId  (required)
   * @param resourceName  (required)
   * @return Call&lt;Resource&gt;
   */
  @GET("organizations/{organization_id}/resources/{resource_name}")
  Call<Resource> getResource(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.Path("resource_name") String resourceName
  );

  /**
   * List Resources
   * List all the resource names in an organization.
   * @param organizationId  (required)
   * @param nextToken  (optional)
   * @param pageSize  (optional)
   * @param sortOrder  (optional)
   * @return Call&lt;ResourcePaginatedResponse&gt;
   */
  @GET("organizations/{organization_id}/resources")
  Call<ResourcePaginatedResponse> listResources(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.Query("nextToken") String nextToken, @retrofit2.http.Query("pageSize") String pageSize, @retrofit2.http.Query("sortOrder") String sortOrder
  );

  /**
   * Update a resource
   * Update resource name of the organization
   * @param organizationId  (required)
   * @param resourceName  (required)
   * @param updateResourceRequest Payload to update resource (required)
   * @return Call&lt;Resource&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("organizations/{organization_id}/resources/{resource_name}")
  Call<Resource> updateResource(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.Path("resource_name") String resourceName, @retrofit2.http.Body UpdateResourceRequest updateResourceRequest
  );


  @Headers({
    "Content-Type:application/json"
  })
  @POST("organizations/{organization_id}/resources")
  Call<Resource> createResource(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.Body CreateResourceRequest createResourceRequest, @retrofit2.http.HeaderMap Map<String, String> headers
  );
  @DELETE("organizations/{organization_id}/resources/{resource_name}")
  Call<BaseSuccessResponse> deleteResource(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.Path("resource_name") String resourceName, @retrofit2.http.HeaderMap Map<String, String> headers
  );
  @GET("organizations/{organization_id}/resources/{resource_name}")
  Call<Resource> getResource(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.Path("resource_name") String resourceName, @retrofit2.http.HeaderMap Map<String, String> headers
  );
  @GET("organizations/{organization_id}/resources")
  Call<ResourcePaginatedResponse> listResources(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.Query("nextToken") String nextToken, @retrofit2.http.Query("pageSize") String pageSize, @retrofit2.http.Query("sortOrder") String sortOrder, @retrofit2.http.HeaderMap Map<String, String> headers
  );
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("organizations/{organization_id}/resources/{resource_name}")
  Call<Resource> updateResource(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.Path("resource_name") String resourceName, @retrofit2.http.Body UpdateResourceRequest updateResourceRequest, @retrofit2.http.HeaderMap Map<String, String> headers
  );
}
