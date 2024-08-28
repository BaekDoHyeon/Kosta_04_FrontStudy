package com.edu.test;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class PolyTest2 {

	public static void main(String[] args) {
		//자식 클래스 생성
		Manager m = new Manager("James", 30000.0, new MyDate(1999, 1, 1), "IT");	
		Engineer eg = new Engineer("Tomas", 45000.0, new MyDate(1997, 3, 12), "Java", 100);
		Secretary s = new Secretary("Peter", 35000.0, new MyDate(2000, 4, 3), "James");
		
		m.changeDept("기획부");
		eg.changeTech("Python");
		s.changeNameOfBoss("Jane");
		
		System.out.println(m.getDetails());
		System.out.println(eg.getDetails());
		System.out.println(s.getDetails());
		
		System.out.println("\n================ Polymorphism ================");
		//부모타입으로 다양한 자식객체 생성.... 1) Object Casting, 2) Virtual Method Invocation 	  	
		Employee m2 = new Manager("James", 30000.0, new MyDate(1999, 1, 1), "IT");	
		Employee eg2 = new Engineer("Tomas", 45000.0, new MyDate(1997, 3, 12), "Java", 100);
		Employee s2 = new Secretary("Peter", 35000.0, new MyDate(2000, 4, 3), "James");		
		
		//Manager 타입으로 불러서 값 할당... 1) Object Casting
		//m2.changeDept("교육부"); -> 사용 불가
		Manager ma2 = (Manager)m2;
		ma2.changeDept("교육부");
		
		Engineer eg3 = (Engineer) eg2;
		eg3.changeTech("AI");
		eg3.changeBonus(300);
		
		//2) Virtual Method Invocation -> Virtual 은 자식을 의미...
		/*
		 *  상속 관계에 있는 2개의 클래스 사이에서 부모 타입으로 자식객체를 생성
		 *  부모 타입으로 오버라이딩된 자식의 메소드를 호출하면 발생하는 원리
		 *  
		 *  컴파일 시점의 메소드 - 부모의 메소드 호출
		 *  실행 시점의 메소드 - 실질적으로 생성된 자식의 메소드 호출
		 */
		System.out.println(m2.getDetails());
		
		//eg2 엔지니어의 기술을 AI로 변경,,, 보너스도 300달러로 변경
		//정보를 출력...확인
		System.out.println(eg2.getDetails());
	}
}