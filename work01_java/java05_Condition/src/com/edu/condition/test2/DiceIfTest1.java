package com.edu.condition.test2;

/*
 * static한 기능을 가지고 있는
 * Math클래스의 메소드 random()을 사용
 */
public class DiceIfTest1 {

	public static void main(String[] args) {
		int num = (int)(Math.random() * 6) + 1;
		System.out.println("num : " + num);
		
		if(num==1) System.out.println("Dice 1");
		else if(num==2) System.out.println("Dice 2");
		else if(num==3) System.out.println("Dice 3");
		else if(num==4) System.out.println("Dice 4");
		else if(num==5) System.out.println("Dice 5");
		else System.out.println("Dice 6");
	}

}
