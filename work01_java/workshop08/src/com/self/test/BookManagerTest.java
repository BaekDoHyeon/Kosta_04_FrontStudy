package com.self.test;

import com.self.service.BookManager;
import com.self.vo.Book;
import com.self.vo.Magazine;
import com.self.vo.Novel;

public class BookManagerTest {

	public static void main(String[] args) {
		BookManager manager = BookManager.getInstance();
		
		System.out.println("============== 1. insertBook ==============");
		manager.insertBook(new Novel(1234, "나미의 잡화점", "AAA", "삼성", 25000, "판타지"));
		manager.insertBook(new Novel(3456, "코난과 도일", "도일", "네이버", 20000, "추리"));
		manager.insertBook(new Magazine(5163, "스포츠매거진", "축구도사", "스포츠전문회사", 13000, "월간"));
		manager.insertBook(new Magazine(4128, "스포츠매거진", "야구도사", "야구전문회사", 19000, "주간"));
		
		System.out.println("\n============== 2. getNumberOfBooks ==============");
		System.out.println("현재 등록되어 있는 책의 개수 : " + manager.getNumberOfBooks() + "개");
		
		System.out.println("\n============== 3. getAllBook ==============");
		for (Book b : manager.getAllBook()) 
			System.out.println(b);
		
		System.out.println("\n============== 4. searchBookByIsbn(3456) ==============");
		System.out.println(manager.searchBookByIsbn(3456));
		
		System.out.println("\n============== 5. searchBookByTitle(스포츠매거진) ==============");
		for (Book b : manager.searchBookByTitle("스포츠매거진"))
			System.out.println(b);
		
		System.out.println("\n============== 6. searchBookByPublisher(삼성) ==============");
		for (Book b : manager.searchBookByPublisher("삼성"))
			System.out.println(b);
		
		System.out.println("\n============== 7. searchBookByPrice(20000, 25000) ==============");
		for (Book b : manager.searchBookByPrice(20000, 25000))
			System.out.println(b);
		
		System.out.println("\n============== 8. getSumPriceOfBooks ==============");
		System.out.println(manager.getSumPriceOfBooks());
		
		
		System.out.println("\n============== 9. getAvgPriceOfBooks ==============");
		System.out.println(manager.getAvgPriceOfBooks());

	}

}
