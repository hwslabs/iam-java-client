/*
 * Hypto IAM
 * APIs for Hypto IAM Service.
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: engineering@hypto.in
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.hypto.iam.client.api;

import com.hypto.iam.client.ApiCallback;
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.ApiResponse;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.Pair;
import com.hypto.iam.client.ProgressRequestBody;
import com.hypto.iam.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.hypto.iam.client.model.BaseSuccessResponse;
import com.hypto.iam.client.model.ErrorResponse;
import com.hypto.iam.client.model.PolicyAssociationRequest;
import com.hypto.iam.client.model.PolicyPaginatedResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class UserPolicyManagementApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public UserPolicyManagementApi() {
        this(Configuration.getDefaultApiClient());
    }

    public UserPolicyManagementApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    /**
     * Build call for attachPolicies
     * @param userName  (required)
     * @param organizationId  (required)
     * @param policyAssociationRequest Payload to attach / detach a policy to a user / resource (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 400 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 401 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 403 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 404 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 429 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
     </table>
     */
    public okhttp3.Call attachPoliciesCall(String userName, String organizationId, PolicyAssociationRequest policyAssociationRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = policyAssociationRequest;

        // create path and map variables
        String localVarPath = "/organizations/{organization_id}/users/{user_name}/attach_policies"
            .replaceAll("\\{" + "user_name" + "\\}", localVarApiClient.escapeString(userName.toString()))
            .replaceAll("\\{" + "organization_id" + "\\}", localVarApiClient.escapeString(organizationId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "bearerAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call attachPoliciesValidateBeforeCall(String userName, String organizationId, PolicyAssociationRequest policyAssociationRequest, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'userName' is set
        if (userName == null) {
            throw new ApiException("Missing the required parameter 'userName' when calling attachPolicies(Async)");
        }
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling attachPolicies(Async)");
        }
        
        // verify the required parameter 'policyAssociationRequest' is set
        if (policyAssociationRequest == null) {
            throw new ApiException("Missing the required parameter 'policyAssociationRequest' when calling attachPolicies(Async)");
        }
        

        okhttp3.Call localVarCall = attachPoliciesCall(userName, organizationId, policyAssociationRequest, _callback);
        return localVarCall;

    }

    /**
     * Attach policies to user
     * Attach policies to user
     * @param userName  (required)
     * @param organizationId  (required)
     * @param policyAssociationRequest Payload to attach / detach a policy to a user / resource (required)
     * @return BaseSuccessResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 400 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 401 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 403 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 404 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 429 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
     </table>
     */
    public BaseSuccessResponse attachPolicies(String userName, String organizationId, PolicyAssociationRequest policyAssociationRequest) throws ApiException {
        ApiResponse<BaseSuccessResponse> localVarResp = attachPoliciesWithHttpInfo(userName, organizationId, policyAssociationRequest);
        return localVarResp.getData();
    }

    /**
     * Attach policies to user
     * Attach policies to user
     * @param userName  (required)
     * @param organizationId  (required)
     * @param policyAssociationRequest Payload to attach / detach a policy to a user / resource (required)
     * @return ApiResponse&lt;BaseSuccessResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 400 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 401 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 403 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 404 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 429 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
     </table>
     */
    public ApiResponse<BaseSuccessResponse> attachPoliciesWithHttpInfo(String userName, String organizationId, PolicyAssociationRequest policyAssociationRequest) throws ApiException {
        okhttp3.Call localVarCall = attachPoliciesValidateBeforeCall(userName, organizationId, policyAssociationRequest, null);
        Type localVarReturnType = new TypeToken<BaseSuccessResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Attach policies to user (asynchronously)
     * Attach policies to user
     * @param userName  (required)
     * @param organizationId  (required)
     * @param policyAssociationRequest Payload to attach / detach a policy to a user / resource (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 400 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 401 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 403 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 404 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 429 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
     </table>
     */
    public okhttp3.Call attachPoliciesAsync(String userName, String organizationId, PolicyAssociationRequest policyAssociationRequest, final ApiCallback<BaseSuccessResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = attachPoliciesValidateBeforeCall(userName, organizationId, policyAssociationRequest, _callback);
        Type localVarReturnType = new TypeToken<BaseSuccessResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for detachPolicies
     * @param userName  (required)
     * @param organizationId  (required)
     * @param policyAssociationRequest Payload to attach / detach a policy to a user / resource (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 400 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 401 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 403 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 404 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 429 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
     </table>
     */
    public okhttp3.Call detachPoliciesCall(String userName, String organizationId, PolicyAssociationRequest policyAssociationRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = policyAssociationRequest;

        // create path and map variables
        String localVarPath = "/organizations/{organization_id}/users/{user_name}/detach_policies"
            .replaceAll("\\{" + "user_name" + "\\}", localVarApiClient.escapeString(userName.toString()))
            .replaceAll("\\{" + "organization_id" + "\\}", localVarApiClient.escapeString(organizationId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "bearerAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call detachPoliciesValidateBeforeCall(String userName, String organizationId, PolicyAssociationRequest policyAssociationRequest, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'userName' is set
        if (userName == null) {
            throw new ApiException("Missing the required parameter 'userName' when calling detachPolicies(Async)");
        }
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling detachPolicies(Async)");
        }
        
        // verify the required parameter 'policyAssociationRequest' is set
        if (policyAssociationRequest == null) {
            throw new ApiException("Missing the required parameter 'policyAssociationRequest' when calling detachPolicies(Async)");
        }
        

        okhttp3.Call localVarCall = detachPoliciesCall(userName, organizationId, policyAssociationRequest, _callback);
        return localVarCall;

    }

    /**
     * Detach policies from user
     * Detach policies from user
     * @param userName  (required)
     * @param organizationId  (required)
     * @param policyAssociationRequest Payload to attach / detach a policy to a user / resource (required)
     * @return BaseSuccessResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 400 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 401 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 403 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 404 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 429 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
     </table>
     */
    public BaseSuccessResponse detachPolicies(String userName, String organizationId, PolicyAssociationRequest policyAssociationRequest) throws ApiException {
        ApiResponse<BaseSuccessResponse> localVarResp = detachPoliciesWithHttpInfo(userName, organizationId, policyAssociationRequest);
        return localVarResp.getData();
    }

    /**
     * Detach policies from user
     * Detach policies from user
     * @param userName  (required)
     * @param organizationId  (required)
     * @param policyAssociationRequest Payload to attach / detach a policy to a user / resource (required)
     * @return ApiResponse&lt;BaseSuccessResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 400 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 401 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 403 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 404 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 429 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
     </table>
     */
    public ApiResponse<BaseSuccessResponse> detachPoliciesWithHttpInfo(String userName, String organizationId, PolicyAssociationRequest policyAssociationRequest) throws ApiException {
        okhttp3.Call localVarCall = detachPoliciesValidateBeforeCall(userName, organizationId, policyAssociationRequest, null);
        Type localVarReturnType = new TypeToken<BaseSuccessResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Detach policies from user (asynchronously)
     * Detach policies from user
     * @param userName  (required)
     * @param organizationId  (required)
     * @param policyAssociationRequest Payload to attach / detach a policy to a user / resource (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 400 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 401 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 403 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 404 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 429 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
     </table>
     */
    public okhttp3.Call detachPoliciesAsync(String userName, String organizationId, PolicyAssociationRequest policyAssociationRequest, final ApiCallback<BaseSuccessResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = detachPoliciesValidateBeforeCall(userName, organizationId, policyAssociationRequest, _callback);
        Type localVarReturnType = new TypeToken<BaseSuccessResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getUserPolicies
     * @param userName  (required)
     * @param organizationId  (required)
     * @param nextToken  (optional)
     * @param pageSize  (optional)
     * @param sortOrder  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Response for list policies request and list policies for user request </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 400 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 401 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 403 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 404 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 429 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
     </table>
     */
    public okhttp3.Call getUserPoliciesCall(String userName, String organizationId, String nextToken, String pageSize, String sortOrder, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/organizations/{organization_id}/users/{user_name}/policies"
            .replaceAll("\\{" + "user_name" + "\\}", localVarApiClient.escapeString(userName.toString()))
            .replaceAll("\\{" + "organization_id" + "\\}", localVarApiClient.escapeString(organizationId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (nextToken != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("nextToken", nextToken));
        }

        if (pageSize != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("pageSize", pageSize));
        }

        if (sortOrder != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("sortOrder", sortOrder));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "bearerAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getUserPoliciesValidateBeforeCall(String userName, String organizationId, String nextToken, String pageSize, String sortOrder, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'userName' is set
        if (userName == null) {
            throw new ApiException("Missing the required parameter 'userName' when calling getUserPolicies(Async)");
        }
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling getUserPolicies(Async)");
        }
        

        okhttp3.Call localVarCall = getUserPoliciesCall(userName, organizationId, nextToken, pageSize, sortOrder, _callback);
        return localVarCall;

    }

    /**
     * List all policies associated with user
     * List all policies associated with user
     * @param userName  (required)
     * @param organizationId  (required)
     * @param nextToken  (optional)
     * @param pageSize  (optional)
     * @param sortOrder  (optional)
     * @return PolicyPaginatedResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Response for list policies request and list policies for user request </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 400 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 401 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 403 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 404 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 429 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
     </table>
     */
    public PolicyPaginatedResponse getUserPolicies(String userName, String organizationId, String nextToken, String pageSize, String sortOrder) throws ApiException {
        ApiResponse<PolicyPaginatedResponse> localVarResp = getUserPoliciesWithHttpInfo(userName, organizationId, nextToken, pageSize, sortOrder);
        return localVarResp.getData();
    }

    /**
     * List all policies associated with user
     * List all policies associated with user
     * @param userName  (required)
     * @param organizationId  (required)
     * @param nextToken  (optional)
     * @param pageSize  (optional)
     * @param sortOrder  (optional)
     * @return ApiResponse&lt;PolicyPaginatedResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Response for list policies request and list policies for user request </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 400 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 401 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 403 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 404 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 429 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
     </table>
     */
    public ApiResponse<PolicyPaginatedResponse> getUserPoliciesWithHttpInfo(String userName, String organizationId, String nextToken, String pageSize, String sortOrder) throws ApiException {
        okhttp3.Call localVarCall = getUserPoliciesValidateBeforeCall(userName, organizationId, nextToken, pageSize, sortOrder, null);
        Type localVarReturnType = new TypeToken<PolicyPaginatedResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List all policies associated with user (asynchronously)
     * List all policies associated with user
     * @param userName  (required)
     * @param organizationId  (required)
     * @param nextToken  (optional)
     * @param pageSize  (optional)
     * @param sortOrder  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Response for list policies request and list policies for user request </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 400 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 401 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 403 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 404 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 429 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  </td></tr>
     </table>
     */
    public okhttp3.Call getUserPoliciesAsync(String userName, String organizationId, String nextToken, String pageSize, String sortOrder, final ApiCallback<PolicyPaginatedResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getUserPoliciesValidateBeforeCall(userName, organizationId, nextToken, pageSize, sortOrder, _callback);
        Type localVarReturnType = new TypeToken<PolicyPaginatedResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
