package com.edu.overloading.test;
//vo... table...mapping 
//모든 클래스에는 생성자가 1개 이상 있다.
class Employee {
	private int empno;
	private String name;
	private double salary;
	private String address;
	
	//추가...
	public static final double BASIC_SALARY = 100.0;
	public static final String BASIC_ADDR = "NY";
	
	public Employee() {}
	
	public Employee(int empno, String name) {
		this(empno, name, BASIC_SALARY, BASIC_ADDR);
	}

	public Employee(int empno, String name, double salary, String address) {
		this.empno = empno;
		this.name = name;
		this.salary = salary;
		this.address = address;
	}
	
	//필드값을 리턴하는 기능
	public String toString() {
		return empno + ", " + name + ", " + salary + ", " + address;
	}
}	
	
public class OverloadingTest {
		
	public static void main(String[] args) {
		Employee e1 = new Employee(7369, "SCOTT", 30000.0, "Texas");
		Employee e2 = new Employee(7521, "SCOTT", 30000.0, "Texas");
		/*
		 * 생성자 오버로딩
		 * 필수정보만으로 객체생성을 할 수 있어야 한다.
		 * 객체를 생성할 때 인자값을 달리 입력해서 객체 생성하는 기법
		 */
		Employee e3 = new Employee(7899, "BLAKE");
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
	}
	
}