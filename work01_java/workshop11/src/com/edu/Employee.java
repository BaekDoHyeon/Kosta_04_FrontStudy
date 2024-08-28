package com.edu;

public class Employee {
	
	private int empno;
	private String ename;
	private double salary;
	
	public Employee(int empno, String ename, double salary) {
		this.empno = empno;
		this.ename = ename;
		this.salary = salary;
	}

	public int getEmpno() {
		return empno;
	}


	public String getEname() {
		return ename;
	}

	public double getSalary() {
		return salary;
	}

	public void changeSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return ename + ", " + empno + ", " + salary;
	}
	
	

}
