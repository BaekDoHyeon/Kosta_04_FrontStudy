package com.self.service;

import com.self.vo.Engineer;
import com.self.vo.Manager;

public class EmployeeService {
	Manager[ ] ms;
	int midx;
	
	Engineer[ ] egs;
	int egidx;	
	
	// 싱글톤 패턴 적용..
	private static final EmployeeService service = new EmployeeService();
	
	// 싱글톤 패턴 적용... Constructor Overloading 기법 적용
	private EmployeeService() {
		this(5);
	}

	private EmployeeService(int size){
		ms = new Manager[size];
		egs = new Engineer[size];
	}
	
	// 싱글톤 패턴 적용...
	public static EmployeeService getInstance() {
		return service;
	}
	
	public void addManager(Manager m) {	
		// Manager를 등록하는 기능
		ms[midx++] = m;
		System.out.println(m.getName() + " 매니저님이 등록되었습니다.");
	}
	
	public void addEngineer(Engineer eg) {	
		// Engineer를 등록하는 기능
		egs[egidx++] = eg;
		System.out.println(eg.getName() + " 엔지니어님이 등록되었습니다.");
	}
	
	public void deleteManager(String name) {	
		// Manager를 삭제하는 기능
		int tmpIndex = 0;
		for(int i = 0; i < midx; i++) {
			// 값 삭제 대상이라면...
			if(ms[i].getName().equals(name)) tmpIndex = i;
		}
		
		for(;tmpIndex < midx - 1; tmpIndex++) 
			ms[tmpIndex] = ms[tmpIndex + 1];
		ms[tmpIndex] = null;
		midx--;
		System.out.println(name + "님이 제거되셨습니다.");
	}
	
	public void deleteEngineer(String name) {
		// Engineer를 삭제하는 기능
		int tmpIndex = 0;
		for(int i = 0; i < egidx; i++) {
			// 값 삭제 대상이라면...
			if(egs[i].getName().equals(name)) tmpIndex = i;
		}
		
		for(;tmpIndex < egidx - 1; tmpIndex++) 
			egs[tmpIndex] = egs[tmpIndex + 1];
		egs[tmpIndex] = null;
		egidx--;
		System.out.println(name + "님이 제거되셨습니다.");
	}
	
	public void updateManager(Manager m) {	
		// Manager를 수정하는 기능
		for(int i = 0; i < midx; i++) {
			// 값 수정 대상이라면...
			if(ms[i].getName().equals(m.getName()) ) {
				ms[i].setSalary(m.getSalary());
				ms[i].setDept(m.getDept());
				ms[i].setDeptno(m.getDeptno());
				System.out.println("[매니저] " + ms[i].getName() + "님의 정보가 수정되었습니다.");
			}
		}
	}
	
	public void updateEngineer(Engineer eg) {	
		// Engineer 를 수정하는 기능
		for(int i = 0; i < egidx; i++) {
			// 값 수정 대상이라면...
			if(egs[i].getName().equals(eg.getName()) ) {
				egs[i].setSalary(eg.getSalary());
				egs[i].setTech(eg.getTech());
				egs[i].setBonus(eg.getBonus());
				System.out.println("[엔지니어] " + egs[i].getName() + "님의 정보가 수정되었습니다.");
			}
		}
	}	
	
	public void printManagers() {
		for(int i = 0; i < midx; i++) {
			if (ms[i] == null) break;
			System.out.println(ms[i].getDetails());
		}
	}
	
	public void printEngineers() {
		for(int i = 0; i < egidx; i++) {
			if (egs[i] == null) break;
			System.out.println(egs[i].getDetails());
		}
	}
	
	//Method Overloading
	/*
	 * 하는일은 똑같은데...처리하는 데이타를 달리할때 쓰는 기법
	 * 메소드의 통일감을 강조하면서도 서로다른 데이타를 처리할수 있게끔 해준다.
	 */
	public Manager findManager(String name) {
		Manager m = null;
		for (Manager manager : ms) {
			if (manager == null) break;
			if(manager.getName().equals(name)) {
				m = manager;
				break;
			}
		}
		
		return m;
	}
	
	public Manager[ ] findManager(int deptno) {
		Manager[ ] temp = new Manager[ms.length];
		int index = 0;
		for(Manager m : ms) {
			if(m == null) break;
			if(m.getDeptno() == deptno)
				temp[index++] = m;				
		}
		
		return temp;
	}
	
	public Engineer findEngineer(String name) {
		Engineer eg = null;
		for (Engineer engineer : egs) {
			if (engineer == null) break;
			if(engineer.getName().equals(name)) {
				eg = engineer;
				break;
			}
		}
		
		return eg;
	}
	
	//엔지니어 중에서 막내를 찾아 리턴 (아이디어 기능)
	public Engineer findBabyOfEngineer() {
		int maxYear = 0;
		int maxMonth = 0;
		int maxDay = 0;
		int babyIndex = 0;
		
		for(int i = 0; i < egidx; i++) {
			String[] birthDay = egs[i].getBirthDate().getDate().split("-");
			int year = Integer.parseInt(birthDay[0]);
			int month = Integer.parseInt(birthDay[1]);
			int day = Integer.parseInt(birthDay[2]);
						
			//막내를 구하는 로직... -> 년도, 월, 일 비교 로직
			if (year > maxYear) {
				maxYear = year;
				babyIndex = i;
			} else if (year == maxYear) {
				if(month > maxMonth) {
					maxMonth = month;
					babyIndex = i;
				} else if (month == maxMonth) {
					if(day > maxDay) {
						maxDay = day;
						babyIndex = i;
					}
				}
			}// if 조건문 끝
		}//for 반복문 끝
		return egs[babyIndex];
	}
	
	//매니저 중에서 막내를 찾아 리턴 (아이디어 기능)
	public Manager findBabyOfManager() {
		int maxYear = 0;
		int maxMonth = 0;
		int maxDay = 0;
		int babyIndex = 0;
		
		for(int i = 0; i < midx; i++) {
			String[] birthDay = ms[i].getBirthDate().getDate().split("-");
			int year = Integer.parseInt(birthDay[0]);
			int month = Integer.parseInt(birthDay[1]);
			int day = Integer.parseInt(birthDay[2]);
						
			//막내를 구하는 로직... -> 년도, 월, 일 비교 로직
			if (year > maxYear) {
				maxYear = year;
				babyIndex = i;
			} else if (year == maxYear) {
				if(month > maxMonth) {
					maxMonth = month;
					babyIndex = i;
				} else if (month == maxMonth) {
					if(day > maxDay) {
						maxDay = day;
						babyIndex = i;
					}
				}
			}// if 조건문 끝
		}//for 반복문 끝
		return ms[babyIndex];
	}
}