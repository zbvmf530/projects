package chap04;

import java.util.Scanner;

public class Exam183p {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		//2번
//		int Sum=0;
//		for(int i=1;i<=100;i++)
//		{Sum+=3*i;}
//		System.out.println("1부터 100까지 3의 배수의 합 : "+Sum);
//		//3번
//		int dice1 = 0;
//		int dice2 = 0;
//		
//		while(dice1+dice2!=5)
//		{
//			dice1 = (int)(Math.random()*6)+1;
//			dice2 = (int)(Math.random()*6)+1;
//			System.out.println("(" + dice1 + ", " + dice2 + ")");
//		}
//		System.out.println("루프 종료! " + dice1 + " + " + dice2 + " = "+(dice1+dice2));

		// 4번
//		for(int x=1;x<=10;x++)
//		{
//			for(int y=1;y<=10;y++)
//			{
//				if( (4*x) + (5*y) == 60)
//				{System.out.println("(" + x + ", " + y + ")");}
//			}
//		}

//		// 5번
//		for(int i = 0;i<4;i++)
//		{
//			for(int j = 0;j<=i;j++)
//			{
//				System.out.print("*");
//			}
//			System.out.print("\n");
//		}

//		// 6번
//		for(int i = 0;i<4;i++)
//		{
//			for(int j = 0;j<5-i;j++){System.out.print(" ");}
//			
//			for(int k=0;k<=i;k++){System.out.print("*");}
//			
//			System.out.print("\n");
//		}

		// 7번
		

		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		final String DEPOSIT = "1", WITHDRAW="2", RETRIEVE="3", EXIT = "4";
		
		while (run) {
			System.out.println("----------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("----------------------------------");
			System.out.print("선택> ");
			String num = scanner.nextLine();
			// 출금 => 잔고 <출금액 => 잔고 부족, 출금 x
			
			switch (num) {
			
			case DEPOSIT:
				System.out.print("예금액> ");
				String deposit = scanner.nextLine();
//				try {}catch(NumberformatException e) {}
				balance+=Integer.parseInt(deposit);
				break;

			case WITHDRAW:
				System.out.print("출금액> ");
				String withdraw = scanner.nextLine();
				if(Integer.parseInt(withdraw)>balance)
				{System.out.println("잔고 부족!");}
				else
				{balance-=Integer.parseInt(withdraw);}
				break;

			case RETRIEVE:
				System.out.println("잔고> "+balance);
				break;

			case EXIT:
				run = false;
				break;

			default:
				System.out.println("입력오류! 숫자는 1~4사이만 입력");
			}
			System.out.println("");
		}
		
		System.out.println("프로그램 종료");
		scanner.close();

	}

}
