package com.edu.array.test1;
/*
 * 배열 : Same Data Type
 * 1) 선언
 * 2) 생성   --- 반드시 배열의 사이즈가 명시
 * 3) 초기화
 */
public class BasicArrayTest2 {

	public static void main(String[] args) {
		//1)선언 + 생성(size 명시)
		int[] arr = new int[3];
		
		//3)명시적 초기화
		arr[0] = 11;
		arr[1] = 22;
		arr[2] = 33;
		
		//배열은 클래스 타입을 제공하지 않음! -> 필드와 메소드가 없다~
		for(int i = 0; i < arr.length; i++) System.out.println(arr[i]);
		
		//향샹된 for 문 사용...
		for (int j : arr) System.out.println(j);
	}
}