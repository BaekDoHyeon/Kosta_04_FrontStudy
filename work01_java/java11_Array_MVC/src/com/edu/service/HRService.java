/* 
 *  step1
 *  void addEngineer(Engineer e) {}
 *  void insertSalesMan(...) {}
 *  void registerAnalysist(...) {}
 *  
 *  step2
 *  void addEngineer(...) {}
 *  void addSalesMan(...) {}
 *  void addAnalysist(...) {}
 *  
 *  step3
 *  void addEmployee(Engineer e) {}
 *  void addEmployee(SaleMan s) {}
 *  void addEmployee(Analysis a) {}
 *  
 *  step4
 *  void addEmployee(Employee e) {}
 */

package com.edu.service;

import com.edu.vo.Engineer;
import com.edu.vo.SalesMan;

/*
 * Engineer, SalesMan 각각의 직원들을 핸들링하는 기능만으로 구성된 서비스 클래스... 
 */
public class HRService {
	
	Engineer[] engineers;
	int eidx;
	
	SalesMan[] salesMans;
	int sidx;
	
	public HRService(int size) {
		engineers = new Engineer[size];
		salesMans = new SalesMan[size];
	}
	
	//서비스 기능들을 정의... 1)선언부 먼저 작성 + 2)나중에 구현부 작성 + Test 에서 하나씩 호출
	// 엔지니어를 추가하는 기능
	public void addEmployee(Engineer engineer) {
		if(eidx == engineers.length)
			System.out.println("더 이상 엔지니어 추가가 불가능합니다.");
		else {
			engineers[eidx++] = engineer;
			System.out.println(engineer.getName() + " 엔지니어 추가 완료");
		}
	}
	
	// 영업사원을 추가하는 기능
	public void addEmployee(SalesMan salesMan) {
		if(sidx == salesMans.length)
			System.out.println("더 이상 영업사원 추가가 불가능합니다.");
		else {
			salesMans[sidx++] = salesMan;
			System.out.println(salesMan.getName() + " 영업사원 추가 완료");
		}
	}
	
	// 엔지니어의 정보를 수정하는 기능 -> 이해 OK
	public void updateEmployee(Engineer engineer) {
		/*
		for(int i = 0; i < engineers.length; i++) {
			if (engineers[i] == null) break;
			
			// 수정 대상
			if (engineers[i].getName() == engineer.getName()) {
				engineers[i].changeSalary(engineer.getSalary());
				engineers[i].developMainSkill(engineer.getMainSkill());
				System.out.println(engineers[i].getName() + "님의 정보가 수정되었습니다.");
				System.out.println("수정 후 : " + engineers[i].getDetails());
			}
		}
		*/
		
		// e의 값을 변경하면 engineers 의 해당 인덱스의 값을 변경한다. -> 직접 참조가 되어 있나보다..?
		for(Engineer e : engineers) {
			if(e == null) continue;
			if(e.getName().equals(engineer.getName())) {
				e.changeSalary(engineer.getSalary());
				e.developMainSkill(engineer.getMainSkill());
			}
		}
	}
	
	// 영업사원의 정보를 수정하는 기능 -> 이해 OK
	public void updateEmployee(SalesMan salesMan) {
		/*
		for(int i = 0; i < salesMans.length; i++) {
			if (salesMans[i] == null) break;
			
			// 수정 대상
			if (salesMans[i].getName() == salesMan.getName()) {
				salesMans[i].changeSalary(salesMan.getSalary());
				salesMans[i].setCommition(salesMan.getCommition());
				System.out.println(salesMans[i].getName() + "님의 정보가 수정되었습니다.");
				System.out.println("수정 후 : " + salesMans[i].getDetails());
			}
		}
		*/
		
		// s의 값을 변경하면 salesMans 의 해당 인덱스의 값을 변경한다. -> 직접 참조가 되어 있나보다..?
		for(SalesMan s : salesMans) {
			if(s == null) continue;
			if(s.getName().equals(salesMan.getName())) {
				s.changeSalary(salesMan.getSalary());
				s.setCommition(salesMan.getCommition());
			}
		}
	}
	
	// 특정한 엔지니어를 검색하는 기능... 이름으로 -> 이해 OK
	public Engineer searchEmployee(String name) {	
		
		Engineer engineer = new Engineer();
		
		for (Engineer e : engineers) {
			if (e == null) break;
			if (e.getName().equals(name))
				return engineer = e;
		}

		return engineer;
	}
	
	// 현재 추가되어 있는 엔지니어들의 정보를 출력
	public void printEngineer() {
		for(Engineer e : engineers) {
			if (e == null) break;
			System.out.println(e.getDetails());
		}
	}
	
	// 현재 추가되어 있는 영업사원들의 정보를 출력
	public void printSalesMan() {
		for(SalesMan s : salesMans) {
			if (s == null) break;
			System.out.println(s.getDetails());
		}
	}
}
