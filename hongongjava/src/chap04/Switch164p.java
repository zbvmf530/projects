package chap04;

import java.util.Scanner;

public class Switch164p {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1~6까지 수 나와야함, 어떤수 나올지 모름 => 1<=Math.random()<7
		
		
		
		
		// 주사위 나온 번호 출력 (1,2,3,4,5,6) => switch()
		
		
		// 주사위 번호 발생
		int diceNum = (int)(Math.random()*20)+1;
		// 주사위 번호 맞추기
		int count = 0;
		// 주사위 번호 입력 -> 번호를 맞출 때 까지 반복 => while(){}
		// up/down diceNum = 4 inputNum =3 -> up    inputNum=5 -> down
		// count -> 몇번 만에 맞췄는지
		
		Scanner sc = new Scanner(System.in);
		int inputNum = 0;
		while(inputNum != diceNum)
		{
			System.out.print("생성된 주사위 번호는?");
			inputNum = sc.nextInt();
			if(inputNum>diceNum)
			{System.out.println("Down");}
			else if(inputNum<diceNum)
			{System.out.println("UP");}
			count++;
		}
		
		System.out.println("정답!"+"정답은"+diceNum+"입니다.");
		
		if(count==1)
		{System.out.print("축하합니다!");}
		System.out.println(count+"번만에 정답을 맞추셨습니다.");
		sc.close();
		
		//		System.out.print("나온 숫자 : ");
//		switch(diceNum) {
//		
//		case 1:
//		System.out.println(diceNum);
//		break;
//		case 2:
//		System.out.println(diceNum);
//		break;
//		case 3:
//		System.out.println(diceNum);
//		break;
//		case 4:
//		System.out.println(diceNum);
//		break;
//		case 5:
//		System.out.println(diceNum);
//		break;
//		default:
//		System.out.println(diceNum);
//		break;
//		
//		}
	}

}
