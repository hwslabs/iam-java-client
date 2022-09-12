package com.hypto.iam.client.api;

import com.hypto.iam.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import com.hypto.iam.client.model.ErrorResponse;
import com.hypto.iam.client.model.TokenResponse;
import com.hypto.iam.client.model.ValidationRequest;
import com.hypto.iam.client.model.ValidationResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserAuthorizationApi {
  /**
   * Generate a token
   * Generate a token for the given user credential (same as /organizations/{organization_id}/token at the moment. Might change in future)
   * @return Call&lt;TokenResponse&gt;
   */
  @POST("token")
  Call<TokenResponse> getToken();
    

  /**
   * Generate a organization_id scoped token
   * Generate a token for the given user credential scoped by the provided organization_id
   * @param organizationId  (required)
   * @return Call&lt;TokenResponse&gt;
   */
  @POST("organizations/{organization_id}/token")
  Call<TokenResponse> getTokenForOrg(
    @retrofit2.http.Path("organization_id") String organizationId
  );

  /**
   * Validate an auth request
   * Validate if the caller has access to resource-action in the request
   * @param validationRequest Payload to validate if a user has access to a resource-action (required)
   * @return Call&lt;ValidationResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("validate")
  Call<ValidationResponse> validate(
    @retrofit2.http.Body ValidationRequest validationRequest
  );


  @POST("token")
  Call<TokenResponse> getToken(@retrofit2.http.HeaderMap Map<String, String> headers);
    
  @POST("organizations/{organization_id}/token")
  Call<TokenResponse> getTokenForOrg(
    @retrofit2.http.Path("organization_id") String organizationId, @retrofit2.http.HeaderMap Map<String, String> headers
  );
  @Headers({
    "Content-Type:application/json"
  })
  @POST("validate")
  Call<ValidationResponse> validate(
    @retrofit2.http.Body ValidationRequest validationRequest, @retrofit2.http.HeaderMap Map<String, String> headers
  );
}
