package com.edu;

import java.util.List;
import java.util.function.Consumer;

public class EmployeeService {
	
	public void raiseSalary(List<Employee> list, Consumer<Employee> c) {
		//여기서 Employee 의 Salary의 값을 수정하는 것이 구조적이다. -> 정보 출력은 Test 클래스에서 Consumer 를 활용해서 출력한다. (Consumer<Integer> c = i -> System.out.println(i.toString());
		//e.changeSalary(e.getSalary() * 1.15);
		//c.accept(e);
		for (Employee e : list) 
			c.accept(e);
	}
}
