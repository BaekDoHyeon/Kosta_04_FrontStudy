package com.edu.vo.test;

import com.edu.vo.NoteBook;
import com.edu.vo.Programmer;

/*
 * 1. 객체 생성
 * 2. 메소드 호출
 */
public class ProgrammerTest {

	public static void main(String[] args) {
		/*
		 * 1. james 라는 개발자를 생성, tomas 라는 개발자를 생성
		 * 2. james가 HP 노트북을 구매, tomas가 LG노트북을 구매
		 * 3. tomas가 구매한 노트북의 가격과 브랜드명을 출력
		 * 4. james의 연봉을 출력
		 * 5. tomas의 급여를 인상...최종적인 연봉을 출력
		 */
		
		 //1. james 라는 개발자를 생성, tomas 라는 개발자를 생성
		 Programmer james = new Programmer("james", "Java", 3000000.0f, "LA", 300000);
		 Programmer tomas = new Programmer("tomas", "Python", 2600000.0f, "NewYork", 200000);
		 
		 //2. james가 HP 노트북을 구매, tomas가 LG노트북을 구매
		 james.buyNoteBook(new NoteBook(123, "HP", 1300000.0));
		 tomas.buyNoteBook(new NoteBook(456, "LG", 2000000.0));
		 
		 //3. tomas가 구매한 노트북의 가격과 브랜드명을 출력
		 System.out.println(tomas.getNoteBook().getNoteBookInfo());
		 
		 //4. james의 연봉을 출력
		 System.out.println("james 연봉: " + (int)james.getAnnualSalary() + "원");
		 
		 //5. tomas의 급여를 인상...최종적인 연봉을 출력
		 tomas.raiseSalary(400000);
		 System.out.println("tomas의 인상된 급여의 최종 연봉: " + (int)tomas.getAnnualSalary() + "원");
	}

}
