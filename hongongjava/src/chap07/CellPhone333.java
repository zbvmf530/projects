package chap07;

public class CellPhone333 {

	// 필드
	private String model;
	private String color;
	private int number;
	// 생성자
	CellPhone333(String model, String color){this.color = color;this.model=model;}
	CellPhone333(String model, String color,int number){this.color = color;this.model=model;this.number = number;}
	// 메소드
	void powerOn() {System.out.println("전원을 켭니다.");}
	void powerOff() {System.out.println("전원을 끕니다.");}
	void bell() {System.out.println("벨이 울립니다.");}
	void sendVoice(String message) {System.out.println("본인 : "+message);}
	void receiveVoice(String message) {System.out.println("상대방 : "+message);}
	void hangUp() {System.out.println("통화 종료");}
}
