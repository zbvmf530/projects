package chap07;

public class SupersonicAirplane extends Airplane{
	
	public static final int NORMAL = 1;
	public static final int SUPERSONIC = 2;
	public int flyMode = NORMAL;
	public int test = 123;
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		if(flyMode == SUPERSONIC)
		{
			System.out.println("초음속비행합니다.");
		}
		else {super.fly();}
		
		
	}
}
