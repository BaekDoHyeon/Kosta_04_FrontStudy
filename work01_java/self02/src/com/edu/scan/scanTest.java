package com.edu.scan;

import java.util.Scanner;

public class scanTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int age;
		String name;
		int currentMoney;
		
		//next()
		System.out.print("현재 나이를 입력하세요: ");
		age = in.nextInt();
		System.out.print("이름을 입력하세요: ");
		name = in.next();
		System.out.print("현재 지갑에 돈은 얼마나 있는지 입력하세요: ");
		currentMoney = in.nextInt();
		
		System.out.println("이름은: " + name + ", 나이는: " + age +"살, 현재 지갑에 있는 돈: " + currentMoney);
		
		/* //nextLine()
		System.out.print("현재 나이를 입력하세요: ");
		age = in.nextInt();
		System.out.print("이름을 입력하세요: ");
		name = in.nextLine();
		System.out.print("현재 지갑에 돈은 얼마나 있는지 입력하세요: ");
		currentMoney = in.nextInt();
		
		System.out.println("이름은: " + name + ", 나이는: " + age +"살, 현재 지갑에 있는 돈: " + currentMoney);
		*/
	}

}
