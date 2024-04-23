package co.yedam;

import java.util.List;
import java.util.Scanner;

public class MemberManager {

	public static void main(String[] args) 
	{
		MemberDAO  dao = new MemberDAO();
		Scanner input = new Scanner(System.in);
		boolean run = true;
		while(run) 
		{
			System.out.println("1.회원목록 2.회원등록 3.정보수정 4.정보삭제 5.종료");
			System.out.print("선택>");
			
			int userCmd=0;
			try 
			{
				userCmd = Integer.parseInt(input.nextLine());
			}
			catch(NumberFormatException e) {System.out.println("입력 오류!");}
			
			 switch(userCmd) 
			 {
			 // 회원목록
			 case 1:
				 List<Member> empList = dao.memberList();
				 if(empList.size()>0) 
				 {					 
					 System.out.println("회원번호\t회원명\t\t연락처\t\t생일\t\t성별");
					 System.out.println("---------------------------------------------------------");
					 for(Member mem : empList) {System.out.println(mem);}
				 }
				 else {System.out.println("등록된 회원이 없습니다!");}
				 break;
			
			// 회원등록
			 case 2:
				 Member mem = new Member();
				 
					 System.out.print("회원명>> ");
					 mem.setName(input.nextLine());
					 System.out.print("연락처>> ");
					 mem.setPhone(input.nextLine());
					 System.out.print("생일>> ");
					 mem.setBirth(input.nextLine());
					 System.out.print("성별>> ");
					 mem.setGender(input.nextLine());
					 
					 if(dao.insertMember(mem) == true)
					 {System.out.println("정상등록");}
					 else {System.out.println("입력오류!");}
				 
				 
				 break;
			// 정보수정
			 case 3:
				 Member chgmem = new Member();
				 try 
				 {
					 System.out.print("수정할 회원번호>>");
					 chgmem.setNo(Integer.parseInt(input.nextLine()));
					 System.out.print("연락처>>");
					 chgmem.setPhone(input.nextLine());
					 
					 if(dao.updateMember(chgmem) == true) 
					 {System.out.println("정상처리");}
					 else {System.out.println("입력 오류!");}
				 }
				 catch(NumberFormatException e) {System.out.println("dfjdjk");}
				 break;
			// 회원삭제
			 case 4:
				 Member deleteMem = new Member();
				 try 
				 {
					 System.out.print("삭제할 회원번호>>");
					 deleteMem.setNo(Integer.parseInt(input.nextLine()));
					 if(dao.deleteMember(deleteMem.getNo())) {System.out.println("정상처리");}
					 else {System.out.println("입력오류!");}
				}
				 catch(NumberFormatException e) {}
				 
				 break;
			// 종료	 
			 case 5:
				 run = false;
				 break;
			// 기타 입력
			default:
				System.out.println("입력오류! (입력값 : 1~5사이의 숫자)");
			 }
		}
		
		System.out.println("end of prog.");
	}
}
