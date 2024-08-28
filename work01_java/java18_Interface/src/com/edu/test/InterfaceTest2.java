package com.edu.test;

class Unit {
	int currentHP; //유닛의 체력
	int x; //유닛의 x 좌표
	int y; //유닛의 y 좌표
}

interface Movable {
	void move(int x, int y);
	void jump(int height);
}

interface Attackable {
	void attack(Unit u);
}

interface Fightable extends Movable, Attackable {
	//3개
}

class Fighter extends Unit implements Fightable {

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jump(int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack(Unit u) {
		// TODO Auto-generated method stub
		
	}
}

public class InterfaceTest2 {

	public static void main(String[] args) {
		
		Fighter f = new Fighter();
		
		if (f instanceof Unit) 
			System.out.println("f는 Unit 의 자손입니다.");

		if (f instanceof Object) 
			System.out.println("f는 Object 의 자손입니다.");
		
		if (f instanceof Fightable) 
			System.out.println("f는 Fightable 의 자손입니다.");
		
		if (f instanceof Movable) 
			System.out.println("f는 Movable 의 자손입니다.");
		
		if (f instanceof Attackable) 
			System.out.println("f는 Attackable 의 자손입니다.");
		
	}
}
