package com.edu.util;

public class Account {
	private int balance;
	
	public Account(int balance) {
		this.balance = balance;
	}
	
	public int getBalance() {
		return balance;
	}
	
	//입금
	public void deposit(int money) {
		balance += money;
		System.out.println("입금 완료하였습니다. 현재 잔액: " + balance + "원");
	}
	
	//출금
	public void withdraw(int money) {
		if(balance < money) 
			System.out.println("[잔액부족] 현재 잔액보다 많은 금액을 출금하려 하고있습니다.");
		else {
			balance -= money;
			System.out.println("출금 완료하였습니다. 현재 잔액: " + balance + "원");
		}
	}

	public String toString() {
		return "Account [balance=" + balance + "]";
	}
	
	
}
