package chap07;

public class Hankook extends Tire{

	public Hankook (String location, int maxRotation)
	{
		super(location,maxRotation);
	}
	
	
	@Override
	public boolean roll() {
		++this.accumulatedRotation;
		if(accumulatedRotation<maxRotation) 
		{
			System.out.println(location+" HankookTire 수명: "+(maxRotation-accumulatedRotation)+"회");
			return true;
		}
		else 
		{
			System.out.println("*** "+location+" HankookTire 펑크 ***");
			return false;
		}
	}
}
