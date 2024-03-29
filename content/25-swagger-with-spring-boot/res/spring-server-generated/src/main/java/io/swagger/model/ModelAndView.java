package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.View;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ModelAndView
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-08-12T06:05:54.271Z")


public class ModelAndView   {
  @JsonProperty("empty")
  private Boolean empty = null;

  @JsonProperty("model")
  private Object model = null;

  @JsonProperty("modelMap")
  @Valid
  private Map<String, Object> modelMap = null;

  @JsonProperty("reference")
  private Boolean reference = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    _100_CONTINUE("100 CONTINUE"),
    
    _101_SWITCHING_PROTOCOLS("101 SWITCHING_PROTOCOLS"),
    
    _102_PROCESSING("102 PROCESSING"),
    
    _103_CHECKPOINT("103 CHECKPOINT"),
    
    _200_OK("200 OK"),
    
    _201_CREATED("201 CREATED"),
    
    _202_ACCEPTED("202 ACCEPTED"),
    
    _203_NON_AUTHORITATIVE_INFORMATION("203 NON_AUTHORITATIVE_INFORMATION"),
    
    _204_NO_CONTENT("204 NO_CONTENT"),
    
    _205_RESET_CONTENT("205 RESET_CONTENT"),
    
    _206_PARTIAL_CONTENT("206 PARTIAL_CONTENT"),
    
    _207_MULTI_STATUS("207 MULTI_STATUS"),
    
    _208_ALREADY_REPORTED("208 ALREADY_REPORTED"),
    
    _226_IM_USED("226 IM_USED"),
    
    _300_MULTIPLE_CHOICES("300 MULTIPLE_CHOICES"),
    
    _301_MOVED_PERMANENTLY("301 MOVED_PERMANENTLY"),
    
    _302_FOUND("302 FOUND"),
    
    _302_MOVED_TEMPORARILY("302 MOVED_TEMPORARILY"),
    
    _303_SEE_OTHER("303 SEE_OTHER"),
    
    _304_NOT_MODIFIED("304 NOT_MODIFIED"),
    
    _305_USE_PROXY("305 USE_PROXY"),
    
    _307_TEMPORARY_REDIRECT("307 TEMPORARY_REDIRECT"),
    
    _308_PERMANENT_REDIRECT("308 PERMANENT_REDIRECT"),
    
    _400_BAD_REQUEST("400 BAD_REQUEST"),
    
    _401_UNAUTHORIZED("401 UNAUTHORIZED"),
    
    _402_PAYMENT_REQUIRED("402 PAYMENT_REQUIRED"),
    
    _403_FORBIDDEN("403 FORBIDDEN"),
    
    _404_NOT_FOUND("404 NOT_FOUND"),
    
    _405_METHOD_NOT_ALLOWED("405 METHOD_NOT_ALLOWED"),
    
    _406_NOT_ACCEPTABLE("406 NOT_ACCEPTABLE"),
    
    _407_PROXY_AUTHENTICATION_REQUIRED("407 PROXY_AUTHENTICATION_REQUIRED"),
    
    _408_REQUEST_TIMEOUT("408 REQUEST_TIMEOUT"),
    
    _409_CONFLICT("409 CONFLICT"),
    
    _410_GONE("410 GONE"),
    
    _411_LENGTH_REQUIRED("411 LENGTH_REQUIRED"),
    
    _412_PRECONDITION_FAILED("412 PRECONDITION_FAILED"),
    
    _413_PAYLOAD_TOO_LARGE("413 PAYLOAD_TOO_LARGE"),
    
    _413_REQUEST_ENTITY_TOO_LARGE("413 REQUEST_ENTITY_TOO_LARGE"),
    
    _414_URI_TOO_LONG("414 URI_TOO_LONG"),
    
    _414_REQUEST_URI_TOO_LONG("414 REQUEST_URI_TOO_LONG"),
    
    _415_UNSUPPORTED_MEDIA_TYPE("415 UNSUPPORTED_MEDIA_TYPE"),
    
    _416_REQUESTED_RANGE_NOT_SATISFIABLE("416 REQUESTED_RANGE_NOT_SATISFIABLE"),
    
    _417_EXPECTATION_FAILED("417 EXPECTATION_FAILED"),
    
    _418_I_AM_A_TEAPOT("418 I_AM_A_TEAPOT"),
    
    _419_INSUFFICIENT_SPACE_ON_RESOURCE("419 INSUFFICIENT_SPACE_ON_RESOURCE"),
    
    _420_METHOD_FAILURE("420 METHOD_FAILURE"),
    
    _421_DESTINATION_LOCKED("421 DESTINATION_LOCKED"),
    
    _422_UNPROCESSABLE_ENTITY("422 UNPROCESSABLE_ENTITY"),
    
    _423_LOCKED("423 LOCKED"),
    
    _424_FAILED_DEPENDENCY("424 FAILED_DEPENDENCY"),
    
    _426_UPGRADE_REQUIRED("426 UPGRADE_REQUIRED"),
    
