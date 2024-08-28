package com.kosta.test;

import com.kosta.service.MovieMgr;
import com.kosta.vo.Movie;

public class MovieTest {

	public static void main(String[] args) {
		MovieMgr mgr = MovieMgr.getInstance();
		
		Movie movie1 = new Movie("인사이드아웃2", "디즈니", 10, "애니메이션", "매우 재밌다.");
		Movie movie2 = new Movie("귀멸의칼날", "AAA", 9, "애니메이션", "완전 재밌다.");
		Movie movie3 = new Movie("겨울왕국", "디즈니", 8, "애니메이션", "진짜 재밌다.");
		Movie movie4 = new Movie("반지의제왕", "BBB", 8, "판타지", "진짜 재밌다.");
		Movie movie5 = new Movie("해리포터", "CCC", 10, "판타지", "짱짱 재밌다.");
		
		System.out.println("===== 1. 영화 추가 테스트 =====");
		mgr.add(movie1);
		mgr.add(movie2);
		mgr.add(movie3);
		mgr.add(movie4);
		mgr.add(movie5);
		mgr.add(movie5);
		System.out.println("현재 등록되어 있는 영화 개수 : " + mgr.getSize() + "개");
		
		
		System.out.println("\n===== 2. 영화 검색 테스트 =====");
		for (Movie m : mgr.search()) {
			System.out.println(m);
		}
		
		System.out.println("\n===== 3. 영화 검색(title) 테스트 =====");
		System.out.println(mgr.search("귀멸의칼날").toString());
		
		
		System.out.println("\n===== 4. 영화 검색(director) 테스트 =====");
		for (Movie m : mgr.searchDirector("디즈니")) {
			System.out.println(m.toString());
		}
		
		System.out.println("\n===== 5. 영화 검색(genre) 테스트 =====");
		for (Movie m : mgr.searchGenre("애니메이션")) {
			System.out.println(m.toString());
		}
		
		System.out.println("\n===== 6. 영화 삭제 테스트 =====");
		mgr.delete("인사이드아웃2");
		for (Movie m : mgr.search()) {
			System.out.println(m);
		}
		
		System.out.println("\n===== 7. 영화 개수 테스트 =====");
		System.out.println(mgr.getSize());
	}

}
