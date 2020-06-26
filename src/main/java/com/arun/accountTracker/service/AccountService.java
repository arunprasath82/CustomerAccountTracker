package com.arun.accountTracker.service;

import com.arun.accountTracker.model.Account;

public interface AccountService {
	
	public Account getAccountDetails(Long id);
	public void addAccountDetails(Account account);
	public void deleteAccountDetails(Long id);
//	public Customer updateCustomerDetails();

}
