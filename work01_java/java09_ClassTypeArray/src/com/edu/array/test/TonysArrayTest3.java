package com.edu.array.test;

import com.edu.vo.NoteBook;
import com.edu.vo.Programmer;
/*
 * Bob의 설계...
 */
public class TonysArrayTest3 {

	public static void main(String[] args) {
		NoteBook nb1 = new NoteBook(111, "HP", 170);
		NoteBook nb2 = new NoteBook(222, "SAMSUNG", 200);
		NoteBook nb3 = new NoteBook(333, "LG", 220);
		NoteBook[] noteBooks = new NoteBook[] { nb1, nb2, nb3 };

		Programmer bob = new Programmer("Bob");
		bob.buyNoteBooks(noteBooks); //NoteBook[]
		NoteBook[] returns = bob.getNoteBooks();
		
		System.out.println("Bob's NoteBook Information========\n");
		for(NoteBook nb : returns) {
			nb.printNoteBookInfo();
		}
	}
	
}
