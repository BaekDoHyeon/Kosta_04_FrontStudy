package com.edu.service;

import com.edu.vo.Customer;

public class BankService {
	public Customer[] customers;
	public static final int MAX_CUSTOMERS = 10;
	public int numberOfCustomers;
	
	public BankService() {
		customers = new Customer[MAX_CUSTOMERS];
		numberOfCustomers = 0;
	}
	
	public void addCustomer(Customer c) {
		customers[numberOfCustomers++] = c;
		System.out.println(c.getName() + "님이 등록되었습니다.");
	}
//	
//	public Customer getCustomer(int ssn) {
//		
//	}
//	
//	public void showAll() {
//		
//	}
}
