package com.edu.condition.test3;

import java.util.Scanner;

public class Pattern369Test {

	public static void solv(int number) {
		// 코드 구현
		// 입력받은 number 의 십의자리 숫자와 일의자리 숫자가 둘다 3의 배수라면 @@ 출력 
		// 입력받은 number 의 십의자리 숫자와 일의자리 숫자 중 하나만 3의 배수라면 @ 출력 
		// 입력받은 number 의 십의자리 숫자와 일의자리 숫자 중 둘다 3의 배수가 아니라면 입력 받은 number 출력
		if (((number/10) % 3) == 0 && ((number%10) % 3) == 0) {
			System.out.println("@@");
		} else if (((number/10) % 3) == 0 || ((number%10) % 3) == 0) {
			System.out.println("@");
		} else {
			System.out.println(number);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("2자리 숫자입력 >> ");
		int n = sc.nextInt();
		
		solv(n);
	}

}
