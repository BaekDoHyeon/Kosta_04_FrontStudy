package com.edu.array.test;

public class TonysArrayTest2 {
	public static void main(String[] args) {
		Contact2 contactRef = null;
		int x = 0;
		while (x < 10) {
			contactRef = new Contact2("PersonName..." + contactRef);
			System.out.println("Contact2 Reference..." + contactRef);
			x++;
		}
		contactRef.printName();
	}	
}


class Contact2 {
	String name;
	// 이외 등등...

	public Contact2(String name) {
		this.name = name;
	}
	
	public void printName() {
		System.out.println(name + "....print!!");
	}
}