package com.edu.loop.test;

import java.util.Scanner;

import com.edu.loop.service.Service;

/*
 * Application 을 작성하기 위한 Looping 문
 */
public class DoWhileTest2 {

	public static void main(String[] args) {
		//키보드로 값을 읽어들이는 Scanner... 실행시점
		Scanner sc = new Scanner(System.in);
		Service service = new Service(); //메모리에 올라간다...기능을 호출.. 
		do {
			System.out.println("원하는 메뉴를 선택하세요");
			System.out.println("1. 계좌 개설 \t2. 고객정보 조회\t3. 종료");
			int menu = sc.nextInt();
			switch(menu) {
			case 1:
				//System.out.println("계좌 개설 서비스 기능이 진행됩니다...");
				service.openAccount();
				break;
			case 2:
				//System.out.println("고객정보 조회 서비스 기능이 진행됩니다...");
				System.out.println(service.getCustomInformation());
				break;
			case 3:
				System.out.println("프로그램 종료 됩니다...");
				System.exit(0);
			}
		} while(true);
	}
}
