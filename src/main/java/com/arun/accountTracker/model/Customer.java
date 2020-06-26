package com.arun.accountTracker.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long customerId;
	private String customerName;
	private String customerMobileNo;
	private String customerEmailId;
	private String customerAddress;
	private String customerCity;
	private String customerCountry;
//	private Account account;
	
	/*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}*/
	public Customer(Long customerId, String customerName, String customerMobileNo, String customerEmailId,
			String customerAddress, String customerCity, String customerCountry) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerMobileNo = customerMobileNo;
		this.customerEmailId = customerEmailId;
		this.customerAddress = customerAddress;
		this.customerCity = customerCity;
		this.customerCountry = customerCountry;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerMobileNo() {
		return customerMobileNo;
	}
	public void setCustomerMobileNo(String customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerCity() {
		return customerCity;
	}
	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}
	public String getCustomerCountry() {
		return customerCountry;
	}
	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}
	
	

}
