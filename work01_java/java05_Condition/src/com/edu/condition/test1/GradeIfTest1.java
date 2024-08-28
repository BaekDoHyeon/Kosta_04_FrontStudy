package com.edu.condition.test1;
/*
 * 조건문
 * ::
 * if(조건 A) / else if(조건 B) / else(나머지 모든 경우)
 */
public class GradeIfTest1 {

	public static void main(String[] args) {
		int grade = 88; //Local Variable, 기본값 없기 때문에 반드시 초기화 해야한다.
		
		if(grade >= 90 && grade <= 100) {
			System.out.println("A grade");
		} else if(grade >= 80) {
			System.out.println("B grade");
		} else if(grade >= 70) {
			System.out.println("C grade");
		} else {
			System.out.println("Try Again");
		}
	}

}