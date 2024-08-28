package com.edu.bank.test;

import java.util.Scanner;
import com.edu.bank.Account;
import com.edu.bank.Customer;

public class BankTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Customer james = new Customer();
		Customer tomas = new Customer();
		
		do {
			System.out.println("===== 메뉴를 선택해주세요. =====");
			System.out.println("1. 고객 생성\t 2.계좌 개설\t 3.입금\t 4.출금\t 5.잔액조회\t 6.고객정보조회\t 7.종료");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				//1.james, tomas라는 이름으로 고객을 생성
				System.out.println("고객 생성 완료\n");
				james = new Customer("James", "LA");
				tomas = new Customer("Tomas", "NY");
				break;
			case 2:
				System.out.println("계좌 개설 완료되었습니다.\n");
				//2.james, tomas가 각각의 통장을 개설한다.
				james.openAccount(new Account(123, "KB", 15000));
				tomas.openAccount(new Account(456, "Toss", 0));
				break;
			case 3:
				System.out.println("James 고객님 계좌에 2만원 입금 완료되었습니다.\n");
				james.getAccount().deposit(20000.0);
				break;
			case 4:
				System.out.println("James 고객님 계좌에서 1만원 출금 되었습니다.\n");
				james.getAccount().withdraw(10000.0);
				break;
			case 5:
				System.out.println("James 고객님 계좌에서 잔액을 조회합니다.\n");
				System.out.println("James님 계좌의 현재 잔액은 >> " + james.getAccount().getBalance() + " 원 입니다.");
				break;
			case 6: 
				System.out.println("James 고객님 정보를 조회합니다.\n");
				System.out.println(james.getCustomerInfo());
				break;
			case 7:
				System.out.println("프로그램을 종료합니다...");
				System.exit(0);
			default:
				System.out.println("잘못 입력하셨습니다.\n");
			}
			
		} while (true);
	}
}
