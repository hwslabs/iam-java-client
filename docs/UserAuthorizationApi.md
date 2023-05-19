# UserAuthorizationApi

All URIs are relative to *https://sandbox-iam.us.hypto.com/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getDelegateToken**](UserAuthorizationApi.md#getDelegateToken) | **POST** delegate_token | Generate a delegate token |
| [**getToken**](UserAuthorizationApi.md#getToken) | **POST** token | Generate a token |
| [**getTokenForOrg**](UserAuthorizationApi.md#getTokenForOrg) | **POST** organizations/{organization_id}/token | Generate a organization_id scoped token |
| [**validate**](UserAuthorizationApi.md#validate) | **POST** validate | Validate an auth request |



## getDelegateToken

> TokenResponse getDelegateToken(getDelegateTokenRequest)

Generate a delegate token

Generate a token with ad-hoc principal on behalf of an user with permissions to a policy to which the user has delegate rights.

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserAuthorizationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        UserAuthorizationApi apiInstance = new UserAuthorizationApi(defaultClient);
        GetDelegateTokenRequest getDelegateTokenRequest = new GetDelegateTokenRequest(); // GetDelegateTokenRequest | Payload to generate a delegate-able token
        try {
            TokenResponse result = apiInstance.getDelegateToken(getDelegateTokenRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserAuthorizationApi#getDelegateToken");
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
| **getDelegateTokenRequest** | [**GetDelegateTokenRequest**](GetDelegateTokenRequest.md)| Payload to generate a delegate-able token | |

### Return type

[**TokenResponse**](TokenResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, text/plain


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Response with token |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **401** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **403** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |


## getToken

> TokenResponse getToken()

Generate a token

Generate a token for the given user credential (same as /organizations/{organization_id}/token at the moment. Might change in future)

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserAuthorizationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        UserAuthorizationApi apiInstance = new UserAuthorizationApi(defaultClient);
        try {
            TokenResponse result = apiInstance.getToken();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserAuthorizationApi#getToken");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**TokenResponse**](TokenResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, text/plain


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Response with token |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **401** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **403** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |


## getTokenForOrg

> TokenResponse getTokenForOrg(organizationId)

Generate a organization_id scoped token

Generate a token for the given user credential scoped by the provided organization_id

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserAuthorizationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        UserAuthorizationApi apiInstance = new UserAuthorizationApi(defaultClient);
        String organizationId = "organizationId_example"; // String | 
        try {
            TokenResponse result = apiInstance.getTokenForOrg(organizationId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserAuthorizationApi#getTokenForOrg");
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

[**TokenResponse**](TokenResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, text/plain


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Response with token |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **401** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **403** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |


## validate

> ValidationResponse validate(validationRequest)

Validate an auth request

Validate if the caller has access to resource-action in the request

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserAuthorizationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        UserAuthorizationApi apiInstance = new UserAuthorizationApi(defaultClient);
        ValidationRequest validationRequest = new ValidationRequest(); // ValidationRequest | Payload to validate if a user has access to a resource-action
        try {
            ValidationResponse result = apiInstance.validate(validationRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserAuthorizationApi#validate");
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
| **validationRequest** | [**ValidationRequest**](ValidationRequest.md)| Payload to validate if a user has access to a resource-action | |

### Return type

[**ValidationResponse**](ValidationResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Response for validation request |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **401** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **403** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |

