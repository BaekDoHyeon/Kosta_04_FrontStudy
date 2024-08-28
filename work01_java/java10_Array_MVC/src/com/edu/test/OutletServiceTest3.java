package com.edu.test;

import com.edu.service.OutletService;
import com.edu.vo.Customer;
import com.edu.vo.Product;

public class OutletServiceTest3 {

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
		Customer c3 = new Customer(333, "아린", "신사동");
		
		Customer[] customers = {c1, c2, c3};
		
		OutletService service = new OutletService();
		customers[0].buyProducts(products1);
		customers[1].buyProducts(products2);
		customers[2].buyProducts(products1);
		
		//1. 특정 고객이 구입한 상품을 반환하는 기능
		Product[] pros = service.getAllProduct(customers[0]); //1. 특정 고객이 구입한 상품을 반환하는 기능
		for(Product product : pros) 
			System.out.println(product.getDetails());		
		
		System.out.println("");		
				
		//2. 특정 고객이 구입한 상품의 MAKER들만을 반환하는 기능 기능
		System.out.println(service.getAllProductMaker(customers[0])+"\n");


		//3. Outlet 안에 있는 고객중에서 특정한 고객을 검색하는 기능
		System.out.println("주민번호로 검색하신 고객 정보 : " + service.findCustomer(customers, 111).getCustomerInfo() + "\n"); // 다시 짜야댐

		//4. Outlet 안에 있는 고객중에서 동일한 주소를 가지는 고객들을 반환하는 기능
		System.out.println("==== 주소로 검색하신 고객 정보 ====="); // 다시 짜야댐
		for(Customer c : service.findCustomer(customers, "신사동")) {
			if (c == null) break;
			System.out.println(c.getCustomerInfo());
		}	
		
		System.out.println("");		

		
		//5. 특정 고객이 구입한 물건중에서 최고가에 해당하는 물건의 가격을 리턴하는 기능
		System.out.println(customers[2].getName() +"고객님이 구매하신 물건 중 최고가는 " + service.maxPriceProduct(customers[2]) + "원 입니다.\n");
		
		//6. 모든 고객이 구입한 물건중 특정 가격 이상이 되는 제품들을 반환하는 기능
		System.out.println("==== 100,000원 이상이 되는 제품들 ====");
		for(Product p : service.getMorePriceProduct(customers, 100000)) {
			if (p == null) break;
			System.out.println(p.getDetails());
		}
	}
}
