package com.self.vo;

/**
 * 책의 정보를 저장하는 Book 의 자식클래스
 */
public class Novel extends Book {
	
	/**
	 * 소설의 장르
	 */
	private String genre;

	/**
	 * 부모로부터 상속받는 필드들은 부모 생성자 호출하여 값을 주입한다.
	 * @param isbn 책의 고유번호
	 * @param title 책의 이름
	 * @param author 책의 저자
	 * @param publisher 출판사
	 * @param price 책의 가격
	 * @param period 소설의 장르
	 */
	public Novel(int isbn, String title, String author, String publisher, double price, String genre) {
		super(isbn, title, author, publisher, price);
		this.genre = genre;
	}
	
	/**
	 * @return 장르 반환
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * 필드 정보 반환
	 * @return 부모 클래스인 Book 의 toString() 메소드의 더하여 자신만의 필드 값을 반환
	 */
	@Override
	public String toString() {
		return super.toString() + ", 소설의 장르: " + genre;
	}
}
