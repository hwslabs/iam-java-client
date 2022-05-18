# UserVerificationApi

All URIs are relative to *https://sandbox-iam.us.hypto.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**verifyEmail**](UserVerificationApi.md#verifyEmail) | **POST** /verifyEmail | Verify email


<a name="verifyEmail"></a>
# **verifyEmail**
> BaseSuccessResponse verifyEmail(verifyEmailRequest)

Verify email

Verify email during account opening and resetting password

### Example
```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.UserVerificationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");

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

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **verifyEmailRequest** | [**VerifyEmailRequest**](VerifyEmailRequest.md)| Payload to send verification link to email |

### Return type

[**BaseSuccessResponse**](BaseSuccessResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
**400** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
**404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
**429** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
**0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |

