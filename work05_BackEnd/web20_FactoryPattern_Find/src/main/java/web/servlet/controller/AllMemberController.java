package web.servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class AllMemberController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "index.html";
		try {
			ArrayList<Member> list =  MemberDAOImpl.getInstance().showAllMember();
			request.setAttribute("list", list);
			path = "allView.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new ModelAndView(path);
	}
}
