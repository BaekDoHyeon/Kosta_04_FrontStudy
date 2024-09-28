package web.generic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *  @ Annotation 기법
 *  
 *  <servlet>
 *      <servlet-name>MyGenericServlet</servlet-name>
 *      <servlet-class>web.generic.servlet.MyGenericServlet</servlet-class>
 *  </servlet>
 *  <servlet-mapping>
 *	    <servlet-name>MyGenericServlet</servlet-name>
 *    	<url-pattern>/SS</url-pattern>
 *  </servlet-mapping>
 */
@WebServlet("/SS")
public class MyGenericServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyGenericServlet() {
    	System.out.println("1....서블릿 인스턴스 생성....BY CONTAINER..");
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>"); //브라우저로 ()안에 있는 내용을 출력
		out.println("Hello MyGenericServlet~~!!");
		out.println("</h2></body></html>");
	}

}