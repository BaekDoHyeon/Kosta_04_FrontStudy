/*
 	람다, 람다식
 	::
 	함수형 프로그래밍
 	자바는 자바8버전부터 함수형 프로그래밍 람다식을 제공..
 	::
 	1) 익명함수(함수명이 없다)
 	2) 코드가 간결하고 성능적으로는 불리한 부분이 있다.
 	3) 병렬처리 가능하다.
 	::
 	
 	<일반적인 함수 형식>
 	public int max(int a, int b) {
 	    return a > b ? a : b;
 	}
 	
 	<람다식>
 	(int a, int b) -> { return a > b ? a : b; }
 	
 	<람다식2>
 	(int a, int b) -> a > b ? a : b;
 	
 	<람다식3>
 	(a, b) -> a > b ? a : b;
 	
--------------------------------------------------------------
@FunctionalInterface 의 구현체를 우리는 람다식으로 만들어야 한다.
그렇기 때문에 @FunctionalInterface 는 단 하나의 추상메소드만 가져야 한다.


 */

package step1;

@FunctionalInterface
interface MyFunction { //추상 메서드 필요.. 단 하나인 인터페이스
	//public abstract 생략되어 있음
	int max(int a, int b); // 2개의 수 중 더 큰수를 반환하는 기능의 Template
}

public class LambdaTest1 {

	public static void main(String[] args) {
		//1. 익명클래스로 구현
		MyFunction f = new MyFunction() {

			@Override
			public int max(int a, int b) {
				return a > b ? a : b;
			}
	
		};
		
		System.out.println(f.max(5, 3));
			
		//2. 람다식으로 구현
		MyFunction f2 = (a, b) -> a > b ? a : b;
		System.out.println(f2.max(3, 6));
	}

}
