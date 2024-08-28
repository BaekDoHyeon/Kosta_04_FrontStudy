package com.edu.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.edu.vo.Custom;

public class SimpleJDBCTest {
	
	static String driver;
	static String url;
	static String user;
	static String pass;
	static String addQuery;
	static String selectQuery;
	static String selectAQuery;
	
	public SimpleJDBCTest() throws Exception {
		//드라이버 로딩.
		Class.forName(driver);
		System.out.println("드라이버 로딩 성공~");
	}
	
	//고정적으로 각 메소드마다 반복되는 로직을 공통로직으로 정의...
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, pass);
		System.out.println("디비 연결 성공...");
		return conn;
	}
	
	//열린 순서 반대로 닫아준다.
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if (ps != null) ps.close();
		if(conn != null) conn.close();
	}
	
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{
		if(rs != null) rs.close();
		closeAll(ps, conn);
	}
	
	public void addCustom(Custom c) throws Exception { // '비즈니스 로직'이라고 한다.
		//insert into...
		Connection conn = null;
		PreparedStatement ps = null;
		
		//1. 디비 연결
		conn =  getConnect();
		
		//2. PreparedStatement 생성
		ps = conn.prepareStatement(addQuery);
		
		//3. 바인딩
		ps.setInt(1, c.getId());
		ps.setString(2, c.getName());
		ps.setString(3, c.getAddress());
		
		//4. 쿼리문 실행
		System.out.println(ps.executeUpdate() + " ROW INSERT 성공");
		
		//5. 자원반환
		closeAll(ps, conn);
		
	}
	
	public Custom getCustom(int id) throws Exception {  // '비즈니스 로직'이라고 한다.
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Custom c = null;
		
		//select where
		//1. 디비 연결
		conn = getConnect();;
		
		//2. PreparedStatement 생성
		ps = conn.prepareStatement(selectQuery);
		
		//3.바인딩
		ps.setInt(1, id);
		
		//4. 쿼리문 실행
		rs = ps.executeQuery();	
		while (rs.next())
			c = new Custom(id, rs.getString("name"), rs.getString("address"));
		
		//5. 자원반환
		closeAll(rs, ps, conn);
		
		return c;
	}
	
public List<Custom> getCustom() throws Exception {  // '비즈니스 로직'이라고 한다.
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Custom> list = new ArrayList<Custom>();
		
		//select where
		//1. 디비 연결
		conn = getConnect();
		
		//2. PreparedStatement 생성
		ps = conn.prepareStatement(selectAQuery);
		
		//3.바인딩 X
		
		//4. 쿼리문 실행
		rs = ps.executeQuery();	
		while (rs.next())
			list.add(new Custom(rs.getInt("id"), rs.getString("name"), rs.getString("address")));
		
		//5. 자원반환
		closeAll(rs, ps, conn);
		
		return list;
	}

	public static void main(String[] args) throws Exception {	
		SimpleJDBCTest dao = new SimpleJDBCTest();
		dao.addCustom(new Custom(555, "Blake", "LA"));
		Custom c = dao.getCustom(111);
		System.out.println(c.toString());
		
		System.out.println("\n=========================");
		for (Custom custom : dao.getCustom())
			System.out.println(custom.toString());
		System.out.println("=========================");
	}
	
	static {
		try {
			Properties p = new Properties();
			p.load(new FileInputStream("src/config/db.properties"));
			p.load(new FileInputStream("src/sql/sql.properties"));
			System.out.println(p.values());
			
			driver = p.getProperty("jdbc.mysql.driver");
			url = p.getProperty("jdbc.mysql.url");
			user = p.getProperty("jdbc.mysql.user");
			pass = p.getProperty("jdbc.mysql.pass");
			
			addQuery = p.getProperty("jdbc.sql.addCustom");
			selectQuery = p.getProperty("jdbc.sql.selectCustom");
			selectAQuery = p.getProperty("jdbc.sql.selectAll");
			
		} catch (Exception e) {
			System.out.println("드라이브 로딩 실패~");
		}
	}
}













