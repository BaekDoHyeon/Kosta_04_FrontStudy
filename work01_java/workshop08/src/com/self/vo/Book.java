package com.self.vo;

/**
 * 책의 정보를 저장하는 부모 클래스
 */
public class Book {
	/**
	 * 책의 고유번호
	 * 유니크한 값
	 */
	private int isbn;
	/**
	 * 책의 이름
	 */
	private String title;
	/**
	 * 책의 저자
	 */
	private String author;
	/**
	 * 출판사
	 */
	private String publisher;
	/**
	 * 책의 가격
	 */
	private double price;
	
	/**
	 * 자식 클래스에서 객체를 생성할 때 해당 생성자를 통해 객체를 생성한다.
	 * @param isbn 책의 고유번호
	 * @param title 책의 이름
	 * @param author 책의 저자
	 * @param publisher 출판사
	 * @param price 책의 가격
	 */
	public Book(int isbn, String title, String author, String publisher, double price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	
	public int getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public double getPrice() {
		return price;
	}
	
	public void changePrice(double price) {
		this.price = price;
	}

	/**
	 * 필드의 정보를 반환
	 */
	@Override
	public String toString() {
		return "["+isbn+"] 제목: " + title + ", 작가: " + author + ", 출판사: " + publisher + ", 가격: " + price  ;
	}
}
