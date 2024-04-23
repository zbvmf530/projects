package chap12;

public class PrintThread2 extends Thread{

	public void run() 
	{
		while(true) 
		{
			System.out.println("실행중");
			if(Thread.interrupted()) 
			{
				System.out.println("interrupted in run method : "+Thread.interrupted());
				break;
			}
		}
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}
}
