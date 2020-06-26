package com.arun.accountTracker.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.arun.accountTracker.model.Account;
import com.arun.accountTracker.model.Customer;
import com.arun.accountTracker.respository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired 
	CustomerServiceImpl customerServiceImpl;
	
	@Override
	public Account getAccountDetails(Long id) {
		System.out.println("fromAccountId inside method"+id);
		Optional<Account> customerDetailsResponse =  accountRepository.findById(id);
		System.out.println("customerDetailsResponse"+customerDetailsResponse);
		Account accountDetails=customerDetailsResponse.get();
		return accountDetails;
		
	}
	@Override
	public void addAccountDetails(Account account) {
		accountRepository.save(account);
		
	}
	@Override
	public void deleteAccountDetails(Long id) {
		accountRepository.deleteById(id);
	}
	
    public Customer fundTransfer(Long fromAccountId, Long toAccountId, Long amount){
    	System.out.println("fromAccountId"+fromAccountId);
		
		Account customerDetailsFromAccount = getAccountDetails(fromAccountId);
		Account customerDetailsToAccount = getAccountDetails(toAccountId);
		if(customerDetailsFromAccount.getBalancemount()>amount) {
			customerDetailsToAccount.setBalancemount(customerDetailsToAccount.getBalancemount()+amount);
			customerDetailsFromAccount.setBalancemount(customerDetailsFromAccount.getBalancemount()-amount);
			addAccountDetails(customerDetailsToAccount);
			addAccountDetails(customerDetailsFromAccount);
		}
		Customer customerDetails = customerServiceImpl.getCustomerDetailsById(customerDetailsToAccount.getCustomerId());
		return customerDetails;
    } 
}
