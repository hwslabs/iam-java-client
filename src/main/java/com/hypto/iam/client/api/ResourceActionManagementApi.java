package com.hypto.iam.client.api;

import com.hypto.iam.client.CollectionFormats.*;
import com.hypto.iam.client.model.Action;
import com.hypto.iam.client.model.ActionPaginatedResponse;
import com.hypto.iam.client.model.BaseSuccessResponse;
import com.hypto.iam.client.model.CreateActionRequest;
import com.hypto.iam.client.model.UpdateActionRequest;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.*;

public interface ResourceActionManagementApi {
    /**
     * Create an action Create an action
     *
     * @param organizationId (required)
     * @param resourceName (required)
     * @param createActionRequest Payload to create action (required)
     * @return Call&lt;Action&gt;
     */
    @Headers({"Content-Type:application/json"})
    @POST("organizations/{organization_id}/resources/{resource_name}/actions")
    Call<Action> createAction(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("resource_name") String resourceName,
            @retrofit2.http.Body CreateActionRequest createActionRequest);

    /**
     * Delete an action Delete an action
     *
     * @param organizationId (required)
     * @param resourceName (required)
     * @param actionName (required)
     * @return Call&lt;BaseSuccessResponse&gt;
     */
    @DELETE("organizations/{organization_id}/resources/{resource_name}/actions/{action_name}")
    Call<BaseSuccessResponse> deleteAction(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("resource_name") String resourceName,
            @retrofit2.http.Path("action_name") String actionName);

    /**
     * Get an action Get an action
     *
     * @param organizationId (required)
     * @param resourceName (required)
     * @param actionName (required)
     * @return Call&lt;Action&gt;
     */
    @GET("organizations/{organization_id}/resources/{resource_name}/actions/{action_name}")
    Call<Action> getAction(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("resource_name") String resourceName,
            @retrofit2.http.Path("action_name") String actionName);

    /**
     * List actions List actions
     *
     * @param organizationId (required)
     * @param resourceName (required)
     * @param nextToken (optional)
     * @param pageSize (optional)
     * @param sortOrder (optional)
     * @return Call&lt;ActionPaginatedResponse&gt;
     */
    @GET("organizations/{organization_id}/resources/{resource_name}/actions")
    Call<ActionPaginatedResponse> listActions(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("resource_name") String resourceName,
            @retrofit2.http.Query("nextToken") String nextToken,
            @retrofit2.http.Query("pageSize") String pageSize,
            @retrofit2.http.Query("sortOrder") String sortOrder);

    /**
     * Update an action Update an action
     *
     * @param organizationId (required)
     * @param resourceName (required)
     * @param actionName (required)
     * @param updateActionRequest Payload to update action (required)
     * @return Call&lt;Action&gt;
     */
    @Headers({"Content-Type:application/json"})
    @PATCH("organizations/{organization_id}/resources/{resource_name}/actions/{action_name}")
    Call<Action> updateAction(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("resource_name") String resourceName,
            @retrofit2.http.Path("action_name") String actionName,
            @retrofit2.http.Body UpdateActionRequest updateActionRequest);

    @Headers({"Content-Type:application/json"})
    @POST("organizations/{organization_id}/resources/{resource_name}/actions")
    Call<Action> createAction(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("resource_name") String resourceName,
            @retrofit2.http.Body CreateActionRequest createActionRequest,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @DELETE("organizations/{organization_id}/resources/{resource_name}/actions/{action_name}")
    Call<BaseSuccessResponse> deleteAction(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("resource_name") String resourceName,
            @retrofit2.http.Path("action_name") String actionName,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @GET("organizations/{organization_id}/resources/{resource_name}/actions/{action_name}")
    Call<Action> getAction(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("resource_name") String resourceName,
            @retrofit2.http.Path("action_name") String actionName,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @GET("organizations/{organization_id}/resources/{resource_name}/actions")
    Call<ActionPaginatedResponse> listActions(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("resource_name") String resourceName,
            @retrofit2.http.Query("nextToken") String nextToken,
            @retrofit2.http.Query("pageSize") String pageSize,
            @retrofit2.http.Query("sortOrder") String sortOrder,
            @retrofit2.http.HeaderMap Map<String, String> headers);

    @Headers({"Content-Type:application/json"})
    @PATCH("organizations/{organization_id}/resources/{resource_name}/actions/{action_name}")
    Call<Action> updateAction(
            @retrofit2.http.Path("organization_id") String organizationId,
            @retrofit2.http.Path("resource_name") String resourceName,
            @retrofit2.http.Path("action_name") String actionName,
            @retrofit2.http.Body UpdateActionRequest updateActionRequest,
            @retrofit2.http.HeaderMap Map<String, String> headers);
}
