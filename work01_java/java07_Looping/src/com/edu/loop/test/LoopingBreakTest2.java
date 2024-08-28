package com.edu.loop.test;
/*
 * 1. 반복문을 이용해서 1~100까지의 총합을 구하는 로직을 작성
 * 2. 반복문 안에서 조건을 하나 추가
 *    sum이 500을 넘으면 반복만 멈추고 빠져나가도
 */
public class LoopingBreakTest2 {

	public static void main(String[] args) {
		int sum = 0;
		for(int i=1; i <=100; i++) {
			sum += i;
			if(sum>500) break;
		}
		System.out.println("총합 : " + sum);
	}
}
