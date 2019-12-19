package com.armadillo.crm.service;

import com.armadillo.crm.entities.Customer;

import java.util.Optional;

public interface CustomerService {
    Optional<Customer> getCustomer(Integer id);
}
