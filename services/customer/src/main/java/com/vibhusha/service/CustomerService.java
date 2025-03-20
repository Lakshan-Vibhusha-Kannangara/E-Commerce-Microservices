package com.vibhusha.service;

import com.vibhusha.dto.CustomerResponse;
import com.vibhusha.exceptions.CustomerNotFoundException;
import com.vibhusha.model.Customer;
import com.vibhusha.model.CustomerRequest;
import com.vibhusha.repository.CustomerRepository;
import com.vibhusha.util.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    @Autowired
    private CustomerRepository repository;
    @Autowired
    private final CustomerMapper mapper;

    public Customer createCustomer(CustomerRequest request) {
        return repository.save(mapper.toCustomer(request));
    }

    public void updateCustomer(CustomerRequest request) {
        Customer customer = repository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(String.format("The customer %s cannot be updated:: No customer with given id %s is available", request.email(), request.id())));
        mergerCustomer(customer, request);
        repository.save(customer);
    }

    private void mergerCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstName())) {
            customer.setFirstName(request.firstName());
        }
        if (StringUtils.isNotBlank(request.lastName())) {
            customer.setLastName(request.lastName());
        }
        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }
        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }

    public List<CustomerResponse> findAllCustomers() {
        return repository.findAll().stream().map(mapper::toCustomerResponse).collect(Collectors.toList());
    }
}
