package com.arun.accountTracker;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.arun.accountTracker.model.Account;
import com.arun.accountTracker.model.Customer;
import com.arun.accountTracker.service.AccountServiceImpl;
import com.arun.accountTracker.service.CustomerServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers=AccountController.class)
public class AccountControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	
	@MockBean
	AccountServiceImpl accountServiceImpl ;
	
	Account arunAcount;
	Account prasathAccount;
	String arunJsonString;
	String prasathJsonString;
	
	@Autowired
	ObjectMapper mapper;
	
	
	@Before
	public void setup() throws JsonProcessingException {
		MockitoAnnotations.initMocks(this);
		arunAcount = new Account((long) 1, (long)1, (long)1, "saving",(long) 1000); 
		prasathAccount=new Account((long) 2, (long)2, (long)2, "saving",(long) 1000); 
		arunJsonString=mapper.writeValueAsString(arunAcount);	   
	    prasathJsonString=mapper.writeValueAsString(prasathAccount);
		
	}
	
	@Test
	public void getCustomerDetails() throws Exception {		
		Mockito.when(accountServiceImpl.getAccountDetails((long)1)).thenReturn(arunAcount);
		mockMvc.perform(get("/accountDeatils"+"/{id}",1)).andExpect(content().string(arunJsonString)).andExpect(status().isOk());
	}
	
	@Test
	public void addAccountDetails() throws Exception {
		Mockito.doNothing().when(accountServiceImpl).addAccountDetails(arunAcount);
		mockMvc.perform(post("/addAccount").contentType(MediaType.APPLICATION_JSON).content(arunJsonString)).andExpect(status().isOk());	
		
	}
	
	@Test
	public void deleteCustomerDetails() throws Exception {
		Mockito.doNothing().when(accountServiceImpl).deleteAccountDetails((long)1);		
		mockMvc.perform(delete("/deleteAccount"+"/{id}",1)).andExpect(status().isOk());
		
	}
	
	@Test
	public void CustomerDetails() throws Exception{
		
		Mockito.when(accountServiceImpl.getAccountDetails((long)1)).thenReturn(arunAcount);
		Mockito.doNothing().when(accountServiceImpl).addAccountDetails(arunAcount);
		mockMvc.perform(put("/updateAccount").contentType(MediaType.APPLICATION_JSON).content(arunJsonString)).andExpect(status().isOk());
	}
	
	

}
