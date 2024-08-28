package com.edu.collection1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HashMapTest2 {

	public static void main(String[] args) {
		
		//람다식 이해를 위해,,,,
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("안녕하세요~");
			}
		};
		
		Thread tr = new Thread(r);
		tr.run();
		//람다식 이해를 위해,,,,
		
		Map<String, Integer> map = new HashMap<> ();
		map.put("강호동", 90);
		map.put("이수근", 80);
		map.put("서장훈", 95);
		map.put("김희철", 60);
		
		/*
		 * 1. 키 값들을 뽑아서
		 * 2. 반복문을 통해서 키값에 해당하는 점수를 뽑고
		 * 3. 최종적으로 모든 성적의 합과 평균을 구하라.
		 */
		
		int total = 0;
		System.out.println("\n============== keySet() ==============");
		for(String key : map.keySet()) {
			int score = map.get(key);
			total += score;
		}
		System.out.println("모든 사람들의 성적의 총합은 " + total + "점 입니다.");
		System.out.println("모든 사람들의 성적의 평균은 " + total/map.size() + "점 입니다.");
		
		System.out.println("\n============== values() ==============");
		int sum = 0;
		for (int v : map.values()) sum += v;
		System.out.println("모든 사람들의 성적의 총합은 " + sum + "점 입니다.");
		System.out.println("모든 사람들의 성적의 평균은 " + sum/map.size() + "점 입니다.");
		
		System.out.println("\n============== Collections() ==============");
		int max = Collections.max(map.values());
		int min = Collections.min(map.values());
		System.out.println("최고성적은: " + max + "점, 최저성적은: " + min + "점 입니다.");
	}

}
