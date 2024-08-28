package com.edu.oop.test;

import com.edu.oop.NoteBook;

/*
 * 1. NoteBook 객체생성 == NoteBook의 멤버를 메모리에 올린다.
 * 2. 접근 - 필드(값 할당), 메서드(호출)
*/
public class NoteBookAppTest {

	public static void main(String[] args) {
		NoteBook n = new NoteBook();
		n.serialNumber = 2994;
		n.brand = "mac";
		n.price = 1500000.0;
		
		n.printNoteBookInfo();
		System.out.println(n);

		
		NoteBook n2 = new NoteBook();
		n2.serialNumber = 222;
		n2.brand = "samsung";
		n2.price = 1350000.0;
		
		n2.printNoteBookInfo();
		System.out.println(n2);
	}

}