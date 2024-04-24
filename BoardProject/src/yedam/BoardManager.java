package yedam;
import java.util.*;
import java.util.regex.Pattern;


public class BoardManager {
	// fields
	static Stack<Integer> userCmd = new Stack<>();
	static MemberDAO memberManager = new MemberDAO();
	static BoardDAO boardManager = new BoardDAO();
	static CommentDAO replyManager = new CommentDAO();
	static BoardManager programManager = new BoardManager();

	// methods
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run = true;
		Scanner input = new Scanner(System.in);
		
		while(run) 
		{
			try 
			{
				System.out.println("1. 회원로그인 2.글작성 3.목록보기 4.댓글작성 5.종료");
				System.out.println("----------------------------------------");
				System.out.print("선택 >> ");
				if(userCmd.isEmpty()) {userCmd.push(Integer.parseInt(input.nextLine()));}
				else {userCmd.set(userCmd.size()-1, Integer.parseInt(input.nextLine()));}
				
			}
			catch(Exception e)  
			{
				System.out.println("입력오류!");
				if(userCmd.isEmpty()) {userCmd.push(6);}
				else {userCmd.set(userCmd.size()-1, 6);}
			}
			System.out.println("1단 메뉴 레벨 : "+ userCmd.size());
			switch(userCmd.lastElement()) 
			{
			// 로그인
			case 1:
				programManager.loadLoginMenu();
				break;
			
			// 글작성
			case 2:
				if(memberManager.isLogin()) 
				{boardManager.setBoardList(programManager.loadWriteBoardMenu());}
				else
				{System.out.println("글을 작성할 권한이 없습니다! 로그인을 해주세요!");}
				break;

			// 목록보기
			case 3:
				programManager.loadRetriveBoardsMenu();
				break;
				
			// 댓글작성
			case 4:
				if(memberManager.isLogin()) 
				{
					if(boardManager.retrieveboardList("").size()>0) 
					{programManager.loadReplyMenu();}
					else 
					{System.out.println("댓글을 작성할 게시물이 없습니다!");}
				}
				else
				{System.out.println("댓글을 작성할 권한이 없습니다! 로그인을 해주세요!");}
				
				break;
			// 종료
			case 5:
				run = false;
				break;
				
			default:
				System.out.println("입력오류! 1~5 사이의 값 입력.");
				break;
			} // end of switch
		} // end of while
		System.out.println("end of prog.");
	} // end of main
	
	// 로그인 메뉴 메소드
	 void loadLoginMenu() 
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
			}
			catch(Exception e)  
			{
				System.out.println("입력오류!");
				if(userCmd.size()==2) {userCmd.set(userCmd.size()-1, 6);}
				else {userCmd.push(6);}
			}
			System.out.println("2단 메뉴 레벨 : "+ userCmd.size());				
			switch(userCmd.lastElement()) 
			{
			// 로그인
			case 1:
				if(login()) 
				{
					System.out.println("로그인 성공");
					memberManager.setLogin(true);
				}
				else {System.out.println("로그인 실패! id/pw를 확인해주세요!");}
				break;
			// id/pw 찾기
			case 2:
				loadFindUserMenu();
				break;
			// 회원가입
			case 3:
				signUp();
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
	
	// 글작성 메뉴
		ArrayList<Board> loadWriteBoardMenu()
		{
			boolean run = true;
			List<Board> boardlist = new ArrayList<>();
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
					
				}
				catch(Exception e)  
				{
					System.out.println("입력오류!");
					if(userCmd.size()==2) {userCmd.set(userCmd.size()-1, 6);}
					else {userCmd.push(6);}
				}
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
					if(boardManager.insertBoard(memberManager.getId(), title, content)) 
					{System.out.println("작성완료!");}
					else {System.out.println("작성실패!");}
					break;
				
				// 게시물 수정
				case 2:
					if(boardManager.retrieveboardList("").size()>0) 
					{
						boardlist = boardManager.getOwnedboardList(memberManager.getId());
						if(boardlist.size()>0) 
						{	
							int postNo;
							while(true) 
							{								
								for(Board ele : boardlist) 
								{System.out.println(ele.getOwnedElement());}
								System.out.println("작성 건수 - "+boardlist.size());
								
								// 글번호 선택시 예외처리 필요.
								System.out.print("글 번호>>");
								try {
									postNo=Integer.parseInt(input.nextLine());
									loadUpdateBoardMenu(postNo);
									break;
									}
								catch(Exception e){}
							}
							
						}
						else{System.out.println("수정할 게시물이 없습니다!");}
					}
					break;

				// 이전메뉴
				case 3:
					int lastCmd = userCmd.firstElement();
					userCmd = new Stack<>();
					userCmd.push(lastCmd);
					run = false;
					break;

				default:
					System.out.println("입력오류! 1~3 사이의 값 입력.");
					break;
				} // end of switch
			} // end of while
			
			return boardManager.getBoardList();
		} // end of loadWriteBoardMenu
		
	 //1.로그인 
	boolean login() 
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
	} // end of login method

	// 2.아이디/비밀번호 찾기 
	void loadFindUserMenu() 
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
				
			}
			catch(Exception e)  
			{
				System.out.println("입력오류!");
				if(userCmd.size()==3) {userCmd.set(userCmd.size()-1, 6);}
				else {userCmd.push(6);}
			}
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
				System.out.println("입력오류! 1~3 사이의 값 입력.");
				break;
			}
			
		}// end of while
	} // end of findUser method
	
	
	// 3.회원가입
	void signUp() 
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

	// 글 수정 메소드
	 void loadUpdateBoardMenu(int post_no) {
		    boolean run = true;
			Scanner input = new Scanner(System.in);
			String title, content;
			List<Board> brList= boardManager.getOwnedboardList(memberManager.getId());
			while(run) 
			{
				brList= boardManager.getOwnedboardList(memberManager.getId());
				try 
				{
					System.out.println("1. 제목 수정2. 내용 수정 3.제목/내용 수정 4.이전메뉴");
					System.out.println("------------------------------------------");
					System.out.print("선택 >> ");
					if(userCmd.size()==3) // 메뉴레벨이 이미 현재 레벨인 경우 - 스택 교체
					{userCmd.set(userCmd.size()-1, Integer.parseInt(input.nextLine()));}
					else 
					{userCmd.push(Integer.parseInt(input.nextLine()));}
					
				}
				catch(Exception e)  
				{
					System.out.println("입력오류!");
					if(userCmd.size()==3) {userCmd.set(userCmd.size()-1, 6);}
					else {userCmd.push(6);}
				}
				System.out.println("3단 메뉴 레벨 : "+ userCmd.size());
				switch(userCmd.lastElement()) 
				{
					// 제목 수정
					case 1:
					///!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 
					// 예외처리 필요(제목, 내용 안적는 경우)
					// varchar2 는 컬럼의 제한 길이보다 큰 값이 들어오면 쿼리가 실행되지않음.(예외처리 해야함)
					// 현재 varchar2타입의 위 특성으로 인해 발생할수 있는 예외는 게시판, 댓글, 회원 전부 처리해줘야함
					// 게시판, 회원, 댓글(값 입력, 수정 등 값 조작하는 메소드 반드시 확인!!!!글자수 제한을 응용단에서 해주자!)
					System.out.print("제목 >>");
					title = input.nextLine();
					//System.out.println("for문 진입 전"+title); 
					for(Board brd : brList) 
					{
						
						if (post_no == brd.getPost_no()) 
						{
							System.out.println(brd);
							brd.setTitle(title);
							if (boardManager.updateBoard(brd,memberManager.getId(),1)) 
							{System.out.println("수정완료!");} 
//							else {
//								System.out.println("??");
//							}
						}
						
					}
					System.out.println("수정실패! 글번호 확인 필요");
					//updateBoard(memberManager.getId(),title);
					break;
				
				// 내용 수정
				case 2:
					// 예외처리 필요(제목, 내용 안적는 경우)
					// varchar2 는 컬럼의 제한 길이보다 큰 값이 들어오면 쿼리가 실행되지않음.(예외처리 해야함)
					System.out.print("내용 >>");
					content = input.nextLine();
					for(Board brd : brList) 
					{
						
						if (post_no == brd.getPost_no()) 
						{
							System.out.println(brd);
							brd.setContent(content);
							if (boardManager.updateBoard(brd,memberManager.getId(),2)) 
							{
								System.out.println("수정완료!");
								
							} 
//							else {
//								System.out.println("??");
//							}
						}
						
					}
					System.out.println("수정실패! 글번호 확인 필요");
					break;
				// 제목/내용 수정
				case 3:
					// 예외처리 필요(제목, 내용 안적는 경우)
					// varchar2 는 컬럼의 제한 길이보다 큰 값이 들어오면 쿼리가 실행되지않음.(예외처리 해야함)
					System.out.print("제목 >>");
					title = input.nextLine();
					System.out.print("내용 >>");
					content = input.nextLine();
					for(Board brd : brList) 
					{
						if (post_no == brd.getPost_no()) 
						{
							System.out.println(brd);
							brd.setTitle(title);
							brd.setContent(content);
							if (boardManager.updateBoard(brd,memberManager.getId(),3)) 
							{
								System.out.println("수정완료!");
								
							} 
//							else {
//								System.out.println("??");
//							}
						}
						
					}
					System.out.println("수정실패! 글번호 확인 필요");
					break;
				// 이전메뉴
				case 4:
					int [] lastCmd = new int[3];
					int i = 0;
					for(Integer ele : userCmd) {lastCmd[i]=ele;i++;}
					userCmd = new Stack<>();
					userCmd.push(lastCmd[0]);
					userCmd.push(lastCmd[1]);
					run = false;
					break;
				default:
					System.out.println("입력오류! 1~4 사이의 값 입력.");
					break;
				}
			} // end of while

	} // end of loadUpdateBoardMenu

	// 목록 보기
	void loadRetriveBoardsMenu()
	{
		boolean run = true;
		Scanner input = new Scanner(System.in);
		List<Board> boardlist;
	
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
			// 전체 목록
			case 1:
				boardlist = boardManager.retrieveboardList("");
				if(boardlist.size()>0) 
				{loadRetrieveContentMenu();}
				else{System.out.println("등록된 게시물이 없습니다!");}
				break;
			// 작성자로 검색
			case 2:
				System.out.print("작성자 id>>");
				String id = input.nextLine();
				boardlist = boardManager.retrieveboardList(id);
				if(boardlist.size()>0) 
				{
					for(Board brd : boardlist) 
					{
						System.out.println(brd);
					}
					
				}
				else{System.out.println("해당 작성자가 작성한 게시물이 없습니다!");}
//				 ----------------------------------------------
//				 1.전체 목록 2.작성자로 검색 3.메인메뉴
//				 선택>> 2
//				 작성자 id>> bbb
//				 // 해당 작성자가 작성한 게시글이 없을 시
//				 작성한 게시글이 없습니다.
//				 // 있을 시 
//				    작성자 : bbb
//				 	------------------------------------
//					1 - | 제목 | 내용 | 댓글 수 | 작성일자 |
//					2 - | 제목 | 내용 | 댓글 수 | 작성일자 |
//					...
//					10 - ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//					작성건수 - 10
//					------------------------------------

				break;
			// 메인메뉴
			case 3:
				int lastCmd = userCmd.firstElement();
				userCmd = new Stack<>();
				userCmd.push(lastCmd);
				run = false;
				break;
			// 기타
			default:
				System.out.println("입력오류! 1~3 사이의 값 입력.");
				break;
			}
			
		} // end of while
	} // end of loadRetriveBoardsMenu
	
	
	// 게시글 조회 메뉴 메소드
		private void loadRetrieveContentMenu() {
			Scanner input = new Scanner(System.in);
			boolean run = true;

			while(run) 
			{			
				List<Board> allBoards = boardManager.retrieveboardList("");
				try 
				{
					for(Board brd : allBoards) 
					{System.out.println(brd);}
					System.out.println("1.게시글 보기 2.이전메뉴");
					System.out.println("----------------");
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
				}
				catch(Exception e)  
				{
					System.out.println("입력오류!");
					if(userCmd.size()==3) {userCmd.set(userCmd.size()-1, 6);}
					else {userCmd.push(6);}
				}
				System.out.println("3단 메뉴 레벨 : "+ userCmd.size());				
				switch(userCmd.lastElement()) 
				{
				// 게시글 보기
				case 1:
					boolean isExistBoard = false;
					int indexBrd=0;
					System.out.print("조회할 게시글 번호>>");
					// 추후 예외처리 필요(숫자 아닌 값 처리)
					int brdNo = Integer.parseInt(input.nextLine());
					String id="";
					for(Board brd : allBoards)
					{
						id = brd.getMem_id();
						if(brdNo == brd.getPost_no()) {isExistBoard = true;indexBrd=brd.getPost_no();}
					}
					if(isExistBoard) 
					{
						// 게시글 조회 메소드 호출
						List<String> contentList = replyManager.retrieveContent(id, indexBrd);
						for(String str:contentList)
						{System.out.println(str);}				
					}
					else{System.out.println("존재하지 않는 게시물입니다!");}
					break;
				// 이전메뉴
				case 2:
					int [] lastCmd = new int[3];
					int i = 0;
					for(Integer ele : userCmd) {lastCmd[i]=ele;i++;}
					userCmd = new Stack<>();
					userCmd.push(lastCmd[0]);
					userCmd.push(lastCmd[1]);				
					run = false;
					break;
				// 기타
				default:
					System.out.println("입력오류! 1~2 사이의 값 입력.");
					break;
				} // end of reply menu
			}// end of while
		} // end of loadRetrieveContentMenu

	void loadReplyMenu() 
	{
		Scanner input = new Scanner(System.in);
		boolean run = true;
		
		while(run) 
		{			
			List<Board> allBoards = boardManager.retrieveboardList("");
			try 
			{
				for(Board brd : allBoards) 
				{System.out.println(brd);}
				System.out.println("1.댓글작성 2.이전메뉴");
				System.out.println("----------------");
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
			}
			catch(Exception e)  
			{
				System.out.println("입력오류!");
				if(userCmd.size()==2) {userCmd.set(userCmd.size()-1, 6);}
				else {userCmd.push(6);}
			}
			System.out.println("2단 메뉴 레벨 : "+ userCmd.size());				
			switch(userCmd.lastElement()) 
			{
			// 댓글작성
			case 1:
				boolean isExistBoard = false;
				int indexBrd=0;
				System.out.print("글번호 입력>>");
				// 추후 예외처리 필요(숫자 아닌 값 처리)
				int brdNo = Integer.parseInt(input.nextLine());
				for(Board brd : allBoards)
				{
					if(brdNo == brd.getPost_no()) {isExistBoard = true;indexBrd=brd.getPost_no();}
				}
				if(isExistBoard) 
				{
					System.out.print("댓글 입력 >>");
					String reply = input.nextLine();
					// 댓글 입력 메소드 호출
					replyManager.insertReply(memberManager.getId(), brdNo, reply);
				}
				else{System.out.println("존재하지 않는 게시물입니다!");}
				break;
			// 이전메뉴
			case 2:
				int lastCmd = userCmd.firstElement();
				userCmd = new Stack<>();
				userCmd.push(lastCmd);
				run = false;
				break;
			// 기타
			default:
				System.out.println("입력오류! 1~2 사이의 값 입력.");
				break;
			} // end of reply menu
		}// end of while
		
	}// end of loadReplyMenu	
}
