package chap10;

public class TryCatchFinally {

	public static void main(String[] args) {

		
		
		
		// args에 값 안넣고 실행
		// 값 넣고 실행
		String data1 = null, data2 = null;
		
		try {
			data1= args[0];data2=args[1];
		}catch(ArrayIndexOutOfBoundsException e) {System.out.println("실행 매개값의 수가 부족합니다.");}
		
		
		// 숫자가 아닌 잘못된 값 넣고 실행
		try {
			int num1 = Integer.parseInt(data1);
			int num2 = Integer.parseInt(data2);		
			System.out.println();
		}catch(NumberFormatException e) {System.out.println("숫자로 변환할 수 없습니다.");}
		finally {System.out.println("다시 실행하세요.");}
		// 정확한 값 넣고 실행
		
	}

}
