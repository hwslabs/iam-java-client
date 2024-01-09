# SubOrganizationManagementApi

All URIs are relative to *https://sandbox-iam.us.hypto.com/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createSubOrganization**](SubOrganizationManagementApi.md#createSubOrganization) | **POST** organizations/{organization_id}/sub_organizations | Create a sub organization under an organization. Sub organization provides a way to create a hierarchy of organizations to easily manage resources at each levels. |
| [**deleteSubOrganization**](SubOrganizationManagementApi.md#deleteSubOrganization) | **DELETE** organizations/{organization_id}/sub_organizations/{sub_organization_name} | Delete a sub organization |
| [**getSubOrganization**](SubOrganizationManagementApi.md#getSubOrganization) | **GET** organizations/{organization_id}/sub_organizations/{sub_organization_name} | Get a sub organization |
| [**listSubOrganizations**](SubOrganizationManagementApi.md#listSubOrganizations) | **GET** organizations/{organization_id}/sub_organizations | List sub organizations under an organization. |
| [**updateSubOrganization**](SubOrganizationManagementApi.md#updateSubOrganization) | **PATCH** organizations/{organization_id}/sub_organizations/{sub_organization_name} | Update a sub organization |



## createSubOrganization

> CreateSubOrganizationResponse createSubOrganization(organizationId, createSubOrganizationRequest)

Create a sub organization under an organization. Sub organization provides a way to create a hierarchy of organizations to easily manage resources at each levels.

Create a sub organization under an organization.

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.SubOrganizationManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        SubOrganizationManagementApi apiInstance = new SubOrganizationManagementApi(defaultClient);
        String organizationId = "organizationId_example"; // String | 
        CreateSubOrganizationRequest createSubOrganizationRequest = new CreateSubOrganizationRequest(); // CreateSubOrganizationRequest | Payload to create sub organization
        try {
            CreateSubOrganizationResponse result = apiInstance.createSubOrganization(organizationId, createSubOrganizationRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubOrganizationManagementApi#createSubOrganization");
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
| **organizationId** | **String**|  | |
| **createSubOrganizationRequest** | [**CreateSubOrganizationRequest**](CreateSubOrganizationRequest.md)| Payload to create sub organization | |

### Return type

[**CreateSubOrganizationResponse**](CreateSubOrganizationResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Response for Create Sub Organization request |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **400** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **401** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **403** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |


## deleteSubOrganization

> BaseSuccessResponse deleteSubOrganization(organizationId, subOrganizationName)

Delete a sub organization

Delete a sub organization. This is a privileged api and only internal application will have access to delete sub organization.

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.SubOrganizationManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        SubOrganizationManagementApi apiInstance = new SubOrganizationManagementApi(defaultClient);
        String organizationId = "organizationId_example"; // String | 
        String subOrganizationName = "subOrganizationName_example"; // String | 
        try {
            BaseSuccessResponse result = apiInstance.deleteSubOrganization(organizationId, subOrganizationName);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubOrganizationManagementApi#deleteSubOrganization");
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
| **organizationId** | **String**|  | |
| **subOrganizationName** | **String**|  | |

### Return type

[**BaseSuccessResponse**](BaseSuccessResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
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


## getSubOrganization

> SubOrganization getSubOrganization(organizationId, subOrganizationName)

Get a sub organization

Get a sub organization and the metadata for the given sub organization.

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.SubOrganizationManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        SubOrganizationManagementApi apiInstance = new SubOrganizationManagementApi(defaultClient);
        String organizationId = "organizationId_example"; // String | 
        String subOrganizationName = "subOrganizationName_example"; // String | 
        try {
            SubOrganization result = apiInstance.getSubOrganization(organizationId, subOrganizationName);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubOrganizationManagementApi#getSubOrganization");
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
| **organizationId** | **String**|  | |
| **subOrganizationName** | **String**|  | |

### Return type

[**SubOrganization**](SubOrganization.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Response for Get and Update Sub Organization requests |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **400** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **401** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **403** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |


## listSubOrganizations

> SubOrganizationsPaginatedResponse listSubOrganizations(organizationId)

List sub organizations under an organization.

List all sub organizations under an organization.

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.SubOrganizationManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        SubOrganizationManagementApi apiInstance = new SubOrganizationManagementApi(defaultClient);
        String organizationId = "organizationId_example"; // String | 
        try {
            SubOrganizationsPaginatedResponse result = apiInstance.listSubOrganizations(organizationId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubOrganizationManagementApi#listSubOrganizations");
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
| **organizationId** | **String**|  | |

### Return type

[**SubOrganizationsPaginatedResponse**](SubOrganizationsPaginatedResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Response for list sub organization under an organization request. |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **400** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **401** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **403** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |


## updateSubOrganization

> SubOrganization updateSubOrganization(organizationId, subOrganizationName, updateSubOrganizationRequest)

Update a sub organization

Update a sub organization

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.SubOrganizationManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        SubOrganizationManagementApi apiInstance = new SubOrganizationManagementApi(defaultClient);
        String organizationId = "organizationId_example"; // String | 
        String subOrganizationName = "subOrganizationName_example"; // String | 
        UpdateSubOrganizationRequest updateSubOrganizationRequest = new UpdateSubOrganizationRequest(); // UpdateSubOrganizationRequest | Payload to update sub organization
        try {
            SubOrganization result = apiInstance.updateSubOrganization(organizationId, subOrganizationName, updateSubOrganizationRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubOrganizationManagementApi#updateSubOrganization");
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
| **organizationId** | **String**|  | |
| **subOrganizationName** | **String**|  | |
| **updateSubOrganizationRequest** | [**UpdateSubOrganizationRequest**](UpdateSubOrganizationRequest.md)| Payload to update sub organization | |

### Return type

[**SubOrganization**](SubOrganization.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Response for Get and Update Sub Organization requests |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **400** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **401** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **403** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |

