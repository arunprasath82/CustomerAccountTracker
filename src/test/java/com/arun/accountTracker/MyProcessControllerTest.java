package com.arun.accountTracker;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.arun.accountTracker.model.Account;
import com.arun.accountTracker.model.Customer;
import com.arun.accountTracker.service.AccountServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers=MyProcessController.class)
public class MyProcessControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	
	@MockBean
	AccountServiceImpl accountServiceImpl ;
	
	Account arunAcount;
	Account prasathAccount;
	Customer arunCustomer;
	Customer prasathCustomer;
	
	String arunJsonString;
	String prasathJsonString;
	
	@Autowired
	ObjectMapper mapper;
	
	@Before
	public void setup() throws JsonProcessingException {
		MockitoAnnotations.initMocks(this);
		arunAcount = new Account((long) 1, (long)1, (long)1, "saving",(long) 1000); 
		prasathAccount=new Account((long) 2, (long)2, (long)2, "saving",(long) 1000); 
		arunCustomer=new Customer((long) 1, "arun", "98798798", "arun@hotmail","electronic city", "Bangalore", "India");
		prasathCustomer= new Customer((long) 2, "prasath", "98798798", "arun@hotmail","electronic city", "Bangalore", "India");
	 
		arunJsonString=mapper.writeValueAsString(arunCustomer);	   
	    prasathJsonString=mapper.writeValueAsString(prasathCustomer);	    
		
	}
	
	@Test
	public void fundTransferTest() throws Exception {
		Mockito.when(accountServiceImpl.fundTransfer((long)1, (long)2, (long)500)).thenReturn(prasathCustomer);
		mockMvc.perform(MockMvcRequestBuilders.get("/fundTransfer").param("fromAccountId",Long.toString(1)).param("toAccountId",Long.toString(2)).param("amount",Long.toString((long)500))).andExpect(content().string(prasathJsonString));
	//	assert
	}
	

}
