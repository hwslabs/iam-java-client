# UserVerificationApi

All URIs are relative to *https://sandbox-iam.us.hypto.com/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**listInvites**](UserVerificationApi.md#listInvites) | **GET** organization/{organization_id}/invites | Get organization passcodes |
| [**resendInvite**](UserVerificationApi.md#resendInvite) | **POST** organizations/{organization_id}/invites/resend | Resend organization passcodes |
| [**verifyEmail**](UserVerificationApi.md#verifyEmail) | **POST** verifyEmail | Verify email |



## listInvites

> PasscodePaginatedResponse listInvites(organizationId)

Get organization passcodes

Get passcodes for the organization

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserVerificationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        UserVerificationApi apiInstance = new UserVerificationApi(defaultClient);
        String organizationId = "organizationId_example"; // String | 
        try {
            PasscodePaginatedResponse result = apiInstance.listInvites(organizationId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserVerificationApi#listInvites");
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

[**PasscodePaginatedResponse**](PasscodePaginatedResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Paginated response of passcodesm |  -  |
| **400** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |


## resendInvite

> BaseSuccessResponse resendInvite(organizationId, resendInviteRequest)

Resend organization passcodes

Resend passcodes for the organization

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserVerificationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        UserVerificationApi apiInstance = new UserVerificationApi(defaultClient);
        String organizationId = "organizationId_example"; // String | 
        ResendInviteRequest resendInviteRequest = new ResendInviteRequest(); // ResendInviteRequest | Payload to resend invite
        try {
            BaseSuccessResponse result = apiInstance.resendInvite(organizationId, resendInviteRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserVerificationApi#resendInvite");
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
| **resendInviteRequest** | [**ResendInviteRequest**](ResendInviteRequest.md)| Payload to resend invite | |

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
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |


## verifyEmail

> BaseSuccessResponse verifyEmail(verifyEmailRequest)

Verify email

Verify email during account opening and resetting password

### Example

```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.auth.*;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserVerificationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        UserVerificationApi apiInstance = new UserVerificationApi(defaultClient);
        VerifyEmailRequest verifyEmailRequest = new VerifyEmailRequest(); // VerifyEmailRequest | Payload to send verification link to email
        try {
            BaseSuccessResponse result = apiInstance.verifyEmail(verifyEmailRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserVerificationApi#verifyEmail");
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
| **verifyEmailRequest** | [**VerifyEmailRequest**](VerifyEmailRequest.md)| Payload to send verification link to email | |

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
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |

