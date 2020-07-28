package com.example.msscbrewery.services;

import com.example.msscbrewery.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {

    public CustomerDTO getCustomerByUUid(UUID customerId);
}
