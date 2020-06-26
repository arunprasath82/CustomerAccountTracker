package com.arun.accountTracker.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.arun.accountTracker.model.Account;
import com.arun.accountTracker.model.Customer;
import com.arun.accountTracker.respository.AccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceImplTest {
	
	@InjectMocks
	AccountServiceImpl accountServiceImpl;
	
	@MockBean
	CustomerServiceImpl customerServiceImpl;
	
	@MockBean
	AccountRepository accountRepository;
	
	Account arunAcount;
	Account prasathAccount;
	Customer arunCustomer;
	Customer prasathCustomer;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		arunAcount = new Account((long) 1, (long)1, (long)1, "saving",(long) 1000); 
		prasathAccount=new Account((long) 2, (long)2, (long)2, "saving",(long) 1000); 
		arunCustomer=new Customer((long) 1, "arun", "98798798", "arun@hotmail","electronic city", "Bangalore", "India");
		prasathCustomer= new Customer((long) 2, "prasath", "98798798", "arun@hotmail","electronic city", "Bangalore", "India");
	 
			
		
	}
	
	@Test
	public void testAddAccountDetails() {
		Mockito.when(accountRepository.save(arunAcount)).thenReturn(arunAcount);
		assertThat(accountRepository.save(arunAcount)).isEqualTo(arunAcount);
		
	}
	
	@Test
	public void getAccountDetails() {
		
		Mockito.when(accountRepository.findById((long)1)).thenReturn(Optional.of(arunAcount));
	    assertThat(accountRepository.findById((long)1)).isEqualTo(Optional.of(arunAcount));
	}
	
	@Test
	public void testDeleteAccountDetails() {
		Mockito.doNothing().when(accountRepository).deleteById((long)1);	
		Mockito.when(accountRepository.existsById(arunAcount.getAccountId())).thenReturn(false);
		assertFalse(accountRepository.existsById(arunAcount.getAccountId()));
	}
	
	@Test
	public void testFundTransfer(){
		
		long amount =500;
		
		Mockito.when(accountRepository.findById((long)1)).thenReturn(Optional.of(arunAcount));
		assertThat(accountRepository.findById((long)1)).isEqualTo(Optional.of(arunAcount));
		Mockito.when(accountRepository.findById((long)2)).thenReturn(Optional.of(prasathAccount));
		assertThat(accountRepository.findById((long)2)).isEqualTo(Optional.of(prasathAccount));
		
		if(arunAcount.getBalancemount()>amount) {
			arunAcount.setBalancemount(arunAcount.getBalancemount()-amount);
			prasathAccount.setBalancemount(prasathAccount.getBalancemount()+amount);
			Mockito.when(accountRepository.save(arunAcount)).thenReturn(arunAcount);
			Mockito.when(accountRepository.save(prasathAccount)).thenReturn(prasathAccount);
		}
		Mockito.when(customerServiceImpl.getCustomerDetailsById((long)1)).thenReturn(prasathCustomer);
		    assertThat(customerServiceImpl.getCustomerDetailsById((long)1)).isEqualTo(prasathCustomer);

	}
	}
