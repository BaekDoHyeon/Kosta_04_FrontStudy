package web.servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface BookDAO {
	public Connection getConnection() throws SQLException;
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	
	void registerBook(Book vo) throws SQLException;
	ArrayList<Book> showAllBook() throws SQLException;
	ArrayList<Book> searchBookByTitle(String title) throws SQLException;
	ArrayList<Book> searchBookByCatalogue(String catalogue) throws SQLException;
	
	Book detailSearchByTitle(String title) throws SQLException;
}
