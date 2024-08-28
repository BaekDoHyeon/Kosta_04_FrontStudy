package com.edu.vo;

/*
 * NoteBook의 정보를 저장하고 있는 클래스
 * VO = Value Object
*/
public class NoteBook {
	//field 선언
	//멤버 변수 -> 메소드 안에 선언된 변수는 Field 가 아니라 지역 변수(로컬 변수)이다.
	//Heap 영역에 올라가는 애들은 클래스의 구성요소만 올라간다. (new 키워드를 통해서 생성된 객체의 멤버)
	//로컬 변수는 Stack 영역에 올라간다.
	public int serialNumber;
	public String brand;
	public double price;
	
	//기본 생성자
	public NoteBook() {}
	
	//명시적 생성자..setter 기능과 동일
	public NoteBook(int serialNumber, String brand, double price) {
		this.serialNumber = serialNumber;
		this.brand = brand;
		this.price = price;
	}
	
	//기능 추가... 필드에 값을 할당, 주입, setter(inject)
	public void setNoteBookField(int serialNumber, String brand, double price) {  //파라미터(매개변수) int, String, double
		this.serialNumber = serialNumber;
		this.brand = brand;
		this.price = price;
	}
	
	//기능 추가... 필드에 주입된 값을 받아옴, getter(reading)
	//String + int = String 타입 변환 
	//리턴타입이 void 가 아닌 String 인 이유는 응답(결과는)은 Server 가 아닌 Client 쪽에서 리턴(출력)해야하기 때문이다. 
	public String getNoteBookInfo() {
		return serialNumber + ", " + brand + ", " + price;
	}
	
	//method 정의(선언 + 구현부)
	//void : 반환타입 - 해당 기능을 수행한 후 반환되는 데이터가 없다는 의미의 반환타입
	public void printNoteBookInfo() {
		System.out.println(serialNumber+", "+brand+", "+price);
	}
}