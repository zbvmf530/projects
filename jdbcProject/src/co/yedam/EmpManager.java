package co.yedam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EmpManager {

	public static void main(String[] args) {
		EmpDAO empM= new EmpDAO();
		Scanner input = new Scanner(System.in);
		boolean run = true;
		while (run) 
		{
			System.out.println("1.사원목록 2.사원등록 3.정보수정 4.사원삭제 5.종료");
			System.out.print("선택>");
			
			int userCmd=0;
			try 
			{
				userCmd = Integer.parseInt(input.nextLine());
			}
			catch(NumberFormatException e) {System.out.println("입력 오류!");}
			
			 switch(userCmd) 
			 {
			 // 사원목록
			 case 1:
				 List<Employee> empList = empM.empList();
				 if(empList.size()>0) 
				 {					 
					 System.out.println("사원번호\t사원명\t\t연락처\t\t급여");
					 System.out.println("----------------------------------------------");
					 for(Employee emp : empList) {System.out.println(emp);}
				 }
				 else {System.out.println("등록된 회원이 없습니다!");}
				 break;
			
			// 사원등록
			 case 2:
				 Employee emp = new Employee();
				 //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
				 try 
				 {
					 System.out.print("사원명>> ");
					 emp.setEmpName(input.nextLine());
					 System.out.print("연락처>> ");
					 emp.setPhone(input.nextLine());
					 System.out.print("이메일>> ");
					 emp.setEmail(input.nextLine());
					 System.out.print("급여>> ");
					 emp.setSalary(Integer.parseInt(input.nextLine()));
					 System.out.print("입사일>> ");
					 emp.setHireDate(input.nextLine());
					 
					 if(empM.insertEmployee(emp) == true)
					 {System.out.println("정상등록");}
					 else {System.out.println("입력오류!");}
				 }
				 catch(NumberFormatException e) {System.out.println("입력오류!");}
				 
				 break;
			// 정보수정
			 case 3:
				 Employee chgemp = new Employee();
				// try 
				// {
					 System.out.print("사원번호>>");
					 chgemp.setEmpNo(Integer.parseInt(input.nextLine()));
					 System.out.print("급여>>");
					 chgemp.setSalary(Integer.parseInt(input.nextLine()));
					 System.out.print("이메일>> ");
					 chgemp.setEmail(input.nextLine());
					 
					 if(empM.updateEmp(chgemp) == true) 
					 {System.out.println("정상처리");}
					 else {System.out.println("입력 오류!");}
				 //}
				 //catch(NumberFormatException e) {System.out.println("dfjdjk");}
				 break;
			// 사원삭제
			 case 4:
				 Employee deleteEmp = new Employee();
				 try 
				 {
					 System.out.print("삭제할 사원번호>>");
					 deleteEmp.setEmpNo(Integer.parseInt(input.nextLine()));
					 if(empM.deleteEmp(deleteEmp)) {System.out.println("정상처리");}
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
