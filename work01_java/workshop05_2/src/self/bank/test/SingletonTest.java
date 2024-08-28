package self.bank.test;

import self.bank.service.BankService;

public class SingletonTest {

	public static void main(String[] args) {
//		BankService s1 = new BankService();
		BankService s1 = BankService.getInstance();
		BankService s2 = BankService.getInstance();
		BankService s3 = BankService.getInstance();
		
		System.out.println(s1 + "\n" + s2 + "\n" + s3);
		System.out.println(s3.toString());
	}

}
