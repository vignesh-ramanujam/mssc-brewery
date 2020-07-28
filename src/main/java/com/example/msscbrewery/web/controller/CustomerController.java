package com.example.msscbrewery.web.controller;

import com.example.msscbrewery.services.CustomerService;
import com.example.msscbrewery.web.model.CustomerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<CustomerDTO> handlePost(@RequestBody CustomerDTO customerDTO) {

        CustomerDTO newCustomeDTO = customerService.createCustomer(customerDTO);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/customer/"+ newCustomeDTO.getId().toString());
        return new ResponseEntity(newCustomeDTO, httpHeaders, HttpStatus.CREATED);
    }
    @PutMapping({"/{customerId}"})
    public ResponseEntity handleUpdate(@PathVariable UUID customerId , CustomerDTO customerDTO) {
        customerService.updateCustomer(customerId, customerDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable UUID customerId ) {
        customerService.deleteCustomer(customerId);
    }


}
