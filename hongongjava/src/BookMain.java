package challenge;

import java.util.*;

public class BookMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run=false;
		BookData bookManager = new BookData();
		List<Book> bookList = new ArrayList<Book>();
		Scanner userCmd = new Scanner(System.in);
		int userCom = 0;
		
		while(!run)
		{
			
			if(userCom == 0) 
			{				
				bookManager.loadUserMenu();
				try {userCom = Integer.parseInt(userCmd.nextLine());}catch(NumberFormatException e) {}
				
			}
			switch(userCom)
			{
				// 도서수 입력
				case 1: 
					userCom = bookManager.setBooksCount();
					break;
				
				case 2: 
					bookList = bookManager.setBooksInfo();
					userCom = bookManager.errorInputBooks?2:0;
					break;
				
				case 3: 
					bookManager.retrieveBooksInfo();
					userCom = 0;
					break;
				
				case 4: 
					if(!bookManager.isBooksEmpty()) 
					{						
						int maxPrice = bookList.getFirst().getPrice();
						int minPrice = bookList.getFirst().getPrice();
						double sum = 0;
						for(Book book : bookList) 
						{
							maxPrice = Math.max(maxPrice, book.getPrice());
							minPrice = Math.min(minPrice, book.getPrice());
							sum += book.getPrice();
						}
						System.out.println("최고 가격 : " +maxPrice);
						System.out.println("최저 가격 : " +minPrice);
						System.out.printf("평균 가격은 %.2f원 입니다.\n", sum/bookList.size());
					}
					else {System.out.println("분석할 도서정보가 없습니다!");}
					userCom=0;
					break;
				
				case 5:
					System.out.println("이용해주셔서 감사합니다!");
					run = true;
					break;
				
				default:
					userCom=0;
					break;
			}
		}
	}

}
