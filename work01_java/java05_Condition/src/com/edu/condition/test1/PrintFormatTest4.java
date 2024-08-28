package com.edu.condition.test1;

import java.util.Random;

//Formatting 출력하기 | 삼항 연산자
public class PrintFormatTest4 {

	public static void main(String[] args) {
		Random r = new Random();
		String result = "";
		
		System.out.println("======== 큰수? 혹은 작은수? ========");
		int num = r.nextInt(100); //0~99사이의 정수
		
		if (num > 50) result = "큰수";
		else result = "작은수";
		System.out.println(num+"은(는)"+result+"이다.");
		
		System.out.printf("%d은(는)%s이다.%n", num, result); //Formatting
		
		result = (num > 50) ? "큰수": "작은수"; //삼항 연산자
		System.out.println(num+"은(는)"+result+"이다."); 
		
		System.out.println("################################");
		System.out.println("======== 큰수? 혹은 작은수? ========");
		
		int num2 = r.nextInt(10); //0~9임의의 정수
		if(num2 % 2 == 0) result = "짝수"	;
		else result = "홀수";
		System.out.printf("%d은(는) %s이다.%n", num2, result);
		
		result = (num2%2==0) ? "짝수" : "홀수";
		System.out.println(num2+"은(는) " + result +"입니다.");
	}
}
