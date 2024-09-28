package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 결과 페이지
		 * login_result.jsp
		 * 
		 * 1. 폼 값을 받아온다.
		 * 2. DAO 리턴받고 비즈니스 로직 호출... 결과값 반환
		 * 3. 세션 받아와서 세션 바인딩
		 * 4. 네비게이션
		 */
		
		/*
		 * request.setCharacterEncoding("UTF-8");
		 * response.setContentType("text/html;charset=UTF-8");
		 */
		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		String path = "index.html";
		
		try {
			Member rvo = MemberDAOImpl.getInstance().login(id, pwd);
			HttpSession session = request.getSession();
			/*
			 * Session 에 바인딩 하는 경우
			 * 1) 로그인 로직...
			 * 2) 정보수정 로직...
			 */
			
			if(rvo != null) { //null 인 경우는 바인딩 진행 안되도록...
				session.setAttribute("vo", rvo);
				System.out.println("LoginServlet... JSESSIONID ::: " + session.getId());	
				path = "login_result.jsp";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			path = "login_fail.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
