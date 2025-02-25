package web.servlet.controller;

import web.servlet.model.ItemDao;

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
		if(command.equals("allFruit.do")) {
			controller = new AllFruitController();
		} else if (command.equals("detailFruit.do")) {
			controller = new DetailFruitController();
		}
		
		return controller;
	}
}
