package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

/*
 * 서버주소
 * 계정명
 * 계정 비번
 * ... 이런 값들은 프로그램 코드에 노출되면 안되는 값들이다.
 * 프로그램에 이런 실제값이 들어가는 것 == 하드코딩
 * 
 * 서버의 파편적인 정보를 외부에 모듈화(메타데이터화) 시켜야 한다.
 */
public class JDBC4ProcessTest3 {
	
	public JDBC4ProcessTest3() {
		try {
		//2. 서버의 데이터를 '메타데이터화' 시켰다. -> '인터페이스.정보' 
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
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
		new JDBC4ProcessTest3();
	}
	
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("1. 드라이버 로딩 성공....");
		} catch(ClassNotFoundException e) {
			System.out.println("1. 드라이버 로딩 실패....");
		}
	}
}






















