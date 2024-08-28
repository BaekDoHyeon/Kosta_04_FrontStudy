package ex03_user;

class Boom extends RuntimeException {

	public Boom() { this("[Default] 실패"); }
	
	public Boom(String message) {
		super(message);
	} 
	
}

class User {
	public void calc(int x, int y) throws Boom { //임의의 값 x, y가 인자값... 호출시
		System.out.println("2. calc 함수 호출....");
		
		if (x==0)
			//ArithmeticException 을 발생시킨다... 이러한 것도 사용자 정의 예외라고 한다. -> 내가 직접 객체를 생성해서 throw 를 통해 예외를 던졌기 때문이다.
			throw new Boom("x가 0이면 안됩니다...분모가 될 숫자거든요.");
			
		//연산이 진행... y/x 
		System.out.println("3. calc 함수 호출.... x는 0이 아닙니다.");
	}
}

public class UserExceptionTest1 {

	public static void main(String[] args) {
		System.out.println("1. User 객체 생성...");
		User user = new User();
		try {
			user.calc(0, 10);
		} catch (Boom e) {
			System.out.println(e.getMessage());
		}
		System.out.println("4. 폭탄 처리 성공....");
	}
}
