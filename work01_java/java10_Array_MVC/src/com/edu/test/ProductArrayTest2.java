package com.edu.test;

import com.edu.vo.Customer;
import com.edu.vo.Product;

//1) 객체생성하기위한 Test class
//2) application 
public class ProductArrayTest2 {

	public static void main(String[] args) {
		Product[] products1 = {
				new Product("신라면", 1200, 5, "농심"),
				new Product("삼다수 생수", 1000, 10, "농심"),
				new Product("하이타이", 14000, 1, "엘지"),
				new Product("짐빔", 130000, 1, "JIM" )
		};
		
		Product[] products2 = {
				new Product("terra", 2200, 1, "농심"),
				new Product("맥심커피", 20000, 1, "농심"),
				new Product("휘센 에어콘", 3340000, 1, "대우")
		};
		
		Customer c1 = new Customer(111, "이정재", "방배동");
		Customer c2 = new Customer(222, "정우성", "신사동");
		
		c1.buyProducts(products1);
		c2.buyProducts(products2);
		
		// 기능들이 Test class 에 있기때문에 application 이라고 볼 수 없다. -> 이렇게 짜면 안됨....
		System.out.println("==== 1. 정우성이 구입한 물건중에서 30만원 이상 제품을 출력 ====\n");
		for(Product product : c2.getProducts()) {
			if(product.getPrice() > 300000)
				System.out.println(product.getDetails());
		}
		
		System.out.println("==== 2. 이정재가 구입한 물건의 모든 maker를 출력 ====\n");
		for(Product product : c1.getProducts()) 
			System.out.println(product.getMaker());
		
		System.out.println("==== 3. 이정재가 구입한 물건의 총 가격을 출력 ====\n");
		int sum = 0;
		for(Product product : c1.getProducts()) 
			sum += product.getPrice() * product.getQuantity();		
		System.out.println("구입한 물품의 총 가격 : " + sum + "원");
		//////////////////////////////////////////////////////////////////////////////
	}
}