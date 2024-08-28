package com.edu.statictest;
/*
 * Access Modifier ::: public > protected > [default] > private
 *  Usage Modifier ::: static, final, abstract 
 *  
 *  static + final 주로 함께 많이 쓰인다.(순서는 중요하지 않다.)
 *  
 *  final :: "내가 마지막이야~~~" 라는 의미를 가지는 키워드
 *  final + 변수,,  -> "내가 마지막 변수야~~"   -> 상수값 지정(값 변경 X)
 *  final + 메소드,, -> "내가 마지막 메소드야~~" ->  메소드 오버라이딩 금지
 *  final + 클래스,, -> "내가 마지막 클래스야~~" ->  상속 금지
 */
class A {
	public final static int BASE_SALARY = 4000;
	public final String test() {
		return "Overriding 금지";
	}
}

final class B { //상속 금지
	
}

class D extends A {
	
}

public class StaticExamTest4 {

	public static void main(String[] args) {
		
	}
}
