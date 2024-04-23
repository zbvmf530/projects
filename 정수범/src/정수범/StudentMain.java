package 정수범;

import java.util.*;

public class StudentMain {

	public static void main(String[] args) {

		// 필요 데이터 : 루프 여부 결정 데이터(run)
		boolean run = true;

		// 사용자 커맨드(Scanner, int)
		Scanner userCmd = new Scanner(System.in);
		int userCom = 0;

		// StudentData로 부터 받을 리스트 데이터
		List<Student> stuList = new ArrayList<>();
		StudentData studentManager = new StudentData();
		// 학생수 저장 변수
		int stuCount = 0;

		while (run) {
			if (userCom == 0) {
				// 메인메뉴 출력 메소드 호출
				studentManager.loadUserMenu();
				// 사용자 커맨드 저장시 예외처리(공백 혹은 숫자가 아닌 데이터)
				try {userCom = Integer.parseInt(userCmd.nextLine());} catch (NumberFormatException e) {userCom = 6;}
			}
			
			// 1~5 사이의 값이 아닐시 Hashmap에 등록되어있지 않은 키값이므로 null 반환함.
			// 해당 예외 발생시 스위치에 입력값을 default로 throw
//			try {}catch(NullPointerException e) {}
			if (studentManager.uiMap.get(userCom) == null) {userCom = 6;}

			switch (studentManager.uiMap.get(userCom)) {

			// 학생 수 등록
			case Ui.REGISTER:
				try 
				{
					System.out.print("학생 수 > ");
					stuCount = Integer.parseInt(userCmd.nextLine());
					if (stuCount > 0) {userCom = 0;} 
					else // 입력값이 음수일때 다시 입력
					{
						System.out.println("잘못 입력했습니다(0이상의 숫자 입력)");
						userCom = 1;
					} 
				} 
				catch (NumberFormatException e) 
				{
					System.out.println("잘못 입력했습니다(0이상의 숫자 입력)");
					userCom = 1;
				} // 잘못된 입력시 다시 입력
				break;

			// 학생 정보 입력
			case Ui.INSERT:
				if(stuCount<=0) {System.out.println("학생수를 먼저 입력해주세요!");}
				if(studentManager.getSavedCount()>0) {stuCount=studentManager.getSavedCount();}
				stuList = studentManager.setStudentsInfo(stuCount);
				userCom = 0;
				break;

			// 학생 조회
			case Ui.RETRIVE:
				if (!stuList.isEmpty()) {
					for (Student ele : stuList) {System.out.println(ele);}
				} else {
					System.out.println("등록된 학생이 없습니다.");
				}
				userCom = 0;
				break;
			// 분석
			case Ui.ANALYSIS:
				if (!stuList.isEmpty()) {
					double sum = 0;
					for (Student student : stuList) {sum += student.getScore();}
					System.out.println("최고 점수 : " + Collections.max(stuList).getScore()+"점");
					System.out.println("최저 점수 : " + Collections.min(stuList).getScore()+"점");
					System.out.printf("평균 점수은 %.2f점 입니다.\n", sum / stuList.size());
				} else {
					System.out.println("분석할 학생정보가 없습니다!");
				}
				userCom = 0;
				break;

			// 종료
			case Ui.EXIT:
				System.out.println("프로그램 종료");
				run = false;
				break;

			// 기타 사용자 오입력
			default:
				System.out.println("입력오류!(입력예시 : 선택 > 1 -> 학생수 입력 메뉴 진입)");
				userCom = 0;
				break;
			}
		}
		userCmd.close();
	}
}
