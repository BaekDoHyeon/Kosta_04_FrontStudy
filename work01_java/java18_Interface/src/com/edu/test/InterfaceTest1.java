package com.edu.test;

import com.edu.child.AirPlane;
//import의 대상은 .java 파일이 아니라 .class 파일이다. -> 컴파일 되어있지 않으면 import 불가능~
import com.edu.child.Bird;
import com.edu.parent.Flyer;

public class InterfaceTest1 {

	public static void main(String[] args) {
		//abstract 가 조금이라도 있다면, 객체 생성의 대상이 될 수 없다.
		//하지만, 객체 생성을 하기 위한 타입으로 선언은 가능하다.
		//Flyer f = new Flyer();
		Flyer f = new Bird();
		/*
		 * Polymorphism...부모 타입으로 자식객체를 생성
		 * ::
		 * 1. Object Casting
		 * 2. Virtual Method Invocation
		 */
		System.out.println(((Bird)f).layEggs()); //1
		f.land(); //2

		/////////////////////////////////////////
		
		Flyer f2 = new AirPlane();
		f2.fly();
		f2.land();
	}
}