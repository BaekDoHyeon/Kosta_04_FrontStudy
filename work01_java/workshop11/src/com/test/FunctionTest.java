package com.test;

import java.util.ArrayList;
import java.util.List;

import com.edu.Employee;
import com.edu.EmployeeService;

public class FunctionTest {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "SCOTT", 30000.0));
		employees.add(new Employee(2, "ADAMS", 25000.0));
		employees.add(new Employee(3, "SMITH", 21000.0));
		employees.add(new Employee(4, "KING", 50000.0));
		
		EmployeeService service = new EmployeeService();
		
		System.out.println("====== 첫 번째 방법 ======");
		service.raiseSalary(employees, i -> {
			i.changeSalary(i.getSalary() + (i.getSalary() * 0.15));
			System.out.println(i.toString());
		});
		
		System.out.println("\n====== 두 번째 방법 ======");
		employees.forEach(i -> {
			i.changeSalary(i.getSalary() + (i.getSalary() * 0.15));
			System.out.println(i.toString());
		});
	}
}
