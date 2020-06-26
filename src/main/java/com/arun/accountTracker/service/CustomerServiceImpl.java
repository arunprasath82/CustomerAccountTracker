package com.arun.accountTracker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arun.accountTracker.model.Customer;
import com.arun.accountTracker.respository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository ;
	
	
	public void addCustomerDetails(Customer customer){
		 customerRepository.save(customer);
	}
	public List<Customer> getAllCustomerDetails(){
		List<Customer> customerList= new ArrayList<>();
		customerRepository.findAll().forEach(e->customerList.add(e));
		return customerList;
				
	}
	public Customer getCustomerDetailsById(Long id){
		Optional<Customer> customerDetailsResponse =  customerRepository.findById(id);
		Customer customerDetails=customerDetailsResponse.get();
		return customerDetails;
	}
/*	public void updateCustomerDetails(Customer cust) {
		
	}*/
	public void deleteCustomerDetails(Long id) {
		customerRepository.deleteById(id);
	}

}
