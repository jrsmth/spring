package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * VendorDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-08-12T06:05:54.271Z")


public class VendorDTO   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("vendor_url")
  private String vendorUrl = null;

  public VendorDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the Vendor
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name of the Vendor")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public VendorDTO vendorUrl(String vendorUrl) {
    this.vendorUrl = vendorUrl;
    return this;
  }

  /**
   * Get vendorUrl
   * @return vendorUrl
  **/
  @ApiModelProperty(value = "")


  public String getVendorUrl() {
    return vendorUrl;
  }

  public void setVendorUrl(String vendorUrl) {
    this.vendorUrl = vendorUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VendorDTO vendorDTO = (VendorDTO) o;
    return Objects.equals(this.name, vendorDTO.name) &&
        Objects.equals(this.vendorUrl, vendorDTO.vendorUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, vendorUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorDTO {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    vendorUrl: ").append(toIndentedString(vendorUrl)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

