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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.Objects;

/** PaginationOptions */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class PaginationOptions {
    public static final String SERIALIZED_NAME_PAGE_SIZE = "pageSize";

    @SerializedName(SERIALIZED_NAME_PAGE_SIZE)
    private Integer pageSize;

    /** Gets or Sets sortOrder */
    @JsonAdapter(SortOrderEnum.Adapter.class)
    public enum SortOrderEnum {
        ASC("asc"),

        DESC("desc");

        private String value;

        SortOrderEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static SortOrderEnum fromValue(String value) {
            for (SortOrderEnum b : SortOrderEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<SortOrderEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final SortOrderEnum enumeration)
                    throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public SortOrderEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return SortOrderEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_SORT_ORDER = "sortOrder";

    @SerializedName(SERIALIZED_NAME_SORT_ORDER)
    private SortOrderEnum sortOrder;

    public PaginationOptions() {}

    public PaginationOptions pageSize(Integer pageSize) {

        this.pageSize = pageSize;
        return this;
    }

    /**
     * Get pageSize
     *
     * @return pageSize
     */
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public PaginationOptions sortOrder(SortOrderEnum sortOrder) {

        this.sortOrder = sortOrder;
        return this;
    }

    /**
     * Get sortOrder
     *
     * @return sortOrder
     */
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    public SortOrderEnum getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(SortOrderEnum sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaginationOptions paginationOptions = (PaginationOptions) o;
        return Objects.equals(this.pageSize, paginationOptions.pageSize)
                && Objects.equals(this.sortOrder, paginationOptions.sortOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageSize, sortOrder);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaginationOptions {\n");
        sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
        sb.append("    sortOrder: ").append(toIndentedString(sortOrder)).append("\n");
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
