package com.edu.child;

import com.edu.parent.Pizza;

public class CombinationPizza extends Pizza {

	public CombinationPizza(int price, String storeName) {
		super(price, storeName);
	}

	public void topping() {
		System.out.println("Combination Topping...Pizza");
	}
	
}
