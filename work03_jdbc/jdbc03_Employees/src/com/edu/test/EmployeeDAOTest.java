package com.edu.test;

import java.sql.SQLException;

import com.edu.dao.Employee;
import com.edu.dao.impl.EmployeeDAO;
import com.edu.exception.DuplicateNumException;

public class EmployeeDAOTest {

	public static void main(String[] args){
		
		EmployeeDAO service = null;
		
		try {
			service = new EmployeeDAO();
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패...");
		}
		
		Employee emp1 = new Employee(1, "BAEK", 55000.0, "인천");
		Employee emp2 = new Employee(2, "KIM", 45000.0, "서울");
		Employee emp3 = new Employee(3, "CHO", 30000.0, "경기도");
		Employee emp4 = new Employee(4, "PARK", 9000.0, "대구");
		Employee emp5 = new Employee(5, "JANG", 22000.0, "부산");
		
		try {
			//INSERT
			service.insertEmployee(emp1);
			service.insertEmployee(emp2);
			service.insertEmployee(emp2);
			service.insertEmployee(emp3);
			service.insertEmployee(emp4);
			service.insertEmployee(emp5);
		} catch(SQLException e) {
			System.out.println("쿼리문 실행도중 알 수 없는 문제가 발생했습니다." + e.getClass());
		} catch(DuplicateNumException e) {
			System.out.println(e.getMessage());
		} 
		
		/*
		try {
			//INSERT
			service.insertEmployee(emp1);
			service.insertEmployee(emp2);
			service.insertEmployee(emp3);
			service.insertEmployee(emp4);
			service.insertEmployee(emp5);
			
			//SELECT ALL
			System.out.println("\n======= 데이터 5개 추가후 ===========");
			for (Employee e : service.selectEmployee()) 
				System.out.println(e);
			System.out.println("===================================");
			
			//DELETE
			service.removeEmployee(emp1);
			service.removeEmployee(emp2);
			service.removeEmployee(emp3);
			service.removeEmployee(emp4);
			service.removeEmployee(emp5);
			
			//SELECT ALL
			System.out.println("\n========= 데이터 전체 삭제 후 ============");
			for (Employee e : service.selectEmployee()) 
				System.out.println(e);
			System.out.println("=========================================");
			
			//INSERT
			service.insertEmployee(emp1);
			service.insertEmployee(emp2);
			service.insertEmployee(emp3);
			
			//UPDATE
			service.updateEmployee(new Employee(1, "BAEK", 77700.0, "서울"));
			service.updateEmployee(new Employee(2, "Yun", 66600.0, "강원도"));
			service.updateEmployee(new Employee(3, "CHANG", 55500.0, "서울"));
			
			//SELECT 
			System.out.println("\n======= 데이터 1, 2, 3 추가 후 =========");
			System.out.println(service.selectEmployee(1));
			System.out.println(service.selectEmployee(2));
			System.out.println("======================================");
			
			//SELECT ALL
			System.out.println("\n======== 데이터 전체 조회 ==========");
			for (Employee e : service.selectEmployee()) 
				System.out.println(e);
			System.out.println("=================================");
			
		} catch(SQLException e) {
			System.out.println("Query ERROR");
		}
		*/
	}
}
