package challenge;

import java.util.*;

public class BookData {
	private List<Book> BookDao =  new ArrayList<Book>();
	Scanner InputField = new Scanner(System.in);
	Map<Integer,Ui> uiMap = new HashMap<>();
	
	String[] inputLabel = {"도서번호 > ", "도서제목 > ", "도서가격 > "};
	boolean errorInputBooks;

	BookData(){uiMap.put(1,Ui.REGISTER);uiMap.put(2, Ui.INSERT);uiMap.put(3,Ui.RETRIVE);uiMap.put(4,Ui.ANALYSIS);uiMap.put(5,Ui.EXIT);uiMap.put(6,Ui.DEFAULT);}
	void loadUserMenu() 
	{
		System.out.println("---------------------------------------------------------");
		System.out.println("1.도서수 입력 2.도서정보 등록 3.도서정보 전체조회 4.도서정보 분석 5.종료");
		System.out.println("---------------------------------------------------------");
		System.out.print("선택 > ");
	}
	

	// 도서 정보 등록 함수
	List<Book> setBooksInfo(int bookCount) 
	{
		int tmp = 0;
		for(int i=0;i<bookCount;i++)
		{
			try
			{				
				Book book = new Book();
				System.out.println((i+1)+" 번째 도서 정보 입력");
				System.out.print(inputLabel[0]);
				book.setNum(Integer.parseInt(InputField.nextLine()));
				System.out.print(inputLabel[1]);
				book.setTitle(InputField.nextLine());
				System.out.print(inputLabel[2]);
				book.setPrice(Integer.parseInt(InputField.nextLine()));
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
}
