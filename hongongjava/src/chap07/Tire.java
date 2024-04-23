package chap07;

public class Tire {
	// 필드
	String location;
	int maxRotation;
	int accumulatedRotation;
	
	// 생성자
	Tire(String location, int maxRotation){this.location = location;this.maxRotation = maxRotation;}
	
	// 메소드
	public boolean roll() 
	{
		++this.accumulatedRotation;
		if(accumulatedRotation<maxRotation) 
		{
			System.out.println(location+" Tire 수명: "+(maxRotation-accumulatedRotation)+"회");
			return true;
		}
		else 
		{
			System.out.println("*** "+location+" Tire 펑크 ***");
			return false;
		}
	}
}
