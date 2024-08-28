package com.edu.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class test3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder tmpSb = new StringBuilder();
		StringBuilder resultSb = new StringBuilder();
		
		//반복 횟수
		int count = sc.nextInt();
		
		for(int i = 0; i < count; i++) {
			
			//패스워드 입력
			String str = sc.next();
			char[] charArr = str.toCharArray();
			
			List<String> list = new LinkedList<>();
			ListIterator<String> iterator = list.listIterator();
			
			for(char c : charArr) {
				//조건
				switch(c) {
				
				case '<':
					if (iterator.hasPrevious()) iterator.previous(); //이전값이 있다면 커서를 뒤로 이동
					else continue; //이전값이 없다면..(커서가 맨 왼쪽에 있다면..) 다음 반복 시작..
					break;
					
				case '>':
					if (iterator.hasNext()) iterator.next(); //다음값이 있다면 커서를 앞으로 이동
					else continue; //다음값이 없다면..(커서가 맨 오른쪽에 있다면..) 다음 반복 시작..
					break;
					
				case '-':
					if (iterator.hasPrevious()) {
						iterator.previous(); //이전값이 있다면 커서를 뒤로 이동
						iterator.remove();
					}
					else continue; //이전값이 없다면..(커서가 맨 왼쪽에 있다면..) 다음 반복 시작..
					break;
					
				default:
					//문자가 입력되면 추가...
					iterator.add(String.valueOf(c));
					break;
				}
			}
			
			for(String s : list)
				tmpSb.append(s);
			
			resultSb.append(tmpSb + "\n");
			tmpSb.setLength(0);
		}//전체 반복 끝..
		
		System.out.println(resultSb);
	}
}
