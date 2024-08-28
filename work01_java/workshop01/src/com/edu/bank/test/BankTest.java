package com.edu.bank.test;

import com.edu.bank.Account;
import com.edu.bank.Customer;

public class BankTest {

	public static void main(String[] args) {

		//1.james, tomas라는 이름으로 고객을 생성
		Customer james = new Customer("James", "인천");
		Customer tomas = new Customer("Tomas", "서울");
		
		//2.james, tomas가 각각의 통장을 개설한다.
		james.openAccount(new Account(123, "Toss Bank", 10000));
		tomas.openAccount(new Account(456, "KaKao Bank", 0));
		
		//3.개설한 통장을 반환받아서 통장의 기능을 사용한다.
		//4.james가 1만원, 3만원을 입금하고 2만원을 출금 잔액을 최종적으로 출력한다.
		Account jamesAccount = james.getAccount();
		System.out.println("입금 20000원 >> ");
		jamesAccount.deposit(20000.0);
		
		System.out.println("입금 30000원 >> ");
		jamesAccount.deposit(30000.0);
		
		System.out.println("출금 20000원 >> ");
		jamesAccount.withdraw(20000.0);
		
		System.out.println("최종 잔액은 >> " + jamesAccount.getBalance() + " 원");
		
	}

}
