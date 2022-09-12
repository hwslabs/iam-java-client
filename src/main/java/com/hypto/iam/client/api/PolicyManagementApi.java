package com.hypto.iam.client.api;

import com.hypto.iam.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import com.hypto.iam.client.model.BaseSuccessResponse;
import com.hypto.iam.client.model.CreatePolicyRequest;
import com.hypto.iam.client.model.ErrorResponse;
import com.hypto.iam.client.model.Policy;
import com.hypto.iam.client.model.PolicyPaginatedResponse;
import com.hypto.iam.client.model.UpdatePolicyRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PolicyManagementApi {
  /**
   * Create a policy
   * Create a policy
   * @param organizationId  (required)
   * @param createPolicyRequest Payload to create policy (required)
   * @return Call&lt;Policy&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("organizations/{organization_id}/policies")
  Call<Policy> createPolicy(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.Body CreatePolicyRequest createPolicyRequest
  );

  /**
   * Delete a policy
   * Delete a policy
   * @param organizationId  (required)
   * @param policyName  (required)
   * @return Call&lt;BaseSuccessResponse&gt;
   */
  @DELETE("organizations/{organization_id}/policies/{policy_name}")
  Call<BaseSuccessResponse> deletePolicy(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.Path("policy_name") String policyName
  );

  /**
   * Get a policy
   * Get a policy
   * @param organizationId  (required)
   * @param policyName  (required)
   * @return Call&lt;Policy&gt;
   */
  @GET("organizations/{organization_id}/policies/{policy_name}")
  Call<Policy> getPolicy(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.Path("policy_name") String policyName
  );

  /**
   * List policies
   * List policies
   * @param organizationId  (required)
   * @param nextToken  (optional)
   * @param pageSize  (optional)
   * @param sortOrder  (optional)
   * @return Call&lt;PolicyPaginatedResponse&gt;
   */
  @GET("organizations/{organization_id}/policies")
  Call<PolicyPaginatedResponse> listPolicies(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.Query("nextToken") String nextToken, @retrofit2.http.Query("pageSize") String pageSize, @retrofit2.http.Query("sortOrder") String sortOrder
  );

  /**
   * Update a policy
   * Update a policy
   * @param organizationId  (required)
   * @param policyName  (required)
   * @param updatePolicyRequest Payload to update policy (required)
   * @return Call&lt;Policy&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("organizations/{organization_id}/policies/{policy_name}")
  Call<Policy> updatePolicy(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.Path("policy_name") String policyName, @retrofit2.http.Body UpdatePolicyRequest updatePolicyRequest
  );


  @Headers({
    "Content-Type:application/json"
  })
  @POST("organizations/{organization_id}/policies")
  Call<Policy> createPolicy(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.Body CreatePolicyRequest createPolicyRequest, @retrofit2.http.HeaderMap Map<String, String> headers
  );
  @DELETE("organizations/{organization_id}/policies/{policy_name}")
  Call<BaseSuccessResponse> deletePolicy(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.Path("policy_name") String policyName, @retrofit2.http.HeaderMap Map<String, String> headers
  );
  @GET("organizations/{organization_id}/policies/{policy_name}")
  Call<Policy> getPolicy(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.Path("policy_name") String policyName, @retrofit2.http.HeaderMap Map<String, String> headers
  );
  @GET("organizations/{organization_id}/policies")
  Call<PolicyPaginatedResponse> listPolicies(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.Query("nextToken") String nextToken, @retrofit2.http.Query("pageSize") String pageSize, @retrofit2.http.Query("sortOrder") String sortOrder, @retrofit2.http.HeaderMap Map<String, String> headers
  );
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("organizations/{organization_id}/policies/{policy_name}")
  Call<Policy> updatePolicy(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.Path("policy_name") String policyName, @retrofit2.http.Body UpdatePolicyRequest updatePolicyRequest, @retrofit2.http.HeaderMap Map<String, String> headers
  );
}
