package web.servlet.http;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.User;
import web.servlet.model.UserDAOImpl;

@WebServlet(urlPatterns = "/Login", loadOnStartup = 1)
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainServlet() {

    }
    
	public void init() throws ServletException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답의 콘텐츠 타입과 문자 인코딩 설정
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		User user = null;
		
		// user가 null이 아니라면 데이터를 Attribute에 저장하고 이후 로직 진행...
		try {
			user = UserDAOImpl.getInstance().login(id, pass);
			if (user != null) {
				HttpSession session = request.getSession();
				System.out.println("MAINSERVLET JSESSIONID : " + session.getId());
				session.setAttribute("user", user);
				request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
			} else
				response.sendRedirect("loginError.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
