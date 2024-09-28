package web.servlet.controller;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

/*
 * Component란?
 * 인터페이스 기반으로 작성된 재사용성 강한 자바 클래스
 * 폼값 받아서
 * DAO 리턴받고 비지니스 로직 호출... 데이터 반환
 * 바인딩
 * 네비게이션
 */
public class IdCheckController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "index.jsp";

		//폼 값 받아서 비지니스 로직 호출... true/false 반환...idExist(id)
		String id = request.getParameter("id");
		try {
			boolean find = MemberDAOImpl.getInstance().idExist(id);
			System.out.println(find);
			request.setAttribute("find", find);
			path = "idCheck.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new ModelAndView(path);
	}
}
