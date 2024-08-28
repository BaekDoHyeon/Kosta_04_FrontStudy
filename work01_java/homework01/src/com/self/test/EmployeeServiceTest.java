package com.self.test;

import com.self.service.EmployeeService;
import com.self.util.MyDate;
import com.self.vo.Engineer;
import com.self.vo.Manager;

public class EmployeeServiceTest {
	public static void main(String[] args) {
		//1. Service 객체를 생성
		EmployeeService service = EmployeeService.getInstance();
				
		//2. method를 각각 호출..
		System.out.println("============ 1. addManager ============ ");
		service.addManager(new Manager("AAA", new MyDate(1978, 1, 1), 20000.0, "개발부", 10));
		service.addManager(new Manager("BBB", new MyDate(1975, 2, 1), 34000.0, "기획부", 20));
		service.addManager(new Manager("CCC", new MyDate(1995, 3, 3), 20000.0, "교육부", 30));
		service.addManager(new Manager("DDD", new MyDate(1980, 8, 1), 37000.0, "개발부", 10));
		service.addManager(new Manager("ABC", new MyDate(2000, 8, 23), 40000.0, "개발부", 10));
		
		System.out.println("============ Manager 정보확인 ============ ");
		service.printManagers();
			
		System.out.println("\n============ 1. addEngineer ============ ");
		service.addEngineer(new Engineer("EEE", new MyDate(1995,3,4), 350000.0, "Java", 200.0));
		service.addEngineer(new Engineer("FFF", new MyDate(1995,7,2), 350000.0, "Java", 200.0));
		service.addEngineer(new Engineer("GGG", new MyDate(1994,11,2), 450000.0, "Python", 300.0));
		service.addEngineer(new Engineer("HHH", new MyDate(1988,7,30), 500000.0, "C++", 350.0));
		
		System.out.println("============ Engineer 정보확인 ============ ");
		service.printEngineers();
		
		System.out.println("\n============ 2. deleteManager(BBB 삭제 + GGG 삭제) ============ ");
		service.deleteManager("BBB");
		service.deleteEngineer("GGG");
		System.out.println("============ Manager 정보확인 ============ ");
		service.printManagers();
		System.out.println("============ Engineer 정보확인 ============ ");
		service.printEngineers();
		
		System.out.println("\n============ 3. updateManager(CCC 연봉 수정 200->350) ============ ");
		service.updateManager(new Manager("CCC", new MyDate(1980, 3, 3), 35000.0, "교육부", 30));
		service.updateEngineer(new Engineer("FFF", new MyDate(1995,7,2), 400000.0, "Java", 200.0));
		
		
		System.out.println("============ Manager 정보확인 ============ ");
		service.printManagers();
		
		System.out.println("============ Engineer 정보확인 ============ ");
		service.printEngineers();
		
		
		System.out.println("\n============ 4. findManager(CCC) ============ ");
		Manager retM1=service.findManager("CCC");
		System.out.println(retM1.getDetails());
		
		System.out.println("\n============ 4. findManager(10) ============ ");
		System.out.println("10번 부서에 근무하는 직원들 입니다..");
		Manager[ ] retMs1 = service.findManager(10);
		for(Manager m : retMs1) {
			if(m==null) continue;
			System.out.println(m.getDetails());
		}
		
		System.out.println("\n============ 5. findBabyOfManager() ============ ");
		System.out.println("매니저 중 막내의 정보입니다.");
		System.out.println(service.findBabyOfManager().getDetails());
		
		System.out.println("\n============ 5. findBabyOfEngineer() ============ ");
		System.out.println("엔지니어 중 막내의 정보입니다.");
		System.out.println(service.findBabyOfEngineer().getDetails());
	}
}







