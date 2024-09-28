package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

@WebServlet("/front.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기서 작성...한글처리 안해도 된다. (Filter 등록되어져 있음)
		//command 값 받아온다.
		String command = request.getParameter("command");
		String path = "index.html";
		
		if(command.equals("find")) {
			path = find(request, response);
		} else if(command.equals("login")) {
			path = login(request, response);
		} else if(command.equals("register")) { 
			path = register(request, response);
		} else if(command.equals("showAll")) { 
			path = showAll(request, response);
		} else if(command.equals("logout")) { 
			path = logout(request, response);
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	private String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "login.jsp";
		try {
			//세션을 죽이는 로직... logout.jsp
			HttpSession session = request.getSession();
			if(session.getAttribute("vo") != null) {  //로그인이 되어져 있다면...
				session.invalidate();
				path = "logout.jsp";
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return path;
	}
	
	private String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String path = "find_fail.jsp";
		
		//3
		try {
			Member rvo = MemberDAOImpl.getInstance().findByIdMember(id);
			if (rvo != null) {
				request.setAttribute("vo", rvo);
				path = "find_ok.jsp";
			}
		} catch (SQLException e) {
			
		}
		
		return path;
	}
	
	private String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		return path;
	}
	
	private String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		
		Member vo = null;
		if(name.equals("") && addr.equals(""))
			vo = new Member(id, pwd);
		else 
			vo = new Member(id, pwd, name, addr);
		
		String path = "index.html";
		
		try {
			if (vo != null) {
				MemberDAOImpl.getInstance().registerMember(vo);
				request.setAttribute("vo", vo);
				path = "register_result.jsp";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return path;
	}

	private String showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "index.html";
		try {
			ArrayList<Member> list =  MemberDAOImpl.getInstance().showAllMember();
			request.setAttribute("list", list);
			path = "allView.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return path;
	}
	
	
}






















