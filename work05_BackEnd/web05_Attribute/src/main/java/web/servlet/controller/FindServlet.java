package web.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.dto.Member;

@WebServlet("/Find")
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FindServlet() {

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		   1. 폼값 받아서
		   2. DAO 비즈니스 로직 호출... 이때 폼값을 인자값으로
		   3. 디비 반환 값 받아서 
		   4. 바인딩... setAttribute()
		   5. 네비게이션
		*/
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String address = request.getParameter("address");
		
		//2.3
		Member mem = new Member("홍종각", 33, "종각");
		
		//4.
		request.setAttribute("mem", mem);
		
		//5. 서버상에서 다이렉트로 다른 서블릿(jsp)로 이동하는 방법
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}
}
