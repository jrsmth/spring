package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.CustomerDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CustomerListDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-08-12T06:05:54.271Z")


public class CustomerListDTO   {
  @JsonProperty("customers")
  @Valid
  private List<CustomerDTO> customers = null;

  public CustomerListDTO customers(List<CustomerDTO> customers) {
    this.customers = customers;
    return this;
  }

  public CustomerListDTO addCustomersItem(CustomerDTO customersItem) {
    if (this.customers == null) {
      this.customers = new ArrayList<CustomerDTO>();
    }
    this.customers.add(customersItem);
    return this;
  }

  /**
   * Get customers
   * @return customers
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<CustomerDTO> getCustomers() {
    return customers;
  }

  public void setCustomers(List<CustomerDTO> customers) {
    this.customers = customers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerListDTO customerListDTO = (CustomerListDTO) o;
    return Objects.equals(this.customers, customerListDTO.customers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerListDTO {\n");
    
    sb.append("    customers: ").append(toIndentedString(customers)).append("\n");
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

