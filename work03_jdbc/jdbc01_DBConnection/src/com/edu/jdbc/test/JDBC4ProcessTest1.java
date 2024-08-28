package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 *  JDBC 기본 4단계 작업
 *  1. 서버정보를 담고 있는... 드라이버 로딩
 *  2. 디비서버 연결... Connection 반환
 *  3. PreparedStatement 객체 생성.
 *  4. SQL 쿼리문 실행
 */
public class JDBC4ProcessTest1 {
	
	public JDBC4ProcessTest1() {
		try {
			//1.
			Class.forName("com.mysql.cj.jdbc.Driver"); //FQCN..
			System.out.println("Driver Loading Success....");
			
			//2.
			String url = "jdbc:mysql://127.0.0.1:3306/kosta?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
			Connection conn = DriverManager.getConnection(url, "root", "1234");
			System.out.println("DBConnection....");
			
			//3.
			String query = "INSERT INTO custom (id, name, address) VALUES(?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement Creating....");
			
			//4. 1) ?에 값 바인딩   2) sql 실행.. 이때 디비에 데이터가 입력된다.
			ps.setInt(1, 111);
			ps.setString(2, "James");
			ps.setString(3, "NY");
			
			int row = ps.executeUpdate();
			System.out.println(row + " ROW Record UPDATE");
			
		} catch(ClassNotFoundException e) {
			System.out.println("Driver Loading Fail....");
		} catch(SQLException e) {
			System.out.println("DB Connection Fail....");
		}
	}

	public static void main(String[] args) {
		new JDBC4ProcessTest1();
	}

}






















