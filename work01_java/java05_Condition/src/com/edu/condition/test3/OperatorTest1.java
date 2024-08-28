package com.edu.condition.test3;

public class OperatorTest1 {
	public static void main(String[] args) {
		
		int i = 5;
		int j = 3;
		
		// % : modulus
		System.out.println("연산자 % : " + i%j); //2
		System.out.println("연산자 / : " + i/j); //1
		
		int num = 98;
		System.out.println("십의자리 => " + num/10);
		System.out.println("일의자리 => " + num%10);
		
		// 1씩 증가 ++, 1씩 감소 --
		int k = 10;
		System.out.println(k++); //10
		System.out.println(++k); //12
		
		//////////////////////// same ////////////////////////
		
		Operator1 o1 = new Operator1();
		Operator1 o2 = new Operator1();
		System.out.println(o1 == o2); //false
		System.out.println(o1 != o2); //true
		
		//////////////////// short circuit ////////////////////
		
		System.out.println(o1.test1() | o1.test2());
		System.out.println("=================================");
		System.out.println(o1.test2() & o1.test1());
		
		System.out.println("----------------------------------");
		
		System.out.println(o1.test1() || o1.test2()); //short circuit
		System.out.println("=================================");
		System.out.println(o1.test2() && o1.test1()); //short circuit
		
		System.out.println("#################################");
		
		//equals()  ==
		System.out.println(o1.equals(o2));
		System.out.println(o1 == o2);
		String msg1 = "Hello";
		String msg2 = "Hello";
		
		System.out.println("----------------------------------");
		
		// == 는 값 비교를 하고, equals 는 주소 값 비교인데 String 에서는 바뀌어서 문자열 비교가 된다. 
		System.out.println(msg1.equals(msg2)); //true
		System.out.println(msg1 == msg2);      //이건 사용하면 안됨
	}
}

class Operator1 {
	public boolean test1() {
		System.out.println("test1() calling.....");
		return true;
	}
	
	public boolean test2() {
		System.out.println("test2() calling.....");
		return false;
	}
}

class Operator2 {
	public boolean test1() {
		System.out.println("test1() calling.....");
		return true;
	}
	
	public boolean test2() {
		System.out.println("test2() calling.....");
		return false;
	}
}