# UserPolicyManagementApi

All URIs are relative to *https://sandbox-iam.us.hypto.com/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**attachPolicies**](UserPolicyManagementApi.md#attachPolicies) | **PATCH** organizations/{organization_id}/users/{user_name}/attach_policies | Attach policies to user |
| [**attachSubOrganizationPolicies**](UserPolicyManagementApi.md#attachSubOrganizationPolicies) | **PATCH** organizations/{organization_id}/sub_organizations/{sub_organization_name}/users/{user_name}/attach_policies | Attach policies to user |
| [**detachPolicies**](UserPolicyManagementApi.md#detachPolicies) | **PATCH** organizations/{organization_id}/users/{user_name}/detach_policies | Detach policies from user |
| [**detachSubOrganizationPolicies**](UserPolicyManagementApi.md#detachSubOrganizationPolicies) | **PATCH** organizations/{organization_id}/sub_organizations/{sub_organization_name}/users/{user_name}/detach_policies | Detach policies from user |
| [**getSubOrganizationUserPolicies**](UserPolicyManagementApi.md#getSubOrganizationUserPolicies) | **GET** organizations/{organization_id}/sub_organizations/{sub_organization_name}/users/{user_name}/policies | List all policies associated with user |
| [**getUserPolicies**](UserPolicyManagementApi.md#getUserPolicies) | **GET** organizations/{organization_id}/users/{user_name}/policies | List all policies associated with user |



## attachPolicies

> BaseSuccessResponse attachPolicies(userName, organizationId, policyAssociationRequest)

Attach policies to user

Attach policies to user

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserPolicyManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        UserPolicyManagementApi apiInstance = new UserPolicyManagementApi(defaultClient);
        String userName = "userName_example"; // String | 
        String organizationId = "organizationId_example"; // String | 
        PolicyAssociationRequest policyAssociationRequest = new PolicyAssociationRequest(); // PolicyAssociationRequest | Payload to attach / detach a policy to a user / resource
        try {
            BaseSuccessResponse result = apiInstance.attachPolicies(userName, organizationId, policyAssociationRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserPolicyManagementApi#attachPolicies");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userName** | **String**|  | |
| **organizationId** | **String**|  | |
| **policyAssociationRequest** | [**PolicyAssociationRequest**](PolicyAssociationRequest.md)| Payload to attach / detach a policy to a user / resource | |

### Return type

[**BaseSuccessResponse**](BaseSuccessResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **400** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **401** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **403** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |


## attachSubOrganizationPolicies

> BaseSuccessResponse attachSubOrganizationPolicies(userName, organizationId, subOrganizationName, policyAssociationRequest)

Attach policies to user

Attach policies to user

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserPolicyManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        UserPolicyManagementApi apiInstance = new UserPolicyManagementApi(defaultClient);
        String userName = "userName_example"; // String | 
        String organizationId = "organizationId_example"; // String | 
        String subOrganizationName = "subOrganizationName_example"; // String | 
        PolicyAssociationRequest policyAssociationRequest = new PolicyAssociationRequest(); // PolicyAssociationRequest | Payload to attach / detach a policy to a user / resource
        try {
            BaseSuccessResponse result = apiInstance.attachSubOrganizationPolicies(userName, organizationId, subOrganizationName, policyAssociationRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserPolicyManagementApi#attachSubOrganizationPolicies");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userName** | **String**|  | |
| **organizationId** | **String**|  | |
| **subOrganizationName** | **String**|  | |
| **policyAssociationRequest** | [**PolicyAssociationRequest**](PolicyAssociationRequest.md)| Payload to attach / detach a policy to a user / resource | |

### Return type

[**BaseSuccessResponse**](BaseSuccessResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **400** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **401** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **403** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |


## detachPolicies

> BaseSuccessResponse detachPolicies(userName, organizationId, policyAssociationRequest)

Detach policies from user

Detach policies from user

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserPolicyManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        UserPolicyManagementApi apiInstance = new UserPolicyManagementApi(defaultClient);
        String userName = "userName_example"; // String | 
        String organizationId = "organizationId_example"; // String | 
        PolicyAssociationRequest policyAssociationRequest = new PolicyAssociationRequest(); // PolicyAssociationRequest | Payload to attach / detach a policy to a user / resource
        try {
            BaseSuccessResponse result = apiInstance.detachPolicies(userName, organizationId, policyAssociationRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserPolicyManagementApi#detachPolicies");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userName** | **String**|  | |
| **organizationId** | **String**|  | |
| **policyAssociationRequest** | [**PolicyAssociationRequest**](PolicyAssociationRequest.md)| Payload to attach / detach a policy to a user / resource | |

### Return type

[**BaseSuccessResponse**](BaseSuccessResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **400** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **401** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **403** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |


## detachSubOrganizationPolicies

> BaseSuccessResponse detachSubOrganizationPolicies(userName, organizationId, subOrganizationName, policyAssociationRequest)

Detach policies from user

Detach policies from user

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserPolicyManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        UserPolicyManagementApi apiInstance = new UserPolicyManagementApi(defaultClient);
        String userName = "userName_example"; // String | 
        String organizationId = "organizationId_example"; // String | 
        String subOrganizationName = "subOrganizationName_example"; // String | 
        PolicyAssociationRequest policyAssociationRequest = new PolicyAssociationRequest(); // PolicyAssociationRequest | Payload to attach / detach a policy to a user / resource
        try {
            BaseSuccessResponse result = apiInstance.detachSubOrganizationPolicies(userName, organizationId, subOrganizationName, policyAssociationRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserPolicyManagementApi#detachSubOrganizationPolicies");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userName** | **String**|  | |
| **organizationId** | **String**|  | |
| **subOrganizationName** | **String**|  | |
| **policyAssociationRequest** | [**PolicyAssociationRequest**](PolicyAssociationRequest.md)| Payload to attach / detach a policy to a user / resource | |

### Return type

[**BaseSuccessResponse**](BaseSuccessResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **400** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **401** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **403** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |


## getSubOrganizationUserPolicies

> PolicyPaginatedResponse getSubOrganizationUserPolicies(userName, organizationId, subOrganizationName, nextToken, pageSize, sortOrder)

List all policies associated with user

List all policies associated with user

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserPolicyManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        UserPolicyManagementApi apiInstance = new UserPolicyManagementApi(defaultClient);
        String userName = "userName_example"; // String | 
        String organizationId = "organizationId_example"; // String | 
        String subOrganizationName = "subOrganizationName_example"; // String | 
        String nextToken = "eyJsYXN0SXRlbUlkIjogInN0cmluZyIsICJwYWdlU2l6ZSI6IDEyMywgInNvcnRPcmRlciI6ICJhc2MifQ=="; // String | 
        String pageSize = "10"; // String | 
        String sortOrder = "asc"; // String | 
        try {
            PolicyPaginatedResponse result = apiInstance.getSubOrganizationUserPolicies(userName, organizationId, subOrganizationName, nextToken, pageSize, sortOrder);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserPolicyManagementApi#getSubOrganizationUserPolicies");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userName** | **String**|  | |
| **organizationId** | **String**|  | |
| **subOrganizationName** | **String**|  | |
| **nextToken** | **String**|  | [optional] |
| **pageSize** | **String**|  | [optional] |
| **sortOrder** | **String**|  | [optional] [enum: asc, desc] |

### Return type

[**PolicyPaginatedResponse**](PolicyPaginatedResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Response for list policies request and list policies for user request |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **400** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **401** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **403** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |


## getUserPolicies

> PolicyPaginatedResponse getUserPolicies(userName, organizationId, nextToken, pageSize, sortOrder)

List all policies associated with user

List all policies associated with user

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserPolicyManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        UserPolicyManagementApi apiInstance = new UserPolicyManagementApi(defaultClient);
        String userName = "userName_example"; // String | 
        String organizationId = "organizationId_example"; // String | 
        String nextToken = "eyJsYXN0SXRlbUlkIjogInN0cmluZyIsICJwYWdlU2l6ZSI6IDEyMywgInNvcnRPcmRlciI6ICJhc2MifQ=="; // String | 
        String pageSize = "10"; // String | 
        String sortOrder = "asc"; // String | 
        try {
            PolicyPaginatedResponse result = apiInstance.getUserPolicies(userName, organizationId, nextToken, pageSize, sortOrder);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserPolicyManagementApi#getUserPolicies");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userName** | **String**|  | |
| **organizationId** | **String**|  | |
| **nextToken** | **String**|  | [optional] |
| **pageSize** | **String**|  | [optional] |
| **sortOrder** | **String**|  | [optional] [enum: asc, desc] |

### Return type

[**PolicyPaginatedResponse**](PolicyPaginatedResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Response for list policies request and list policies for user request |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **400** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **401** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **403** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |

