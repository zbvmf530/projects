package chap06;

public class MemberService {

	String id  = "hong";
	String password  = "12345";
	
	boolean login(String id, String password) 
	{
		 boolean result = false;
		 result = id.equals(this.id)?(password.equals(this.password)?true:false):false;
		return result;
	}
	
	void logout(String id) 
	{
		System.out.println("로그아웃 되었습니다.");
	}
}
