package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 *  JDBC 기본 4단계 작업
 *  1. 서버정보를 담고 있는... 드라이버 로딩  --> 생성자보다 더 일찍 실행되는 static Initialization Block...O
 *  2. 디비서버 연결... Connection 반환
 *  3. PreparedStatement 객체 생성.
 *  4. SQL 쿼리문 실행
 */
public class JDBC4ProcessTest2 {
	
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://127.0.0.1:3306/kosta?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	public static final String USER = "root";
	public static final String PASSWORD = "1234";
	
	public JDBC4ProcessTest2() {
		try {
		//2. 
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		System.out.println("2. 디비연결 성공...");
		
		//3-1. INSERT 
		/*
		String query = "INSERT INTO custom (id, name, address) VALUES(?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query); //미리 쿼리문이 컴파일만 먼저 수행된다....
		System.out.println("3. PreparedStatement 생성...");
		
		//4. 바인딩 및 쿼리문 실행
		ps.setInt(1, 444);
		ps.setString(2, "CHO");
		ps.setString(3, "경기도");
		
		System.out.println(ps.executeUpdate() + " ROW INSERT OK~~!!");
		*/
		
		
		//3-2. DELETE... id 값이 2인 사람을 삭제
		/*
		String query = "DELETE FROM custom WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		//4. 바인딩 및 쿼리문 실행
		ps.setInt(1, 222);
			
		System.out.println(ps.executeUpdate() + " ROW DELETE OK~~!!");
		*/
		
		
		//3-3 UPDATE... id 값이 4인 사람의 정보를 수정... name(오상욱), address(광주)	
		/*
		String query = "UPDATE custom SET name=?, address=? WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, "오상욱");
		ps.setString(2, "광주");
		ps.setInt(3, 444);
		
		System.out.println(ps.executeUpdate() + " ROW UPDATE OK~~!!");
		*/
		
		
		//3-4 SELECT
		String query = "SELECT id, name, address FROM custom";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		System.out.println("======================================");
		while (rs.next())
			System.out.println(rs.getInt("id") + ", " + rs.getString("name") + ", " + rs.getString(3)); //인자값으로 컬럼명을 줘도 되고, 숫자를 줘도 되지만 컬럼명 사용 권장.
		System.out.println("======================================");
		
		} catch(SQLException e) {
			System.out.println("DB Connection Fail....");
		}
	}

	public static void main(String[] args) {
		new JDBC4ProcessTest2();
	}
	
	static {
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("1. 드라이버 로딩 성공....");
		} catch(ClassNotFoundException e) {
			System.out.println("1. 드라이버 로딩 실패....");
		}
	}
}






















