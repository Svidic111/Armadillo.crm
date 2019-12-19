package com.armadillo.crm.repositories;

import com.armadillo.crm.entities.Customer;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EntityScan("com.armadillo.crm.entities")
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    Optional<Customer> findById(Integer id);

}
