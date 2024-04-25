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
					// 글제목 : 공백 포함 30자
					// 글내용 : 공백 포함 150자씩
					String title, content;
					System.out.println("제목 : 30자이하(공백포함)");
					System.out.print("제목 >>");
					title = input.nextLine();
					if(Pattern.matches("^(?=.{1,30}$).*", title)) 
					{
						System.out.println("내용 : 150자이하(공백포함)");
						System.out.print("내용 >>");
						content = input.nextLine();
						if(Pattern.matches("^(?=.{1,150}$).*", content)) 
						{
							if(boardManager.insertBoard(memberManager.getId(), title, content)) 
							{System.out.println("작성완료!");}
							else {System.out.println("작성실패!");}
						}
						else {System.out.println("입력 실패! 0 ~ 150자 사이의 내용을 입력해주세요!");}
					}
					else {System.out.println("입력 실패! 0 ~ 30자 사이의 내용을 입력해주세요!");}
					break;
				
				// 게시물 수정
				case 2:
					///!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 
					
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
								
								// loadUpdateBoardMenu 함수 내부 처리루틴에 예외처리 완료
								System.out.print("글 번호>>");
								try {
									postNo=Integer.parseInt(input.nextLine());
									loadUpdateBoardMenu(postNo);
									break;
									}
								catch(Exception e){System.out.println("입력오류! 유효한 값이 아닙니다.");}
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
		boolean isExistId,isExistEmail;
		
		List<Member>memberList = memberManager.memList();
		while(run) 
		{
			isExistId = false;
			isExistEmail = false;
			
			// 등록된 회원이 하나도 없을경우 입력형식 예외 처리만 해주면 됨
			if(memberList.isEmpty()) 
			{
				System.out.println("id : 4~15자 사이의 영문/숫자 조합 ex)abc123");
				System.out.print("id >>");
				id = input.nextLine();
				//^[A-Za-z0-9]{6,12}$
				
				// id : 4~15자 사이의 영문으로시작(특수문자,공백 허용안함)
				if (Pattern.matches("^[A-Za-z0-9]{4,15}$",id))
				{
					System.out.println("email : 영문/숫자@영문/숫자.도메인 ex)abc123@gmail.com");
					System.out.print("email >>");
					email = input.nextLine();
					if(Pattern.matches("^[_a-zA-Z0-9-\\.]+@[_a-zA-Z0-9-\\.]+\\.[_a-zA-Z0-9-\\.]+$$", email)) 
					{
						System.out.println("name : 2~15자 사이의 공백없는 영문 or 한글 ex)John");
						System.out.print("name >>");
						name = input.nextLine();
						// 이름 : 글자수, 공백유무만 제한
						if(Pattern.matches("^[A-Z|a-z|가-힣]{2,15}$",name)) 
						{
							System.out.print("pw >>");
							pw = input.nextLine();
							// 비밀번호 : 4~15자 사이의 영문 or 숫자 ,공백 입력 제한(첫,중간,끝 전부 처리)
							// 단 pw는 첫글자가 숫자든 영어든 상관없음
							// 모든 입력조건을 충족시 회원 등록
							System.out.println("pw : 4~15자 사이의 공백없는 영문 or 숫자 ex)1234(o)");
							if(Pattern.matches("^[A-Z|a-z|0-9]{4,15}$",pw)) 
							{
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
							else {System.out.println("유효한 비밀번호가 아닙니다!");}
						}
						else {System.out.println("유효한 이름이 아닙니다!");}
					}
					else {System.out.println("유효한 메일주소가 아닙니다!");}
				}
				// id 입력규칙에 맞지 않으면 입력 오류
				else {System.out.println("유효한 아이디가 아닙니다!");}				
			}
			
			// 등록된 회원이 있으면 -> 입력형식 및 중복 체크도 필요
			else 
			{
				System.out.println("id : 4~15자 사이의 영문/숫자 조합 ex)abc123");
				System.out.print("id >>");
				id = input.nextLine();
				if (Pattern.matches("^[A-Za-z0-9]{4,15}$",id))
				{
					// id 입력 규칙에 맞으면 중복체크
					for(Member mem : memberList) 
					{
						if(id.equals(mem.getId()))
						{isExistId=true;}
					}
					if(isExistId==false) 
					{
						// 중복되지 않는 id면 다음 입력
						System.out.println("email : 영문/숫자@영문/숫자.도메인 ex)abc123@gmail.com");
						System.out.print("email >>");
						email = input.nextLine();
						// email 입력규칙 확인
						if(Pattern.matches("^[_a-zA-Z0-9-\\.]+@[_a-zA-Z0-9-\\.]+\\.[_a-zA-Z0-9-\\.]+$$", email)) 
						{
							// email 중복체크
							for(Member mem : memberList) 
							{
								if(email.equals(mem.getEmail()))
								{isExistEmail=true;}
							}
							// 중복된 이메일이 아니면 다음입력
							if(isExistEmail==false) 
							{
								System.out.println("name : 2~15자 사이의 공백없는 영문 or 한글 ex)John");
								System.out.print("name >>");
								name = input.nextLine();
								// 이름 : 글자수, 공백유무만 제한
								if(Pattern.matches("^[A-Z|a-z|0-9|가-힣]{2,15}$",name)) 
								{
									System.out.println("pw : 4~15자 사이의 공백없는 영문 or 숫자 ex)1234(o)");
									System.out.print("pw >>");
									pw = input.nextLine();
									// 비밀번호 : 4~15자 사이의 영문 or 숫자 ,공백 입력 제한(첫,중간,끝 전부 처리)
									// 단 pw는 첫글자가 숫자든 영어든 상관없음
									// 모든 입력조건을 충족시 회원 등록
									if(Pattern.matches("^[A-Z|a-z|0-9]{4,15}$",pw)) 
									{
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
									else {System.out.println("유효한 비밀번호가 아닙니다!");}
								}
								else {System.out.println("유효한 이름이 아닙니다!");}
							}
							else {System.out.println("이미 등록된 이메일 입니다!");}
						}
						else {System.out.println("유효한 메일주소가 아닙니다!");}
					}
					else 
					{System.out.println("이미 등록된 ID 입니다!");}
				}
				// id 입력규칙에 맞지 않으면 입력 오류
				else {System.out.println("유효한 아이디가 아닙니다!");}			
			}
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
					boolean tiModified=false;
					System.out.println("제목 : 30자이하(공백포함)");
					System.out.print("제목 >>");
					title = input.nextLine();
					if(Pattern.matches("^(?=.{1,30}$).*", title)) 
					{
						for (Board brd : brList) {

							if (post_no == brd.getPost_no()) {
								System.out.println(brd);
								brd.setTitle(title);
								if (boardManager.updateBoard(brd, memberManager.getId(), 1)) {
									System.out.println("수정완료!");
									tiModified = true;
								}
							}

						}
						if (!tiModified) {System.out.println("수정실패! 글번호를 다시 확인해주세요!");}
					}
					else {System.out.println("수정실패! 제목 : 30자이하(공백포함)");}
					break;
				
				// 내용 수정
				case 2:
					boolean conModified=false;
					System.out.println("내용 : 150자이하(공백포함)");
					System.out.print("내용 >>");
					content = input.nextLine();
					if (Pattern.matches("^(?=.{1,150}$).*", content)) 
					{
						for (Board brd : brList) 
						{
							if (post_no == brd.getPost_no()) 
							{
								System.out.println(brd);
								brd.setContent(content);
								if (boardManager.updateBoard(brd, memberManager.getId(), 2)) 
								{System.out.println("수정완료!");conModified=true;}
							}

						}
						if (!conModified) {System.out.println("수정실패! 글번호를 다시 확인해주세요!");}
					}
					else {System.out.println("수정실패! 내용 : 150자이하(공백포함)");}
					
					break;
				// 제목/내용 수정
				case 3:
					boolean allModified=false;
					System.out.println("제목 : 30자이하(공백포함)");
					System.out.print("제목 >>");
					title = input.nextLine();
					if(Pattern.matches("^(?=.{1,30}$).*", title)) 
					{
						System.out.println("내용 : 150자이하(공백포함)");
						System.out.print("내용 >>");
						content = input.nextLine();
						if (Pattern.matches("^(?=.{1,150}$).*", content)) 
						{
							for (Board brd : brList) 
							{
								if (post_no == brd.getPost_no()) 
								{
									System.out.println(brd);
									brd.setTitle(title);
									brd.setContent(content);
									if (boardManager.updateBoard(brd, memberManager.getId(), 3)) {System.out.println("수정완료!");}
								}
							}
							if (!allModified) {System.out.println("수정실패! 글번호 확인 필요");}
						}else {System.out.println("수정실패! 내용 : 150자이하(공백포함)");}
						
					}else {System.out.println("수정실패! 제목 : 30자이하(공백포함)");}
					
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
					drawHeaders();
					for(Board brd : boardlist) 
					{
						System.out.println(brd);
					}
					
				}
				else{System.out.println("해당 작성자가 작성한 게시물이 없습니다!");}
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
	
	
	private void drawHeaders() {
		System.out.printf("%3.2s | %3.1s%-7s | %2.1s%-8s | %2.1s%-8s | %3s | %19s |\n"
				+ "--------------------------------------------------------------------------\n",
				new String("NO"),
				new String(" "),
				new String("TITLE"),
				new String(" "),
				new String("CONTENT"),
				new String(" "),
				new String("WRITER"),
				new String("REPLY"),
				new String("DATE"));
	}

	// 게시글 조회 메뉴 메소드
		private void loadRetrieveContentMenu() {
			Scanner input = new Scanner(System.in);
			boolean run = true;

			while(run) 
			{			
				List<Board> allBoards = boardManager.retrieveboardList("");
				try 
				{
					drawHeaders();
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
					try 
					{
						int brdNo = Integer.parseInt(input.nextLine());
						String id="";
						for(Board brd : allBoards)
						{
							if(brdNo == brd.getPost_no()) {isExistBoard = true;indexBrd=brdNo;id = brd.getMem_id();}
						}
						if(isExistBoard == true) 
						{
							// 게시글 조회 메소드 호출
							List<String> contentList = replyManager.retrieveContent(id, indexBrd);
							for(String str:contentList)
							{System.out.println(str);}				
						}
						else{System.out.println("존재하지 않는 게시물입니다!");}
					}
					catch(Exception e) {System.out.println("입력오류! 유효한 값이 아닙니다!(글번호:숫자)");}
					
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
				//(숫자 아닌 값 처리)
				try 
				{
					int brdNo = Integer.parseInt(input.nextLine());
					for(Board brd : allBoards)
					{
						if(brdNo == brd.getPost_no()) {isExistBoard = true;indexBrd=brd.getPost_no();}
					}
					if(isExistBoard) 
					{
						//글자수 제한 완료 2024-04-25
						System.out.println("최대 글자수(공백 포함): 30자 이하");
						System.out.print("댓글 입력 >>");
						String reply = input.nextLine();
						// 댓글 입력 메소드 호출
						if(reply.length()<=30 && reply.length()>0) 
						{replyManager.insertReply(memberManager.getId(), brdNo, reply);}
						else
						{System.out.println("입력 실패! 댓글 글자수 : 1~30자");}
					}
					else{System.out.println("존재하지 않는 게시물입니다!");}
				}
				catch(Exception e) {System.out.println("입력오류! 숫자를 입력해주세요!");}
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
