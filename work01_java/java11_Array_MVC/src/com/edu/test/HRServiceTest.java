package com.edu.test;

import com.edu.service.HRService;
import com.edu.util.MyDate;
import com.edu.vo.Engineer;
import com.edu.vo.SalesMan;

public class HRServiceTest {
	
	public static void main(String[] args) {
		HRService service = new HRService(5);
		
		Engineer e1 = new Engineer("En1", 30000.0, "Java", new MyDate(1998, 1, 1));
		Engineer e2 = new Engineer("En2", 46000.0, "Python", new MyDate(1997, 3, 11));
		Engineer e3 = new Engineer("En3", 52000.0, "AI", new MyDate(1990, 2, 1));
		
		SalesMan s = new SalesMan("Sa1", 55555, 1000, new MyDate(1992, 3, 1));
		
		//서비스 기능 호출...
		
		//엔지니어를 추가하는 기능
		System.out.println("============= 1. addEmployee =============");
		service.addEmployee(e1);
		service.addEmployee(e2);
		service.addEmployee(e3);

		//영업사원을 추가하는 기능
		service.addEmployee(s);
		
		System.out.println("============= 2. Employee 정보 확인 =============");
		service.printEngineer();
		service.printSalesMan();
		
		
		// 엔지니어의 정보를 수정하는 기능
		System.out.println("============= 3. updateEmployee Engineer =============");
		service.updateEmployee(new Engineer("En1", 40000.0, "Java", new MyDate(1998, 1, 1)));
		
		// 영업사원의 정보를 수정하는 기능
		service.updateEmployee(new SalesMan("Sa1", 60000, 2000, new MyDate(1992, 3, 1)));
		
		
		System.out.println("============= 4. Employee 정보 확인 =============");
		service.printEngineer();
		service.printSalesMan();
		
		System.out.println("============= 5. searchEmployee  Tomas =============");
		System.out.println("검색한 엔지니어 정보 : " + service.searchEmployee("En1").getDetails());
	}

}
