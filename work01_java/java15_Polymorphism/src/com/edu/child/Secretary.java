package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class Secretary extends Employee {
	
	private String nameOfBoss;
	
	public Secretary(String name, double salary, MyDate mydate, String nameOfBoss) {
		super(name, salary, mydate);
		this.nameOfBoss = nameOfBoss;
	}
	
	public String getNameOfBoss() {
		return nameOfBoss;
	}

	public void changeNameOfBoss(String nameOfBoss) {
		this.nameOfBoss = nameOfBoss;
	}

	@Override
	public String getDetails() {
		return super.getDetails() + ", " + nameOfBoss;
	}
	
}   
