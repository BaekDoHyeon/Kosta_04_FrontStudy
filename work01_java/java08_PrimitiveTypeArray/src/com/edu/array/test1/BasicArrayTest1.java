package com.edu.array.test1;
/*
 * 배열
 * 1) 선언	
 * 2) 생성   --- 반드시 배열의 사이즈가 명시	 
 * 3) 초기화 
 */
public class BasicArrayTest1 {

	public static void main(String[] args) {
		//1)선언
		int[] arr;
		
		//2)생성
		arr = new int[3];
		System.out.println("배열 Container 주소값 :: " + arr);	
		System.out.println("\n ================ 배열 안의 각각의 요소값[1] ================");
		for(int i = 0; i < 3; i++) System.out.println(arr[i]);
		
		//3)초기화
		arr[0] = 11;
		arr[1] = 22;
		arr[2] = 33;
		System.out.println("\n ================ 배열 안의 각각의 요소값[2] ================");
		for(int i = 0; i < 3; i++) System.out.println(arr[i]);
	}
}