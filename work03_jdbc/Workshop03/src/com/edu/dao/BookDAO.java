package com.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.edu.exception.DMLException;
import com.edu.exception.DuplicateNumException;
import com.edu.exception.RecordNotFoundException;
import com.ssafy.Book;

import config.ServerInfo;

public class BookDAO {
	
	//싱글톤
	private static final BookDAO dao = new BookDAO();
	
	private BookDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);			
		} catch(ClassNotFoundException e) {
			System.out.println("1. 클래스 로딩 실패...");
		}
	}
	
	public static BookDAO getInstance() {
		return dao;
	}

	//===?
	private Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		
		return conn;
	}
	
	private void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}
	
	private void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		if(rs != null) rs.close();
		this.closeAll(conn, ps);
	}
	
	public void insertBook(Book book) throws DuplicateNumException, DMLException {	
		String query = "INSERT INTO book (isbn, title, author, publisher, price, description) VALUES(?, ?, ?, ?, ?, ?)";
		
		try(Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, book.getIsbn());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getPublisher());
			ps.setInt(5, book.getPrice());
			ps.setString(6, book.getDescription());
			
			ps.executeUpdate();
			System.out.println("[성공] 도서 저장 완료");		
		} catch(SQLIntegrityConstraintViolationException e) { //중복 오류
			throw new DuplicateNumException("[실패] 이미 저장된 도서입니다.. 다시 확인해 주세요.");
		} catch(SQLException e) {  //SQL문법 오류
			throw new DMLException("[실패] 도서 저장에 실패하였습니다.");
		} 
	}
	
	public List<Book> listBooks() throws RecordNotFoundException, DMLException {
		List<Book> list = new ArrayList<>();
		
		String query = "SELECT isbn, title, author, publisher, price, description FROM book";
		try(Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery();) {
			
			while(rs.next())
				list.add(new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs.getString("publisher"), rs.getInt("price"), rs.getString("description")));
			
			if(list.size() == 0) throw new RecordNotFoundException("검색 결과가 없습니다.");
			
			return list;
			
		} catch(SQLException e) {  //SQL문법 오류
			throw new DMLException("[실패] 도서 목록 조회에 실패하였습니다.");
		}
	}
	
	//책 isbn 으로 검색
	public Book findBookByIsbn(String isbn) throws DMLException, RecordNotFoundException {
		Book book = null;
		
		String query = "SELECT isbn, title, author, publisher, price, description FROM book WHERE isbn = ?";
		
		try(Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			
			ps.setString(1, isbn);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.isBeforeFirst()) throw new RecordNotFoundException("검색 결과가 존재하지 않습니다.");
			
			while(rs.next())
				book = new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs.getString("publisher"), rs.getInt("price"), rs.getString("description"));
			
			return book;
		} catch(SQLException e) {
			throw new DMLException("[실패] 도서 조회에 실패하였습니다.");
		}
	}
	
	private LocalDate now() {
		// TODO Auto-generated method stub
		return null;
	}

	//책 타이틀로 검색
	public List<Book> findBookByTitle(String title) throws RecordNotFoundException, DMLException {
		List<Book> list = new ArrayList<>();
		
		String query = "SELECT isbn, title, author, publisher, price, description FROM book WHERE title LIKE ?";
		
		try(Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			
			ps.setString(1, "%"+title+"%");
			
			ResultSet rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst()) throw new RecordNotFoundException("검색 결과가 존재하지 않습니다.");
			
			while(rs.next())
				list.add(new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs.getString("publisher"), rs.getInt("price"), rs.getString("description")));
			
			return list;
		} catch(SQLException e) {
			throw new DMLException("[실패] 도서 조회에 실패하였습니다.");
		}
	}
		
	//책 출판사별로 검색
	public List<Book> findBookByPublisher(String publisher) throws RecordNotFoundException, DMLException {
		List<Book> list = new ArrayList<>();
		
		String query = "SELECT isbn, title, author, publisher, price, description FROM book WHERE publisher LIKE ?";
		
		try(Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			
			ps.setString(1, "%"+publisher +"%");
			
			ResultSet rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst()) throw new RecordNotFoundException("검색 결과가 존재하지 않습니다.");
			
			while(rs.next())
				list.add(new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs.getString("publisher"), rs.getInt("price"), rs.getString("description")));
			
			return list;
		} catch(SQLException e) {
			throw new DMLException("[실패] 도서 조회에 실패하였습니다.");
		}
	}
	
	//작가로 검색
	public List<Book> findBookByAuthor(String author) throws RecordNotFoundException, DMLException {
		List<Book> list = new ArrayList<>();
		
		String query = "SELECT isbn, title, author, publisher, price, description FROM book WHERE author LIKE ?";
		
		try(Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			
			ps.setString(1, "%"+author +"%");
			
			ResultSet rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst()) throw new RecordNotFoundException("검색 결과가 존재하지 않습니다.");
			
			while(rs.next())
				list.add(new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs.getString("publisher"), rs.getInt("price"), rs.getString("description")));
			
			return list;
		} catch(SQLException e) {
			throw new DMLException("[실패] 도서 조회에 실패하였습니다.");
		}
	}
	
	//가격대로 검색(해당 가격보다 비싼 도서 검색)
	public List<Book> findBookByPrice(int price) throws RecordNotFoundException, DMLException {
		List<Book> list = new ArrayList<>();
		
		String query = "SELECT isbn, title, author, publisher, price, description FROM book WHERE price >= ?";
		
		try(Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setInt(1, price);
			
			ResultSet rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst()) throw new RecordNotFoundException("검색 결과가 존재하지 않습니다.");
			
			while(rs.next())
				list.add(new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs.getString("publisher"), rs.getInt("price"), rs.getString("description")));
			
			return list;
		} catch(SQLException e) {
			throw new DMLException("[실패] 도서 조회에 실패하였습니다.");
		}
	}
	
	//특정 출판사(자앤 출판사)가 도서가격 할인 이벤트 (25% 할인!)
	public List<Book> discountEvent() throws DMLException {
		List<Book> list = new ArrayList<>();
		
		String query = "SELECT isbn, title, author, publisher, round(price * ?) 할인가격, description FROM book";
		double discount = 1.25;
		
		try(Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setDouble(1, discount);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
				list.add(new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs.getString("publisher"), rs.getInt("할인가격"), rs.getString("description")));
			
			System.out.println("===== 7월 여름 이벤트!! 전 도서 25% 할인!! =====");
			return list;
		} catch(SQLException e) {
			throw new DMLException("[실패] 도서 조회에 실패하였습니다.");
		}
	}
		
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	public void updateBook(Book book) throws RecordNotFoundException, DMLException{
		String query = "UPDATE book SET price=?, description=? WHERE isbn=?";
		
		try(Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, book.getPrice());
			ps.setString(2, book.getDescription());
			ps.setString(3, book.getIsbn());
			
			int resultCnt = ps.executeUpdate();
			
			if(resultCnt == 0) throw new RecordNotFoundException("[실패] 수정할 도서가 존재하지 않습니다.");
			
			System.out.println("[성공] 도서 수정 완료");
			
		} catch(SQLException e) {  //SQL문법 오류
			throw new DMLException("[실패] 도서 수정에 실패하였습니다.");
		} 
	}
	
	public void deleteBook(String isbn) throws RecordNotFoundException, DMLException {
		String query = "DELETE FROM book WHERE isbn = ?";
		
		try(Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, isbn);
			
			int resultCnt = ps.executeUpdate();
			
			if(resultCnt == 0) throw new RecordNotFoundException("[실패] 삭제할 도서가 존재하지 않습니다.");
			
			System.out.println("[성공] 도서 삭제 완료");
			
		} catch(SQLException e) {  //SQL문법 오류
			throw new DMLException("[실패] 도서 삭제에 실패하였습니다.");
		} 
	}
	
	public int count() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int count = 0;
		//String query = "SELECT count(*) count FROM book"; 
		String query = "SELECT count(ISBN) count FROM book"; //더 효율적이다.
		
		conn = getConnection();
		ps = conn.prepareStatement(query);

		rs = ps.executeQuery();
		
		while(rs.next())
			count = rs.getInt("count");
		
		closeAll(conn, ps, rs);
		
		return count;
	}
}

















