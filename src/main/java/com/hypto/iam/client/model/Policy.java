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

/** Policy */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Policy {
    public static final String SERIALIZED_NAME_NAME = "name";

    @SerializedName(SERIALIZED_NAME_NAME)
    private String name;

    public static final String SERIALIZED_NAME_ORGANIZATION_ID = "organizationId";

    @SerializedName(SERIALIZED_NAME_ORGANIZATION_ID)
    private String organizationId;

    public static final String SERIALIZED_NAME_HRN = "hrn";

    @SerializedName(SERIALIZED_NAME_HRN)
    private String hrn;

    public static final String SERIALIZED_NAME_VERSION = "version";

    @SerializedName(SERIALIZED_NAME_VERSION)
    private Integer version;

    public static final String SERIALIZED_NAME_STATEMENTS = "statements";

    @SerializedName(SERIALIZED_NAME_STATEMENTS)
    private List<PolicyStatement> statements = new ArrayList<>();

    public Policy() {}

    public Policy name(String name) {

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

    public Policy organizationId(String organizationId) {

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

    public Policy hrn(String hrn) {

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

    public Policy version(Integer version) {

        this.version = version;
        return this;
    }

    /**
     * Get version
     *
     * @return version
     */
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Policy statements(List<PolicyStatement> statements) {

        this.statements = statements;
        return this;
    }

    public Policy addStatementsItem(PolicyStatement statementsItem) {
        this.statements.add(statementsItem);
        return this;
    }

    /**
     * Get statements
     *
     * @return statements
     */
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
    public List<PolicyStatement> getStatements() {
        return statements;
    }

    public void setStatements(List<PolicyStatement> statements) {
        this.statements = statements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Policy policy = (Policy) o;
        return Objects.equals(this.name, policy.name)
                && Objects.equals(this.organizationId, policy.organizationId)
                && Objects.equals(this.hrn, policy.hrn)
                && Objects.equals(this.version, policy.version)
                && Objects.equals(this.statements, policy.statements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, organizationId, hrn, version, statements);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Policy {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    organizationId: ").append(toIndentedString(organizationId)).append("\n");
        sb.append("    hrn: ").append(toIndentedString(hrn)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    statements: ").append(toIndentedString(statements)).append("\n");
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
