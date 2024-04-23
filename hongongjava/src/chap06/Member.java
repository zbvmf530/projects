package chap06;

public class Member {

	String name;
	String id;
	String password;
	int age;
	
	void printUserinfo() 
	{
		System.out.println("==================");
		System.out.println("회원 이름 : " + this.name);
		System.out.println("회원 id : " + this.id);
		System.out.println("회원 나이 : " + this.age);
		System.out.println("==================");
	}
	Member(){}
	Member(String uname, String uid)
	{
		this.name = uname;
		this.id = uid;
	}
}
