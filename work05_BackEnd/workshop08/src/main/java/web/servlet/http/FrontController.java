package web.servlet.http;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Book;
import web.servlet.model.BookDAOImpl;
import web.servlet.model.User;
import web.servlet.model.UserDAOImpl;


@WebServlet("/front.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		String con = request.getParameter("condition");
		String form = request.getParameter("search");
		String path = "";
		
		if(command.equals("login")) {
			path = login(request, response);
		} else if (command.equals("bookRegister")) {
			path = bookRegister(request, response);
		} else if (command.equals("showBooks") || con != null && con.equals("전체")) {			
			path = showAllBook(request, response);
		} else if (command.equals("conditionSearch")) {
			if (con.equals("도서명")) {
				path = searchBookByTitle(form, request, response);
			} else if (con.equals("도서분류")){ 
				path = searchBookByCatalogue(form, request, response);
			}
		} else if (command.equals("detailInfo")) { //비동기 처리
			String detailTitle = request.getParameter("title");
			path = detailSearchByTitle(detailTitle, request, response);
		}
		
		System.out.println("요청 성공~ path: " + path);
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	private String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String path = "";
		
		User user = null;
		
		// user가 null이 아니라면 데이터를 Attribute에 저장하고 이후 로직 진행...
		try {
			user = UserDAOImpl.getInstance().login(id, pass);
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				path = "loginSuccess.jsp";
			} else
				path = "loginError.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return path;
	}

	private String bookRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		
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
			BookDAOImpl.getInstance().registerBook(new Book(isbn, title, category, country, date, publisher, author, price, currency, description));
			path = "book/bookSuccess.jsp";
		} catch (SQLException e) {
			path = "error/error.html";
			e.printStackTrace();
		}
		
		return path;
	}
	
	private String showAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "error/error.html";
		
		try {
			ArrayList<Book> list = BookDAOImpl.getInstance().showAllBook();
			HttpSession session = request.getSession();
			session.setAttribute("list", list);
			path = "book/showBooks.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return path;
	}
	
	private String searchBookByTitle(String title, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "error/error.html";
		
		try {
			ArrayList<Book> list = BookDAOImpl.getInstance().searchBookByTitle(title);
			HttpSession session = request.getSession();
			session.setAttribute("list", list);
			path = "book/showBooks.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return path;
	}
	
	private String searchBookByCatalogue(String catalogue, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "error/error.html";
		
		try {
			ArrayList<Book> list = BookDAOImpl.getInstance().searchBookByCatalogue(catalogue);
			HttpSession session = request.getSession();
			session.setAttribute("list", list);
			path = "book/showBooks.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return path;
	}
	
	private String detailSearchByTitle(String detailTitle, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Book book = BookDAOImpl.getInstance().detailSearchByTitle(detailTitle);
			System.out.println(book.getTitle());
			HttpSession session = request.getSession();
			session.setAttribute("book", book);
			System.out.println("detailSearchByTitle 호출");
			return "book/detail_bookInfo.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "book/detail_bookInfo.jsp";
	}
}








