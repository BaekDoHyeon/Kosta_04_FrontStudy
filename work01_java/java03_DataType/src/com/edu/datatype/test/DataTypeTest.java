package com.edu.datatype.test;

public class DataTypeTest {

	public static void main(String[] args) {
		//지역(Local)변수는 기본값을 가지지 않는다. -> 필드만 기본값을 가진다.
		float salary = 100;
		System.out.println(salary);
		
		float salary2 = 100.0f;
		System.out.println(salary2);
		
		System.out.println("=======================");
		
		// int 타입 이하에서 사칙연산이 일어나면 int 타입으로 변환한다.(타입 비교)
		short a, b;
		a = 1; b = 2;
		short c = (short)(a+b);
		System.out.println(c);
		
		int x = 24;
		//byte b2 = x; //Error
		byte b2 = 24;
		System.out.println(b2);
	
	}

}