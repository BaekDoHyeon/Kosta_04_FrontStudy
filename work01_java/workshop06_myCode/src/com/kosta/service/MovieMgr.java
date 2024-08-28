package com.kosta.service;

import com.kosta.vo.Movie;

public class MovieMgr {
	private Movie[] movies = new Movie[5]; //5개로 임시설정...
	private int index;
	private static MovieMgr mgr = new MovieMgr();
	
	private MovieMgr() {}
	
	public static MovieMgr getInstance() {
		return mgr;
	}
	
	//1. 영화 추가
	public void add(Movie movie) {
		if(index >= 5) {
			System.out.println("[에러] 영화 추가가 불가능합니다.. 영화를 삭제 후 추가해주십시오.");
			
		} else {
			movies[index++] = movie;
			System.out.println(movie.getTitle() + " 영화 등록 완료!");
		}
	}
	
	//영화 검색
	public Movie[] search() {
		int tmpIndex = 0;
		int size = 0;
		
		//null 값을 제외한 값 만큼의 배열 크기 선언
		for(Movie m : movies) {
			if (m == null) break;
		
			size++;
		}
		
		Movie[] temp = new Movie[size];
		
		for(Movie m : movies) {
			if (m == null) break;
			
			temp[tmpIndex++] = m;
		}
		
		return temp;
	}
	
	//title 사용하여 영화 검색...동일한 영화 이름이 없을테니...Movie 반환...?
	public Movie search(String title) {	
		for(Movie m : movies) {
			if (m.getTitle().equals(title)) {
				return m;
			}
		}
		
		return new Movie(); // title에 해당하는 영화가 없다는 의미로 빈 객체 리턴...
	}
	
	//director 사용하여 영화 검색
	public Movie[] searchDirector(String director) {
		int size = 0;
		int tempIndex = 0;
		for(Movie m : movies) {
			if (m == null) break;
			if (m.getDirector().equals(director))
				size++;
		}
		
		Movie[] temp = new Movie[size];
		
		for(Movie m : movies) {
			if (m == null) break;
			
			if (m.getDirector().equals(director))
				temp[tempIndex++] = m;
		}
		
		return temp;
	}
	
	//genre 사용하여 영화 검색
	public Movie[] searchGenre(String genre) {
		int size = 0;
		int tempIndex = 0;
		for(Movie m : movies) {
			if (m == null) break;
			if (m.getGenre().equals(genre))
				size++;
		}
		
		Movie[] temp = new Movie[size];
		
		for(Movie m : movies) {
			if (m == null) break;
			
			if (m.getGenre().equals(genre))
				temp[tempIndex++] = m;
		}
		
		return temp;
	}
	
	//영화 이름으로 영화 삭제
	public void delete(String title) {
		for (int i = 0; i < movies.length; i++) {
			//삭제 조건에 일치한다면...
			if (movies[i].getTitle().equals(title)) {
				for(int j = i+1; j < movies.length; j++) {
					movies[j-1] = movies[j]; 
				}
				movies[movies.length-1] = null;
				break;
			}
		}
	}
	
	//영화 개수 리턴 -> 배열의 크기는 5지만 내부적으로 영화가 삭제되었을 수도 있다.
	public int getSize() {
		int count = 0;
		for(Movie m : movies) {
			if(m == null) break;
			count++;
		}	
		return count;
	}
}
