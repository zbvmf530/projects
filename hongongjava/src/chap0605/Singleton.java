package chap0605;

public class Singleton {

	// 싱글톤 : 프로그램 전체에 오직 하나의 객체만 생성하는 기법
	// 자신의 클래스 안에서 한번 객체 생성
	// 외부에서 객체를 생성할 수 없음
	// 외부에서는 메소드를 통해서 객체를 전달 받아야 함 -> getInstance()
	
	
	// 객체를 필드 값으로 넣은 상태
	private static Singleton singletone = new Singleton();
	
	// constructor
	private Singleton() {};
	
	static Singleton getInstance() {return singletone;}
}
