package chap05;

import java.util.Scanner;

public class Exam195p {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 참조 타입 => 변수의 값으로 주소(힙영역에 객체가 저장된 번지) 저장
//		String var1="신민철";
//		String var2="신민철";
//		System.out.println("리터럴 사용한 경우");
//		if(var1==var2)
//		{
//			System.out.println("참조가 같음 : 동일한 객체 참조");
//		}
//		else 
//		{
//			System.out.println("참조가 다름 : 다른 객체 참조");
//		}
//		
//		if(var1.equals(var2)) {System.out.println("데이터가 같음");}
//		
//		String var3 = new String("신민철");
//		String var4 = new String("신민철");
//		System.out.println("new 키워드 사용한 경우");
//		if(var3==var4)
//		{
//			System.out.println("참조가 같음 : 동일한 객체 참조");
//		}
//		else 
//		{
//			System.out.println("참조가 다름 : 다른 객체 참조");
//		}
		
		
		// 정수 타입의 배열을 선언, 크기 10
		// 1에서 100사이의 난수 발생-> 배열에 저장
		// 배열의 합, 최대값, 최소값 출력
		
//		int[] num = new int[10];
////		int max=-1, sum=0, min=101, count = 0;
////		int cnt=0;
////	
//		System.out.print("생성한 숫자 : ");
//		for(int i:num)
//		{
//			i = (int)Math.floor(Math.random()*100)+1;
//			count = i>=50?(i<=70?count+1:count):count;
//			sum += i; num[cnt] = i; cnt++;
//			System.out.print(i+" ");
//		}
//		System.out.println();
//		
//		Arrays.sort(num);
//		System.out.println("배열의합 : "+sum+ ", 최대값: "+num[num.length-1]+", 최소값 : "+num[0] + ", 50~70 사이의 수 : "+count);
//		System.out.println("평균 : "+(double)sum/num.length);
		
//		int [][] kscores = new int[3][];
//		kscores[0] = new int[2];
//		kscores[1] = new int[4];
//		kscores[2] = new int[3];
//		
//		for(int i =0;i<kscores.length;i++) 
//		{
//			for(int j=0;j<kscores[i].length;j++)
//			{
//				kscores[i][j]=i+j;
//				System.out.print(kscores[i][j] + "\t");
//				
//			}
//			System.out.println();
//		}
		
//		int [][] escores = {
//				{95,85},
//				{58,89,78},
//				{77,88,99}
//		};
//		
//		
//		for(int i =0;i<escores.length;i++)
//		{
//			for(int j=0;j<escores[i].length;j++)
//			{
//				System.out.print(escores[i][j]+"\t");
//			}
//			System.out.println();
//		}
//		
//	}
		
//		String[] web = {"html", "css", "js"};
//		
//		String[] web5 = new String[5];
//		
////		for(int i = 0;i<web.length;i++)
////		{
////			web5[i] = web[i];
////		}
////		
//	
//		System.arraycopy(web,0,web5,0,3);
//		web5[3]="java";web5[4]="sql";
//		for(String i : web5)
//			System.out.print(i+" ");
//		Scanner sc = new Scanner(System.in);
//		int[] arr= new int[10];
////		int i = 0;
//		int sum = 0;
////		while(i < 10) 
////		{
////		System.out.print("숫자 입력(50~100 사이 정수) : ");
////		
////		int ele = Integer.parseInt(sc.nextLine());
////		arr[i] = ele;
////		i++;
////		}
//		for(int i =0;i<arr.length;i++) {arr[i]=(int)(Math.random()*51)+50;}
//		
//		for(int ele : arr)
//		{
//			sum += ele;
//			System.out.print(ele + " ");
//		}
//		System.out.print("합계 : " + sum+", 평균 : "+(double)sum/arr.length);
		
		
		// 4번
//		int max = 0;
//		int[] array = {1,5,3,8,2};
//		for(int i : array)
//		{max = max<i?i:max;}
//		System.out.println("max: "+max);
		
		// 5번
//		int[][] array = {
//				{95,86},
//				{83,92,96},
//				{78,83,93,87,88}
//		};
//		
//		int sum = 0;
//		for(int i=0;i<array.length;i++)
//		{
//			for(int j : array[i])
//			{sum += j;}
//		}
//		
//		double avg = (double)sum/(array[0].length+array[1].length+array[2].length);
//		System.out.println("sum: "+sum);
//		System.out.println("avg: "+avg);
		
		// 6번
		boolean run = true;
		int zeroChk=1;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);
		int selectNo=0;
		while(run)
		{
			if(selectNo==0) 
			{				
				System.out.println("---------------------------------------------");
				System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
				System.out.println("---------------------------------------------");
				
				
				System.out.print("선택>");
				
				try 
				{selectNo= Integer.parseInt(scanner.nextLine());}
				catch(NumberFormatException e) {System.out.println("입력오류! 숫자를 입력해주세요.");selectNo=0;}
				
			}
			else 
			{
				switch(selectNo)
				{
				case 1:
					System.out.print("학생수>");
					try 
					{studentNum = Integer.parseInt(scanner.nextLine());selectNo = 0;}
					catch(NumberFormatException e) {System.out.println("입력오류! 숫자를 입력해주세요.");selectNo=1;}
					try {
						zeroChk /= studentNum;
						selectNo = 0;
					}catch(ArithmeticException e){System.out.println("입력오류! 값은 0보다 커야합니다.");selectNo=1;}
					break;
				case 2:
					if(studentNum !=0) 
					{
						scores = new int[studentNum];
						for(int i =0;i<studentNum;i++)
						{					
							System.out.print("scores["+i+"]>");
							scores[i] = Integer.parseInt(scanner.nextLine());
						}
					}
					else {System.out.println("점수를 입력할 수 없습니다.! 학생 수를 먼저 입력해주세요.");}
					selectNo = 0;
					break;
				case 3:
					if(studentNum !=0) 
					{
						for(int i =0;i<studentNum;i++) {System.out.println("scores["+i+"]>"+ scores[i]);}
					}
					else {System.out.println("등록된 점수가 없습니다.! 학생의 점수를 먼저 입력해주세요.");}
					selectNo = 0;
					break;
				case 4:
					if(studentNum !=0) 
					{
					int max=-1, sum = 0;
					for(int i:scores)
					{
						max = max<i?i:max;
						sum += i;
					}
					System.out.println("최고 점수: " + max);
					System.out.println("평균 점수: " + (double)sum/scores.length);
					}else {System.out.println("분석 실패! 점수를 먼저 입력해주세요");}
					selectNo = 0;
					break;
				case 5:
					run = !run;
					break;
				default:
					System.out.println("0 ~ 5의 값 입력!");
					selectNo = 0;
					break;
				}
			}
			
			
		}
		System.out.println("프로그램 종료");
	}
	
}
