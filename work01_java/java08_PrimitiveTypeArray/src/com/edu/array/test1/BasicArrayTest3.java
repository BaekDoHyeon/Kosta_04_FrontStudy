package com.edu.array.test1;
/*
 * 배열 : Same Data Type
 * 선언 + 생성 + 초기화 ==> 동시에 한번에
 */
public class BasicArrayTest3 {

	public static void main(String[] args) {
		//초기화를 바로 진행해도 내부적으로(Heap영역) 묵시적 초기화가 먼저 일어난 후 값이 초기화 된다.
		int[] scores = {95, 78, 66, 90, 87};
		int sum = 0;
		
		//향상된 for문을 이용해서 성적들의 총합 / 평균값을 각각 출력
		for(int score : scores) sum += score;

		
		System.out.println("점수들의 총합 : " + sum + "점");
		System.out.println("점수들의 평균 : " + sum/scores.length + "점");
	}
}