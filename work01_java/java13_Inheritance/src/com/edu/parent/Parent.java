package com.edu.parent;
/*
 * 상속관계에서 Access Modifier 관계를 정리
 * 부모 클래스
 * 
 * public > protected > [default] > private
 */
public class Parent {
	public String publicField = "publicField";
	protected String protectedField = "protectedField";
	String defaultField = "defaultField";
	private String privateField = "privateField";
	
	public void access() {
		System.out.println("Access Modifier Test...");
	}
	
}
