package self.bank;

public class Customer {
	
	private String name;
	private int ssn; //고객의 주민번호	
	
	private Address address;
	private Account account;
	
	//주소값 입력이 안되었을경우 기본값을 상수로 지정
	public static final String DEFAULT_NAME = "김한국";
	
	public Customer() {}
	
	public Customer(int ssn, Address address, Account account) {		
		this(DEFAULT_NAME, ssn, address, account);
	}
	
	public Customer(String name, int ssn, Address address, Account account) {		
		this.name = name;
		this.ssn = ssn;
		this.address = address;
		this.account = account;
	}
	
	public Customer(String name, int ssn, Address address) {		
		this(name, ssn, address, null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public String toString() {
		return "Customer [name=" + name + ", ssn=" + ssn + ", address=" + address + ", account=" + account + "]";
	}
	
}