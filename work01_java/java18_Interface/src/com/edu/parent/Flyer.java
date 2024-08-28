package com.edu.parent;
/*
 * 인터페이스는 추상메소드들의 집합 + public static final 상수값
 * ==
 * public abstract 메소드와 public static final 상수값으로 구성된다.
 * Template 기능 위주의 모듈...
 */
public interface Flyer {
	public void fly();
	void land(); //public abstract 이 무조건 앞에 생략되어져 있다. (인터페이스이기 때문에)
	void take_off();
	
}
