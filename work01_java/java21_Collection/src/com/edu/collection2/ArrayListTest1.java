package com.edu.collection2;

import java.util.ArrayList;

import com.edu.vo.Person;

public class ArrayListTest1 {

	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<>(); //기본 10칸자리 리스트...
		
		//add
		list.add(new Person(11, "AA"));
		list.add(new Person(22, "BB"));
		list.add(new Person(33, "CC"));
		list.add(new Person(44, "DD"));
		list.add(new Person(55, "EE"));

		System.out.println(list);
		System.out.println(list.size());
		list.trimToSize(); //size와 Capacity가 동일해진다.
		
		//리스트에 있는 사람중에서 2번째 사람의 정보를 출력
		System.out.println(list.get(1).toString());
		
		//list에 들어있는 사람들 평균나이를 구해서 출력
		int sum = 0;
		for(Object o : list) 
			sum += ((Person)o).getAge();
		
		System.out.println("평균연령은 " + sum/list.size());
	}
}