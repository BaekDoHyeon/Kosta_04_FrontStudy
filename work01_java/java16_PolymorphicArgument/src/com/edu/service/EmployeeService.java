package com.edu.service;

import com.edu.vo.Employee;
import com.edu.vo.Engineer;

public class EmployeeService {
	
	static private EmployeeService service = new EmployeeService();//1
	private EmployeeService() {}//2
	public static EmployeeService getInstance() { //3
		return service;
	}
		
	//1. 모든 Employee[ ]안에 들어있는 객체 정보들을 출력
	public Employee[ ] getAllEmployee(Employee[ ] ea){	
		Employee[ ] temp = new Employee[ea.length];
		int count = 0;
		for(Employee e : ea)
			temp[count++] = e;			
		
		return temp;
	}
	
	//2.테스트 클래스에서 넘겨받은 empId의 값과 일치하는 객체를 리턴하는 기능
	public Employee findEmployee(Employee[ ] ea, int empId){
		Employee employee = null;
		for(Employee e : ea) {
			if(e.getEmpId() == empId) {
				employee = e;
				break;
			}
		}
		
		return employee;		
	}	
	
	//3. 테스트 클래스에서 넘겨받은 addr 값과 일치하는 Employee 타입의 객체를 리턴받음
	//메소드 오버로딩 : "하는일은 같지만 처리하는 데이터를 달리할 때 사용하는 기법"... -> 인지
	public Employee[ ] findEmployee(Employee[ ] ea, String addr){
		int count = 0;
		int idx = 0;
		
		for (Employee e : ea)
			if(e.getAddr().equals(addr)) 
				count++;
		
		Employee[] addrEmps = new Employee[count];
		
		//for (Employee e : ea)
		//	if(e.getAddr().equals(addr)) 
		//		addrEmps[--count] = e;
		for (int i = 0; i < ea.length; i++) 
			if(ea[i].getAddr().equals(addr))
				addrEmps[idx++] = ea[i];
		
		return addrEmps;	
	}
	
	//4. 특정한 Employee 의 연봉을 리턴하는 기능...Engineer 일때는 보너스 까지 생각
	public int getAnnualSalary(Employee e){
		int annualSalary = 0;
		
		annualSalary = e.getSalary() * 12;
		
		if (e instanceof Engineer) 
			annualSalary += ((Engineer) e).getBonus();
	
		return annualSalary;
	}
	
	//5. 연간 총 인건비의 총액을 리턴하는 기능
	public int getTotalCost(Employee[ ] ea){
		int totalCost = 0;
		for(Employee e : ea) 
			totalCost += getAnnualSalary(e);
		
		return totalCost;
	}
}