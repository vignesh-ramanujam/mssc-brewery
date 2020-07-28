package com.example.msscbrewery.services;

import com.example.msscbrewery.web.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerByUUid(UUID customerId) {

        return CustomerDTO.builder().
                id(UUID.randomUUID()).name("Mike").
                build();
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {

        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Sachin")
                .build();

    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDTO customerDTO) {


    }

    @Override
    public void deleteCustomer(UUID customerId) {

    }
}
