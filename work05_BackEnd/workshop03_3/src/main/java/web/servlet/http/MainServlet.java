package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.vo.User;

@WebServlet(urlPatterns = "/MS", loadOnStartup = 1)
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainServlet() {

    }
    
	public void init() throws ServletException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답의 콘텐츠 타입과 문자 인코딩 설정
	    response.setContentType("text/html;charset=UTF-8");
	    
	    PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		User user = new User(id, pass, "크리스토퍼 놀란", "인천");

		if(id.equals("kosta") && pass.equals("1234")) {
			request.setAttribute("user", user);
			//request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
			out.println("<a href='loginSuccess.jsp'>Success Page 이동</a>");
		} else {
			//request.getRequestDispatcher("loginError.jsp").forward(request, response);
			out.println("<a href='loginError.jsp'>Error Page 이동</a>");
		}
	}
}
