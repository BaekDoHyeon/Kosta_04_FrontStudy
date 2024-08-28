package com.edu.service;

import com.edu.vo.Customer;
import com.edu.vo.Product;

//Outlet 에서 상품을 구매하는 고객의 기능을 정의하고 있는 클래스...
//서비스 클래스는 기능만으로 이뤄지는 클래스
//vo, test, service 클래스를 작성하게 되면, 드디어 구조적인 Application 을 자바 SE기반으로 작성
public class OutletService {
	
	//1. 특정 고객이 구입한 상품을 반환하는 기능
	public Product[] getAllProduct(Customer vo) {
		return vo.getProducts();
	}
	
	//2. 특정 고객이 구입한 상품의 MAKER들만을 반환하는 기능 기능
	public String getAllProductMaker(Customer vo) {
		
		String result = "";
		
		for(Product product : vo.getProducts()) {
			result += product.getMaker() + ", ";
		}
		
		return vo.getName() + "님이 구매하신 상품들의 MAKER : " + result;
	}
	
	//3. Outlet 안에 있는 고객중에서 특정한 고객을 검색하는 기능
	public Customer findCustomer(Customer[] customers, int ssn) {
		
		for(Customer customer : customers) {
			if (customer.getSsn() == ssn) 
				return customer;
		}
		
		return new Customer();
	}
	
	//4. Outlet 안에 있는 고객중에서 동일한 주소를 가지는 고객들을 반환하는 기능
	public Customer[] findCustomer(Customer[] customers, String address) {
		
		Customer[] temp = new Customer[customers.length];
		int index = 0;
		
		for(Customer customer : customers) {
			if (customer.getAddress().equals(address))
				temp[index++] = customer;
		}
		
		return temp;
	}
	
	//5. 특정 고객이 구입한 물건중에서 최고가에 해당하는 물건의 가격을 리턴하는 기능
	public int maxPriceProduct(Customer vo) {
		int max = 0;
		for(Product product : vo.getProducts()) {
			if (product.getPrice() > max)
				max = product.getPrice();
		}
		
		return max;
	}
	
	//6. 모든 고객이 구입한 물건중 특정 가격 이상이 되는 제품들을 반환하는 기능 -> 아쉬움... 고치면 좋긴할듯?
	public Product[] getMorePriceProduct(Customer[] customers, int price) {
		int size = 0;
		for(Customer c : customers) {
			if(c.getProducts() != null)
				size += c.getProducts().length;
		}
		
		Product[] temp = new Product[size];
		int idx = 0;
		for(Customer c : customers) {
			//상품을 구매하지 않은 누군가를 위한 구문
			if (c.getProducts() == null) continue; 
			
			//조건에 맞는 상품은 temp 배열에 담기 -> 조건은 만약 temp 배열에 동일한 상품이 있다면 저장하지 않기.
			for(Product p : c.getProducts()) {
				if(p.getPrice() >= price) {
					//temp 배열에 해당 product 가 있다면 저장하지 않음
					temp[idx++] = p;
				}
			}
		}		
		return temp;
	}
}