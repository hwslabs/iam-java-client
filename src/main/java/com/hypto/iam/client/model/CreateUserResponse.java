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
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/** CreateUserResponse */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class CreateUserResponse {
    public static final String SERIALIZED_NAME_USER = "user";

    @SerializedName(SERIALIZED_NAME_USER)
    private User user;

    public static final String SERIALIZED_NAME_USER_TOKEN = "userToken";

    @SerializedName(SERIALIZED_NAME_USER_TOKEN)
    private String userToken;

    public CreateUserResponse() {}

    public CreateUserResponse user(User user) {

        this.user = user;
        return this;
    }

    /**
     * Get user
     *
     * @return user
     */
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CreateUserResponse userToken(String userToken) {

        this.userToken = userToken;
        return this;
    }

    /**
     * JWT token of the user
     *
     * @return userToken
     */
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "JWT token of the user")
    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateUserResponse createUserResponse = (CreateUserResponse) o;
        return Objects.equals(this.user, createUserResponse.user)
                && Objects.equals(this.userToken, createUserResponse.userToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, userToken);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateUserResponse {\n");
        sb.append("    user: ").append(toIndentedString(user)).append("\n");
        sb.append("    userToken: ").append(toIndentedString(userToken)).append("\n");
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
