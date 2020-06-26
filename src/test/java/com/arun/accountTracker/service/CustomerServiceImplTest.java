package com.arun.accountTracker.service;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.arun.accountTracker.model.Customer;
import com.arun.accountTracker.respository.CustomerRepository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;



@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceImplTest {
	
	@InjectMocks
	CustomerServiceImpl customerServiceImpl;
	
	Customer arunCustomer;
	Customer prasathCustomer;
	
	@MockBean
	CustomerRepository customerRepository;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		arunCustomer=new Customer((long) 1, "arun", "98798798", "arun@hotmail","electronic city", "Bangalore", "India");
		prasathCustomer= new Customer((long) 2, "prasath", "98798798", "arun@hotmail","electronic city", "Bangalore", "India");
	  
	}
	
	@Test
	public void getCustomerDetailsById() {
		System.out.println("arunCustomer==="+arunCustomer.getCustomerAddress());
		Mockito.when(customerRepository.findById((long)1)).thenReturn(Optional.of(arunCustomer));
	    assertThat(customerRepository.findById((long)1)).isEqualTo(Optional.of(arunCustomer));
	}
	
	@Test
	public void testAddCustomerDetails() {
		Mockito.when(customerRepository.save(arunCustomer)).thenReturn(arunCustomer);
		assertThat(customerRepository.save(arunCustomer)).isEqualTo(arunCustomer);
		
	}
	
	@Test
	public void testGetAllCustomerDetails(){
	}
	
	@Test
	public void testDeleteCustomerDetails() {
		Mockito.doNothing().when(customerRepository).deleteById((long)1);	
		Mockito.when(customerRepository.existsById(arunCustomer.getCustomerId())).thenReturn(false);
		assertFalse(customerRepository.existsById(arunCustomer.getCustomerId()));
	}

}
