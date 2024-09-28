package web.generic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyGenericServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		PrintWriter out = res.getWriter();
		out.println("<html><body><h2>"); //브라우저로 ()안에 있는 내용을 출력
		out.println("Hello MyGenericServlet~~!!");
		out.println("</h2></body></html>");
	}
	
}
