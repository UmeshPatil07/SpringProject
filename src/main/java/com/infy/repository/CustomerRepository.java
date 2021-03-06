package com.infy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infy.dto.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
