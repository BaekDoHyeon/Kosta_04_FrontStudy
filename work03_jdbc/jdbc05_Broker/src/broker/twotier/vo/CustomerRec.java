package broker.twotier.vo;

import java.util.ArrayList;

/*
 * 고객에 대한 정보를 저장하는 vo 클래스
 * 1) 주식을 보유하고 있는 고객
 * 2) 주식을 보유하고 있지 않는 고객
 */
public class CustomerRec {
	private String ssn;
	private String name; //컬럼명은 cust_name
	private String address;
	////////// has a //////////
	private ArrayList<SharesRec> portfolio;
	
	public CustomerRec() {}
	
	public CustomerRec(String ssn, String name, String address) {
		this.ssn = ssn;
		this.name = name;
		this.address = address;
	}

	public CustomerRec(String ssn, String name, String address, ArrayList<SharesRec> portfolio) {
		this(ssn, name, address);
		this.portfolio = portfolio;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<SharesRec> getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(ArrayList<SharesRec> portfolio) {
		this.portfolio = portfolio;
	}

	@Override
	public String toString() {
		return "CustomerRec [ssn=" + ssn + ", name=" + name + ", address=" + address + ", portfolio=" + portfolio + "]";
	}
	
}
