package web.servlet.http;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Book;
import web.servlet.model.BookDAOImpl;

@WebServlet("/book/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
	
		//폼값 받아오기~
		String[] bookNo = request.getParameterValues("bookNo");
		String isbn = String.join("-", bookNo);
		String title = request.getParameter("bookTitle");
		String category = request.getParameter("bookCategory");
		String country = request.getParameter("bookCountry");
		String date = request.getParameter("bookDate");
		String publisher = request.getParameter("bookPublisher");
		String author = request.getParameter("bookAuthor");
		int price = Integer.parseInt(request.getParameter("bookPrice"));
		String currency = request.getParameter("bookPrice2");
		String description = request.getParameter("bookSummary");
		
		//DAO 호출
		try {
			HttpSession session = request.getSession();
			System.out.println("BOOKSERVLET JSESSIONID : " +session.getId());
			BookDAOImpl.getInstance().registerBook(new Book(isbn, title, category, country, date, publisher, author, price, currency, description));
			request.getRequestDispatcher("bookSuccess.jsp").forward(request, response);
		} catch (SQLException e) {
			response.sendRedirect("../error/error.html");
			e.printStackTrace();
		}
	}

}
