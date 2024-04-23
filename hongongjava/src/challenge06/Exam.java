package challenge06;

import java.util.Scanner;

public class Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Lamp myLamp = new Lamp();

//		myLamp.state();
//		myLamp.turnOn();
//		myLamp.state();
//		myLamp.turnOff();
//		myLamp.state();

//		Box box1 = new Box();
//		Box box2 = new Box(20);
//		Box box3 = new Box(30,40);
//		Box box4 = new Box(40,50,60);
//		
//		System.out.println("box1의 부피 : " + box1.volume());
//		System.out.println("box2의 부피 : " + box2.volume());
//		System.out.println("box3의 부피 : " + box3.volume());
//		System.out.println("box4의 부피 : " + box4.volume());
//		

//		Tv myTV = new Tv();
//		
//		myTV.print();
//		myTV.turnOnOff();
////		myTV.turnOnOff();
//		myTV.channelUp();
//		myTV.channelUp();
//		myTV.channelUp();
//		myTV.print();
//		
//		myTV.channelDown();
//		myTV.channelDown();
//		myTV.channelDown();
//		myTV.channelDown();
//		myTV.print();
//
//	
//		myTV.volumeUp();
//		myTV.volumeUp();
//		myTV.volumeUp();		
//		myTV.print();
//		
//		myTV.volumeDown();
//		myTV.volumeDown();
//		myTV.volumeDown();
//		myTV.print();
//		
//		myTV.setChannel(970);
//		myTV.print();
//		
//		myTV.turnOnOff();
//		myTV.turnOnOff();
//		Bank mybank = new Bank();
//		// 로그인시
//		
//		
//		Scanner input = new Scanner(System.in);
//		boolean run = true;
//		while(run) 
//		{			
//			System.out.println("1.입금\t2.출금\t3.잔액조회\t4.종료");
//			System.out.println("============================");
//			int menuNum = Integer.parseInt(input.nextLine());
//			
//			switch(menuNum)
//			{
//			case 1:
//				if(mybank.isLogedin()) 
//				{					
//					System.out.print("입금 금액> ");
//					int deposit = Integer.parseInt(input.nextLine());
//					mybank.deposit(deposit);
//				}
//				else 
//				{mybank.deposit(0);}
//				break;
//			case 2:
//				if(mybank.isLogedin()) 
//				{
//					System.out.print("출금 금액> ");
//					int withdraw = Integer.parseInt(input.nextLine());
//					mybank.withdraw(withdraw);
//				}
//				else 
//				{mybank.withdraw(0);}
//				break;
//			case 3:
//				mybank.toString();
//				break;
//			case 4: 
//				mybank.Logout();
//				run = false;
//				break;
//			}
//		}
//		input.close();
		// switch 1 2 3 4
		// 1 : Bank.deposit();
		// 2 : Bank.withdraw();
		// 3 : Bank.balance();
		// 4 : Bank.Logout();
		// 비밀번호만 입력받는다
		// 비밀번호 체크 함수 로직
		// 일치하는지 검색
		// 일치하는 객체 로그인된 회원 변수(회원객체)에 저장
		// 메인메뉴 출력(입금, 출금, 잔액확인, 돌아가기)
		// 입금 = 잔액+매개변수 -> x 호출
		// 출금 = 잔액<매개변수 -> 오류
		// 아니면 잔액 = 잔액-매개변수 -> x 호출
		// 잔액 화면에 표시하는 함수 x

		// 메인메뉴 -> 돌아가기 -> 로그아웃
		//

		// 6번
//		System.out.println(MyMath.power(2, 3));
//		System.out.println(MyMath.abs(-100));
//		

		// 7번
//		double[]array1 = {1.1, 2, 99, 5.5, 0.1, 0.9};
//		double[]array2 = {4.4, 20, -63, 10.8, 9, 0.5};
//		MinMax minmax = new MinMax();
//		System.out.println("첫번째 배열의 최소값 = "+minmax.getMin(array1));
//		System.out.println("두번째 배열의 최소값 = "+minmax.getMin(array2));

		// 8번
//		Dice myDice = new Dice();
//		int sum = 0, count = 0;
//		int[]dice = new int[2];
//		while(sum != 2)
//		{
//			dice = myDice.generateDiceNumber();
//			sum = dice[0]+dice[1];
//			System.out.print("( "+dice[0]+", "+dice[1]+" ) ");
//			count++;
//		}
//		System.out.println();
//		System.out.print("("+dice[0]+","+dice[1]+")이 나오는데 걸린 횟수 = "+count);

		// 4번
		Car myCar = new Car();
		Scanner input = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.print("1.가속 2.감속 3.운행종료");
			int select = Integer.parseInt(input.nextLine());

			switch (select) {
			case 1:
				if(myCar.speed <120)
				{myCar.speedUp();}
				else {
					System.out.println("속도를 줄여주세요.");
					myCar.speedDown();
				}
				break;
			case 2:
				if(myCar.speed >40)
				{myCar.speedDown();}
				else 
				{
					System.out.println("가속");
					myCar.speedUp();
				}
				break;
			case 3:
				run = false;
				break;
			}
			
			if(myCar.speed == 100) 
			{
				myCar.changeGear();
			}
		}
		System.out.println("운행종료");
	}

}
