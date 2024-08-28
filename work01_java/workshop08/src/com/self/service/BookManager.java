package com.self.service;

import com.self.vo.Book;

/**
 * @author BAEK DO HYEON
 * @version BookManager version 1.0.0
 * @since JDK 17
 */
public class BookManager {
	/**
	 * 책을 최대로 저장할 수 있는 값, 상수 5로 지정
	 */
	private static final int MAX_EMPLOYEES = 5;
	
	/**
	 * 책을 저장할 배열 선언
	 */
	private Book[] books;
	/**
	 * 책을 저장할 때마다 값 1씩 증가
	 * 현재 저장되어 있는 책의 개수를 의미
	 */
	private int numberOfBook;
	/**
	 * 특정 조건 검색 기능에서 조건에 맞는 객체들을 
	 * 새로운 배열에 저장하기 위한 인덱스 값으로 사용
	 */
	private int idx;
	
	/**
	 * 싱글톤 객체로 사용
	 * ::
	 * 객체 생성시 배열과 책의 개수, 인덱스 값을 초기화
	 */
	private static final BookManager manager = new BookManager();
	
	private BookManager() {
		books = new Book[MAX_EMPLOYEES];
		numberOfBook = 0;
		idx = 0;
	}
	
	public static BookManager getInstance() {
		return manager;
	}
	
	/**
	 * @return 현재 저장되어 있는 책의 개수 반환
	 */
	public int getNumberOfBooks() {
		return numberOfBook;
	}
	
	/**
	 * Book 요소 추가하는 기능
	 * 최대 추가 가능 개수인 10개 이상 추가시 
	 * 요소를 추가하지 않고, 추가 불가 메세지 출력
	 * @param book
	 */
	public void insertBook(Book book) {
		if (numberOfBook < MAX_EMPLOYEES) {
			books[numberOfBook++] = book;
			System.out.println("["+book.getIsbn()+"] "+book.getTitle() + "이 등록되었습니다.");
		} else
			System.out.println("[실패] 더이상 추가가 불가능합니다.");
	}
	
	/**
	 * @return 현재 저장되어 있는 Book 배열의 요소들을 반환
	 */
	public Book[] getAllBook() {
		Book[] allBooks = new Book[numberOfBook];
		for(int i = 0; i < numberOfBook; i++)
			allBooks[i] = books[i];
			
		return allBooks;
	}
	
	/**
	 * @param isbn 책의 고유번호로 유니크한 값
	 * 책의 고유번호를 이용하여 조건에 맞는 요소를 리턴하는 기능
	 * @return 입력 조건에 맞는 Book 객체 반환
	 */
	public Book searchBookByIsbn(int isbn) {
		for(Book b : books)
			if(b.getIsbn() == isbn)
				return b;
		
		return null;
	}
	
	/**
	 * @param title 책의 이름
	 * @return 조건에 맞는 Book 객체들을 배열로 반환
	 */
	public Book[] searchBookByTitle(String title) {
		int size = 0;
		for (int i = 0; i < numberOfBook; i++)
			if(books[i].getTitle().equals(title))
				size++;
		
		Book[] tmpBooks = new Book[size];
		
		for (int i = 0; i < numberOfBook; i++)
			if(books[i].getTitle().equals(title))
				tmpBooks[idx++] = books[i];
		
		idx = 0;
		return tmpBooks;
	}
	
	/**
	 * @param publisher 출판사
	 * @return 조건에 맞는 Book 객체들을 배열로 반환
	 */
	public Book[] searchBookByPublisher(String publisher) {
		int size = 0;
		for (int i = 0; i < numberOfBook; i++)
			if(books[i].getPublisher().equals(publisher))
				size++;
		
		Book[] tmpBooks = new Book[size];
		
		for (int i = 0; i < numberOfBook; i++)
			if(books[i].getPublisher().equals(publisher))
				tmpBooks[idx++] = books[i];
			
		idx = 0;
		return tmpBooks;
	}
	
	/**
	 * @param min 최소 금액
	 * @param max 최대 금액
	 * @return 최소 금액과 최대 금액 사이값을 가진 Book 객체들을 배열로 반환
	 */
	public Book[] searchBookByPrice(int min, int max) {
		int size = 0;
		for (int i = 0; i < numberOfBook; i++)
			if(books[i].getPrice() >= min && books[i].getPrice() <= max)
				size++;
		
		Book[] tmpBooks = new Book[size];
		
		for (int i = 0; i < numberOfBook; i++)
			if(books[i].getPrice() >= min && books[i].getPrice() <= max)
				tmpBooks[idx++] = books[i];
			
		idx = 0;
		return tmpBooks;
	}
	
	/**
	 * @return 현재 저장되어 있는 Book 요소들의 가격 총합
	 */
	public double getSumPriceOfBooks() {
		double total = 0.0;
		for(int i = 0; i < numberOfBook; i++)
			total += books[i].getPrice();
		
		return total;
	}
	
	/**
	 * @return 현재 저장되어 있는 Book 요소들의 평균 가격
	 */
	public double getAvgPriceOfBooks() {
		double total = 0.0;
		for(int i = 0; i < numberOfBook; i++)
			total += books[i].getPrice();
		
		return total / numberOfBook;
	}
}
