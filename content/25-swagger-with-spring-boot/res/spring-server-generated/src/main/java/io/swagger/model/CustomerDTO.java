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
 * CustomerDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-08-12T06:05:54.271Z")


public class CustomerDTO   {
  @JsonProperty("customer_url")
  private String customerUrl = null;

  @JsonProperty("firstname")
  private String firstname = null;

  @JsonProperty("lastname")
  private String lastname = null;

  public CustomerDTO customerUrl(String customerUrl) {
    this.customerUrl = customerUrl;
    return this;
  }

  /**
   * Get customerUrl
   * @return customerUrl
  **/
  @ApiModelProperty(value = "")


  public String getCustomerUrl() {
    return customerUrl;
  }

  public void setCustomerUrl(String customerUrl) {
    this.customerUrl = customerUrl;
  }

  public CustomerDTO firstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  /**
   * This is the first name
   * @return firstname
  **/
  @ApiModelProperty(required = true, value = "This is the first name")
  @NotNull


  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public CustomerDTO lastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  /**
   * Get lastname
   * @return lastname
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerDTO customerDTO = (CustomerDTO) o;
    return Objects.equals(this.customerUrl, customerDTO.customerUrl) &&
        Objects.equals(this.firstname, customerDTO.firstname) &&
        Objects.equals(this.lastname, customerDTO.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerUrl, firstname, lastname);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerDTO {\n");
    
    sb.append("    customerUrl: ").append(toIndentedString(customerUrl)).append("\n");
    sb.append("    firstname: ").append(toIndentedString(firstname)).append("\n");
    sb.append("    lastname: ").append(toIndentedString(lastname)).append("\n");
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

