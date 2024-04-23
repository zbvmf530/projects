package challenge06;

public class Dice {

	
	//	① 주사위 눈 발생 클래스 작성
	int[] generateDiceNumber() 
	{
		int[] num = {(int)(Math.random()*6)+1, (int)(Math.random()*6)+1};
		return num;
	}
}
