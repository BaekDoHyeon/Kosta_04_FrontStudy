package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1
		/*
		 * request.setCharacterEncoding("UTF-8");
		 * response.setContentType("text/html;charset=UTF-8");
		 */
		
		//2
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
		request.getRequestDispatcher(path).forward(request, response);

	}

}
