package chalenge05;

import java.util.Calendar;

public class ExamEnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Week today = null;
//		
//		Calendar cal = Calendar.getInstance();
//		int week = cal.get(Calendar.DAY_OF_WEEK);
//		
//		switch(week)
//		{
//		case 1:
//			today = Week.일요일;break;
//		case 2:
//			today = Week.월요일;break;
//		case 3:
//			today = Week.화요일;break;
//		case 4:
//			today = Week.수요일;break;
//		case 5:
//			today = Week.목요일;break;
//		case 6:
//			today = Week.금요일;break;
//		case 7:
//			today = Week.토요일;break;
//		}
//		
//		if(today == Week.일요일) {System.out.println("축구를 합니다");}
//		else{System.out.println("자바를 공부합니다");}
		
		LoginResult result = LoginResult.FAIL_PASSWORD;
		
		if(result == LoginResult.SUCCESS)
		{System.out.println("로그인 성공!");}
		else if(result == LoginResult.FAIL_ID) {System.out.println("존재하지 않는 아이디입니다!");}
		else if(result == LoginResult.FAIL_PASSWORD) {System.out.println("비밀번호가 틀렸습니다!");}
	}

}
