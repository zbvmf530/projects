package challenge;

import java.util.*;

public class BookData {
	private List<Book> BookDao;
	Scanner InputCount = new Scanner(System.in);
	int bookCount;
	String[] inputLabel = {"도서번호 > ", "도서제목 > ", "도서가격 > "};
	boolean errorInputBooks;
//	실행 클래스로 list 자료를 넘길 함수를 선언한다. 
//	- List 인터페이스 타입에 ArrayList 구현객체를 생성한다. 
//	- Book 타입의 도서 객체를 입력된 도서 수만큼 키보드로 입력 받아 추가한다. 
//	- 도서 목록을 return 한다.
	
	BookData(){BookDao = new ArrayList<Book>(1);}

	
	
	void loadUserMenu() 
	{
		System.out.println("---------------------------------------------------------");
		System.out.println("1.도서수 입력 2.도서정보 등록 3.도서정보 전체조회 4.도서정보 분석 5.종료");
		System.out.println("---------------------------------------------------------");
		System.out.print("선택 > ");
	}
	// 도서 수 입력 함수(음수 안됨, 숫자아닌값 안됨)
	int setBooksCount() 
	{
		try {
			System.out.print("도서 수 > ");
			bookCount = Integer.parseInt(InputCount.nextLine());
			if(bookCount>0){return 0;}
			else {System.out.println("잘못 입력했습니다(0이상의 숫자 입력)");return 1;} // 입력값이 음수일때 다시 입력
		}
		catch(NumberFormatException e) {System.out.println("잘못 입력했습니다(0이상의 숫자 입력)");return 1;} // 잘못된 입력시 다시 입력
	}
	
	// 도서 정보 등록 함수
	List<Book> setBooksInfo() 
	{
		int tmp = 0;
		for(int i=0;i<bookCount;i++)
		{
			try
			{				
				Book book = new Book();
				System.out.println((i+1)+" 번째 도서 정보 입력");
				System.out.print(inputLabel[0]);
				book.setNum(Integer.parseInt(InputCount.nextLine()));
				System.out.print(inputLabel[1]);
				book.setTitle(InputCount.nextLine());
				System.out.print(inputLabel[2]);
				book.setPrice(Integer.parseInt(InputCount.nextLine()));
				BookDao.add(book);
				tmp++;
			}
			catch(NumberFormatException e) 
			{
				for(int j = 0; j<tmp;j++) {BookDao.removeLast();}
				System.out.println("잘못 입력했습니다! 다시 입력해주세요.");
				errorInputBooks = true;
				return BookDao;
			} // 잘못된 입력시 추가된 내용 다시 지운 뒤 다시 입력
			
		}
		return BookDao;		
	}
	
	// 도서정보 전체조회함수
	void retrieveBooksInfo() 
	{
		if(!isBooksEmpty()) {for(Book ele:BookDao) {System.out.println(ele);}}
		else {System.out.println("등록된 도서가 없습니다.");}
	}
	
	boolean isBooksEmpty() {return BookDao.isEmpty();}
}
