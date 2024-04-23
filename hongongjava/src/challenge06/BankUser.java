package challenge06;

public class BankUser {

	String name;
	int AccountNo;
	String password;
	int balance;
	BankUser(){}
	BankUser(String uName, int account, String pwd)
	{
		this.name = uName;
		this.AccountNo = account;
		this.password = pwd;
	}
	int getBalance() {return this.balance;}
	void setBalance(int money) {this.balance = money;}
	String getOwner() {return this.name;}
}
