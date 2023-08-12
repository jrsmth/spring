package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.VendorDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * VendorListDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-08-12T06:05:54.271Z")


public class VendorListDTO   {
  @JsonProperty("vendors")
  @Valid
  private List<VendorDTO> vendors = null;

  public VendorListDTO vendors(List<VendorDTO> vendors) {
    this.vendors = vendors;
    return this;
  }

  public VendorListDTO addVendorsItem(VendorDTO vendorsItem) {
    if (this.vendors == null) {
      this.vendors = new ArrayList<VendorDTO>();
    }
    this.vendors.add(vendorsItem);
    return this;
  }

  /**
   * Get vendors
   * @return vendors
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<VendorDTO> getVendors() {
    return vendors;
  }

  public void setVendors(List<VendorDTO> vendors) {
    this.vendors = vendors;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VendorListDTO vendorListDTO = (VendorListDTO) o;
    return Objects.equals(this.vendors, vendorListDTO.vendors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vendors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorListDTO {\n");
    
    sb.append("    vendors: ").append(toIndentedString(vendors)).append("\n");
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

