package com.edu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.edu.dao.Employee;

import config.ServerInfo;

public class EmployeeDAO {
	
	public EmployeeDAO() throws ClassNotFoundException {
		//1. 드라이버 로딩
		Class.forName(ServerInfo.DRIVER_NAME);
	}
	
	
	//////////////////////////// 공통적인 로직 ////////////////////////////
	public Connection getConnect() throws SQLException {
		//2. 커넥션 연결
		System.out.println("db 연결 성공...");
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		return conn;
	}
	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}
	
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs != null) rs.close();
		closeAll(ps, conn);
	}
	
	
	//////////////////////////// 비즈니스 로직 //////////////////////////// 	
	//isExist() 사용안하는 경우...(쿼리문 2번 동작할 이유가 없다. (select 가 안돌아간다.))
	public void insertEmployee(Employee emp) {
		String query = "INSERT INTO employee (num, name, salary, address) VALUES(?, ?, ?, ?)";
		
		//2. 커넥션 연결
		try(Connection conn = getConnect(); PreparedStatement ps = conn.prepareStatement(query);) {

			//3. 바인딩
			ps.setInt(1, emp.getNum());
			ps.setString(2, emp.getName());
			ps.setDouble(3, emp.getSalary());
			ps.setString(4, emp.getAddress());
			
			//4. 쿼리 실행
			System.out.println(ps.executeUpdate() + " ROWS INSERT COMPLETE!!");
			
		} catch(SQLIntegrityConstraintViolationException e) { //중복 오류
			System.out.println(e.getMessage());
		} catch(SQLException e) {  //SQL문법 오류
			System.out.println(e);
		} 
	}
	
	public void removeEmployee(Employee emp) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		//2. 커넥션 연결
		conn = getConnect();
		
		String query = "DELETE FROM employee WHERE num = ?";
		ps = conn.prepareStatement(query);
		
		//3. 바인딩
		ps.setInt(1, emp.getNum());
		
		//4. 쿼리 실행
		System.out.println(ps.executeUpdate() + " ROWS DELETE COMPLETE!!");
		
		//5. 자원 반환
		closeAll(ps, conn);
	}
	
	public void updateEmployee(Employee emp) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		//2. 커넥션 연결
		conn = getConnect();
		
		String query = "UPDATE employee SET name=?, salary=?, address=? WHERE num = ?";
		ps = conn.prepareStatement(query);
		
		//3. 바인딩
		ps.setString(1, emp.getName());
		ps.setDouble(2, emp.getSalary());
		ps.setString(3, emp.getAddress());
		ps.setInt(4, emp.getNum());
		
		//4. 쿼리 실행
		System.out.println(ps.executeUpdate() + " ROWS UPDATE COMPLETE!!");
		
		//5. 자원 반환
		closeAll(ps, conn);
	}
	
	public Employee selectEmployee(int num) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee dao = null;
		
		//2. 커넥션 연결
		conn = getConnect();
		
		String query = "SELECT num, name, salary, address FROM employee WHERE num = ?";
		ps = conn.prepareStatement(query);
		
		//3. 바인딩
		ps.setInt(1, num);
		
		//4. 쿼리 실행
		rs = ps.executeQuery();
		while (rs.next()) 
			dao = new Employee(num, rs.getString("name"), rs.getDouble("salary"), rs.getString("address"));
		
		//5. 자원 반환
		closeAll(rs, ps, conn);
		
		return dao;
	}
	
	public List<Employee> selectEmployee() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Employee> list = new ArrayList<>();
		
		//2. 커넥션 연결
		conn = getConnect();
		
		String query = "SELECT num, name, salary, address FROM employee";
		ps = conn.prepareStatement(query);
		
		//4. 쿼리 실행
		rs = ps.executeQuery();
		while (rs.next()) 
			list.add(new Employee(rs.getInt("num"), rs.getString("name"), rs.getDouble("salary"), rs.getString("address")));
		
		//5. 자원 반환
		closeAll(rs, ps, conn);
		
		return list;
	}	
}