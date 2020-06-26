package com.arun.accountTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.accountTracker.model.Customer;
import com.arun.accountTracker.service.CustomerServiceImpl;


@RestController
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	@GetMapping("/CustomerDeatils/{id}")
	public Customer getCustomerDetails(@PathVariable Long id) {
		
		return customerServiceImpl.getCustomerDetailsById(id);
	}
	
	@PostMapping(path="/addCustomer", consumes= {"application/json"})
	public String addCustomerDetails(@RequestBody Customer customer) {
	System.out.println("customerrrrr===>>"+customer.getCustomerAddress());
	customerServiceImpl.addCustomerDetails(customer);
	return "Customer added sucessfully" ;
	}
	
	@PutMapping(path="/updateCustomer",consumes= {"application/json"})
	public Customer updateCustomerDetails( @RequestBody Customer customer) {
	customerServiceImpl.addCustomerDetails(customer);
	return customer;
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public String deleteCustomerDetails(@PathVariable Long id) {
	customerServiceImpl.deleteCustomerDetails(id);
	return "customer details deleted";
	}

}
