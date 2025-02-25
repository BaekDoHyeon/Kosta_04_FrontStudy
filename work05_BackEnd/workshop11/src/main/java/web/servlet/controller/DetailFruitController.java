package web.servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Item;
import web.servlet.model.ItemDao;

public class DetailFruitController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemNum = Integer.parseInt(request.getParameter("itemNum"));
		String path = "index.jsp";
		
		ItemDao.getInstance().updateRecordCount(itemNum);
		Item item = ItemDao.getInstance().getItem(itemNum);
		
		
		request.setAttribute("item", item);
		path = "detailFruit.jsp";
		
		return new ModelAndView(path);
	}
	 
}