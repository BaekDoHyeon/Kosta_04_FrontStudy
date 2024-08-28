package com.edu.statictest;

class Member {
	int ssn = 1234;
	static String name = "길동";
	static int age = 19;
	
	public static void memverInfo() {
		System.out.println("우/유/빛/깔/" + name);
	}
}

/*
 *  static 키워드 특징
 *  1. static 한 성질의 멤버는 객체생성 과정없이 메모리에 올라간다. 
 *  2. compile    |   runtime(v)
 *     static 한 성질의 멤버는 class file loader 단계에서 미리 메모리에 올라간다.
 *  3. 클래스이름.static멤버
 *     System.out
 *     System.in
 *     Integer.parseInt()
 *     Math.random()
 *     main()
 *  4. static 한 멤버는 생성된 객체들이 다 공유하는 성질의 것이다!!!!!! -> 중요~!
 *  5. Member Level 에서 사용된다. | Local Level 에서는 사용하지 못한다.
 *  6. static 은 static 끼리 통한다. 
 */
public class StaticExamTest1 {

	public static void main(String[] args) {
		//static int count = 0; -> static 한 멤버는 Local Level 에서 사용하지 못한다.
		
		Member m = new Member();
		
		System.out.println(m.name);
		m.memverInfo();
	}

}
