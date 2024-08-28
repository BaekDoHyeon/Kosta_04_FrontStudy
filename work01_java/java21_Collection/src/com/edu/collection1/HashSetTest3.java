package com.edu.collection1;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest3 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("강호동");
		set.add("이수근");
		set.add("강호동"); //중복
		set.add("서장훈");
		set.add("김희철");
		
		System.out.println(set.size());
		System.out.println(set); //컬렉션은 자체적으로 toString() 오버라이딩 되어있다. -> 데이터 출력되게...
		
		//1. 서장훈씨가 포함되어져 있는지 확인..
		System.out.println("1. 서장훈씨가 존재하나요? " + set.contains("서장훈"));
		
		//2. 현재 컬렉션 안이 비어졌는지 여부도 확인...
		System.out.println("2. 현재 컬렉션이 비어있나요? " + set.isEmpty());
		
		//3. 이수근을 삭제... 나머지 사람들을 출력
		System.out.println("3. 이수근을 삭제 후 나머지 사람들 출력..");
		set.remove("이수근");
		System.out.println(set);
		
		//4. set 안에 들어있는 모든 데이터를 삭제
		System.out.println("4. set 안에 들어있는 모든 데이터 삭제");
		set.clear();
		
		//5. 정말로 비워졋는지 확인
		System.out.println("5. 현재 컬렉션이 비어있나요? " + set.isEmpty());
		System.out.println(set);
	}

}
