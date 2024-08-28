package com.edu.oop.test;

import com.edu.oop.Greet;

/*
 * 1.Greet 클래스를 메모리에 올리고==객체 생성
 * 2.멤버에 접근 (메모리에 올리는 이유) -> 필드: 값할당, 메소드: 호출
 * ---------------------------------------------------
 * Test 클래스는 실행의 대상이 된다.
 */
public class GreetAppTest {

	public static void main(String[] args) {
		Greet greet = new Greet();
		greet.who = "Baek";
		greet.message ="hello!!";
		
		//Calling Method
		greet.sayHello();
	}

}
