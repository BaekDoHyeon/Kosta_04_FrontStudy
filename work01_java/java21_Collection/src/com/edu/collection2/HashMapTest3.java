package com.edu.collection2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.edu.vo.Customer;

public class HashMapTest3 {

	public static void main(String[] args) {
		HashMap<String, Customer> map = new HashMap<>();
		map.put("111", new Customer("111", 11, "AAA"));
		map.put("222", new Customer("222", 22, "BBB"));
		map.put("333", new Customer("333", 33, "CCC"));
		
		//1. map에 들어있는 사람중에서 222
		System.out.println(map.get("222"));
		
		//2. 이름이 CCC인 사람을 찾아서 그 사람의 나이를 콘솔로 출력
		for(Customer c : map.values())
			if(c.getName().equals("CCC")) System.out.println("CCC 님의 나이는: " + c.getAge());
		
		//3. map에 있는 사람 중에서 최고연령과 최소연령의 사람을 각각 출력
		int max = 0;
		int min = Integer.MAX_VALUE;
		
		List<Integer> list = new ArrayList<>();	
		
		Customer maxC = null;
		Customer minC = null;
		
		for(Customer c : map.values()) {		
			list.add(c.getAge());
			max = Collections.max(list);
			min = Collections.min(list);
			if(c.getAge() == max) maxC = c;
			
			if (c.getAge()==min) minC = c;
		}
		
		System.out.println("최고 연령자 정보 출력 : " + maxC);
		System.out.println("최소 연령자 정보 출력 : " + minC);
	}

}
