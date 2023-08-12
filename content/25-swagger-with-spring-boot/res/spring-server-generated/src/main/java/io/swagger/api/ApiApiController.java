package io.swagger.api;

import io.swagger.model.CategoryDTO;
import io.swagger.model.CatorgoryListDTO;
import io.swagger.model.CustomerDTO;
import io.swagger.model.CustomerListDTO;
import io.swagger.model.VendorDTO;
import io.swagger.model.VendorListDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-08-12T06:05:54.271Z")

@Controller
public class ApiApiController implements ApiApi {

    private static final Logger log = LoggerFactory.getLogger(ApiApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ApiApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<CustomerDTO> createNewCustomerUsingPOST(@ApiParam(value = "customerDTO" ,required=true )  @Valid @RequestBody CustomerDTO customerDTO) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("")) {
            try {
                return new ResponseEntity<CustomerDTO>(objectMapper.readValue("", CustomerDTO.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type ", e);
                return new ResponseEntity<CustomerDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CustomerDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<VendorDTO> createNewVendorUsingPOST(@ApiParam(value = "vendorDTO" ,required=true )  @Valid @RequestBody VendorDTO vendorDTO) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("")) {
            try {
                return new ResponseEntity<VendorDTO>(objectMapper.readValue("", VendorDTO.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type ", e);
                return new ResponseEntity<VendorDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<VendorDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteCustomerUsingDELETE(@ApiParam(value = "id",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteVendorUsingDELETE(@ApiParam(value = "id",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CatorgoryListDTO> getAllCategoriesUsingGET() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("")) {
            try {
                return new ResponseEntity<CatorgoryListDTO>(objectMapper.readValue("", CatorgoryListDTO.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type ", e);
                return new ResponseEntity<CatorgoryListDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CatorgoryListDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CategoryDTO> getCategoryByNameUsingGET(@ApiParam(value = "name",required=true) @PathVariable("name") String name) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("")) {
            try {
                return new ResponseEntity<CategoryDTO>(objectMapper.readValue("", CategoryDTO.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type ", e);
                return new ResponseEntity<CategoryDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CategoryDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CustomerDTO> getCustomerByIdUsingGET(@ApiParam(value = "id",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("")) {
            try {
                return new ResponseEntity<CustomerDTO>(objectMapper.readValue("", CustomerDTO.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type ", e);
                return new ResponseEntity<CustomerDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CustomerDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CustomerListDTO> getListOfCustomersUsingGET() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("")) {
            try {
                return new ResponseEntity<CustomerListDTO>(objectMapper.readValue("", CustomerListDTO.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type ", e);
                return new ResponseEntity<CustomerListDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CustomerListDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<VendorDTO> getVendorByIdUsingGET(@ApiParam(value = "id",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("")) {
            try {
                return new ResponseEntity<VendorDTO>(objectMapper.readValue("", VendorDTO.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type ", e);
                return new ResponseEntity<VendorDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<VendorDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<VendorListDTO> getVendorListUsingGET() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("")) {
            try {
                return new ResponseEntity<VendorListDTO>(objectMapper.readValue("", VendorListDTO.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type ", e);
                return new ResponseEntity<VendorListDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<VendorListDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CustomerDTO> patchCustomerUsingPATCH(@ApiParam(value = "id",required=true) @PathVariable("id") Long id,@ApiParam(value = "customerDTO" ,required=true )  @Valid @RequestBody CustomerDTO customerDTO) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("")) {
            try {
                return new ResponseEntity<CustomerDTO>(objectMapper.readValue("", CustomerDTO.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type ", e);
                return new ResponseEntity<CustomerDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CustomerDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<VendorDTO> patchVendorUsingPATCH(@ApiParam(value = "id",required=true) @PathVariable("id") Long id,@ApiParam(value = "vendorDTO" ,required=true )  @Valid @RequestBody VendorDTO vendorDTO) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("")) {
            try {
                return new ResponseEntity<VendorDTO>(objectMapper.readValue("", VendorDTO.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type ", e);
                return new ResponseEntity<VendorDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<VendorDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CustomerDTO> updateCustomerUsingPUT(@ApiParam(value = "id",required=true) @PathVariable("id") Long id,@ApiParam(value = "customerDTO" ,required=true )  @Valid @RequestBody CustomerDTO customerDTO) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("")) {
            try {
                return new ResponseEntity<CustomerDTO>(objectMapper.readValue("", CustomerDTO.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type ", e);
                return new ResponseEntity<CustomerDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CustomerDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<VendorDTO> updateVendorUsingPUT(@ApiParam(value = "id",required=true) @PathVariable("id") Long id,@ApiParam(value = "vendorDTO" ,required=true )  @Valid @RequestBody VendorDTO vendorDTO) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("")) {
            try {
                return new ResponseEntity<VendorDTO>(objectMapper.readValue("", VendorDTO.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type ", e);
                return new ResponseEntity<VendorDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<VendorDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

}
