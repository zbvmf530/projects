package yedam;

import java.util.*;
import java.util.regex.Pattern;

public class BoardManager {
	static Stack<Integer> userCmd = new Stack<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run = true;
		Scanner input = new Scanner(System.in);
		MemberDAO memberManager = new MemberDAO();
		BoardDAO boardManager = new BoardDAO();
		BoardManager programManager = new BoardManager();
		while(run) 
		{
			try 
			{
				System.out.println("1. 회원로그인 2.글작성 3.목록보기 4.댓글작성 5.종료");
				System.out.println("----------------------------------------");
				System.out.print("선택 >> ");
				if(userCmd.isEmpty()) {userCmd.push(Integer.parseInt(input.nextLine()));}
				else {userCmd.set(userCmd.size()-1, Integer.parseInt(input.nextLine()));}
				
			}catch(NoSuchElementException e) {}catch(NumberFormatException e) {System.out.println("입력오류!");}
			System.out.println("1단 메뉴 레벨 : "+ userCmd.size());
			switch(userCmd.lastElement()) 
			{
			// 로그인
			case 1:
				programManager.loadLoginMenu(memberManager);
				break;
			
			// 글작성
			case 2:
				if(memberManager.isLogin()) 
				{boardManager.setBoardList(programManager.loadWriteBoardMenu(boardManager.getBoardList()));}
				else
				{System.out.println("글을 작성할 권한이 없습니다! 로그인을 해주세요!");}
				break;

			// 목록보기
			case 3:
				programManager.loadRetriveBoardsMenu();
				break;
				
			// 댓글작성
			case 4:
				break;
			// 종료
			case 5:
				run = false;
				break;
				
			default:
				break;
			} // end of switch
		} // end of while
		System.out.println("end of prog.");
	} // end of main
	
	// 로그인 메뉴 메소드
	 void loadLoginMenu(MemberDAO memberManager) 
	{
		Scanner input = new Scanner(System.in);
		boolean run = true;
		while(run) 
		{			
			try 
			{
				System.out.println("1.로그인 2.아이디/비밀번호 찾기 3.회원가입 4.메인메뉴");
				System.out.println("---------------------------------------------------");
				System.out.print("선택 >> ");
				if(userCmd.size()==2) // 메뉴레벨이 이미 현재 레벨인 경우
				{
					// 스택 교체
					userCmd.set(userCmd.size()-1, Integer.parseInt(input.nextLine()));
				}
				else 
				{
					userCmd.push(Integer.parseInt(input.nextLine()));
				}
			}catch(NoSuchElementException e) {}catch(NumberFormatException e) {System.out.println("입력오류!");}
			System.out.println("2단 메뉴 레벨 : "+ userCmd.size());				
			switch(userCmd.lastElement()) 
			{
			// 로그인
			case 1:
				if(login(memberManager)) 
				{
					System.out.println("로그인 성공");
					memberManager.setLogin(true);
				}
				else {System.out.println("로그인 실패! id/pw를 확인해주세요!");}
				break;
			// id/pw 찾기
			case 2:
				loadFindUserMenu(memberManager);
				break;
			// 회원가입
			case 3:
				signUp(memberManager);
				break;
			// 메인메뉴
			case 4:
				int lastCmd = userCmd.firstElement();
				userCmd = new Stack<>();
				userCmd.push(lastCmd);
				run = false;
				break;
			// 기타
			default:
				System.out.println("입력오류! 1~4 사이의 값 입력.");
				break;
			} // end of Login menu
		}// end of while
	} // end of loginMenu
	
	 //1.로그인 
	boolean login(MemberDAO memberManager) 
	{

		Scanner input = new Scanner(System.in);
		String id,pw;
	
		System.out.print("id >> ");
		id = input.nextLine();
		System.out.print("pw >> ");
		pw = input.nextLine();
		
		if(memberManager.loginCheck(id,pw))
		{return true;}
		else {return false;}
		// id pw 확인(userDAO호출, 불리언타입 메소드)
		
		// 성공시 객체 필드(아이디,비밀번호)에 값 저장 및 return true;
		// 실패시 객체 필드(아이디,비밀번호)에 null 저장 및 return false;
		
	} // end of login method

	// 2.아이디/비밀번호 찾기 
	void loadFindUserMenu(MemberDAO memberManager) 
	{
		boolean run = true;
		Scanner input = new Scanner(System.in);
		String id,name,email;
		while(run) 
		{
			try 
			{
				System.out.println("1.id 찾기 2.비밀번호 찾기 3.이전");
				System.out.println("-----------------------------");
				System.out.print("선택 >> ");
				if(userCmd.size()==3) // 메뉴레벨이 이미 현재 레벨인 경우
				{
					// 스택 교체
					userCmd.set(userCmd.size()-1, Integer.parseInt(input.nextLine()));
				}
				else 
				{
					userCmd.push(Integer.parseInt(input.nextLine()));
				}
				
			}catch(NoSuchElementException e) {}catch(NumberFormatException e) {System.out.println("입력오류!");}
			System.out.println("3단 메뉴 레벨 : "+ userCmd.size());
			switch(userCmd.lastElement()) 
			{
			// id 찾기
			case 1:
				System.out.print("이름 >>");
				name = input.nextLine();
				System.out.print("이메일 >>");
				email = input.nextLine();
				String result = memberManager.findId(name, email);
				if(result.length()>0) 
				{System.out.println("회원님의 id는 "+result+ "입니다.");}
				else {System.out.println("존재하지 않는 회원입니다!");}
				break;
			// pw 찾기
			case 2:
				System.out.print("id >>");
				id = input.nextLine();
				String presult = memberManager.findPw(id);
				if(presult.length()>0) 
				{System.out.println("회원님의 비밀번호는 "+presult+ "입니다.");}
				else {System.out.println("비밀번호를 찾지 못했습니다! id를 다시 확인해주세요.");}
				System.out.println("pw찾기 메뉴");
				break;
			// 이전 메뉴
			case 3:
				int [] lastCmd = new int[3];
				int i = 0;
				for(Integer ele : userCmd) {lastCmd[i]=ele;i++;}
				userCmd = new Stack<>();
				userCmd.push(lastCmd[0]);
				userCmd.push(lastCmd[1]);				
				run = false;
				break;
			// 기타 입력오류	
			default:
				break;
			}
			
		}// end of while
	} // end of findUser method
	
	
	// 3.회원가입
	void signUp(MemberDAO memberManager) 
	{
		boolean run = true;
		Scanner input = new Scanner(System.in);
		String id,name,email,pw;
		//String regexID = "^[a-zA-Z]{1}[a-zA-Z0-9_]{0,14}$";
		// 시작은 영문으로만, '_'를 제외한 특수문자 안되며 영문, 숫자, '_'으로만 이루어진 1 ~ 15자 이하
		//String regexEmail = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
		boolean isExistId,isExistEmail;
		
		List<Member>memberList = memberManager.memList();
		while(run) 
		{
			isExistId = false;
			isExistEmail = false;
			// userDAO로부터 회원 조회
			// id 공백, null 체크			
			// id 중복이면 이미 존재 출력
			// email 공백, null 체크
			// email 중복이면 이미 존재 출력
			
			// id : 1~15자 사이의 영문으로시작(+특수문자)
			if(memberList.isEmpty()) 
			{
				System.out.print("id >>");
				id = input.nextLine();
				System.out.print("email >>");
				email = input.nextLine();
				System.out.print("name >>");
				name = input.nextLine();
				System.out.print("pw >>");
				pw = input.nextLine();
				Member mem = new Member();
				mem.setId(id);
				mem.setEmail(email);
				mem.setName(name);
				mem.setPw(pw);
				
				if(memberManager.insertMember(mem)) 
				{						
					System.out.println("회원가입 완료!");
					run = false;
				}
				else {System.out.println("회원가입 실패!");}
			}
			else 
			{
				System.out.print("id >>");
				id = input.nextLine();
				for(Member mem : memberList) 
				{
					if(id.equals(mem.getId()))
					{isExistId=true;}
				}
				if(isExistId==false) 
				{				
					System.out.print("email >>");
					email = input.nextLine();
					for(Member mem : memberList) 
					{
						if(email.equals(mem.getEmail()))
						{isExistEmail=true;}
					}
					if(isExistEmail==false) 
					{					
						System.out.print("name >>");
						name = input.nextLine();
						System.out.print("pw >>");
						pw = input.nextLine();
						Member mem = new Member();
						mem.setId(id);
						mem.setEmail(email);
						mem.setName(name);
						mem.setPw(pw);
						
						if(memberManager.insertMember(mem)) 
						{						
							System.out.println("회원가입 완료!");
							run = false;
						}
						else {System.out.println("회원가입 실패!");}
						// DAO insert method 호출 및 회원가입 완료 출력 및 
					}
					else {System.out.println("이미 등록된 이메일 입니다!");}
				}
				else 
				{System.out.println("이미 등록된 ID 입니다!");}
				
			}
			
//			if(Pattern.matches(regexID, id))
//			{				
//				System.out.print("email >>");
//				email = input.nextLine();
//				if(Pattern.matches(regexEmail, email)) 
//				{
//					System.out.print("pw >>");
//					name = input.nextLine();
//				}
//				
//			}
			
		} //end of while
	}//end of signUp
	
	
	// 글작성 메뉴
	ArrayList<Board> loadWriteBoardMenu(ArrayList<Board> boardList)
	{
		boolean run = true;
		Scanner input = new Scanner(System.in);
		while(run) 
		{
			try 
			{
				System.out.println("1.새 게시물 2.게시물 수정 3.이전메뉴");
				System.out.println("----------------------------");
				System.out.print("선택 >> ");
				if(userCmd.size()==2) // 메뉴레벨이 이미 현재 레벨인 경우 - 스택 교체
				{userCmd.set(userCmd.size()-1, Integer.parseInt(input.nextLine()));}
				else 
				{userCmd.push(Integer.parseInt(input.nextLine()));}
				
			}catch(NoSuchElementException e) {}catch(NumberFormatException e) {System.out.println("입력오류!");}
			System.out.println("2단 메뉴 레벨 : "+ userCmd.size());
			switch(userCmd.lastElement()) 
			{
			// 새 게시물
			case 1:
				// 예외처리 필요(제목, 내용 안적는 경우)
				String title, content;
				System.out.print("제목 >>");
				title = input.nextLine();
				System.out.print("내용 >>");
				content = input.nextLine();
//				boardManager.insertBoard(title,content);
//				작성 완료!
				break;
			
			// 게시물 수정
			case 2:
				System.out.println(boardList.size());
				if(boardList.size()>0) 
				{
					
				}
//				// 게시글이 있을때만 수정가능
//				수정할 게시물이 없습니다!
//				-------------------
//				1 - | 제목 | 내용 |
//				2 - | 제목 | 내용 |
//				...
//				10 - ~~~~~~~~~~~~~
//				작성건수 - 10
//				-------------------
//				글 선택>> 1
//				----------------------------------------------
//				1. 제목 수정2. 내용 수정 3.제목/내용 수정 4.이전메뉴
//				----------------------------------------------
//				선택 >> 1
//				제목>> ㅇㅇㅇㅇ
//				수정완료
//				----------------------------------------------
//				1. 제목 수정2. 내용 수정 3.제목/내용 수정 4.이전메뉴
//				----------------------------------------------
//				선택 >> 1
//				제목>> ㅇㅇㅇㅇ
//				수정완료
//				
//				----------------------------------------------
//				1. 제목 수정2. 내용 수정 3.제목/내용 수정 4.이전메뉴
//				----------------------------------------------	
//				선택 >> 2
//				글번호 >> 1
//				내용 >> ㅓㅓㅓㅓ
//				수정완료
//				
//				----------------------------------------------
//				1. 제목 수정2. 내용 수정 3.제목/내용 수정 4.이전메뉴
//				----------------------------------------------
//				선택 >> 3
//				제목>> ㅇㅇㅇㅇ
//				내용 >> ㅓㅓㅓㅓ
//				수정완료
				break;

			// 이전메뉴
			case 3:
				int lastCmd = userCmd.firstElement();
				userCmd = new Stack<>();
				userCmd.push(lastCmd);
				run = false;
				break;

			default:
				break;
			} // end of switch
		} // end of while
		
		return boardList;
	} // end of loadWriteBoardMenu
	

		
	 // 입력 완료시 테이블 갱신 (작성자, 글 제목)
	
	
	
	
	// 목록 보기
	void loadRetriveBoardsMenu()
	{
		boolean run = true;
		Scanner input = new Scanner(System.in);
		while(run) 
		{
			try 
			{
				System.out.println("1.전체 목록 2.작성자로 검색 3.메인메뉴");
				System.out.println("----------------------------");
				System.out.print("선택 >> ");
				if(userCmd.size()==2) // 메뉴레벨이 이미 현재 레벨인 경우 - 스택 교체
				{userCmd.set(userCmd.size()-1, Integer.parseInt(input.nextLine()));}
				else 
				{userCmd.push(Integer.parseInt(input.nextLine()));}
				
			}catch(NoSuchElementException e) {}catch(NumberFormatException e) {System.out.println("입력오류!");}
			System.out.println("2단 메뉴 레벨 : "+ userCmd.size());
			switch(userCmd.lastElement()) 
			{
			// 새 게시물
			case 1:
//				제목 >>1111
//				내용 >>~~~~~
//				작성 완료!
				break;
			}
			
		} // end of while
	} // end of loadRetriveBoardsMenu
