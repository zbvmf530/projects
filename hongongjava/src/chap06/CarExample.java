package chap06;

public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Car 클래스를 활용하는 실행 클래스
		Car mycar = new Car("현대","g90","흰색");
		System.out.println("모델명 : "+mycar.model + ", 제조회사 : "+mycar.company + ", 색상 : "+mycar.color + ", 최고 속도 : "+ mycar.maxSpeed);
	}

}
