package com.edu.child;

import com.edu.parent.Parent;

public class Child extends Parent {
	
	//자신만의 멤버
	public void childAccess() {
		System.out.println(publicField);
		System.out.println(protectedField);
		System.out.println("defaultField, privateField 는 접근할 수 없네요...");
	}
	
	
	@Override
	public void access() {
		super.access();
		System.out.println("부모에 접근가능한 필드 :: " + publicField + ", " + protectedField);
	}
}