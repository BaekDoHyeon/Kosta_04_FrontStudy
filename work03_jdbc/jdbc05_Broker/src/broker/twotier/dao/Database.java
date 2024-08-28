package broker.twotier.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import broker.twotier.exception.DuplicateSSNException;
import broker.twotier.exception.InvalidTransactionException;
import broker.twotier.exception.RecordNotFoundException;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;
import broker.twotier.vo.StockRec;
import config.ServerInfo;

public class Database implements DatabaseTemplate {
	
	private static final Database db = new Database("127.0.0.1");
	
	private Database(String serverId) {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공...");
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패...");
		}
	}
	
	public static Database getInstance() {
		return db;
	}

	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("디비 연결 성공...");
		return conn;
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

	//존재유무 확인하는 비즈니스 로직...
	private boolean isExist(String ssn, Connection conn) throws SQLException {
		String query = "SELECT ssn FROM customer WHERE ssn = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, ssn);
		
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}
	
	@Override
	public void addCustomer(CustomerRec cust) throws SQLException, DuplicateSSNException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			if(!isExist(cust.getSsn(), conn)) { //추가하려는 ssn이 존재하지 않는다면...
				String query = "INSERT INTO customer (ssn, cust_name, address) VALUES (?, ?, ?)";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, cust.getSsn());
				ps.setString(2, cust.getName());
				ps.setString(3, cust.getAddress());
				
				System.out.println("[성공] " + ps.executeUpdate() + " 명 INSERT OK~!!");
			} else {
				throw new DuplicateSSNException("[실패] 고객님은 이미 회원이십니다.");
			}
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void deleteCustomer(String ssn) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			if(isExist(ssn, conn)) { //추가하려는 ssn이 존재한다면...
				String query = "DELETE FROM customer WHERE ssn = ?";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, ssn);
								
				System.out.println("[성공] " + ps.executeUpdate() + " 명 DELETE OK~!!");
			} else {
				throw new RecordNotFoundException("[실패] 삭제하려는 고객이 존재하지 않습니다.");
			}
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void updateCustomer(CustomerRec cust) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			if(isExist(cust.getSsn(), conn)) { //추가하려는 ssn이 존재한다면...
				String query = "UPDATE customer SET cust_name=?, address=? WHERE ssn = ?";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, cust.getName());
				ps.setString(2, cust.getAddress());
				ps.setString(3, cust.getSsn());
				
				
				System.out.println("[성공] " + ps.executeUpdate() + " 명 UPDATE OK~!!");
			} else {
				throw new RecordNotFoundException("[실패] 수정하려는 고객이 존재하지 않습니다.");
			}
		} finally {
			closeAll(ps, conn);
		}
	}

	
	/////////////////////////////////////////////////////////////////////
	// ssn 의 번호를 가진 Customer 의 보유 주식을 가져오는 로직
	@Override
	public ArrayList<SharesRec> getPortfolio(String ssn) throws SQLException {
		ArrayList<SharesRec> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			
			String query = "SELECT symbol, quantity FROM shares WHERE ssn = ?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, ssn);
			
			rs = ps.executeQuery();
			
			while (rs.next())
				list.add(new SharesRec(ssn, rs.getString("symbol"), rs.getInt("quantity")));
			
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return list;
	}

	@Override
	public CustomerRec getCustomer(String ssn) throws SQLException {
		CustomerRec customer = null;	
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			
			String query = "SELECT ssn, cust_name, address FROM customer WHERE ssn = ?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, ssn);
			
			rs = ps.executeQuery();
			
			if(rs.next())
				customer = new CustomerRec(ssn, rs.getString("cust_name"), rs.getString("address"), getPortfolio(ssn));
			
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return customer;
	}

	@Override
	public ArrayList<CustomerRec> getAllCustomers() throws SQLException {
		ArrayList<CustomerRec> customers = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			
			String query = "SELECT ssn, cust_name, address FROM customer";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String ssn = rs.getString("ssn");
				customers.add(new CustomerRec(ssn, rs.getString("cust_name"), rs.getString("address"), getPortfolio(ssn)));
			}	
			
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return customers;
	}

	@Override
	public ArrayList<StockRec> getAllStocks() throws SQLException {
		ArrayList<StockRec> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			
			String query = "SELECT symbol, price FROM stock;";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while (rs.next())
				list.add(new StockRec(rs.getString("symbol"), rs.getInt("price")));
			
				
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return list;
	}
	///////////////////////////////////////////////////////////////////
	

	///////////////////////////// 이쁘게 ///////////////// ///////////////
	//이미 가지고 있는 주식이라면 쿼리문은 UPDATE, 가지고 있지 않은 주식이라면 INSERT -> 주식 구매 로직
	@Override
	public void buyShares(String ssn, String symbol, int quantity) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			//구매하려는 고객이 구매하려는 주식을 보유하고 있는지(true -> UPDATE), 보유하고 있지 않은지(false -> INSERT) 검증로직
			boolean IsHave = getPortfolio(ssn).stream().anyMatch(i -> i.getSymbol().equals(symbol));
			
			String query = (IsHave == true) ? "UPDATE shares SET quantity = quantity + ? WHERE ssn = ? AND symbol = ?" : 
												"INSERT INTO shares (quantity, ssn, symbol) VALUES (?, ?, ?)";
			
			ps = conn.prepareStatement(query);
			ps.setInt(1, quantity);
			ps.setString(2,  ssn);
			ps.setString(3, symbol);
			ps.executeUpdate();
		} finally {
			closeAll(ps, conn);
		}
		
	}

	@Override
	// 현재 가지고 있는 개수보다 적게 판다면 UPDATE, 전체 개수를 전부 판다면 DELETE, 더 많이 팔려하거나 존재하지 않는데 파려고 하면... 4가지 경우의 수...
	// 스트림(Stream)의 사용이 잦으면 온갖 라이브러리?를 끌어다 쓰기때문에 성능적으로 매우 불리할 수 있다.
	public void sellShares(String ssn, String symbol, int quantity) throws SQLException, InvalidTransactionException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		 
		try {
			conn = getConnect();
						
			ArrayList<SharesRec> list = getPortfolio(ssn);
			
			//판매하려는 고객이 판매하려는 주식을 보유하고 있는지(true), 보유하고 있지 않은지(false) 검증로직
			boolean IsHave = getPortfolio(ssn).stream().anyMatch(i -> i.getSymbol().equals(symbol));
			
			//보유하지 않는다면 RecordNotFoundException 예외 발생
			SharesRec sr = list.stream().filter(i -> i.getSymbol().equals(symbol)).findAny().orElseThrow(() -> new RecordNotFoundException());
			
			if(!IsHave) throw new RecordNotFoundException(); //보유하지 않는다면 RecordNotFoundException 예외 발생
			else {				
				int q = sr.getQuantity();
				int num = 1;
				
				if(q < quantity) throw new InvalidTransactionException();
				else if (q == quantity) {
					String query = "DELETE FROM shares WHERE ssn = ? AND symbol = ?";
					ps = conn.prepareStatement(query);		
				} else {
					String query = "UPDATE shares SET quantity = quantity - ? WHERE ssn = ? AND symbol = ?";
					ps = conn.prepareStatement(query);
					ps.setInt(num++, quantity);
				}
				
				ps.setString(num++,  ssn);
				ps.setString(num,  symbol);
				ps.executeUpdate();
			}			
		} finally {
			closeAll(ps, conn);
		}
	}
	
	/*
	public static void main(String[] args) throws Exception { //단위 테스트용
		Database db = Database.getInstance();
		db.addCustomer(new CustomerRec("111-111", "BAEK", "Seoul"));
		db.deleteCustomer("111-111");
		db.updateCustomer(new CustomerRec("111-112", "BAEK", "Incheon"));
		
		System.out.println("\n======== getPortfolio() ========");
		for (SharesRec s : db.getPortfolio("111-112"))
			System.out.println(s);
		
		System.out.println("\n======== getCustomer() ========");
		System.out.println(db.getCustomer("111-112"));
		
		System.out.println("\n======== getAllCustomers() ========");
		for (CustomerRec c : db.getAllCustomers())
			System.out.println(c);
		
		System.out.println("\n======== getAllStocks() ========");
		for (StockRec sr : db.getAllStocks()) 
			System.out.println(sr);
		
		System.out.println("\n======== buyShares() ========");
		db.buyShares("111-112", "DUKE", 20);
		db.buyShares("111-112", "DUKE", 50);
		db.buyShares("111-112", "JDK", 100);
		db.buyShares("111-113", "JDK", 30);
		for (CustomerRec c : db.getAllCustomers())
			System.out.println(c);
		
		
		System.out.println("\n======== sellShares() ========");
		db.sellShares("111-113", "JDK", 10);
		System.out.println(db.getCustomer("111-113"));
	}
	*/
}
