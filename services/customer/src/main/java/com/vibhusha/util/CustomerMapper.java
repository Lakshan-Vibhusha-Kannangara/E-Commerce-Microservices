package com.vibhusha.util;

import com.vibhusha.dto.CustomerResponse;
import com.vibhusha.model.Customer;
import com.vibhusha.model.CustomerRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    public Customer toCustomer(CustomerRequest request) {
        if (request == null) {
            return null;
        }
        return Customer.builder().id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .address(request.address())
                .email(request.email())
                .build();

    }
    public CustomerResponse toCustomerResponse(Customer customer){
      return CustomerResponse.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .address(customer.getAddress())
                .build();
    }
}
