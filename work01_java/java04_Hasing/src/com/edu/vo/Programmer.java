package com.edu.vo;

public class Programmer {
	//생성자 주입
	String name;
	String mainSkill;
	float salary;
	String address;
	int bonus;
	// Has a Relation, setter 주입
	NoteBook noteBook;
	
	public Programmer() {}
	
	public Programmer(String name, String mainSkill, float salary, String address, int bonus) {
		this.name = name;
		this.mainSkill = mainSkill;
		this.salary = salary;
		this.address = address;
		this.bonus = bonus;
	}
	
	public void buyNoteBook(NoteBook noteBook) {
		this.noteBook = noteBook;
	}

	public NoteBook getNoteBook() {
		return noteBook;
	}
	
	public String getNoteBookInfo() {
		return name + ", " + mainSkill + ", " + salary + ", " + address + ", " + bonus;
	}
	
	//기능을 추가
	//개발자의 연봉을 리턴하는 기능
	public float getAnnualSalary() {
		float annualSalary = salary * 12 + bonus;
		
		return annualSalary;
	}
	
	//개발자의 급여를 기존보다 50만원 더 인상하는 급여
	//리턴하는 기능이 아니기 때문에 get 안써도 된다.
	public void raiseSalary(int amount) {
		salary += amount;
	}
}