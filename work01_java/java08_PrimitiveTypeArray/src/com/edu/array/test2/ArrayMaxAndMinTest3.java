package com.edu.array.test2;
/*
	성적중에서 최고 성적과 최저성적을 구하라
 */
public class ArrayMaxAndMinTest3 {

	public static void main(String[] args) {
		
		int[] scores = {79, 88, 91, 45, 100, 58, 91};
		int max = scores[0]; //배열의 첫번째 값으로 최대값을 초기화한다...79
		int min = scores[0]; //배열의 첫번째 값으로 최소값을 초기화한다...79
		
		for(int i : scores) {
			if (max < i) max = i;
			else if (min > i) min = i;
		}
		
		System.out.println("최대값 : " + max + ", 최소값 : " + min);
	
	}
}