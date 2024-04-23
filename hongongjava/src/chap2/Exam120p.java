package chap2;

import java.util.Scanner;

public class Exam120p {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1.
		/*
		 * String name = "감자바"; int age = 25; String tell = "010", tel2="123",
		 * tel3="4567"; System.out.println("이름 : " + name); System.out.print("나이 : " +
		 * age + "\n"); System.out.printf("전화 : %s-%s-%s",tell,tel2,tel3);
		 */

		// 2. 스캐너 이용
		/*
		 * Scanner scanner = new Scanner(System.in);
		 * 
		 * System.out.print("첫번째 수:"); String strNum1 = scanner.nextLine();
		 * 
		 * System.out.print("두번째 수:"); String strNum2 = scanner.nextLine();
		 * 
		 * int num1 = Integer.parseInt(strNum1); int num2 = Integer.parseInt(strNum2);
		 * int result = num1 + num2;
		 * 
		 * System.out.println("덧셈 결과:"+result);
		 */

		// 3. 스캐너 이용
		Scanner scanner = new Scanner(System.in);

		// 이름:
		// 주민번호 앞 6자리:
		// 전화번호:
//		String name = "";
//		String idNum = "";
//		String tel = "";
//		
//		while (true) 
//		{
//			System.out.println("===================");
//			System.out.println("[필수 정보 입력]");
//			System.out.print("1. 이름:");
//			name = scanner.nextLine();
//
//			System.out.print("2. 주민번호 앞 6자리:");
//			idNum = scanner.nextLine();
//
//			System.out.print("3. 전화번호:");
//			tel = scanner.nextLine();
//
//			if(!name.equals("q") && !idNum.equals("q") && !tel.equals("q")) 
//			{				
//				// 출력결과
//				System.out.println("===================");
//				System.out.println("[입력된 내용]");
//				System.out.println("이름: " + name);
//				System.out.println("주민번호 앞 6자리: " + idNum);
//				System.out.println("전화번호: " + tel);
//			}
//			else {break;}
//		}
//		
//		System.out.println("입력종료");
//		scanner.close();
		// 이름: 홍길동
		// 주민번호 앞 6자리: 123456
		// 전화번호: 010-123-1234
	}

}
