# KeyManagementApi

All URIs are relative to *https://sandbox-iam.us.hypto.com/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getKey**](KeyManagementApi.md#getKey) | **GET** /keys/{kid} | Get keys |


<a name="getKey"></a>
# **getKey**
> KeyResponse getKey(kid, format, type)

Get keys

Get public/private keys from Key-id in der/pem format

### Example
```java
// Import classes:
import com.hypto.iam.client.ApiClient;
import com.hypto.iam.client.ApiException;
import com.hypto.iam.client.Configuration;
import com.hypto.iam.client.models.*;
import com.hypto.iam.client.api.KeyManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox-iam.us.hypto.com/v1");

    KeyManagementApi apiInstance = new KeyManagementApi(defaultClient);
    String kid = "kid_example"; // String | 
    String format = "der"; // String | 
    String type = "public"; // String | 
    try {
      KeyResponse result = apiInstance.getKey(kid, format, type);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling KeyManagementApi#getKey");
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
| **kid** | **String**|  | |
| **format** | **String**|  | [optional] [default to pem] [enum: der, pem] |
| **type** | **String**|  | [optional] [default to public] [enum: public] |

### Return type

[**KeyResponse**](KeyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Response for key request |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **404** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |
| **0** | Error response |  * X-Iam-User-Organization - Organization Id of the authenticated user <br>  |

