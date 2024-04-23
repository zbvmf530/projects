package chap12;

public class ThreadNameExam {

	public static void main(String[] args) {
//		Thread mainThread = Thread.currentThread();
//		System.out.println("프로그램 시작 스레드 이름: "+mainThread.getName());
//		
//		ThreadA threadA = new ThreadA();
//		System.out.println("작업 스레드 이름: "+threadA.getName());
//		threadA.start();
//		
//		ThreadB threadB = new ThreadB();
//		System.out.println("작업 스레드 이름: "+threadB.getName());
//		threadB.start();
		
//		Calculator calculator = new Calculator();
//		
//		
//		User1 user1 = new User1();
//		user1.setCalculator(calculator);
//		user1.start();
//		
//		User2 user2 = new User2();
//		user2.setCalculator(calculator);
//		user2.start();
		
//		Daemon daemon = new Daemon();
//		daemon.setDaemon(true);
//		daemon.start();
//		
//		try {Thread.sleep(3006);}catch(InterruptedException e) {}
//		System.out.println("메인스레드 종료");
		
		
		Thread thread = new MovieThread();
		thread.setDaemon(true);
		thread.start();
		
		try {Thread.sleep(3000);}catch(InterruptedException e) {}
		
//		thread.interrupt();
		System.out.println("interrupted in main: "+thread.interrupted());
	}

}
