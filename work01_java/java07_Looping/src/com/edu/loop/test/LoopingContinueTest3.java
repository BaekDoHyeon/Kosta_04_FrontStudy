package com.edu.loop.test;

public class LoopingContinueTest3 {

	public static void main(String[] args) {
		//조건에 해당하는 구간은 건너뛰면서 반복은 계속 한다.
		int sum = 0;
		for(int i = 1; i < 100; i++) {
			if(i%2 == 0) continue;
			sum += i;
		}
		System.out.printf("1부터 100까지의 홀수값 총합 : %d",sum);
	}
}
