package com.edu.oop.test;

import com.edu.oop.Movie;

public class MovieTestDrive {
	public static void main(String[] args) {
		//객체 생성 코드... setter()
		Movie setterMovie = new Movie();
		setterMovie.setMovieField("듄2", "판타지", 5);
		System.out.println("setter 방식 : " + setterMovie.getMovieInfo());
		
		//객체 생성 코드... Construct
		Movie constructMovie = new Movie("듄2", "판타지", 5);
		System.out.println("Construct 방식 : " + constructMovie.getMovieInfo());
	}
}
