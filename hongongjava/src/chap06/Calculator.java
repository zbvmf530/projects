package chap06;

public class Calculator {
	// field
	
	// constructor
	
	// method
	void turnOn() {System.out.println("계산기 켜짐");}
	void turnOff() {System.out.println("계산기 꺼짐");}
	
	int plus(int num, int num2) {return num+num2;}
//	int plus(int[] values) 
//	{
//		int sum=0;
//		
//		for(int val : values)
//		{sum += val;}
//		
//		return sum;
//	}
	
	int plus(int ... nums) 
	{
		int sum=0;
		
		for(int val : nums)
		{sum += val;}
		
		return sum;
	}
	double plus(double num, double num2) {return num+num2;}
	
	double divide(double num, double num2) {return num/num2;}
	
	
}
