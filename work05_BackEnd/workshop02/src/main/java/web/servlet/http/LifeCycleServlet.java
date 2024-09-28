package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/LS", loadOnStartup = 1)
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public LifeCycleServlet() {
    	System.out.println("LifeCycleServlet() is called!!");
    }
    
    
	public void init() throws ServletException {
		System.out.println("init() is called!!");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() is called!!");
		
	    // 응답의 콘텐츠 타입과 문자 인코딩 설정
	    response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>안녕하세요, LifeCycleServlet 입니다.</h2></body></html>");
	}



}
