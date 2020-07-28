package com.example.msscbrewery.web.controller;

import com.example.msscbrewery.services.CustomerService;
import com.example.msscbrewery.web.model.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {


    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable UUID customerId) {

        return new ResponseEntity<>(customerService.getCustomerByUUid(customerId), HttpStatus.OK);
    }

}
