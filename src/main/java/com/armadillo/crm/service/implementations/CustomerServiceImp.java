package com.armadillo.crm.service.implementations;

import com.armadillo.crm.entities.Customer;
import com.armadillo.crm.repositories.CustomerRepository;
import com.armadillo.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Optional<Customer> getCustomer(Integer id) {
        return customerRepository.findById(id);
    }


    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
