package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindController implements Controller {

	private static FindController register = new FindController();
	private FindController() {}
	public static FindController getInstance() {
		return register;
	}
	
	@Override
	public String handle(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * 폼값 받아서...
		 * DAO 비지니스 로직 리턴받고...
		 * 데이터 바인딩
		 * 네비게이션
		 */
		System.out.println("FindController...Find 비지니스 로직 호출...");
		return "find_result.jsp";
	}
	
}
