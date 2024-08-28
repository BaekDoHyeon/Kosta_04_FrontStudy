package com.edu.condition.test1;
/*
 * switch(조건에 해당하는 변수) {
 *  case 95:
 *  case 90:
 *   //실행문
 *   break; -> switch 밖으로 나간다~
 *  
 *  case ??:
 *   //실행문
 *   break;
 *   
 *  default: 
 *   //실행문
 * }
 */
public class GradeSwitchTest3 {

	public static void main(String[] args) {
		int grade = 80;
		switch(grade) {
		case 90:
		case 95:
			System.out.println("A Grade~");
			break;
		case 80:
		case 85:
			System.out.println("B Grade~");
			break;
		case 70:
		case 75:
			System.out.println("C Grade~");
			break;
		default: 
			System.out.println("Nuts~~!!");
		}
	}
	
}