    _428_PRECONDITION_REQUIRED("428 PRECONDITION_REQUIRED"),
    
    _429_TOO_MANY_REQUESTS("429 TOO_MANY_REQUESTS"),
    
    _431_REQUEST_HEADER_FIELDS_TOO_LARGE("431 REQUEST_HEADER_FIELDS_TOO_LARGE"),
    
    _451_UNAVAILABLE_FOR_LEGAL_REASONS("451 UNAVAILABLE_FOR_LEGAL_REASONS"),
    
    _500_INTERNAL_SERVER_ERROR("500 INTERNAL_SERVER_ERROR"),
    
    _501_NOT_IMPLEMENTED("501 NOT_IMPLEMENTED"),
    
    _502_BAD_GATEWAY("502 BAD_GATEWAY"),
    
    _503_SERVICE_UNAVAILABLE("503 SERVICE_UNAVAILABLE"),
    
    _504_GATEWAY_TIMEOUT("504 GATEWAY_TIMEOUT"),
    
    _505_HTTP_VERSION_NOT_SUPPORTED("505 HTTP_VERSION_NOT_SUPPORTED"),
    
    _506_VARIANT_ALSO_NEGOTIATES("506 VARIANT_ALSO_NEGOTIATES"),
    
    _507_INSUFFICIENT_STORAGE("507 INSUFFICIENT_STORAGE"),
    
    _508_LOOP_DETECTED("508 LOOP_DETECTED"),
    
    _509_BANDWIDTH_LIMIT_EXCEEDED("509 BANDWIDTH_LIMIT_EXCEEDED"),
    
    _510_NOT_EXTENDED("510 NOT_EXTENDED"),
    
    _511_NETWORK_AUTHENTICATION_REQUIRED("511 NETWORK_AUTHENTICATION_REQUIRED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("view")
  private View view = null;

  @JsonProperty("viewName")
  private String viewName = null;

  public ModelAndView empty(Boolean empty) {
    this.empty = empty;
    return this;
  }

  /**
   * Get empty
   * @return empty
  **/
  @ApiModelProperty(value = "")


  public Boolean isEmpty() {
    return empty;
  }

  public void setEmpty(Boolean empty) {
    this.empty = empty;
  }

  public ModelAndView model(Object model) {
    this.model = model;
    return this;
  }

  /**
   * Get model
   * @return model
  **/
  @ApiModelProperty(value = "")


  public Object getModel() {
    return model;
  }

  public void setModel(Object model) {
    this.model = model;
  }

  public ModelAndView modelMap(Map<String, Object> modelMap) {
    this.modelMap = modelMap;
    return this;
  }

  public ModelAndView putModelMapItem(String key, Object modelMapItem) {
    if (this.modelMap == null) {
      this.modelMap = new HashMap<String, Object>();
    }
    this.modelMap.put(key, modelMapItem);
    return this;
  }

  /**
   * Get modelMap
   * @return modelMap
  **/
  @ApiModelProperty(value = "")


  public Map<String, Object> getModelMap() {
    return modelMap;
  }

  public void setModelMap(Map<String, Object> modelMap) {
    this.modelMap = modelMap;
  }

  public ModelAndView reference(Boolean reference) {
    this.reference = reference;
    return this;
  }

  /**
   * Get reference
   * @return reference
  **/
  @ApiModelProperty(value = "")


  public Boolean isReference() {
    return reference;
  }

  public void setReference(Boolean reference) {
    this.reference = reference;
  }

  public ModelAndView status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public ModelAndView view(View view) {
    this.view = view;
    return this;
  }

  /**
   * Get view
   * @return view
  **/
  @ApiModelProperty(value = "")

  @Valid

  public View getView() {
    return view;
  }

  public void setView(View view) {
    this.view = view;
  }

  public ModelAndView viewName(String viewName) {
    this.viewName = viewName;
    return this;
  }

  /**
   * Get viewName
   * @return viewName
  **/
  @ApiModelProperty(value = "")


  public String getViewName() {
    return viewName;
  }

  public void setViewName(String viewName) {
    this.viewName = viewName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelAndView modelAndView = (ModelAndView) o;
    return Objects.equals(this.empty, modelAndView.empty) &&
        Objects.equals(this.model, modelAndView.model) &&
        Objects.equals(this.modelMap, modelAndView.modelMap) &&
        Objects.equals(this.reference, modelAndView.reference) &&
        Objects.equals(this.status, modelAndView.status) &&
        Objects.equals(this.view, modelAndView.view) &&
        Objects.equals(this.viewName, modelAndView.viewName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(empty, model, modelMap, reference, status, view, viewName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelAndView {\n");
    
    sb.append("    empty: ").append(toIndentedString(empty)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    modelMap: ").append(toIndentedString(modelMap)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    view: ").append(toIndentedString(view)).append("\n");
    sb.append("    viewName: ").append(toIndentedString(viewName)).append("\n");
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

