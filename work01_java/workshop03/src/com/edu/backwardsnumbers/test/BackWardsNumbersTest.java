package com.edu.backwardsnumbers.test;

import java.util.Scanner;

public class BackWardsNumbersTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("1 이상의 숫자를 입력하세요 :");
			int number = sc.nextInt();
			
			if (number < 1) continue;
			
			for(int min = 1; number >= min; number--) {
				System.out.print(number + " ");
			}
			
			System.exit(0);
			
		} while(true);
	}
}