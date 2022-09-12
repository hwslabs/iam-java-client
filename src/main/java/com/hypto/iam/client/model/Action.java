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

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Action
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Action {
  public static final String SERIALIZED_NAME_ORGANIZATION_ID = "organizationId";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION_ID)
  private String organizationId;

  public static final String SERIALIZED_NAME_RESOURCE_NAME = "resourceName";
  @SerializedName(SERIALIZED_NAME_RESOURCE_NAME)
  private String resourceName;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_HRN = "hrn";
  @SerializedName(SERIALIZED_NAME_HRN)
  private String hrn;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public Action() { 
  }

  public Action organizationId(String organizationId) {
    
    this.organizationId = organizationId;
    return this;
  }

   /**
   * Get organizationId
   * @return organizationId
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public String getOrganizationId() {
    return organizationId;
  }


  public void setOrganizationId(String organizationId) {
    this.organizationId = organizationId;
  }


  public Action resourceName(String resourceName) {
    
    this.resourceName = resourceName;
    return this;
  }

   /**
   * Get resourceName
   * @return resourceName
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public String getResourceName() {
    return resourceName;
  }


  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }


  public Action name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public Action hrn(String hrn) {
    
    this.hrn = hrn;
    return this;
  }

   /**
   * Get hrn
   * @return hrn
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public String getHrn() {
    return hrn;
  }


  public void setHrn(String hrn) {
    this.hrn = hrn;
  }


  public Action description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Action action = (Action) o;
    return Objects.equals(this.organizationId, action.organizationId) &&
        Objects.equals(this.resourceName, action.resourceName) &&
        Objects.equals(this.name, action.name) &&
        Objects.equals(this.hrn, action.hrn) &&
        Objects.equals(this.description, action.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(organizationId, resourceName, name, hrn, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Action {\n");
    sb.append("    organizationId: ").append(toIndentedString(organizationId)).append("\n");
    sb.append("    resourceName: ").append(toIndentedString(resourceName)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    hrn: ").append(toIndentedString(hrn)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

