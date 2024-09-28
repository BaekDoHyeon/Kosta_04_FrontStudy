package web.servlet.page;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Redirect2")
public class ChoiceRedirect2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 *  1. 폼값 받아서...
		 *  2. 에러발생 여부에 따라서 페이지 이동법을 달리한다.
		 *  	1) 에러 발생하는 경우(선택하지 않으면)...에러페이지로 연결 --> Redirect 방식으로 페이지 이동
		 *  	2) 에러 발생하지 않는 경우... redirect2.jsp 페이지로 연결 --> Forward 방식으로 이동
		 *  
		 */
		
		String city = request.getParameter("city");
		
		if (city == null) {
			response.sendRedirect("error/error2.html");
		} else {
			//request.setAttribute("city", city);
			request.getRequestDispatcher("redirect2.jsp").forward(request, response);
		}
		
	}

}
