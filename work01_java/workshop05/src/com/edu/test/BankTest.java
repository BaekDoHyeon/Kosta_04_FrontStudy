package com.edu.test;

import com.edu.service.BankService;
import com.edu.util.Account;
import com.edu.util.Address;
import com.edu.vo.Customer;

public class BankTest {

	public static void main(String[] args) {
		
		Address ad = new Address(1, "2", "3");
		Account ac = new Account(1000);
		
		//Address 테스트
		System.out.println("======= 1. Address 테스트 =======");
		System.out.println(ad.toString());
		
		//Account 테스트
		System.out.println("======= 2. Account 테스트 =======");
		ac.deposit(10000);
		ac.deposit(50000);
		ac.withdraw(30000);
		ac.withdraw(80000);
		System.out.println(ac.toString());
		
		//Customer 테스트
		System.out.println("======= 3. Customer 테스트 =======");
		Customer customer = new Customer("Baek", 2000 , ad, ac);
		System.out.println(customer.toString());
		
		//BankService 테스트
		System.out.println("======= 4. BankService 테스트 =======");
		BankService bs = new BankService();
		bs.addCustomer(customer);
	}

}
