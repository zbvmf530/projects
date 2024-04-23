package chap12;

public class MovieThread extends Thread{
	
	@Override
	public void run() {
		while(true)
		{
			System.out.println("동영상을 재생합니다.");
//			if(Thread.interrupted()) 
//			{
//				break;
//			}
			try {Thread.sleep(1000);}catch(InterruptedException e) {}
		}
//		System.out.println("자원 정리");
//		System.out.println("작업 종료");	
	}
}
