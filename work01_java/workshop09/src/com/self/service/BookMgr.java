package com.self.service;

import java.util.ArrayList;

import com.self.vo.Book;
import com.self.vo.Magazine;

public interface BookMgr {

	public void addBook(Book b);
	
	public ArrayList<Book> getAllBook();
	
	public Book searchBookByIsbn(String isbn);
	
	public ArrayList<Book> searchBookByTitle(String title);
	
	public ArrayList<Book> onlySearchBook();
	
	public ArrayList<Book> onlySearchMagazin();
	
	public ArrayList<Magazine> magazineOfThisYearInfo(int year);
	
	public ArrayList<Book> searchBookByPublish(String publish);
	
	public ArrayList<Book> searchBookByPrice(int price);
	
	public int getTotalPrice();
	
	public int getAvgPrice();
	
}
