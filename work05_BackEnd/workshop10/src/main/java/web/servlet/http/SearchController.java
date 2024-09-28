package web.servlet.http;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Book;
import web.servlet.model.BookDAOImpl;

public class SearchController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String option = request.getParameter("condition");
		String search = request.getParameter("search");
		String path = "error/error.jsp";
		ArrayList<Book> list = new ArrayList<Book>();
		
		try {
			if(option.equals("도서명"))
				list = BookDAOImpl.getInstance().searchBookByTitle(search);
			else 
				list = BookDAOImpl.getInstance().searchBookByCatalogue(search);
			
			HttpSession session = request.getSession();
			session.setAttribute("list", list);
			path = "book/showBooks.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return new ModelAndView(path);
	}
	
}
