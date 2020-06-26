package com.arun.accountTracker;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import javax.net.ssl.SSLEngineResult.Status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito.Then;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.arun.accountTracker.model.Customer;
import com.arun.accountTracker.service.CustomerServiceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers=CustomerController.class)
public class CustomerControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	
	
	@MockBean
	CustomerServiceImpl customerServiceImpl ;
	
	Customer arunCustomer;
	Customer prasathCustomer;
	String requestUrl="/CustomerDeatils";
	String arunJsonString;
	String prasathJsonString;
	
	@Autowired
	ObjectMapper mapper;
	
	@Before
	public void setup() throws JsonProcessingException {
		
		MockitoAnnotations.initMocks(this);
		arunCustomer=new Customer((long) 1, "arun", "98798798", "arun@hotmail","electronic city", "Bangalore", "India");
		prasathCustomer= new Customer((long) 2, "prasath", "98798798", "arun@hotmail","electronic city", "Bangalore", "India");
	    arunJsonString=mapper.writeValueAsString(arunCustomer);	   
	    prasathJsonString=mapper.writeValueAsString(prasathCustomer);
	}

	@Test
	public void getCustomerDetails() throws Exception {
	//	when(customerServiceImpl1.getCustomerDetailsById(anyLong())).thenReturn(arunCustomer);
		
//		Customer customer= customerServiceImpl1.getCustomerDetailsById((long)1);
	//	assertNotNull(customer);
		
		System.out.println("arunJsonString===========>>"+arunCustomer.getCustomerAddress());
		
		
		Mockito.when(customerServiceImpl.getCustomerDetailsById((long)1)).thenReturn(arunCustomer);
		mockMvc.perform(get(requestUrl+"/{id}",1)).andExpect(content().string(arunJsonString)).andExpect(status().isOk());
	}
	
	@Test
	public void addCustomerDetails() throws Exception {
		Mockito.doNothing().when(customerServiceImpl).addCustomerDetails(arunCustomer);
		mockMvc.perform(post("/addCustomer").contentType(MediaType.APPLICATION_JSON).content(arunJsonString)).andExpect(status().isOk());	
		
	}
	
	@Test
	public void deleteCustomerDetails() throws Exception {
		Mockito.doNothing().when(customerServiceImpl).deleteCustomerDetails((long)1);		
		mockMvc.perform(delete("/deleteCustomer"+"/{id}",1)).andExpect(status().isOk());
		
	}
	
	@Test
	public void CustomerDetails() throws Exception{
		
		Mockito.when(customerServiceImpl.getCustomerDetailsById((long)1)).thenReturn(arunCustomer);
		Mockito.doNothing().when(customerServiceImpl).addCustomerDetails(arunCustomer);
		mockMvc.perform(put("/updateCustomer").contentType(MediaType.APPLICATION_JSON).content(arunJsonString)).andExpect(status().isOk());
	}
 
}
