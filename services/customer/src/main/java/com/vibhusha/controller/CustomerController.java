package com.vibhusha.controller;


import com.vibhusha.dto.CustomerResponse;
import com.vibhusha.util.CustomerMapper;
import com.vibhusha.model.CustomerRequest;
import com.vibhusha.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    @Autowired
    private final CustomerService service;


    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request){

        return ResponseEntity.ok(service.createCustomer(request).toString());
    }

    @PutMapping
    public ResponseEntity<Void> updateCustomer(@RequestBody @Valid CustomerRequest request){
        service.updateCustomer(request);
        return ResponseEntity.accepted().build();
    }

    public ResponseEntity<List<CustomerResponse>> findAll(){
        return ResponseEntity.ok(service.findAllCustomers());
    }
}
