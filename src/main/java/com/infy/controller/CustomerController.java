package com.infy.controller;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.Customer;

import com.infy.service.CustomerService;

import net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.Resolution;

@RestController
@RequestMapping("/rest")
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@GetMapping("/Customer")
	public Customer getCustomer() {
		Customer c =new Customer(1,"Umesh",22,"Jalgaon");
		return c;
		
	}
    @GetMapping("/Customer/{id}")
	public Customer getCustomerById(@PathVariable ("id")int id) {
	 Customer c =service.getCustomer(id);
		return c;
		
	}

	@GetMapping("/customers")
	public Iterable<Customer> getCustomers() {
		return service.getCustomers();
		
	}
	
	@PostMapping("/addcustomer")
		public Customer addCustomer(@RequestBody Customer c) {
		service.addCustomer(c);
		return c;
			
		}
	
	 @PutMapping("/modifycustomer")
	 public Customer modifyCustomer(@RequestBody Customer c) {
	 service.modifyCustomer(c);
		 return c;
	 }
	
	 @DeleteMapping("/deletecustomer/{id}")
	 public Customer delCustomer(@Valid@PathVariable("id")
			                     @Min(value=3,message="min value failed")
	                             @Max(value=5,message="max value failed")int id) {
		Customer c=service.delCustomer(id);
		 return c;
	 }
	

}
