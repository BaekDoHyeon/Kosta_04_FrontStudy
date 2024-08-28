package com.edu.algorithm;

import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("테스트 번호 입력: ");
		int testNum = sc.nextInt();
		int[][] arr = new int[100][100];
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++)
				arr[i][j] = sc.nextInt();
		}
		
		System.out.println("#" + testNum + " " + solv(testNum, arr));
	}
	
	static int solv(int testNum, int[][] arr) {
		
		int sum1 = 0;
		int sum2 = 0;
		int tmpMax = 0;
		int max = 0;
	
		//가로 세로 합, 반복
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				sum1 += arr[i][j]; //가로 합
				sum2 += arr[j][i]; //세로 합
			}
			tmpMax = Math.max(sum1, sum2);
			max = Math.max(tmpMax, max);
			sum1 = sum2 = 0;
		}
		
		//대각선 합 
		for(int i = 0; i < 100; i++) {
			sum1 += arr[i][i];
			sum2 += arr[99-i][i];
		}
		tmpMax = Math.max(sum1, sum2);
		max = Math.max(tmpMax, max);
		
		return max;
	}

}
