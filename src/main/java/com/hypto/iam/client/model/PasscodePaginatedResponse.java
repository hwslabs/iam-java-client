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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** PasscodePaginatedResponse */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class PasscodePaginatedResponse {
    public static final String SERIALIZED_NAME_DATA = "data";

    @SerializedName(SERIALIZED_NAME_DATA)
    private List<Passcode> data = null;

    public static final String SERIALIZED_NAME_NEXT_TOKEN = "nextToken";

    @SerializedName(SERIALIZED_NAME_NEXT_TOKEN)
    private String nextToken;

    public static final String SERIALIZED_NAME_CONTEXT = "context";

    @SerializedName(SERIALIZED_NAME_CONTEXT)
    private PaginationOptions context;

    public PasscodePaginatedResponse() {}

    public PasscodePaginatedResponse data(List<Passcode> data) {

        this.data = data;
        return this;
    }

    public PasscodePaginatedResponse addDataItem(Passcode dataItem) {
        if (this.data == null) {
            this.data = new ArrayList<>();
        }
        this.data.add(dataItem);
        return this;
    }

    /**
     * Get data
     *
     * @return data
     */
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    public List<Passcode> getData() {
        return data;
    }

    public void setData(List<Passcode> data) {
        this.data = data;
    }

    public PasscodePaginatedResponse nextToken(String nextToken) {

        this.nextToken = nextToken;
        return this;
    }

    /**
     * Get nextToken
     *
     * @return nextToken
     */
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    public String getNextToken() {
        return nextToken;
    }

    public void setNextToken(String nextToken) {
        this.nextToken = nextToken;
    }

    public PasscodePaginatedResponse context(PaginationOptions context) {

        this.context = context;
        return this;
    }

    /**
     * Get context
     *
     * @return context
     */
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    public PaginationOptions getContext() {
        return context;
    }

    public void setContext(PaginationOptions context) {
        this.context = context;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PasscodePaginatedResponse passcodePaginatedResponse = (PasscodePaginatedResponse) o;
        return Objects.equals(this.data, passcodePaginatedResponse.data)
                && Objects.equals(this.nextToken, passcodePaginatedResponse.nextToken)
                && Objects.equals(this.context, passcodePaginatedResponse.context);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, nextToken, context);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PasscodePaginatedResponse {\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    nextToken: ").append(toIndentedString(nextToken)).append("\n");
        sb.append("    context: ").append(toIndentedString(context)).append("\n");
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
