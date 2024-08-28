package step1;

@FunctionalInterface
interface Attackable {
	void attack();
}

@FunctionalInterface
interface Moveable {
	void move(int right, int left); //인자값 2개, 반환타입은 없다.
}

class Fighter {
	//Method Overloading
	public void action(Attackable a) {
		a.attack();
	}
	
	public void action(Moveable m) {
		m.move(100, 200);
	}
}

public class LambdaTest5 {

	public static void main(String[] args) {
		Fighter fighter = new Fighter();
		
		//실행문이 하나일때...
		fighter.action(() -> System.out.println("왼손 잽 공격"));
		
		//실행문이 두개일때
		fighter.action(() -> {
			System.out.println("오른손 훅 공격");
			System.out.println("날아차기 공격");
		});
		
		fighter.action((r, l) -> {
			System.out.println("오른쪽으로 " + r + "cm 이동합니다.");
			System.out.println("왼쪽으로 " + l + "cm 이동합니다.");
		});
		
	}

}
