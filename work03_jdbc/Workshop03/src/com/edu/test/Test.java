package com.edu.test;

import java.sql.SQLException;
import java.time.LocalDate;
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
		
		try {
			//타이틀로 찾기..
			System.out.println("============== 타이틀 검색 ================");
			dao.findBookByTitle("기본")
				.stream()
				.forEach(i -> System.out.println(i));
			
			//출판사로 찾기..
			System.out.println("\n============== 출판사 검색 ================");
			printAllBooks(dao.findBookByPublisher("자앤"));
			
			//작가로 찾기..
			System.out.println("\n============== 작가 검색 ================");
			printAllBooks(dao.findBookByAuthor("자앤 기술"));
			
			//가격대별 찾기..
			System.out.println("\n============== 가격대별 검색 (25,000원 이상) ================");
			printAllBooks(dao.findBookByPrice(25000));
			
			System.out.println();
			
			//할인 이벤트.. 할인된 가격 보여주기만..
			if(LocalDate.now().getMonthValue() == 7)
				printAllBooks(dao.discountEvent());
		
			
		} catch (DMLException e) {
			e.printStackTrace();
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void printAllBooks(List<Book> list) {
		for (Book book : list) {
			System.out.println(book);
		}
	}
}
