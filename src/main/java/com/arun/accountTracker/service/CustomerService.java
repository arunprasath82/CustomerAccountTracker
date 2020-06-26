package com.arun.accountTracker.service;

import java.util.List;

import com.arun.accountTracker.model.Customer;

public interface CustomerService {
	
	public void addCustomerDetails(Customer customer);
	public List<Customer> getAllCustomerDetails();
	public Customer getCustomerDetailsById(Long id);
	public void deleteCustomerDetails(Long id);
	

}
