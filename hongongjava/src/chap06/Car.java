package chap06;

public class Car {

	// 필드 : 객체의 데이터(속성)저장
	String company = "현대자동차";
	String model = "그랜저";
	String color = "검정";
	int maxSpeed = 350;
	int speed;
	
	// constructor(생성자) : 객체 생성(초기화)
	Car(String com, String mod, String col){this.company = com;this.model=mod;this.color=col;}
	// method : 동작(기능), 객체 간의 데이터 주고 받기
}
