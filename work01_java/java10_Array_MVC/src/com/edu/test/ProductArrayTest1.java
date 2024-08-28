package com.edu.test;

import com.edu.vo.Product;

public class ProductArrayTest1 {

	public static void main(String[] args) {
		Product[] products = {
				new Product("신라면", 1200, 5, "농심"),
				new Product("삼다수 생수", 1000, 10, "농심"),
				new Product("하이타이", 14000, 1, "엘지"),
				new Product("짐빔", 130000, 1, "JIM" )
		};
		
		System.out.println("상품정보를 출력합니다...");
		
		for(int i = 0; i < products.length; i++) {
			if(products[i].getMaker().equals("하이타이")) 
				products[i].changePrice(products[i].getPrice()-2000);
		
			System.out.println(products[i].getDetails());
		}
	}
}