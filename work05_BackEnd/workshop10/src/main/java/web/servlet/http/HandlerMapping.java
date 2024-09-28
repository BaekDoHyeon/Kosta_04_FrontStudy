package web.servlet.http;

//Component를 생성하는 일종의 공장
//서블릿이 전해주는 command 값에 따라서 Component를 생성
//그리고 다시 서블릿에게 생성한 Component를 반환할때는 Controller 인터페이스 타입으로 반환
public class HandlerMapping {
	
	private static HandlerMapping factory = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getFactory() {
		return factory;
	}
	
	//Component를 생성하는 기능...
	public Controller createComponent(String command) {
		Controller controller = null;
		if(command.equals("login.do")) {
			controller = new LoginController();
			System.out.println("LoginController...생성됨...");
		} else if (command.equals("registerBook.do")) {
			controller = new RegisterBookController();
			System.out.println("RegisterBookController...생성됨...");
		} else if (command.equals("bookList.do")) {
			controller = new BookListController();
			System.out.println("BookListController...생성됨...");
		} else if (command.equals("detailView.do")) {
			controller = new DetailBookController();
			System.out.println("DetailBookController...생성됨...");
		} else if (command.equals("search.do")) {
			controller = new SearchController();
			System.out.println("SearchController...생성됨...");
		} else if (command.equals("logout.do")) {
			controller = new LogoutController();
			System.out.println("LogoutController...생성됨...");
		}
		
		return controller;
	}
}
