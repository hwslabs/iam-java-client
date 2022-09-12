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
import com.hypto.iam.client.model.ResourceAction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Payload to validate if a user has access to a resource-action
 */
@ApiModel(description = "Payload to validate if a user has access to a resource-action")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ValidationRequest {
  public static final String SERIALIZED_NAME_VALIDATIONS = "validations";
  @SerializedName(SERIALIZED_NAME_VALIDATIONS)
  private List<ResourceAction> validations = new ArrayList<>();

  public ValidationRequest() { 
  }

  public ValidationRequest validations(List<ResourceAction> validations) {
    
    this.validations = validations;
    return this;
  }

  public ValidationRequest addValidationsItem(ResourceAction validationsItem) {
    this.validations.add(validationsItem);
    return this;
  }

   /**
   * Get validations
   * @return validations
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public List<ResourceAction> getValidations() {
    return validations;
  }


  public void setValidations(List<ResourceAction> validations) {
    this.validations = validations;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidationRequest validationRequest = (ValidationRequest) o;
    return Objects.equals(this.validations, validationRequest.validations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(validations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidationRequest {\n");
    sb.append("    validations: ").append(toIndentedString(validations)).append("\n");
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

