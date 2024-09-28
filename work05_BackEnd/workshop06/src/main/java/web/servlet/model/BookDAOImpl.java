package web.servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BookDAOImpl implements BookDAO{

private DataSource ds;
	
	//싱글톤 
	private static BookDAOImpl dao = new BookDAOImpl();
	private BookDAOImpl() { 
		//Naming Service 작업을 진행...
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql"); 
			System.out.println("DataSource lookup...Success~~!!");
		} catch(NamingException e) {
			System.out.println("DataSource lookup...Fail~~!!");
		}
	}
	public static BookDAOImpl getInstance() { return dao; }

	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("디비 연결 성공...");
		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs != null) rs.close();
		closeAll(ps, conn);	
	}

	@Override
	public void registerBook(Book vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		String isbn = vo.getIsbn();
		String title = vo.getTitle();
		String catalogue = vo.getCatalogue();
		String nation = vo.getNation();
		String publish_date = vo.getPublish_date();
		String publisher = vo.getPublisher();
		String author = vo.getAuthor();
		int price = vo.getPrice();
		String currency = vo.getCurrency();
		String description = vo.getDescription();
		
		try {
			conn = getConnection();
			String query = "INSERT INTO book VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, isbn);
			ps.setString(2,  title);	
			ps.setString(3, catalogue);
			ps.setString(4, nation);
			ps.setString(5, publish_date);
			ps.setString(6, publisher);
			ps.setString(7, author);
			ps.setInt(8, price);
			ps.setString(9, currency);
			ps.setString(10, description);
			ps.executeUpdate();
			System.out.println(title + " 등록 완료!");
		} finally {
			closeAll(ps, conn);
		}
		
	}

	@Override
	public ArrayList<Book> showAllBook() throws SQLException {
		
		return null;
	}
}
