package com.hypto.iam.client.api;

import com.hypto.iam.client.CollectionFormats.*;
import com.hypto.iam.client.model.BaseSuccessResponse;
import com.hypto.iam.client.model.CreateSubOrganizationRequest;
import com.hypto.iam.client.model.CreateSubOrganizationResponse;
import com.hypto.iam.client.model.SubOrganization;
import com.hypto.iam.client.model.SubOrganizationsPaginatedResponse;
import com.hypto.iam.client.model.UpdateSubOrganizationRequest;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.*;

public interface SubOrganizationManagementApi {
    /**
     * Create a sub organization under an organization. Sub organization provides a way to create a
     * hierarchy of organizations to easily manage resources at each levels. Create a sub
     * organization under an organization.
     *
     * @param organizationId (required)
     * @param createSubOrganizationRequest Payload to create sub organization (required)
     * @return Call&lt;CreateSubOrganizationResponse&gt;
     */
    @Headers({"Content-Type:application/json"})
    @POST("organizations/{organization_id}/sub_organizations")
    Call<CreateSubOrganizationResponse> createSubOrganization(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Body CreateSubOrganizationRequest createSubOrganizationRequest);

    /**
     * Delete a sub organization Delete a sub organization. This is a privileged api and only
     * internal application will have access to delete sub organization.
     *
     * @param organizationId (required)
     * @param subOrganizationName (required)
     * @return Call&lt;BaseSuccessResponse&gt;
     */
    @DELETE("organizations/{organization_id}/sub_organizations/{sub_organization_name}")
    Call<BaseSuccessResponse> deleteSubOrganization(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("sub_organization_name") String subOrganizationName);

    /**
     * Get a sub organization Get a sub organization and the metadata for the given sub
     * organization.
     *
     * @param organizationId (required)
     * @param subOrganizationName (required)
     * @return Call&lt;SubOrganization&gt;
     */
    @GET("organizations/{organization_id}/sub_organizations/{sub_organization_name}")
    Call<SubOrganization> getSubOrganization(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("sub_organization_name") String subOrganizationName);

    /**
     * List sub organizations under an organization. List all sub organizations under an
     * organization.
     *
     * @param organizationId (required)
     * @return Call&lt;SubOrganizationsPaginatedResponse&gt;
     */
    @GET("organizations/{organization_id}/sub_organizations")
    Call<SubOrganizationsPaginatedResponse> listSubOrganizations(
            @retrofit2.http.Path("organization_id") String organizationId);

    /**
     * Update a sub organization Update a sub organization
     *
     * @param organizationId (required)
     * @param subOrganizationName (required)
     * @param updateSubOrganizationRequest Payload to update sub organization (required)
     * @return Call&lt;SubOrganization&gt;
     */
    @Headers({"Content-Type:application/json"})
    @PATCH("organizations/{organization_id}/sub_organizations/{sub_organization_name}")
    Call<SubOrganization> updateSubOrganization(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("sub_organization_name") String subOrganizationName,
            @retrofit2.http.Body UpdateSubOrganizationRequest updateSubOrganizationRequest);

    @Headers({"Content-Type:application/json"})
    @POST("organizations/{organization_id}/sub_organizations")
    Call<CreateSubOrganizationResponse> createSubOrganization(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Body CreateSubOrganizationRequest createSubOrganizationRequest,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @DELETE("organizations/{organization_id}/sub_organizations/{sub_organization_name}")
    Call<BaseSuccessResponse> deleteSubOrganization(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("sub_organization_name") String subOrganizationName,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @GET("organizations/{organization_id}/sub_organizations/{sub_organization_name}")
    Call<SubOrganization> getSubOrganization(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("sub_organization_name") String subOrganizationName,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @GET("organizations/{organization_id}/sub_organizations")
    Call<SubOrganizationsPaginatedResponse> listSubOrganizations(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @Headers({"Content-Type:application/json"})
    @PATCH("organizations/{organization_id}/sub_organizations/{sub_organization_name}")
    Call<SubOrganization> updateSubOrganization(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("sub_organization_name") String subOrganizationName,
            @retrofit2.http.Body UpdateSubOrganizationRequest updateSubOrganizationRequest,
            @retrofit2.http.HeaderMap Map<String, String> headers);
}
