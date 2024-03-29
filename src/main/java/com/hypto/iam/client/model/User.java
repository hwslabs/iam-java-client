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
import java.time.OffsetDateTime;
import java.util.Objects;

/** User */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class User {
    public static final String SERIALIZED_NAME_HRN = "hrn";

    @SerializedName(SERIALIZED_NAME_HRN)
    private String hrn;

    public static final String SERIALIZED_NAME_USERNAME = "username";

    @SerializedName(SERIALIZED_NAME_USERNAME)
    private String username;

    public static final String SERIALIZED_NAME_PREFERRED_USERNAME = "preferredUsername";

    @SerializedName(SERIALIZED_NAME_PREFERRED_USERNAME)
    private String preferredUsername;

    public static final String SERIALIZED_NAME_NAME = "name";

    @SerializedName(SERIALIZED_NAME_NAME)
    private String name;

    public static final String SERIALIZED_NAME_ORGANIZATION_ID = "organizationId";

    @SerializedName(SERIALIZED_NAME_ORGANIZATION_ID)
    private String organizationId;

    public static final String SERIALIZED_NAME_EMAIL = "email";

    @SerializedName(SERIALIZED_NAME_EMAIL)
    private String email;

    /** Gets or Sets status */
    @JsonAdapter(StatusEnum.Adapter.class)
    public enum StatusEnum {
        ENABLED("enabled"),

        DISABLED("disabled");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static StatusEnum fromValue(String value) {
            for (StatusEnum b : StatusEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<StatusEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final StatusEnum enumeration)
                    throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public StatusEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return StatusEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_STATUS = "status";

    @SerializedName(SERIALIZED_NAME_STATUS)
    private StatusEnum status;

    public static final String SERIALIZED_NAME_PHONE = "phone";

    @SerializedName(SERIALIZED_NAME_PHONE)
    private String phone;

    public static final String SERIALIZED_NAME_LOGIN_ACCESS = "loginAccess";

    @SerializedName(SERIALIZED_NAME_LOGIN_ACCESS)
    private Boolean loginAccess;

    public static final String SERIALIZED_NAME_CREATED_BY = "createdBy";

    @SerializedName(SERIALIZED_NAME_CREATED_BY)
    private String createdBy;

    public static final String SERIALIZED_NAME_CREATED_AT = "createdAt";

    @SerializedName(SERIALIZED_NAME_CREATED_AT)
    private OffsetDateTime createdAt;

    public static final String SERIALIZED_NAME_VERIFIED = "verified";

    @SerializedName(SERIALIZED_NAME_VERIFIED)
    private Boolean verified;

    public User() {}

    public User hrn(String hrn) {

        this.hrn = hrn;
        return this;
    }

    /**
     * Get hrn
     *
     * @return hrn
     */
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
    public String getHrn() {
        return hrn;
    }

    public void setHrn(String hrn) {
        this.hrn = hrn;
    }

    public User username(String username) {

        this.username = username;
        return this;
    }

    /**
     * Get username
     *
     * @return username
     */
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User preferredUsername(String preferredUsername) {

        this.preferredUsername = preferredUsername;
        return this;
    }

    /**
     * Get preferredUsername
     *
     * @return preferredUsername
     */
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    public String getPreferredUsername() {
        return preferredUsername;
    }

    public void setPreferredUsername(String preferredUsername) {
        this.preferredUsername = preferredUsername;
    }

    public User name(String name) {

        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User organizationId(String organizationId) {

        this.organizationId = organizationId;
        return this;
    }

    /**
     * Get organizationId
     *
     * @return organizationId
     */
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public User email(String email) {

        this.email = email;
        return this;
    }

    /**
     * Get email
     *
     * @return email
     */
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User status(StatusEnum status) {

        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     */
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public User phone(String phone) {

        this.phone = phone;
        return this;
    }

    /**
     * Get phone
     *
     * @return phone
     */
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User loginAccess(Boolean loginAccess) {

        this.loginAccess = loginAccess;
        return this;
    }

    /**
     * Get loginAccess
     *
     * @return loginAccess
     */
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
    public Boolean getLoginAccess() {
        return loginAccess;
    }

    public void setLoginAccess(Boolean loginAccess) {
        this.loginAccess = loginAccess;
    }

    public User createdBy(String createdBy) {

        this.createdBy = createdBy;
        return this;
    }

    /**
     * Get createdBy
     *
     * @return createdBy
     */
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public User createdAt(OffsetDateTime createdAt) {

        this.createdAt = createdAt;
        return this;
    }

    /**
     * Get createdAt
     *
     * @return createdAt
     */
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User verified(Boolean verified) {

        this.verified = verified;
        return this;
    }

    /**
     * Get verified
     *
     * @return verified
     */
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(this.hrn, user.hrn)
                && Objects.equals(this.username, user.username)
                && Objects.equals(this.preferredUsername, user.preferredUsername)
                && Objects.equals(this.name, user.name)
                && Objects.equals(this.organizationId, user.organizationId)
                && Objects.equals(this.email, user.email)
                && Objects.equals(this.status, user.status)
                && Objects.equals(this.phone, user.phone)
                && Objects.equals(this.loginAccess, user.loginAccess)
                && Objects.equals(this.createdBy, user.createdBy)
                && Objects.equals(this.createdAt, user.createdAt)
                && Objects.equals(this.verified, user.verified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                hrn,
                username,
                preferredUsername,
                name,
                organizationId,
                email,
                status,
                phone,
                loginAccess,
                createdBy,
                createdAt,
                verified);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class User {\n");
        sb.append("    hrn: ").append(toIndentedString(hrn)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("    preferredUsername: ")
                .append(toIndentedString(preferredUsername))
                .append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    organizationId: ").append(toIndentedString(organizationId)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
        sb.append("    loginAccess: ").append(toIndentedString(loginAccess)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    verified: ").append(toIndentedString(verified)).append("\n");
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
