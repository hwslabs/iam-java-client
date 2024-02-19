package com.hypto.iam.client.api;

import com.hypto.iam.client.CollectionFormats.*;
import com.hypto.iam.client.model.TokenResponse;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserAuthenticationApi {
    /**
     * Authenticate a request Authenticates the request and respond with token. Upon successful
     * authentication, - For basic auth as well as credential based bearer auth, this API generates
     * a token and returns it. - For JWT bearer auth, returns the same JWT token in response
     *
     * @return Call&lt;TokenResponse&gt;
     */
    @POST("authenticate")
    Call<TokenResponse> authenticate();

    @POST("authenticate")
    Call<TokenResponse> authenticate(@retrofit2.http.HeaderMap Map<String, String> headers);
}
