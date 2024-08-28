package com.self.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import com.self.vo.Book;
import com.self.vo.Magazine;

public class BookMgrImpl implements BookMgr {
	
	private ArrayList<Book> books = null;
	
	//싱글톤
	private static BookMgrImpl mgr = new BookMgrImpl();
	
	private BookMgrImpl() {
		books = new ArrayList<Book>();
	}
	
	public static BookMgrImpl getInstance() {
		return  mgr;
	}
	
	
	//데이터 입력 기능 -> 책 추가
	@Override
	public void addBook(Book b) {
		books.add(b);
	}

	//데이터 전체검색 기능
	@Override
	public ArrayList<Book> getAllBook() {
		return books;
	}

	//isbn 으로 정보를 검색하는 기능
	@Override
	public Book searchBookByIsbn(String isbn) {
		Book book = null;

		for (Book b : books)
			if(b.getIsbn().equals(isbn))
				book = b;
		
		return book;
	}

	//title 로 정보를 검색하는 기능
	@Override
	public ArrayList<Book> searchBookByTitle(String title) {
		ArrayList<Book> temp = new ArrayList<>();
		
		for	(Book b : books)
			if(b.getTitle().equals(title))
				temp.add(b);
		
		return temp;
	}

	//Book 만 검색하는 기능
	@Override
	public ArrayList<Book> onlySearchBook() {
		ArrayList<Book> temp = new ArrayList<>();
		
		for (Book b : books)
			if (!(b instanceof Magazine)) temp.add(b);
			
		return temp;
	}

	
	//Magazine 만 검색하는 기능
	@Override
	public ArrayList<Book> onlySearchMagazin() {
		ArrayList<Book> temp = new ArrayList<>();

		for (Book b : books)
			if (b instanceof Magazine) temp.add(b);
		
		return temp;
	}

	//Magizine 중 올해 잡지만 검색하는 기능
	@Override
	public ArrayList<Magazine> magazineOfThisYearInfo(int year) {
		ArrayList<Magazine> temp = new ArrayList<>();
		LocalDate date = LocalDate.now();
		int thisYear = date.getYear();
		
		for (Book b : books) 
			if (b instanceof Magazine && ((Magazine) b).getYear() == thisYear)
				temp.add((Magazine)b);
		
		return temp;
	}

	
	//출판사로 검색하는 기능
	@Override
	public ArrayList<Book> searchBookByPublish(String publish) {
		ArrayList<Book> temp = new ArrayList<>();
		
		for (Book b : books) 
			if (b.getPublisher().equals(publish)) temp.add(b);
		
		return temp;
	}

	//가격으로 검색(인자로 주어진 가격보다 낮은 가격의 도서 검색)
	@Override
	public ArrayList<Book> searchBookByPrice(int price) {
		ArrayList<Book> temp = new ArrayList<>();

		for (Book b : books) 
			if (b.getPrice() < price) temp.add(b);
		
		return temp;
	}

	//저장된 모든 도서의 금액의 합을 구하는 기능
	@Override
	public int getTotalPrice() {
		int total = 0;
		
		for (Book b : books) 
			total += b.getPrice();
		
		return total;
	}
	
	//저장된 모든 도서의 금액 평균을 구하는 기능
	@Override
	public int getAvgPrice() {
		int total = 0;
		
		for	(Book b: books) 
			total += b.getPrice();
		
		return total/books.size();
	}
	
}
