package com.hypto.iam.client.api;


import com.hypto.iam.client.CollectionFormats.*;
import com.hypto.iam.client.model.BaseSuccessResponse;
import com.hypto.iam.client.model.CreateCredentialRequest;
import com.hypto.iam.client.model.Credential;
import com.hypto.iam.client.model.CredentialWithoutSecret;
import com.hypto.iam.client.model.ListCredentialResponse;
import com.hypto.iam.client.model.UpdateCredentialRequest;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserCredentialManagementApi {
    /**
     * Create a new credential for a user Create a new credential for a user. This API returns the
     * credential&#39;s secret key, which will be available only in the response of this API.
     *
     * @param userName (required)
     * @param organizationId (required)
     * @param createCredentialRequest Payload to create credential (required)
     * @return Call&lt;Credential&gt;
     */
    @Headers({"Content-Type:application/json"})
    @POST("organizations/{organization_id}/users/{user_name}/credentials")
    Call<Credential> createCredential(
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Body CreateCredentialRequest createCredentialRequest);

    /**
     * Create a new credential for a user Create a new credential for a user. This API returns the
     * credential&#39;s secret key, which will be available only in the response of this API.
     *
     * @param userName (required)
     * @param organizationId (required)
     * @param subOrganizationName (required)
     * @param createCredentialRequest Payload to create credential (required)
     * @return Call&lt;Credential&gt;
     */
    @Headers({"Content-Type:application/json"})
    @POST(
            "organizations/{organization_id}/sub_organizations/{sub_organization_name}/users/{user_name}/credentials")
    Call<Credential> createSubOrganizationCredential(
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("sub_organization_name") String subOrganizationName,
            @retrofit2.http.Body CreateCredentialRequest createCredentialRequest);

    /**
     * Delete a credential Delete a credential associated with the user
     *
     * @param organizationId (required)
     * @param userName (required)
     * @param credentialId (required)
     * @return Call&lt;BaseSuccessResponse&gt;
     */
    @DELETE("organizations/{organization_id}/users/{user_name}/credentials/{credential_id}")
    Call<BaseSuccessResponse> deleteCredential(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("credential_id") String credentialId);

    /**
     * Delete a credential Delete a credential associated with the user
     *
     * @param organizationId (required)
     * @param subOrganizationName (required)
     * @param userName (required)
     * @param credentialId (required)
     * @return Call&lt;BaseSuccessResponse&gt;
     */
    @DELETE(
            "organizations/{organization_id}/sub_organizations/{sub_organization_name}/users/{user_name}/credentials/{credential_id}")
    Call<BaseSuccessResponse> deleteSubOrganizationCredential(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("sub_organization_name") String subOrganizationName,
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("credential_id") String credentialId);

    /**
     * Gets credential for the user Gets credential for the user, given the credential id
     *
     * @param organizationId (required)
     * @param userName (required)
     * @param credentialId (required)
     * @return Call&lt;CredentialWithoutSecret&gt;
     */
    @GET("organizations/{organization_id}/users/{user_name}/credentials/{credential_id}")
    Call<CredentialWithoutSecret> getCredential(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("credential_id") String credentialId);

    /**
     * Gets credential for the user Gets credential for the user, given the credential id
     *
     * @param organizationId (required)
     * @param subOrganizationName (required)
     * @param userName (required)
     * @param credentialId (required)
     * @return Call&lt;CredentialWithoutSecret&gt;
     */
    @GET(
            "organizations/{organization_id}/sub_organizations/{sub_organization_name}/users/{user_name}/credentials/{credential_id}")
    Call<CredentialWithoutSecret> getSubOrganizationCredential(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("sub_organization_name") String subOrganizationName,
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("credential_id") String credentialId);

    /**
     * List all credentials for a user List all credentials for a user
     *
     * @param userName (required)
     * @param organizationId (required)
     * @return Call&lt;ListCredentialResponse&gt;
     */
    @GET("organizations/{organization_id}/users/{user_name}/credentials")
    Call<ListCredentialResponse> listCredentials(
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("organization_id") String organizationId);

    /**
     * List all credentials for a user List all credentials for a user
     *
     * @param userName (required)
     * @param organizationId (required)
     * @param subOrganizationName (required)
     * @return Call&lt;ListCredentialResponse&gt;
     */
    @GET(
            "organizations/{organization_id}/sub_organizations/{sub_organization_name}/users/{user_name}/credentials")
    Call<ListCredentialResponse> listSubOrganizationCredentials(
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("sub_organization_name") String subOrganizationName);

    /**
     * Update the status of credential Update the status of credential to ACTIVE/INACTIVE.
     * Credentials which are marked INACTIVE cannot be used to fetch short-term tokens.
     *
     * @param organizationId (required)
     * @param userName (required)
     * @param credentialId (required)
     * @param updateCredentialRequest Payload to update credential (required)
     * @return Call&lt;CredentialWithoutSecret&gt;
     */
    @Headers({"Content-Type:application/json"})
    @PATCH("organizations/{organization_id}/users/{user_name}/credentials/{credential_id}")
    Call<CredentialWithoutSecret> updateCredential(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("credential_id") String credentialId,
            @retrofit2.http.Body UpdateCredentialRequest updateCredentialRequest);

    /**
     * Update the status of credential Update the status of credential to ACTIVE/INACTIVE.
     * Credentials which are marked INACTIVE cannot be used to fetch short-term tokens.
     *
     * @param organizationId (required)
     * @param subOrganizationName (required)
     * @param userName (required)
     * @param credentialId (required)
     * @param updateCredentialRequest Payload to update credential (required)
     * @return Call&lt;CredentialWithoutSecret&gt;
     */
    @Headers({"Content-Type:application/json"})
    @PATCH(
            "organizations/{organization_id}/sub_organizations/{sub_organization_name}/users/{user_name}/credentials/{credential_id}")
    Call<CredentialWithoutSecret> updateSubOrganizationCredential(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("sub_organization_name") String subOrganizationName,
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("credential_id") String credentialId,
            @retrofit2.http.Body UpdateCredentialRequest updateCredentialRequest);

    @Headers({"Content-Type:application/json"})
    @POST("organizations/{organization_id}/users/{user_name}/credentials")
    Call<Credential> createCredential(
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Body CreateCredentialRequest createCredentialRequest,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @Headers({"Content-Type:application/json"})
    @POST(
            "organizations/{organization_id}/sub_organizations/{sub_organization_name}/users/{user_name}/credentials")
    Call<Credential> createSubOrganizationCredential(
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("sub_organization_name") String subOrganizationName,
            @retrofit2.http.Body CreateCredentialRequest createCredentialRequest,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @DELETE("organizations/{organization_id}/users/{user_name}/credentials/{credential_id}")
    Call<BaseSuccessResponse> deleteCredential(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("credential_id") String credentialId,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @DELETE(
            "organizations/{organization_id}/sub_organizations/{sub_organization_name}/users/{user_name}/credentials/{credential_id}")
    Call<BaseSuccessResponse> deleteSubOrganizationCredential(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("sub_organization_name") String subOrganizationName,
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("credential_id") String credentialId,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @GET("organizations/{organization_id}/users/{user_name}/credentials/{credential_id}")
    Call<CredentialWithoutSecret> getCredential(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("credential_id") String credentialId,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @GET(
            "organizations/{organization_id}/sub_organizations/{sub_organization_name}/users/{user_name}/credentials/{credential_id}")
    Call<CredentialWithoutSecret> getSubOrganizationCredential(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("sub_organization_name") String subOrganizationName,
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("credential_id") String credentialId,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @GET("organizations/{organization_id}/users/{user_name}/credentials")
    Call<ListCredentialResponse> listCredentials(
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @GET(
            "organizations/{organization_id}/sub_organizations/{sub_organization_name}/users/{user_name}/credentials")
    Call<ListCredentialResponse> listSubOrganizationCredentials(
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("sub_organization_name") String subOrganizationName,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @Headers({"Content-Type:application/json"})
    @PATCH("organizations/{organization_id}/users/{user_name}/credentials/{credential_id}")
    Call<CredentialWithoutSecret> updateCredential(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("credential_id") String credentialId,
            @retrofit2.http.Body UpdateCredentialRequest updateCredentialRequest,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @Headers({"Content-Type:application/json"})
    @PATCH(
            "organizations/{organization_id}/sub_organizations/{sub_organization_name}/users/{user_name}/credentials/{credential_id}")
    Call<CredentialWithoutSecret> updateSubOrganizationCredential(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("sub_organization_name") String subOrganizationName,
            @retrofit2.http.Path("user_name") String userName,
            @retrofit2.http.Path("credential_id") String credentialId,
            @retrofit2.http.Body UpdateCredentialRequest updateCredentialRequest,
            @retrofit2.http.HeaderMap Map<String, String> headers);
}
