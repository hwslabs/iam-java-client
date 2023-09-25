# UserAuthorizationMethodsManagementApi

All URIs are relative to *https://sandbox-iam.us.hypto.com/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getUserAuthMethods**](UserAuthorizationMethodsManagementApi.md#getUserAuthMethods) | **GET** organizations/{organization_id}/users/{user_name}/auth_methods | Gets authorization methods of a user entity associated with the organization |



## getUserAuthMethods

> UserAuthMethodsResponse getUserAuthMethods(userName, organizationId)

Gets authorization methods of a user entity associated with the organization

Get authorization methods of a User

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserAuthorizationMethodsManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        UserAuthorizationMethodsManagementApi apiInstance = new UserAuthorizationMethodsManagementApi(defaultClient);
        String userName = "userName_example"; // String | 
        String organizationId = "organizationId_example"; // String | 
        try {
            UserAuthMethodsResponse result = apiInstance.getUserAuthMethods(userName, organizationId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserAuthorizationMethodsManagementApi#getUserAuthMethods");
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

### Return type

[**UserAuthMethodsResponse**](UserAuthMethodsResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Response for list user auth methods request |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **400** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **401** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **403** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |

