package web.servlet.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.vo.Product;

@WebServlet("/List")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Product> list = null;
			
	//list 는 클래스와 라이프사이클을 같이한다.
	public ListServlet() {
		list = new ArrayList<Product>();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product p1 = new Product("AAA", 450000, "A++");
		Product p2 = new Product("BBB", 300000, "B++");
		Product p3 = new Product("CCC", 150000, "C++");
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
}








