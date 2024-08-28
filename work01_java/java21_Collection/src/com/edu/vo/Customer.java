package com.edu.vo;

public class Customer {
	private String ssn;
	private int age;
	private String name;
	
	public Customer() {}
	
	public Customer(String ssn, int age, String name) {
		super();
		this.ssn = ssn;
		this.age = age;
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}
	
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "이름: " + name + ", 나이: " + age + ", 주민번호: " + ssn;
	}
}
