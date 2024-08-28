package com.edu.singletone.test;

class EmployeeDAO {
	//싱글톤 패턴으로 작성하는 방법!
	//1. private static 으로 객체 생성
	private static EmployeeDAO dao = new EmployeeDAO();
	
	//2. 생성자 앞에 private
	private EmployeeDAO() {
		System.out.println("싱글톤으로 객체 하나만 생성");
	}
	
	//3. public static 한 성질로 만든 객체를 반환하는 기능
	public static EmployeeDAO getInstance() {
		return dao;
	}
	
	public void register(String name) {
		System.out.println("Register Service..." + name + "...Register Success!!");
	}
	
	public void search() {
		System.out.println("Search Service...OK!!");
	}
}

//client side... BLAKE, SCOTT, SMITH 세명의 직원이 사내 사이트 접속... 직원가입을 요청
public class EmployeeDAOTest {

	public static void main(String[] args) {
		EmployeeDAO.getInstance().register("BLAKE");
		EmployeeDAO.getInstance().register("SCOTT");
		EmployeeDAO.getInstance().register("SMITH");
	}

}
