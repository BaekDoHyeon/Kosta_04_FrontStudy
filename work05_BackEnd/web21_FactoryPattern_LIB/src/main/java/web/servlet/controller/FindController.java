package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

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
public class FindController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String path = "find_fail.jsp";
		
		Member rvo = MemberDAOImpl.getInstance().findByIdMember(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("find_ok");
		mv.addObject("message","Hello Spring MVC FARAMEWORK~~!! " + rvo.getName());
		
		return mv;
	}
}
