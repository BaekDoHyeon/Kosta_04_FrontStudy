package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.edu.Employee;

public class EmployeeLambdaTest {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "SCOTT", 30000.0));
		employees.add(new Employee(2, "ADAMS", 25000.0));
		employees.add(new Employee(3, "SMITH", 21000.0));
		employees.add(new Employee(4, "KING", 50000.0));
		
		System.out.println("\n========== 1. 직원들 급여 인상 정보 출력 ==========");
		Consumer<Employee> consumer = x -> {
			x.changeSalary(Math.round(x.getSalary() * 1.15));
		};
		
		Consumer<Employee> consumer1 = x -> {
			x.changeSalary(Math.round(x.getSalary() * 1.35));
		};
		
		raiseSalary(employees, consumer.andThen(System.out::println));
		System.out.println("============================================");
		raiseSalary(employees, consumer1.andThen(System.out::println));
	}
	
	private static void raiseSalary(List<Employee> list, Consumer<Employee> c) {
		for (Employee e : list) c.accept(e); //모든 직원의 급여가 15% 인상된다.
	}
}
