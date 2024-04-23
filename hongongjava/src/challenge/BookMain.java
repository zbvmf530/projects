package challenge;

import java.util.*;

public class BookMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run=false;
		BookData bookManager = new BookData();
		List<Book> bookList = new ArrayList<Book>();
		Scanner userCmd = new Scanner(System.in);
		int userCom = 0, bookCount=0;
		
		
		while(!run)
		{
			
			if(userCom == 0) 
			{				
				bookManager.loadUserMenu();
				try {userCom = Integer.parseInt(userCmd.nextLine());}catch(NumberFormatException e) {userCom=6;}
			}
			switch(bookManager.uiMap.get(userCom))
			{
				// 학생수 입력
				case Ui.REGISTER: 
					try {
						System.out.print("도서 수 > ");
						bookCount = Integer.parseInt(userCmd.nextLine());
						if(bookCount>0){userCom = 0;}
						else {System.out.println("잘못 입력했습니다(0이상의 숫자 입력)");userCom = 1;} // 입력값이 음수일때 다시 입력
					}
					catch(NumberFormatException e) {System.out.println("잘못 입력했습니다(0이상의 숫자 입력)");userCom = 1;} // 잘못된 입력시 다시 입력
					break;
				//
				case Ui.INSERT: 
					bookList = bookManager.setBooksInfo(bookCount);
					userCom = bookManager.errorInputBooks?2:0;
					break;
				
				case Ui.RETRIVE: 
					if(!bookList.isEmpty()) {for(Book ele:bookList) {System.out.println(ele);}}
					else {System.out.println("등록된 도서가 없습니다.");}
					userCom = 0;
					break;
				
				case Ui.ANALYSIS: 
					if(!bookList.isEmpty()) 
					{
						double sum = 0;
						for(Book book : bookList){sum += book.getPrice();}
						System.out.println("최고 가격 : " +Collections.max(bookList).getPrice());
						System.out.println("최저 가격 : " +Collections.min(bookList).getPrice());
						System.out.printf("평균 가격은 %.2f원 입니다.\n", sum/bookList.size());
					}
					else {System.out.println("분석할 도서정보가 없습니다!");}
					userCom=0;
					break;
				
				case Ui.EXIT:
					System.out.println("이용해주셔서 감사합니다!");
					run = true;
					break;
				
				default:
					System.out.println("입력오류!(입력예시 : 선택 > 1 -> 도서수 입력 메뉴 진입)");
					userCom=0;
					break;
			}
		}
		userCmd.close();
	}

}
