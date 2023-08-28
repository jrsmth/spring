package guru.springframework.msscbrewery.web.mappers;

import guru.springframework.msscbrewery.domain.Customer;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-28T22:00:44+0100",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer customerDtoToCustomer(CustomerDto dto) {
        if ( dto == null ) {
            return null;
        }

        Customer customer = new Customer();

        return customer;
    }

    @Override
    public CustomerDto customerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        return customerDto;
    }
}
