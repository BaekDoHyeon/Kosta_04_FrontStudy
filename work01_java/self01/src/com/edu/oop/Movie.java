package com.edu.oop;

public class Movie {
	String title;
	String genre;
	int rating;
	
	//기본 생성자
	public Movie() { }
	
	//명시적 생성자
	public Movie(String title, String genre, int rating) {
		this.title = title;
		this.genre = genre;
		this.rating = rating;
	}
	
	//setter() - 필드 값 주입 
	public void setMovieField(String title, String genre, int rating) {
		this.title = title;
		this.genre = genre;
		this.rating = rating;
	}
	
	//getter() - 필드 값 출력
	public String getMovieInfo() {
		return "영화제목: " + title + ", 장르: " + genre + ", 평점: " + rating;
	}
	
	void playIt() {
		System.out.println("Playing the movie");
	}
}
