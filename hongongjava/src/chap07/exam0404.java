package chap07;

public class exam0404 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		SupersonicAirplane sa = new SupersonicAirplane();
//		sa.takeOff();
//		sa.fly();
//		sa.flyMode = SupersonicAirplane.SUPERSONIC;
//		sa.fly();
//		sa.flyMode = SupersonicAirplane.NORMAL;
//		sa.land();
		
		Child ch = new Child();
		System.out.println(ch.getClass().getDeclaredClasses());
		System.out.println(ch);
//		Car car = new Car();
//		for(int i = 1; i<=5; i++)
//		{
//			int problemLocation = car.run();
//			
//			switch(problemLocation)
//			{
//			case 1:
//				System.out.println("앞왼쪽 HankookTire로 교체");
//				car.frontLeftTire = new Hankook("앞왼쪽", 15);
//				break;
//			case 2:
//				System.out.println("앞오른쪽 KumhoTire로 교체");
//				car.frontLeftTire = new Kumho("앞오른쪽", 13);
//				break;
//			case 3:
//				System.out.println("뒤왼쪽 HankookTire로 교체");
//				car.frontLeftTire = new Hankook("뒤왼쪽", 14);
//				break;
//			case 4:
//				System.out.println("뒤오른쪽 KumhoTire로 교체");
//				car.frontLeftTire = new Kumho("뒤오른쪽", 17);
//				break;
//				
//			}
//			System.out.println("---------------------------");
//		}
//		
//		SupersonicAirplane test = new SupersonicAirplane();
//		System.out.println(test.test);
//		Airplane test1 = test;
//		System.out.println(test1.a);
//		test = (SupersonicAirplane)test1;
//		System.out.println(test.test);

//		Driver driver = new Driver();
////		Bus bus = new Bus();
////		Taxi taxi = new Taxi();
//		
//		Vehicle[] test = new Vehicle[5];
//		Vehicle[] element = {new Vehicle(), new Bus(), new Taxi()};
//		for(int i = 0; i<5;i++)
//		{
//			int random = (int)(Math.random()*3);
//			test[i] = element[random];
//		}
//		driver.drive(test);
//      driver.drive(bus);
		
//		driver.drive(taxi);
	}

}
