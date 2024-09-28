package web.servlet.http;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Book;
import web.servlet.model.BookDAOImpl;

public class DetailBookController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String detailTitle = request.getParameter("title");
		
		try {
			Book book = BookDAOImpl.getInstance().detailSearchByTitle(detailTitle);
			System.out.println(book.getTitle());
			HttpSession session = request.getSession();
			session.setAttribute("book", book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new ModelAndView("book/detail_bookInfo.jsp");
	}
	
}
