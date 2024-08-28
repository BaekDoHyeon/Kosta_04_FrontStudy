package com.edu.vo;
/*
 * 상품에 관련된 "정보를 저장하는 클래스"... 기능 X
 * 필드로 maker, price, quantity, company
 * setter / getter / 생성자
 */
public class Product {
	private String maker;
	private int price;
	private int quantity;
	private String company;
	
	public Product() {}
	
	public Product(String maker, int price, int quantity, String company) {
		this.maker = maker;
		this.price = price;
		this.quantity = quantity;
		this.company = company;
	}

	public String getMaker() {
		return maker;
	}

	public int getPrice() {
		return price;
	}

	public void changePrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getCompany() {
		return company;
	}
	
	//필드를 리턴하는 기능
	public String getDetails() {
		return maker + ", " + price +  ", " + company;
	}

}
