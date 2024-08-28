package step1;
/*
 	LambdaTest2에서 기능의 매개변수로 인터페이스를 주입
 	훨씬 더 간단한 코드로 다시 작성하자.
 */

@FunctionalInterface
interface Calculable {
	void calculate(int a, int b); //매개변수 2, 반환타입 없다.
}

public class LambdaTest3 {
	public static void main(String[] args) {
		//1. 함수형 인터페이스를 바로 사용... 람다식
		Calculable c = (a, b) -> System.out.println(a + b);
		c.calculate(10, 20);
		
		action((a, b) -> System.out.println(a * b));
	}
	
	//2. static 메소드의 매개변수로 Hasing...
	public static void action(Calculable cal) {
		System.out.println("action...method...");
		int a = 11;
		int b = 22;
		cal.calculate(a, b);
	}
}
