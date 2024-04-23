package 정수범;

import java.util.*;

public class StudentData {

	private List<Student> studentDao = new ArrayList<Student>();
	private Scanner InputField = new Scanner(System.in);
	private String[] inputLabel = {"학번 > ", "이름 > ", "점수 > "};
	private int savedCount;
	Map<Integer,Ui> uiMap = new HashMap<>();
	
	// Constructor
	StudentData(){
		uiMap.put(1,Ui.REGISTER);
		uiMap.put(2, Ui.INSERT);
		uiMap.put(3,Ui.RETRIVE);
		uiMap.put(4,Ui.ANALYSIS);
		uiMap.put(5,Ui.EXIT);
		uiMap.put(6, Ui.DEFAULT);
		savedCount = 0;
		}
	
	// Method	
	// 메인 메뉴 출력 
	void loadUserMenu() 
	{
		System.out.println("---------------------------------------------------------");
		System.out.println("1.학생수 입력 2.학생정보 등록 3.학생정보 전체조회 4.학생정보 분석 5.종료");
		System.out.println("---------------------------------------------------------");
		System.out.print("선택 > ");
	}

	// 학생 정보 입력(메인에서 학생수를 받아서 그만큼 처리)
	List<Student> setStudentsInfo(int stuCount) 
	{
		
		int tmp = 0;
		for(int i=0;i<stuCount;i++)
		{
			try
			{				
				Student student = new Student();
				System.out.println((i+1)+" 번째 학생 정보 입력");
				System.out.print(inputLabel[0]);
				student.setId(Integer.parseInt(InputField.nextLine()));
				System.out.print(inputLabel[1]);
				student.setName(InputField.nextLine());
				System.out.print(inputLabel[2]);
				student.setScore(Integer.parseInt(InputField.nextLine()));
				studentDao.add(student);
				tmp++;
			}
			catch(NumberFormatException e) 
			{
				savedCount = stuCount-tmp;
				//for(int j = 0; j<tmp;j++) {studentDao.removeLast();}
				System.out.println("잘못 입력했습니다! 다시 입력해주세요.");
				return studentDao;
			} // 잘못된 입력시 추가된 내용 다시 지운 뒤 다시 입력
			
		}
		return studentDao;		
	}
	int getSavedCount() {return savedCount;}
}
