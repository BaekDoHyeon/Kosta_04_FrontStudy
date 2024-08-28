package com.edu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.dao.Employee;
import com.edu.exception.DuplicateNumException;

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
	//PK에 해당하는 사람이 있는지 여부, CUD 로직을 진행할 때 해당 데이터가 있는지 확인하기 위해 존재여부 메소드 생성
	private boolean isExist(int num, Connection conn) throws SQLException { 
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "SELECT num FROM employee WHERE num = ?";
		
		ps = conn.prepareStatement(query);
		ps.setInt(1, num);
		rs = ps.executeQuery();
		
		return rs.next();
	}
	
	public void insertEmployee(Employee emp) throws SQLException, DuplicateNumException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		//2. 커넥션 연결
		try {
			conn = getConnect();
			
			//isExist() 함수를 호출해서 사람이 없을때만 아래 코드가 실행되도록 로직을 제어한다.
			if (!isExist(emp.getNum(), conn)) {
				String query = "INSERT INTO employee (num, name, salary, address) VALUES(?, ?, ?, ?)";
				ps = conn.prepareStatement(query);
				
				//3. 바인딩
				ps.setInt(1, emp.getNum());
				ps.setString(2, emp.getName());
				ps.setDouble(3, emp.getSalary());
				ps.setString(4, emp.getAddress());
				
				//4. 쿼리 실행
				System.out.println(ps.executeUpdate() + " ROWS INSERT COMPLETE!!");
			} else throw new DuplicateNumException(emp.getName() + " 님은 이미 회원입니다.");
			
		} finally {
			//5. 자원 반환(반드시) 
			closeAll(ps, conn);
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