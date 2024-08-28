package com.edu.condition.test3;

import java.util.Scanner;

public class CatchAMouseTest {

	public static String solv(int a, int b, int m) {
		// 이 안에 로직을 작성
		
		// if (catA 가 catB 보다 mouse에 더 가까울 때) 
		// else if (catA 와 catB가 mouse 와 거리가 동일할 때) 
		// else (CatB가 mouse에 더 가까울 때)
		if (Math.abs(b-m) > Math.abs(a-m)) {
			return "CatA Catch!!";
		} else if (Math.abs(b-m) == Math.abs(a-m)) {
			return "Mouse Escapes!!";
		} else {
			return "CatB Catch!!";
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int catA = sc.nextInt();
		int catB = sc.nextInt();
		int mouse = sc.nextInt();
		
		
		String result = solv(catA, catB, mouse);
		System.out.println(result);
	}

}
