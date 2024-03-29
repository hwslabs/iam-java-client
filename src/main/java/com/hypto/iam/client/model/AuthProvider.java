/*
 * Hypto IAM
 * APIs for Hypto IAM Service.
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: engineering@hypto.in
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.hypto.iam.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/** Authorization provider details for user to login */
@ApiModel(description = "Authorization provider details for user to login")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class AuthProvider {
    public static final String SERIALIZED_NAME_PROVIDER_NAME = "providerName";

    @SerializedName(SERIALIZED_NAME_PROVIDER_NAME)
    private String providerName;

    public static final String SERIALIZED_NAME_AUTH_URL = "authUrl";

    @SerializedName(SERIALIZED_NAME_AUTH_URL)
    private String authUrl;

    public static final String SERIALIZED_NAME_CLIENT_ID = "clientId";

    @SerializedName(SERIALIZED_NAME_CLIENT_ID)
    private String clientId;

    public AuthProvider() {}

    public AuthProvider providerName(String providerName) {

        this.providerName = providerName;
        return this;
    }

    /**
     * Name of the authorization provider
     *
     * @return providerName
     */
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "Name of the authorization provider")
    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public AuthProvider authUrl(String authUrl) {

        this.authUrl = authUrl;
        return this;
    }

    /**
     * Authorization url of the provider
     *
     * @return authUrl
     */
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "Authorization url of the provider")
    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    public AuthProvider clientId(String clientId) {

        this.clientId = clientId;
        return this;
    }

    /**
     * Client Id generated by the provider
     *
     * @return clientId
     */
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "Client Id generated by the provider")
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AuthProvider authProvider = (AuthProvider) o;
        return Objects.equals(this.providerName, authProvider.providerName)
                && Objects.equals(this.authUrl, authProvider.authUrl)
                && Objects.equals(this.clientId, authProvider.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(providerName, authUrl, clientId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AuthProvider {\n");
        sb.append("    providerName: ").append(toIndentedString(providerName)).append("\n");
        sb.append("    authUrl: ").append(toIndentedString(authUrl)).append("\n");
        sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first
     * line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
