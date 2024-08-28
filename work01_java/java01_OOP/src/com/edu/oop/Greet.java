package com.edu.oop;

/*
 * 클래스의 구성요소
 * 필드(변수) : 클래스의 특징
 * 메소드 : 클래스를 통해서 하는 기능
 * -------------------------
 * Greet 클래스는 컴파일 대상이 된다.
 */
public class Greet {
	//필드 선언
	//필드 선언 + 값 할당 = 초기화(새로운 값 할당 o, 처음 입력하는 값 x)
	public String who;
	public String message;
	
	//메소드 정의(선언부 + 구현부)
	public void sayHello() {
		//콘솔창에 출력... 누구에게 어떤 인삿말을 하는지...
		//Worker Method
		System.out.println(who + ", " + message);
	}
}