//	----------------------------------------------
//	 1.전체 목록 2.작성자로 검색 3.메인메뉴
//	 선택>> 1
//		-----------------------------------
//		1 - | 제목 | 내용 | 작성자 | 댓글 수 | 작성일자 |
//		2 - | 제목 | 내용 | 작성자 | 댓글 수 | 작성일자 |
//		...
//		50 - ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//		-----------------------------------
//	  1.게시글 보기 2.이전메뉴
//	  선택>>1
//	  게시글 번호>> 1
//	  -----------------------
//	  제목
//	  -----------------------
//	  내용
//	  ~~~~~~~~~~~~~~~~~~~~~
//	  ~~~~~~~~~~~~~~~~~~~~
//	  -----------------------
//	  댓글
//	  -----------------------
//	  test
//	  -----------------------
//	  test2
//	  -----------------------  
//	 ----------------------------------------------
//	 1.전체 목록 2.작성자로 검색 3.메인메뉴
//	 선택>> 2
//	 작성자 id>> bbb
//	 // 해당 작성자가 작성한 게시글이 없을 시
//	 작성한 게시글이 없습니다.
//	 // 있을 시 
//	    작성자 : bbb
//	 	------------------------------------
//		1 - | 제목 | 내용 | 댓글 수 | 작성일자 |
//		2 - | 제목 | 내용 | 댓글 수 | 작성일자 |
//		...
//		10 - ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//		작성건수 - 10
//		------------------------------------
//	  ----------------------------------------------
//	 1.전체 목록 2.작성자로 검색 3.메인메뉴
//	 선택>> 3
//	 --------------------------------------------
//	1. 회원로그인 2.글작성 3.목록보기 4.댓글작성 5.종료
}
