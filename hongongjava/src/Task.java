


import java.util.Scanner;

public class Task {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		// 1번
//		Tasks.loadTask1();
		
//		// 2번
//		Tasks.loadTask2();
		
//		// 3번
//		Tasks.loadTask3();
		
//		// 4번
//		Tasks.loadTask4();
		
//		// 5번
//		Tasks.loadTask5();
		
//		// 6번
//		Tasks.loadTask6();
		
		// 7번
//		Tasks.loadTask7();

	}

	public static class Tasks
	{
		// ---------------------------------- 1번 -----------------------------
		public static void loadTask1() 
		{
			Scanner input = new Scanner(System.in);
			String year = "", yearChk = "";
			int fullyear = 0;
			boolean cmdExit = false;
			while(!cmdExit) 
			{
				System.out.print("##년도 입력 : ");
				year = input.nextLine();
				yearChk = "";
				try 
				{
					fullyear = Integer.parseInt(year);
					if((fullyear%4==0 && fullyear%100 != 0) || fullyear%400 == 0)
					{yearChk = String.valueOf(year)+"년은 윤년입니다.";}
					
					else
					{yearChk = String.valueOf(year)+"년은 평년입니다.";}
					cmdExit=true;
				}
				catch(NumberFormatException e) 
				{
					yearChk = "입력오류! 숫자를 입력해주세요.";
				}
				System.out.println(yearChk);	
			}
			input.close();
		}
		
		// --------------------------------------- 2번 ------------------------------------
		public static void loadTask2() 
		{
			Scanner money = new Scanner(System.in);
			String inputMoney = "";
			
			int total = 0, remain = 0;
			int won[] = new int[5];
			int wonUnit = 0;
	
			while (true) 
			{
				System.out.print("##교환할 금액 : ");
				inputMoney = money.nextLine();
				
				try 
				{
					total = Integer.parseInt(inputMoney);
					remain = Integer.parseInt(inputMoney);
					
					for (int i = 5; i >= 2; i--) 
					{
						wonUnit = (int) (Math.pow(2, ((i - 1) % 2)) * 5 * Math.pow(10, Math.floor(((i - 1) / 2))));
						won[5 - i] = remain / wonUnit;
						remain -= (remain / wonUnit) * wonUnit;
						System.out.println(wonUnit + "원 짜리 : " + won[5 - i] + "개");
					}
					
					break;
				} 
				catch (NumberFormatException e) {System.out.println("입력오류! 숫자를 입력해주세요.");}
			
			}
	
			System.out.println("교환 금액 : " + (total - remain) + "원");
			System.out.println("남은 금액 : " + remain + "원");
			money.close();
		}
		
		// ----------------------------------------- 3번 -----------------------------
		public static void loadTask3() 
		{
			int num = (int)(Math.random()*100)+1;
			int human = 0;
			Scanner input = new Scanner(System.in);
			String inputNum = "";
	
			while(human != num)
			{
				System.out.print("숫자 입력 : ");
				
				try 
				{				
					inputNum = input.nextLine();
					human = Integer.parseInt(inputNum);
					
					if(human > num) {System.out.println("down하세요!!");}
					
					else if(human < num){System.out.println("up하세요!!");}
				}
			
				catch(NumberFormatException e)
				{System.out.println("입력오류! 숫자만 입력가능.");}
			
			}
			System.out.println("축하합니다!!");
			input.close();

		}
		
		// ---------------------------------------- 4번 ---------------------------------
		public static void loadTask4() 
		{
			for(int i = 2; i<=9;i++)
			{System.out.printf("%3d단\t", i);}
			System.out.println();
			for(int j = 1;j<10;j++)
			{
				for(int k=2;k<10;k++)
				{
	
					System.out.printf("%dx%d=%2d\t",k,j,k*j);
				}
				System.out.println();
			}

		}
		
		// -------------------------------------- 5번  -------------------------------------
		public static void loadTask5() 
		{
			boolean run = true;
			
					int degree = 0;
			
					Scanner scanner = new Scanner(System.in);
			
					final String TOCELSIUS = "1", TOFAHRENHEIT = "2", EXIT = "3";
			
					String far = "", cel = "";
					String Error = "NONE";
					String num="";
					while (run) {
			
						if (Error.equals("NONE")) 
						{
							System.out.println("----------------------------------");
							System.out.println("1.화씨 => 섭씨");
							System.out.println("2.섭씨 => 화씨");
							System.out.println("3.종료");
							System.out.println("----------------------------------");
			
							System.out.print("▶ 번호선택 : ");
							num = scanner.nextLine();
			
						}
			
						switch (num) {
			
						case TOCELSIUS:
							System.out.print("▶ 화씨 온도 입력 : ");
							far = scanner.nextLine();
			
							try {
								cel = String.valueOf((Double.parseDouble(far) - 32) * 5 / 9);
								System.out.printf("  섭씨 온도 = %.6f", Double.parseDouble(cel));
								Error = "NONE";
							} catch (NumberFormatException e) {
								System.out.println("입력오류! 숫자를 입력해주세요.");
								e.getMessage();
								Error = "TOCELSIUS";
								num = TOCELSIUS;
							}
							break;
			
						case TOFAHRENHEIT:
							System.out.print("▶ 섭씨 온도 입력 : ");
							cel = scanner.nextLine();
			
							try {
								far = String.valueOf((Double.parseDouble(cel)* 9 / 5) + 32);
								System.out.printf("  화씨 온도 = %.6f", Double.parseDouble(far));
								Error = "NONE";
							} catch (NumberFormatException e) {
								System.out.println("입력오류! 숫자를 입력해주세요.");
								e.getMessage();
								Error = "TOFAHRENHEIT";
								num = TOFAHRENHEIT;
							}
							break;
			
						case EXIT:
							run = false;
							break;
			
						default:
							System.out.println("입력오류! 숫자는 1~3사이만 입력");
							break;
						}
			
						System.out.println("");
					}
			
					System.out.println("program end");
			
					scanner.close();
		}
		
		//--------------------------------- 6번-------------------------------------
		public static void loadTask6() 
		{
			Scanner input = new Scanner(System.in);
			
					String inputNum = "";
					String result = "";
					int human = 0;
					NumberFormatException inputError = new NumberFormatException();
					while(true)
					{
			
						int com = (int)(Math.random()*3);
						
						System.out.print("## 가위(0) 바위(1) 보(2) : ");
						try 
						{
							inputNum = input.nextLine();
							if(!inputNum.equals("3")) 
							{
								if(inputNum.length()>=2)
								{throw inputError;}
								human =Integer.parseInt(inputNum);
								
								if((human+1) % 3 == com) {result = " 컴 승리\n";}
								
								else {result = human==com ? " 비겼음\n" : " 사람 승리\n";}
								
								System.out.print("사람 "+inputNum+", 컴 "+ com + result);				
							}
							else {break;}				
						}
						catch(NumberFormatException e) {System.out.println("입력오류! 0 ~ 2의 값 입력(3 : 종료)");}
			
					}
					
					System.out.print("game over");
					input.close();
		}
		
		//---------------------- 7번----------------------------------------------
		static int count=0;
		public static void loadTask7() 
		{
			int enter = 0;
			String num="";
			for(int i = 1;i<=50;i++)
			{
				count = 0; enter++;
				num=num.valueOf(i);
				num.chars().forEach(c->count = (c-'0')%3==0?(c!='0'?count+1:count):count);
				
				switch(count)
				{
				case 0:
					System.out.print(i + "\t");
					break;
				case 1:
					System.out.print("♥"+ "\t");
					break;
				case 2:
					System.out.print("♥♥"+ "\t");
					break;
				}
				
				if(enter/10*10 == enter) {System.out.println();enter = 0;}}
		}
	}

}