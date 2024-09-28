package web.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	/*
	 * 이전 방식과 다른점
	 * hidden 태그로 요청을 제각각 받지 않았다.
	 * 들어온 요청의 주소를 직접 인식시킨다.
	 */
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
		String requstURI = request.getRequestURI(); //web20_factoryPattern_Find/find.do
		String contextPath = request.getContextPath(); //web20_factoryPattern_Find
		
		//find.do만 추출해보자
		String command = requstURI.substring(contextPath.length() + 1); //find.do
		System.out.println("command: " + command);
		
		//1. HandlerMapping의 createComponent 함수를 호출... 이때 위에서 받은 command를 넣어준다.
		// Controller 반환
		Controller controller = HandlerMapping.getFactory().createComponent(command);
		
		//2. Controller 의 메소드 호출... ModelAndView 반환
		// 네비게이션
		ModelAndView mv = null;
		String path = "index.jsp";
		
		try {
			mv = controller.handleRequest(request, response);
			path = mv.getPath();
			
			if(mv != null) {
				if(!mv.isRedirect()) request.getRequestDispatcher(path).forward(request, response);
				else response.sendRedirect(command);
			}
		} catch (Exception e) {
			System.out.println(e);	
		}
	}
}
