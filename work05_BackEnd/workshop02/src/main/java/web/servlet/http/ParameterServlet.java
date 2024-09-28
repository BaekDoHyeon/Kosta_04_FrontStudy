package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/params")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ParameterServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<html><body><h3>");
		out.println("job : " + request.getParameter("job"));
		out.println("<br>");
		out.println("<br>");
		out.println("pageNo : " + request.getParameter("pageNo"));
		out.println("<br>");
		out.println("<br>");
		out.println("searchWord : " + request.getParameter("searchWord"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		String[] hobbies = request.getParameterValues("hobby");
		
		out.println("<h3>");
		out.println("name : " + request.getParameter("name"));
		out.println("<br>");
		out.println("<br>");
		out.println("email : " + request.getParameter("email"));
		out.println("<br>");
		out.println("<br>");	
		out.println("gender : " + request.getParameter("gender"));
		out.println("<br>");
		out.println("<br>");
		out.print("hobby : ");
		for (int i = 0; i < hobbies.length; i++) {
			if(i == hobbies.length - 1)
				out.print(hobbies[i]);
			else
				out.print(hobbies[i] + ", ");
		}
		out.println("<br>");
		out.println("<br>");
		out.println("favorite : " + request.getParameter("favorite"));
		out.println("<br>");
		out.println("<br>");
		out.println("desc : " + request.getParameter("desc"));
		out.println("</h3>");
	}

}
