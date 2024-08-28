package step1;

@FunctionalInterface
interface Workable {
	String monthPayment(String ename, double weekSal);
}

class Employee { //Workable을 매개변수로 Hasing
	public void work(String name, int price, Workable w) {
//		String result = w.monthPayment("SMITH", 2000.0);
		String result = w.monthPayment(name, price);
		System.out.println("Result => " + result);
	}
}

public class LambdaTest2 {
	public static void main(String[] args) {
		
		Employee e = new Employee();
		String name = "BAEK";
		int price = 30000;
		e.work(name, price, (ename, weekSal) -> {
			//구현체를 작성...
			double salary = weekSal * 4 + 100.0;
			return ename + " 씨의 4주 급여는 " + salary;
		});
	}
}
