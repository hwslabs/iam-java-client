# UserCredentialManagementApi

All URIs are relative to *https://sandbox-iam.us.hypto.com/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createCredential**](UserCredentialManagementApi.md#createCredential) | **POST** organizations/{organization_id}/users/{user_name}/credentials | Create a new credential for a user |
| [**createSubOrganizationCredential**](UserCredentialManagementApi.md#createSubOrganizationCredential) | **POST** organizations/{organization_id}/sub_organizations/{sub_organization_name}/users/{user_name}/credentials | Create a new credential for a user |
| [**deleteCredential**](UserCredentialManagementApi.md#deleteCredential) | **DELETE** organizations/{organization_id}/users/{user_name}/credentials/{credential_id} | Delete a credential |
| [**deleteSubOrganizationCredential**](UserCredentialManagementApi.md#deleteSubOrganizationCredential) | **DELETE** organizations/{organization_id}/sub_organizations/{sub_organization_name}/users/{user_name}/credentials/{credential_id} | Delete a credential |
| [**getCredential**](UserCredentialManagementApi.md#getCredential) | **GET** organizations/{organization_id}/users/{user_name}/credentials/{credential_id} | Gets credential for the user |
| [**getSubOrganizationCredential**](UserCredentialManagementApi.md#getSubOrganizationCredential) | **GET** organizations/{organization_id}/sub_organizations/{sub_organization_name}/users/{user_name}/credentials/{credential_id} | Gets credential for the user |
| [**listCredentials**](UserCredentialManagementApi.md#listCredentials) | **GET** organizations/{organization_id}/users/{user_name}/credentials | List all credentials for a user |
| [**listSubOrganizationCredentials**](UserCredentialManagementApi.md#listSubOrganizationCredentials) | **GET** organizations/{organization_id}/sub_organizations/{sub_organization_name}/users/{user_name}/credentials | List all credentials for a user |
| [**updateCredential**](UserCredentialManagementApi.md#updateCredential) | **PATCH** organizations/{organization_id}/users/{user_name}/credentials/{credential_id} | Update the status of credential |
| [**updateSubOrganizationCredential**](UserCredentialManagementApi.md#updateSubOrganizationCredential) | **PATCH** organizations/{organization_id}/sub_organizations/{sub_organization_name}/users/{user_name}/credentials/{credential_id} | Update the status of credential |



## createCredential

> Credential createCredential(userName, organizationId, createCredentialRequest)

Create a new credential for a user

Create a new credential for a user. This API returns the credential&#39;s secret key, which will be available only in the response of this API.

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserCredentialManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        UserCredentialManagementApi apiInstance = new UserCredentialManagementApi(defaultClient);
        String userName = "userName_example"; // String | 
        String organizationId = "organizationId_example"; // String | 
        CreateCredentialRequest createCredentialRequest = new CreateCredentialRequest(); // CreateCredentialRequest | Payload to create credential
        try {
            Credential result = apiInstance.createCredential(userName, organizationId, createCredentialRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserCredentialManagementApi#createCredential");
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
| **createCredentialRequest** | [**CreateCredentialRequest**](CreateCredentialRequest.md)| Payload to create credential | |

### Return type

[**Credential**](Credential.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Response for CreateCredentialRequest |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **400** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **401** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **403** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |


## createSubOrganizationCredential

> Credential createSubOrganizationCredential(userName, organizationId, subOrganizationName, createCredentialRequest)

Create a new credential for a user

Create a new credential for a user. This API returns the credential&#39;s secret key, which will be available only in the response of this API.

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserCredentialManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        UserCredentialManagementApi apiInstance = new UserCredentialManagementApi(defaultClient);
        String userName = "userName_example"; // String | 
        String organizationId = "organizationId_example"; // String | 
        String subOrganizationName = "subOrganizationName_example"; // String | 
        CreateCredentialRequest createCredentialRequest = new CreateCredentialRequest(); // CreateCredentialRequest | Payload to create credential
        try {
            Credential result = apiInstance.createSubOrganizationCredential(userName, organizationId, subOrganizationName, createCredentialRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserCredentialManagementApi#createSubOrganizationCredential");
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
| **createCredentialRequest** | [**CreateCredentialRequest**](CreateCredentialRequest.md)| Payload to create credential | |

### Return type

[**Credential**](Credential.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Response for CreateCredentialRequest |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **400** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **401** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **403** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |


## deleteCredential

> BaseSuccessResponse deleteCredential(organizationId, userName, credentialId)

Delete a credential

Delete a credential associated with the user

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserCredentialManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        UserCredentialManagementApi apiInstance = new UserCredentialManagementApi(defaultClient);
        String organizationId = "organizationId_example"; // String | 
        String userName = "userName_example"; // String | 
        String credentialId = "credentialId_example"; // String | 
        try {
            BaseSuccessResponse result = apiInstance.deleteCredential(organizationId, userName, credentialId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserCredentialManagementApi#deleteCredential");
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
| **userName** | **String**|  | |
| **credentialId** | **String**|  | |

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


## deleteSubOrganizationCredential

> BaseSuccessResponse deleteSubOrganizationCredential(organizationId, subOrganizationName, userName, credentialId)

Delete a credential

Delete a credential associated with the user

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserCredentialManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        UserCredentialManagementApi apiInstance = new UserCredentialManagementApi(defaultClient);
        String organizationId = "organizationId_example"; // String | 
        String subOrganizationName = "subOrganizationName_example"; // String | 
        String userName = "userName_example"; // String | 
        String credentialId = "credentialId_example"; // String | 
        try {
            BaseSuccessResponse result = apiInstance.deleteSubOrganizationCredential(organizationId, subOrganizationName, userName, credentialId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserCredentialManagementApi#deleteSubOrganizationCredential");
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
| **userName** | **String**|  | |
| **credentialId** | **String**|  | |

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


## getCredential

> CredentialWithoutSecret getCredential(organizationId, userName, credentialId)

Gets credential for the user

Gets credential for the user, given the credential id

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserCredentialManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        UserCredentialManagementApi apiInstance = new UserCredentialManagementApi(defaultClient);
        String organizationId = "organizationId_example"; // String | 
        String userName = "userName_example"; // String | 
        String credentialId = "credentialId_example"; // String | 
        try {
            CredentialWithoutSecret result = apiInstance.getCredential(organizationId, userName, credentialId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserCredentialManagementApi#getCredential");
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
| **userName** | **String**|  | |
| **credentialId** | **String**|  | |

### Return type

[**CredentialWithoutSecret**](CredentialWithoutSecret.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Response for GetCredentialRequest |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **400** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **401** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **403** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |


## getSubOrganizationCredential

> CredentialWithoutSecret getSubOrganizationCredential(organizationId, subOrganizationName, userName, credentialId)

Gets credential for the user

Gets credential for the user, given the credential id

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserCredentialManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        UserCredentialManagementApi apiInstance = new UserCredentialManagementApi(defaultClient);
        String organizationId = "organizationId_example"; // String | 
        String subOrganizationName = "subOrganizationName_example"; // String | 
        String userName = "userName_example"; // String | 
        String credentialId = "credentialId_example"; // String | 
        try {
            CredentialWithoutSecret result = apiInstance.getSubOrganizationCredential(organizationId, subOrganizationName, userName, credentialId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserCredentialManagementApi#getSubOrganizationCredential");
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
| **userName** | **String**|  | |
| **credentialId** | **String**|  | |

### Return type

[**CredentialWithoutSecret**](CredentialWithoutSecret.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Response for GetCredentialRequest |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **400** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **401** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **403** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |


## listCredentials

> ListCredentialResponse listCredentials(userName, organizationId)

List all credentials for a user

List all credentials for a user

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserCredentialManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        UserCredentialManagementApi apiInstance = new UserCredentialManagementApi(defaultClient);
        String userName = "userName_example"; // String | 
        String organizationId = "organizationId_example"; // String | 
        try {
            ListCredentialResponse result = apiInstance.listCredentials(userName, organizationId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserCredentialManagementApi#listCredentials");
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

[**ListCredentialResponse**](ListCredentialResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Response for list credential request |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **400** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **401** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **403** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |


## listSubOrganizationCredentials

> ListCredentialResponse listSubOrganizationCredentials(userName, organizationId, subOrganizationName)

List all credentials for a user

List all credentials for a user

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserCredentialManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        UserCredentialManagementApi apiInstance = new UserCredentialManagementApi(defaultClient);
        String userName = "userName_example"; // String | 
        String organizationId = "organizationId_example"; // String | 
        String subOrganizationName = "subOrganizationName_example"; // String | 
        try {
            ListCredentialResponse result = apiInstance.listSubOrganizationCredentials(userName, organizationId, subOrganizationName);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserCredentialManagementApi#listSubOrganizationCredentials");
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

### Return type

[**ListCredentialResponse**](ListCredentialResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Response for list credential request |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **400** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **401** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **403** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |


## updateCredential

> CredentialWithoutSecret updateCredential(organizationId, userName, credentialId, updateCredentialRequest)

Update the status of credential

Update the status of credential to ACTIVE/INACTIVE. Credentials which are marked INACTIVE cannot be used to fetch short-term tokens.

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserCredentialManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        UserCredentialManagementApi apiInstance = new UserCredentialManagementApi(defaultClient);
        String organizationId = "organizationId_example"; // String | 
        String userName = "userName_example"; // String | 
        String credentialId = "credentialId_example"; // String | 
        UpdateCredentialRequest updateCredentialRequest = new UpdateCredentialRequest(); // UpdateCredentialRequest | Payload to update credential
        try {
            CredentialWithoutSecret result = apiInstance.updateCredential(organizationId, userName, credentialId, updateCredentialRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserCredentialManagementApi#updateCredential");
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
| **userName** | **String**|  | |
| **credentialId** | **String**|  | |
| **updateCredentialRequest** | [**UpdateCredentialRequest**](UpdateCredentialRequest.md)| Payload to update credential | |

### Return type

[**CredentialWithoutSecret**](CredentialWithoutSecret.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Response for UpdateCredentialRequest |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **400** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **401** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **403** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |


## updateSubOrganizationCredential

> CredentialWithoutSecret updateSubOrganizationCredential(organizationId, subOrganizationName, userName, credentialId, updateCredentialRequest)

Update the status of credential

Update the status of credential to ACTIVE/INACTIVE. Credentials which are marked INACTIVE cannot be used to fetch short-term tokens.

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserCredentialManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        UserCredentialManagementApi apiInstance = new UserCredentialManagementApi(defaultClient);
        String organizationId = "organizationId_example"; // String | 
        String subOrganizationName = "subOrganizationName_example"; // String | 
        String userName = "userName_example"; // String | 
        String credentialId = "credentialId_example"; // String | 
        UpdateCredentialRequest updateCredentialRequest = new UpdateCredentialRequest(); // UpdateCredentialRequest | Payload to update credential
        try {
            CredentialWithoutSecret result = apiInstance.updateSubOrganizationCredential(organizationId, subOrganizationName, userName, credentialId, updateCredentialRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserCredentialManagementApi#updateSubOrganizationCredential");
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
| **userName** | **String**|  | |
| **credentialId** | **String**|  | |
| **updateCredentialRequest** | [**UpdateCredentialRequest**](UpdateCredentialRequest.md)| Payload to update credential | |

### Return type

[**CredentialWithoutSecret**](CredentialWithoutSecret.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Response for UpdateCredentialRequest |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **400** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **401** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **403** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |

