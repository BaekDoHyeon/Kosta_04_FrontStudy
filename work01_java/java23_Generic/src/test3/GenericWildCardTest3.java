package test3;

class Person {
	
}

class Worker extends Person {
	
}

class Employee extends Person {
	
}

class Manager extends Employee {
	
}

class Engineer extends Employee {
	
}

class Application<T> { //제한된 파라미터 타입 사용 못함
	
	T kind;

	public Application(T kind) {
		this.kind = kind;
	}
	
}

class Dog2 {}

class PersonService {
	
	public static void register(Application<?> application) {
		System.out.println(application.kind.getClass().getSimpleName() + " 가(이) 등록됨..");
	}
	
	public static void register2(Application<? super Worker> application) {
		System.out.println(application.kind.getClass().getSimpleName() + " 가(이) 등록됨..");
	}

	public static void register3(Application<? extends Employee> application) {
		System.out.println(application.kind.getClass().getSimpleName() + " 가(이) 등록됨..");
	}

}

public class GenericWildCardTest3 {
	public static void main(String[] args) {
		PersonService.register(new Application(new Employee())); 
		PersonService.register2(new Application(new Dog2())); 
		PersonService.register3(new Application(new Manager())); // 이걸 가장 많이 사용한다고 합니다?
		//PersonService.register3(new Application(new Person()));
	}
}
