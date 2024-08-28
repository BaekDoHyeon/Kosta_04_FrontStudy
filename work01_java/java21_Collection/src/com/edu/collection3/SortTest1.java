package com.edu.collection3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class SortTest1 {

	public static void main(String[] args) {
		System.out.println("List 정렬하기");
		
		List<Integer> list = new ArrayList<>();
		list.add(11);
		list.add(9);
		list.add(3);
		list.add(33);
		System.out.println(list);
		
		System.out.println("\n====== 오름차순 정렬 ======");
		Collections.sort(list);

		Iterator<Integer> it = list.iterator();	
		while (it.hasNext())
			System.out.print(it.next() + ", ");   //출력해서 확인,,,
		
		System.out.println("\n====== 내림차순 정렬 ======");
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		}); //내림차순
		
		Iterator<Integer> it2 = list.iterator();	
		while(it2.hasNext())
			System.out.print(it2.next());
	}
}
