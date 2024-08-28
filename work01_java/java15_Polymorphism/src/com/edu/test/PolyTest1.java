package com.edu.test;

import java.util.Arrays;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class PolyTest1 {

	public static void main(String[] args) {
		//Heterogeneous Collection
		Employee[] employees = {
				new Manager("James", 30000.0, new MyDate(1999, 1, 1), "IT"),
				new Engineer("Tomas", 45000.0, new MyDate(1997, 3, 12), "Java", 100),
				new Secretary("Peter", 35000.0, new MyDate(2000, 8, 23), "James"),
				new Manager("James2", 28000.0, new MyDate(1999, 5, 9), "IT2"),
				new Engineer("Tomas2", 40000.0, new MyDate(1997, 11, 22), "Java2", 200)
		};
		
		for(Employee e : employees) 
			System.out.println(e.getDetails());
		
		//배열안에 들어있는 데이터 요소를 출력...Arrays.toString();
		System.out.println(Arrays.toString(employees));
		
		System.out.println("\n======== employees 안에서 관리되는 직원들의 연봉 ========");
		for(Employee e : employees)  {
			int annualSalary = (int) e.getSalary()*12;
			if (e instanceof Engineer)
				annualSalary += ((Engineer) e).getBonus();
			System.out.println(e.getName() + "님의 연봉은 " + annualSalary + "원 입니다.");
		}
	}
}