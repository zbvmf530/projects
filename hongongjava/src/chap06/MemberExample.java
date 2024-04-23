package chap06;

import java.util.Scanner;

public class MemberExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Member member = new Member();
//		member.name = "최하얀";
//		member.age = 23;
//		member.printUserinfo();
//		
//		
//		member = new Member("홍길동","hong");
//		member.printUserinfo();
		
//		
//		Board board1 = new Board("리버보이","소설");
//		Board board2 = new Board("파묘","영화","장재현");
//		Board board3 = new Board("배틀그라운드","게임","블루홀","2017-03-17");
//		Board board4 = new Board("유튜브","앱","구글","2005-02-14",3);
//		
//		
//		board1.getBoardinfo();
//		board2.getBoardinfo();
//		board3.getBoardinfo();
//		board4.getBoardinfo();
		
		MemberService member = new MemberService();
		Scanner loginForm = new Scanner(System.in);
		
		
		
		System.out.print("id : ");
		String id = loginForm.nextLine();
		System.out.print("password : ");
		String password = loginForm.nextLine();
		if(member.login(id,password)) 
		{System.out.println("로그인 성공!");}
		else {System.out.println("로그인 실패! 아이디와 비밀번호를 확인해주세요.");}
		loginForm.close();
		
		
	}

}
