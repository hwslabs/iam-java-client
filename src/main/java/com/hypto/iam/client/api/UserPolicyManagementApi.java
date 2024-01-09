package com.hypto.iam.client.api;


import com.hypto.iam.client.CollectionFormats.*;
import com.hypto.iam.client.model.BaseSuccessResponse;
import com.hypto.iam.client.model.PolicyAssociationRequest;
import com.hypto.iam.client.model.PolicyPaginatedResponse;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserPolicyManagementApi {
    /**
     * Attach policies to user Attach policies to user
     *
     * @param userName (required)
     * @param organizationId (required)
     * @param policyAssociationRequest Payload to attach / detach a policy to a user / resource
     *     (required)
     * @return Call&lt;BaseSuccessResponse&gt;
     */
    @Headers({"Content-Type:application/json"})
    @PATCH("organizations/{organization_id}/users/{user_name}/attach_policies")
    Call<BaseSuccessResponse> attachPolicies(
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Body PolicyAssociationRequest policyAssociationRequest);

    /**
     * Attach policies to user Attach policies to user
     *
     * @param userName (required)
     * @param organizationId (required)
     * @param subOrganizationName (required)
     * @param policyAssociationRequest Payload to attach / detach a policy to a user / resource
     *     (required)
     * @return Call&lt;BaseSuccessResponse&gt;
     */
    @Headers({"Content-Type:application/json"})
    @PATCH(
            "organizations/{organization_id}/sub_organizations/{sub_organization_name}/users/{user_name}/attach_policies")
    Call<BaseSuccessResponse> attachSubOrganizationPolicies(
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("sub_organization_name") String subOrganizationName,
            @retrofit2.http.Body PolicyAssociationRequest policyAssociationRequest);

    /**
     * Detach policies from user Detach policies from user
     *
     * @param userName (required)
     * @param organizationId (required)
     * @param policyAssociationRequest Payload to attach / detach a policy to a user / resource
     *     (required)
     * @return Call&lt;BaseSuccessResponse&gt;
     */
    @Headers({"Content-Type:application/json"})
    @PATCH("organizations/{organization_id}/users/{user_name}/detach_policies")
    Call<BaseSuccessResponse> detachPolicies(
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Body PolicyAssociationRequest policyAssociationRequest);

    /**
     * Detach policies from user Detach policies from user
     *
     * @param userName (required)
     * @param organizationId (required)
     * @param subOrganizationName (required)
     * @param policyAssociationRequest Payload to attach / detach a policy to a user / resource
     *     (required)
     * @return Call&lt;BaseSuccessResponse&gt;
     */
    @Headers({"Content-Type:application/json"})
    @PATCH(
            "organizations/{organization_id}/sub_organizations/{sub_organization_name}/users/{user_name}/detach_policies")
    Call<BaseSuccessResponse> detachSubOrganizationPolicies(
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("sub_organization_name") String subOrganizationName,
            @retrofit2.http.Body PolicyAssociationRequest policyAssociationRequest);

    /**
     * List all policies associated with user List all policies associated with user
     *
     * @param userName (required)
     * @param organizationId (required)
     * @param subOrganizationName (required)
     * @param nextToken (optional)
     * @param pageSize (optional)
     * @param sortOrder (optional)
     * @return Call&lt;PolicyPaginatedResponse&gt;
     */
    @GET(
            "organizations/{organization_id}/sub_organizations/{sub_organization_name}/users/{user_name}/policies")
    Call<PolicyPaginatedResponse> getSubOrganizationUserPolicies(
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("sub_organization_name") String subOrganizationName,
            @retrofit2.http.Query("nextToken") String nextToken,
            @retrofit2.http.Query("pageSize") String pageSize,
            @retrofit2.http.Query("sortOrder") String sortOrder);

    /**
     * List all policies associated with user List all policies associated with user
     *
     * @param userName (required)
     * @param organizationId (required)
     * @param nextToken (optional)
     * @param pageSize (optional)
     * @param sortOrder (optional)
     * @return Call&lt;PolicyPaginatedResponse&gt;
     */
    @GET("organizations/{organization_id}/users/{user_name}/policies")
    Call<PolicyPaginatedResponse> getUserPolicies(
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Query("nextToken") String nextToken,
            @retrofit2.http.Query("pageSize") String pageSize,
            @retrofit2.http.Query("sortOrder") String sortOrder);

    @Headers({"Content-Type:application/json"})
    @PATCH("organizations/{organization_id}/users/{user_name}/attach_policies")
    Call<BaseSuccessResponse> attachPolicies(
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Body PolicyAssociationRequest policyAssociationRequest,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @Headers({"Content-Type:application/json"})
    @PATCH(
            "organizations/{organization_id}/sub_organizations/{sub_organization_name}/users/{user_name}/attach_policies")
    Call<BaseSuccessResponse> attachSubOrganizationPolicies(
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("sub_organization_name") String subOrganizationName,
            @retrofit2.http.Body PolicyAssociationRequest policyAssociationRequest,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @Headers({"Content-Type:application/json"})
    @PATCH("organizations/{organization_id}/users/{user_name}/detach_policies")
    Call<BaseSuccessResponse> detachPolicies(
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Body PolicyAssociationRequest policyAssociationRequest,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @Headers({"Content-Type:application/json"})
    @PATCH(
            "organizations/{organization_id}/sub_organizations/{sub_organization_name}/users/{user_name}/detach_policies")
    Call<BaseSuccessResponse> detachSubOrganizationPolicies(
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("sub_organization_name") String subOrganizationName,
            @retrofit2.http.Body PolicyAssociationRequest policyAssociationRequest,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @GET(
            "organizations/{organization_id}/sub_organizations/{sub_organization_name}/users/{user_name}/policies")
    Call<PolicyPaginatedResponse> getSubOrganizationUserPolicies(
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("sub_organization_name") String subOrganizationName,
            @retrofit2.http.Query("nextToken") String nextToken,
            @retrofit2.http.Query("pageSize") String pageSize,
            @retrofit2.http.Query("sortOrder") String sortOrder,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @GET("organizations/{organization_id}/users/{user_name}/policies")
    Call<PolicyPaginatedResponse> getUserPolicies(
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Query("nextToken") String nextToken,
            @retrofit2.http.Query("pageSize") String pageSize,
            @retrofit2.http.Query("sortOrder") String sortOrder,
            @retrofit2.http.HeaderMap Map<String, String> headers);
}
