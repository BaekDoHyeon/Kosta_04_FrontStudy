package com.edu.condition.test1;

import java.util.Scanner;

/*
 * GradeIfTest1 코드는 컴파일 시점에 실제값 88이 입력되는 코드... 프로그램이 아니다.
 * 실행시점에 값이 입력되도록 Scanner를 생성해서 값을 입력받아서 보겠다.
 * 
 * 학생이름 | 해당학생의 점수를 입력
 * 조건을 그대로 작성
 * 백도현 , C Grade... 출력되도록 로직을 추가
 */
public class GradeIfTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름과 점수를 입력: ");
		String name = sc.next();
		int grade = sc.nextInt();
		
		if(grade >= 90 && grade <= 100) {
			System.out.println(name+", " + "A grade...");
		} else if(grade >= 80) {
			System.out.println(name+", " + "B grade...");
		} else if(grade >= 70) {
			System.out.println(name+", " + "C grade...");
		} else {
			System.out.println(name+", " + "Try Again...");
		}
		
		sc.close();
	}
}