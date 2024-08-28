package com.edu.collection1;

import java.util.ArrayList;
import java.util.List;

/*
 * List
 * 순서를 가지면서 데이터를 핸들링하는 컬렉션
 * 순서를 가진다는 것은 내부적으로 index로 관리하는 시스템을 말한다.
 * 순서가 있고 중복은 허용된다.
 */
public class ArrayListTest4 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("강호동");
		list.add("이수근");
		list.add("강호동");
		list.add("서장훈");
		list.add("김희철");
		
		System.out.println(list);
		
		//1. 3번째 객체를 삭제..
		String removeName = list.remove(2);
		
		//2. "삭제된 사람은 ~~입니다" 를 출력
		System.out.println("삭제된 사람은 " + removeName + "입니다..");
		
		//3. 맨 처음에 민경훈을 추가
		list.add(0, "민경훈");
		System.out.println(list);
		
		//4. 멤버들 중에서 서..자로 시작하는 사람을 찾아서 해당 정보를 출력
		for (String s : list)
			if (s.startsWith("서")) System.out.println(s);
	}
	
}