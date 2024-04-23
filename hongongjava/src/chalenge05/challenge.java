package chalenge05;

public class challenge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1번
//		int randomNum = 0;
//		int[] arr = new int[10];
//		int sum =0, max = 0, min = 101;
//		
//		for(int i = 0;i<arr.length;i++)
//		{
//			randomNum = (int)(Math.random()*100)+1;
//			arr[i] = randomNum;
//			max = max<arr[i]?arr[i]:max;
//			min = min>arr[i]?arr[i]:min;
//			sum +=arr[i];
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println();
//		System.out.println("합계 : "+sum + " 최대값 : "+ max +" 최소값 : " + min);
//		
//		//2번
//		int[][] array = {{1,2,3}, {1,2}, {1}, {1,2,3}};
//		for(int i =0;i<array.length;i++)
//		{
//			for(int j : array[i])
//			{
//				System.out.print(j + " ");
//			}
//			System.out.println();
//		}
		//3번
//		int[][] seat = new int[3][10];
//		int audience = 0;
//		for(int i = 0; i< seat.length;i++)
//		{
//			for(int j = 0;j<seat[i].length;j++)
//			{
//				seat[i][j] = (int)(Math.random()*2);
//				System.out.print(seat[i][j]+" ");
//				audience = seat[i][j]==1?audience+1:audience;
//			}
//			System.out.println();
//		}
//		System.out.println("현재 관객 수는 "+audience+"명");

		//4번
		// 배열을 사용하지 않고 개별학생의 평균을 구한다면?
		
//		int[][] student = new int[3][5];
//		for(int i = 0;i<student.length;i++)
//		{
//			int sum = 0;
//			for(int j = 0;j<student[i].length;j++)
//			{
//				student[i][j] = (int)(Math.random()*51)+50;
//				sum += student[i][j];
//			}
//			System.out.println((i+1)+"번 학생 점수 평균 : "+ (double)sum/student[i].length);
//		}
		
		//5번

//		String[] arr1 = {"Clubs", "Diamonds", "Hearts", "Spades"};
//		String[] arr2 = {"2","3","4", "5", "6","7","8","9","10","Jack","Queen","King","Ace"};
//		int ran1,ran2;
//		for(int i=0;i<5;i++)
//		{
//			ran1 = (int)(Math.random()*4);
//			ran2= (int)(Math.random()*13);
//			System.out.println(arr1[ran1]+"의 "+arr2[ran2]);
//		}
		
		//6번
//		3*5 크기의 2차원 배열 생성하고 초기값은 0으로 초기화
//		• 5개의 정수 1을 랜덤하게 배치
//		• 최종 배열 출력
//		
//		int[][] arr = new int[3][5];
//		int idx1 = 0, idx2 = 0;
//		
//		for(int j = 0; j < 5;j++)
//		{
//			// 최대값 = 2, 4  최소값 : 0
//			idx1 = (int)(Math.random()*3); // 첫번째 인덱스 번호
//			idx2 = (int)(Math.random()*5); // 두번째 인덱스 번호
//			if(arr[idx1][idx2] ==1)
//			{
//				j--;
//			}
//			else {arr[idx1][idx2] = 1;}
//			
//		}
//		
//		
//		for(int i = 0 ; i< arr.length;i++)
//		{
//			for(int j : arr[i])
//			{System.out.print(j+ " ");}
//			System.out.println();
//		}
		
		
	}

}
