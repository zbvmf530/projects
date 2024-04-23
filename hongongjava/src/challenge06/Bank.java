package challenge06;

import java.util.Scanner;

public class Bank {

	int asset;
	String password;
	BankUser userNow;
	boolean login;
	BankUser[] userList = { 
			new BankUser("김진형", 0001, "jh01"), 
			new BankUser("권준오", 0002, "jo01"),
			new BankUser("김도겸", 0003, "dk01"), 
			new BankUser("정수범", 0004, "sb01"), 
			new BankUser("배동규", 0005, "dg01"),
			new BankUser("맹선우", 0006, "su01"), 
			new BankUser("김다은", 0007, "du01"), 
			new BankUser("김철규", 0010, "ck01"),
			new BankUser("박성준", 0011, "sj01"), 
			new BankUser("이정한", 0012, "jh01") 
			};

	boolean isLogedin() {
		return this.login;
	}

	BankUser getUserinfo() 
	{
		if (this.login) 
		{
			return this.userNow;
		} else
			{return null;}
	}
	// 입금 , 로그인 안됐으면 로그인 호출, 되어있으면 입금 실행
	void deposit(int money) {
		if (this.isLogedin()) 
		{
			System.out.println(money + "원이 입금 되었습니다.");
			this.getUserinfo().setBalance(this.getUserinfo().getBalance() + money);
		} 
		else {this.Login();}
	}

	void withdraw(int money) {
		if (this.isLogedin()) {
			if (this.getUserinfo().getBalance() < money) 
			{
				System.out.println("잔액부족!");
			} 
			else 
			{
				System.out.println(money + "원이 출금 되었습니다.");
				this.getUserinfo().setBalance(this.getUserinfo().getBalance() - money);
			}
		} else {this.Login();}
	}

	public String toString() {
		if (this.isLogedin()) {
			return ("잔액 : " + this.getUserinfo().getBalance());
		} else {
			this.Login();
			return "";
		}
	}

	void Login() {
		Scanner input = new Scanner(System.in);
		System.out.print("계좌 비밀번호 입력 : ");
		String pwd = input.nextLine();
		for (int i = 0; i < 10; i++) 
		{
			if (pwd.equals(this.userList[i].password)) 
			{
				this.userNow = userList[i];
				this.login = true;
			}
		}

		if (this.isLogedin()) 
		{
			System.out.println(this.getUserinfo().getOwner()+"님 환영합니다.");
		} 
		else 
		{
			System.out.println("로그인 실패! 다시 입력해주세요.");
		}
		input.close();
	}
	void Logout() 
	{
		if(this.isLogedin())
		{
			System.out.println("좋은하루 되세요 "+this.getUserinfo().getOwner()+"님");
			
		}
		
	}

}
