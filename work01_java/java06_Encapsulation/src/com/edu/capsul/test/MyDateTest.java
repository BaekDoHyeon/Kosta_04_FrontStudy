package com.edu.capsul.test;

import java.util.Scanner;

import com.edu.capsul.MyDate;

public class MyDateTest {
//월에 따라서 날짜가 결정되는 프로그램
	public static void main(String[] args) {
		MyDate md = new MyDate();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("월 입력 >>>");
		int month = sc.nextInt();
		
		System.out.print("날짜 입력 >>>");
		int day = sc.nextInt();
		
		md.setMonth(month);
		md.setDay(day);
		
		System.out.println("Today is " + md.getMonth() + "월 " + md.getDay() + " 일 입니다.");
	}

}
