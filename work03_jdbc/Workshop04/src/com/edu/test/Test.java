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
			dao.insertBook(new Book("a1101", "JAVA 기본", "자앤 연구소", "자앤 출판사", 23000, "기본"));
			dao.insertBook(new Book("a1102", "JAVA 중급", "김영광", "AAA 출판사", 25000, "중급"));
			dao.insertBook(new Book("a1103", "JAVA 실전", "김영광", "DDD 출판사", 30000, "실전"));
			dao.insertBook(new Book("a1104", "PYTHON 기본", "김지수", "AAA 출판사", 22000, "기본"));
			dao.insertBook(new Book("a1105", "PYTHON 알고리즘", "김지수", "빙구 출판사", 45000, "알고리즘 기출 문제"));
			dao.insertBook(new Book("a1106", "SPRING 실전", "유비빔", "자앤 출판사", 19000, "Spring 실전"));
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

			//작가로 찾기.. -> 4. 이름이 "김xx" 인 저자의 도서명, isbn, 출판사를 출력하는 기능...
			System.out.println("\n============== 작가 검색 (김XX) ================");
			printAllBooks(dao.findBookByAuthor("김"));
			
			//가격대별 찾기..
			System.out.println("\n============== 가격대별 검색 (25,000원 이상) ================");
			printAllBooks(dao.findBookByPrice(25000));	
			
			//5. Author 테이블에 있는 저자명 별로 출간된 도서들을 도서명, 출판사, 가격, 저자명을 출력하는 기능
			System.out.println("\n============== Author 테이블에 있는 저자명 별로 출간된 도서들을 도서명, 출판사, 가격, 저자명을 출력하는 기능 ================");
			dao.booksOfAuthors();
			
			//6.Book 테이블에 있는 title 와 publisher 를 이용하여 서로의 관계 출력 기능
			System.out.println("\n============== title 와 publisher 를 이용하여 서로의 관계 출력 ================");
			dao.bookInfo();
			
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
