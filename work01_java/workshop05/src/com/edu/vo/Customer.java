package com.edu.vo;

import com.edu.util.Account;
import com.edu.util.Address;

public class Customer {
	private String name;
	private int ssn;
	private Address address;
	private Account account;
	
	public Customer(int ssn) {
		this.ssn = ssn;
	}

	public Customer(String name,int ssn, Address address) {
		this.name = name;
		this.ssn = ssn;
		this.address = address;
	}

	public Customer(String name, int ssn, Address address, Account account) {
		this.name = name;
		this.ssn = ssn;
		this.address = address;
		this.account = account;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getSsn() {
		return ssn;
	}
	
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String toString() {
		return "Customer [name=" + name + ", ssn=" + ssn + ", address=" + address + ", account=" + account + "]";
	}	
	
}
