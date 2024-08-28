package com.edu.test;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class PolyTest3 {

	public static void main(String[] args) {
		//Heterogeneous Collection
		Employee[] employees = {
				new Manager("James", 30000.0, new MyDate(1999, 1, 1), "IT"),
				new Engineer("Tomas", 45000.0, new MyDate(1997, 3, 12), "Java", 100),
				new Secretary("Peter", 35000.0, new MyDate(2000, 8, 23), "James")
		};
		
		/*
		 * for문과 instanceof, Object Casting, Virtual Method Invocation 전부 다 사용
		 * ::
		 * James 부서를 "개발부" 로 수정
		 * Tomas 기술을 "AI" 로 수정
		 * Peter Boss의 이름을 "Gosling" 로 수정
		 * 
		 * 수정된 정보를 출력...확인
		 */
		/*/////////////////////////////////////////////////////////////////////////
		 * 1 step
		 * updateManager(Manager m) {}
		 * updateEngineer(Engineer eg) {}
		 * 
		 * 2 step
		 * updateEmployee(Manager m) {}
		 * updateEmployee(Engineer eg) {}
		 * 
		 * 3 step
		 * updateEmployee(Employee e) {}
		 */	
		for(Employee e : employees) {
			if (e instanceof Manager)
				((Manager) e).changeDept("개발부");
			else if (e instanceof Engineer) 
				((Engineer) e).changeTech("AI");
			else if (e instanceof Secretary)
				((Secretary) e).changeNameOfBoss("Gosling");
			
			System.out.println(e.getDetails());
		}
	}
}