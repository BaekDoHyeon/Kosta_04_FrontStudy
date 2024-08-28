package com.self.vo;

/**
 * 책의 정보를 저장하는 Book 의 자식클래스
 */
public class Magazine extends Book {
	/**
	 * 발행 간격
	 * "일간", "주간", "월간" 값 가능
	 */
	private String period;

	/**
	 * 부모로부터 상속받는 필드들은 부모 생성자 호출하여 값을 주입한다.
	 * @param isbn 책의 고유번호
	 * @param title 책의 이름
	 * @param author 책의 저자
	 * @param publisher 출판사
	 * @param price 책의 가격
	 * @param period 잡지 발행 간격
	 */
	public Magazine(int isbn, String title, String author, String publisher, double price, String period) {
		super(isbn, title, author, publisher, price);
		this.period = period;
	}
	
	/**
	 * @return 발행 간격 반환
	 */
	public String getPeriod() {
		return period;
	}
	
	/**
	 * 발행 간격 변경
	 */
	public void changePeriod(String period) {
		this.period = period;
	}

	/**
	 * 필드 정보 반환
	 * @return 부모 클래스인 Book 의 toString() 메소드의 더하여 자신만의 필드 값을 반환
	 */
	@Override
	public String toString() {
		return super.toString() + ", 잡지 발행기간: " + period;
	}
}
