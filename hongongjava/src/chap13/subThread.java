package chap13;

import java.util.List;
import java.util.Vector;

public class subThread extends Thread{

	public static List<Board> list = new Vector<Board>();
	public static List<Board> rList = new Vector<Board>();
	public void setList(List<Board> vector) {rList = vector;}
	public void run() {
		try 
		{
			int rn = (int)(Math.random()*3);
			list.add(rList.get(rn));
			System.out.print("서브 리스트: ");
			for(int i=0;i<list.size();i++)
			{System.out.print(list.get(i)+"\t");}
			Thread.sleep(1000);
		}catch(InterruptedException e) {}
	}
}
