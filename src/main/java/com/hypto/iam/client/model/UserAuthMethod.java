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

/** User auth method details */
@ApiModel(description = "User auth method details")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class UserAuthMethod {
    public static final String SERIALIZED_NAME_PROVIDER_NAME = "providerName";

    @SerializedName(SERIALIZED_NAME_PROVIDER_NAME)
    private String providerName;

    public UserAuthMethod() {}

    public UserAuthMethod providerName(String providerName) {

        this.providerName = providerName;
        return this;
    }

    /**
     * Name of the authorization method
     *
     * @return providerName
     */
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "Name of the authorization method")
    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserAuthMethod userAuthMethod = (UserAuthMethod) o;
        return Objects.equals(this.providerName, userAuthMethod.providerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(providerName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserAuthMethod {\n");
        sb.append("    providerName: ").append(toIndentedString(providerName)).append("\n");
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
