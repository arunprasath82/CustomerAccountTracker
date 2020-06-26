package com.arun.accountTracker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Account {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long accountId;
	private Long customerId;
	private Long CustomerAccNumber;
	private String accountType;
	private Long balancemount;
//	private Customer customer;
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(Long accountId, Long customerId, Long customerAccNumber, String accountType, Long balancemount) {
	super();
	this.accountId = accountId;
	this.customerId = customerId;
	CustomerAccNumber = customerAccNumber;
	this.accountType = accountType;
	this.balancemount = balancemount;
    }
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getCustomerAccNumber() {
		return CustomerAccNumber;
	}
	public void setCustomerAccNumber(Long customerAccNumber) {
		CustomerAccNumber = customerAccNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Long getBalancemount() {
		return balancemount;
	}
	public void setBalancemount(Long balancemount) {
		this.balancemount = balancemount;
	}
/*	@OneToOne(mappedBy = "account")
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}*/
	

}
