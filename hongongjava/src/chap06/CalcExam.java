package chap06;

public class CalcExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator calc = new Calculator();
		
		calc.turnOn();
		int result = calc.plus(10,20);
		System.out.println("정수의 합 = "+result);
		
		System.out.println("실수의 합 = "+calc.plus(10.0, 20));
		
		System.out.println("20/2 결과 = "+calc.divide(20.0, 2.0));
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
//		int resultArr=calc.plus(arr);
//		System.out.println("배열의 합 : "+resultArr);
		int resultArr2=calc.plus(1,2,3,4,5,6,7,8,9,10);
		System.out.println("배열의 합 : "+resultArr2);
		calc.turnOff();
	}
}
