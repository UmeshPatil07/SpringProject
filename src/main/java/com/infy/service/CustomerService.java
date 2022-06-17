package com.infy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.infy.dto.Customer;

import com.infy.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository repo;
	
	   public Customer getCustomer(int id) {
	   return repo.findById(id).get();
		
		}
	
		public Customer getCustomerById(int Id) {
			Customer c= repo.findById(Id).get();
			return c;
	    }
	
	
	    public Iterable<Customer> getCustomers(){
		Iterable<Customer> custs=repo.findAll();
		return custs;
	}
	
	
	    public Customer addCustomer(Customer c) {
	    repo.save(c);
	    return c;
	}
	
	
	    public Customer modifyCustomer(Customer c) {
		if(repo.existsById(c.getCustId()))
		 { repo.save(c);
			 return c;
		 } else
			 return null;}
		 
		  
	
	
	 public Customer delCustomer(int id) {
		 if(repo.existsById(id)) {
			Customer c= repo.findById(id).get();
			 repo.deleteById(id);
			 return c;
		 }else
			 return null;
	 }


}
