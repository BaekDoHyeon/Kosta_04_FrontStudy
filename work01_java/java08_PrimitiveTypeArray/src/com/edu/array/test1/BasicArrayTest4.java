package com.edu.array.test1;

import java.util.Scanner;

/*
 * Scanner를 사용해서 맨 처음 입력받는 값으로 배열의 크기를 받아오자.
 * int size = sc.nextInt(); //3 
 */
public class BasicArrayTest4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력받을 이름의 갯수를 입력해주세요 : ");
		int size = sc.nextInt();
		String[] names = new String[size];
		
		for(int i = 0; i < names.length; i++) {
			System.out.print("사용자 이름 입력 : ");
			names[i] = sc.next();
		}
		
		for(String name : names) System.out.println(name);
	}
}