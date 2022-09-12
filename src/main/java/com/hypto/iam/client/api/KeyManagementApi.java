package com.hypto.iam.client.api;

import com.hypto.iam.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import com.hypto.iam.client.model.ErrorResponse;
import com.hypto.iam.client.model.KeyResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface KeyManagementApi {
  /**
   * Get keys
   * Get public/private keys from Key-id in der/pem format
   * @param kid  (required)
   * @param format  (optional, default to pem)
   * @param type  (optional, default to public)
   * @return Call&lt;KeyResponse&gt;
   */
  @GET("keys/{kid}")
  Call<KeyResponse> getKey(
    @retrofit2.http.Path("kid") String kid, @retrofit2.http.Query("format") String format, @retrofit2.http.Query("type") String type
  );


  @GET("keys/{kid}")
  Call<KeyResponse> getKey(
    @retrofit2.http.Path("kid") String kid, @retrofit2.http.Query("format") String format, @retrofit2.http.Query("type") String type, @retrofit2.http.HeaderMap Map<String, String> headers
  );
}
