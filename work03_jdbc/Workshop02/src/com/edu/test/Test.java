package com.edu.test;

import java.sql.SQLException;
import java.util.List;

import com.edu.dao.BookDAO;
import com.edu.exception.DMLException;
import com.edu.exception.DuplicateNumException;
import com.edu.exception.RecordNotFoundException;
import com.ssafy.Book;

public class Test {

	public static void main(String[] args) throws SQLException {
		//insert, update, delete 예외처리 진행
		
		BookDAO dao = BookDAO.getInstance();
		
		// 1.
		try  {
			dao.insertBook(new Book("a1101123", "JAVA 기본", "자앤 기술연구소", "자앤 출판사", 23000, "기본"));
			dao.insertBook(new Book("a1102123", "JAVA 중급", "자앤 기술연구소", "자앤 출판사", 25000, "중급"));
			dao.insertBook(new Book("a1103123", "JAVA 실전", "자앤 기술연구소", "자앤 출판사", 30000, "실전"));
		} catch(DuplicateNumException e) {
			System.out.println(e.getMessage());
		} catch(DMLException e) {
			System.out.println(e.getMessage());
		}
		
		// 2.
		try {
			printAllBooks(dao.listBooks());
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (DMLException e) {
			System.out.println(e.getMessage());
		}
		
		// 3.
		System.out.println("\n3.==============================");
		System.out.println(dao.findBook("a1101123")); //존재 O
		System.out.println(dao.findBook("a1101124")); //존재 X

		
		// 4.
		System.out.println("\n4.==============================");
		try  {
			dao.insertBook(new Book("a1104123", "JAVA 심화", "자앤 기술연구소", "자앤 출판사", 28000, "심화"));
		} catch(DuplicateNumException e) {
			System.out.println(e.getMessage());
		} catch(DMLException e) {
			System.out.println(e.getMessage());
		}
		
		
		// 5.
		System.out.println("\n5.==============================");
		try {
			dao.updateBook(new Book("a1101123", "JAVA 기본", "자앤 기술연구소", "자앤 출판사", 20000, "기본"));
			printAllBooks(dao.listBooks());	
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (DMLException e) {
			System.out.println(e.getMessage());
		}
		
		// 6.
		System.out.println("\n6.==============================");
		try {
			dao.deleteBook("a1103123");
			printAllBooks(dao.listBooks());
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (DMLException e) {
			System.out.println(e.getMessage());
		}
	
		// 7.
		System.out.println("\n7.==============================");
		System.out.println(dao.count());
	}
	
	private static void printAllBooks(List<Book> list) {
		for (Book book : list) {
			System.out.println(book);
		}
	}
}
