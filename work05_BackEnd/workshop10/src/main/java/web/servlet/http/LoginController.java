package web.servlet.http;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.User;
import web.servlet.model.UserDAOImpl;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String path = "index.jsp";
		
		User user = null;
		
		// user가 null이 아니라면 데이터를 Attribute에 저장하고 이후 로직 진행...
		try {
			user = UserDAOImpl.getInstance().login(id, pass);
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				path = "loginSuccess.jsp";
			}
		} catch (SQLException e) {
			path = "loginError.jsp";
			e.printStackTrace();
		}
		
		return new ModelAndView(path);	
	}
}
