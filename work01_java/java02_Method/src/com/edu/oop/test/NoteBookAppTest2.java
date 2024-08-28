package com.edu.oop.test;

import com.edu.oop.NoteBook;

/*
 * 필드에 직접 값을 할당하지 않고
 * setXXXX(...) 기능을 호출해서 필드 초기화를 구동
*/
public class NoteBookAppTest2 {

	public static void main(String[] args) {
		//객체 생성 코드...
		NoteBook n = new NoteBook();	//메모리 올리고 == 객체생성
		n.setNoteBookField(123, "LG Gram", 1700000.0);	//호출
		//n.printNoteBookInfo();
		System.out.println(n.getNoteBookInfo());	//호출
	}
}