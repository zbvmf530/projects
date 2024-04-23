package Chap08;



public class Chap08Exam {

	public static void main(String[] args) {

		
		
		
//		int i = 10;
//		for(int k=2;k<=9;k++)
//		{System.out.printf("%2dx%d=%2d", k,i,k*i);}
//		
//		int num = (int)(Math.random()*16)+5;
//		System.out.println(num);
		
		
//		int[] array = {1,5,3,8,2};
//		
//		int max = array[0];
//		
//		for(int i = 1 ; i < 5; i++)
//		{
//			if(max<array[i])
//			{
//				max = array[i];
//			}
//		}
//		System.out.println("max: "+max);
		
		int[][] array = {
			{95,86},{83,92,96},{78,83,93,87,88}
		};
		
		
		int sum = 0;
		double avg = 0.0;
		int count = 0;
		
		for(int i = 0; i<array.length;i++)
		{
			for(int j = 0; j<array[i].length;j++)
			{
				sum += array[i][j];
				count++;
			}
		}
		avg=(double)sum/count;
		System.out.println("sum: "+ sum);
		System.out.println("avg: "+ avg);
		
		
		
		
		
		
		
		
		
		
		
//		Car myCar = new Car();
//		Tire[] tires = {myCar.frontLeftTire, myCar.frontRightTire, myCar.backLeftTire, myCar.backRightTire};
//		
//		
//		Tire[] typeTire = new Tire[2];
//		typeTire[0] = new HankookTire();
//		typeTire[1] =new KumhoTire();
//		
//		System.out.println(tires[0]);
//		System.out.println(tires[1]);
//		System.out.println(tires[2]);
//		System.out.println(tires[3]);
//		System.out.println();
//		System.out.println(myCar.frontLeftTire);
//		System.out.println(myCar.frontRightTire);
//		System.out.println(myCar.backLeftTire);
//		System.out.println(myCar.backRightTire);
//		
////		System.out.println(tires[0]);
//		for(int i=0;i<4;i++)
//		{
//			int randomTire = (int)(Math.random()*2);
//
//			tires[i] = typeTire[randomTire];
//
//		}
//
//		tires[0] = new KumhoTire();
//		
//		System.out.println(myCar.frontLeftTire);
//		myCar.frontLeftTire.roll();
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		RemoteControl rc;
//		rc = new Television();
//		rc.turnOn();
//		rc.setVolume(50);
//		rc.setVolume(-5);
//		rc.setVolume(8);
//		rc.turnOff();
//		
//		System.out.println(rc.getClass());
//		
//		rc = new Audio();
//		rc.turnOn();
//		rc.setVolume(70);
//		rc.setVolume(-4);
//		rc.setVolume(6);
//		rc.turnOff();		
//		
//		System.out.println(rc.getClass());

//		SmartTelevision tv= new SmartTelevision();
//		
//		Searchable searchable = tv;
//		
//		searchable.turnOn();
//		searchable.setVolume(100);
//		searchable.setVolume(-100);
//		searchable.setVolume(5);
//		searchable.search("http://www.naver.com");

//		Chap08Exam test = new Chap08Exam();
//		test.printSound(test.new Cat());
//		test.printSound(test.new Dog());



		//		Chap08Exam dbworkTest = new Chap08Exam();
//		Chap08Exam.dbWork(dbworkTest.new OracleDao());
//		System.out.println();
//		Chap08Exam.dbWork(dbworkTest.new MySqlDao());

	}

//	public static void dbWork(DataAccessObject dao) {
//		dao.select();
//		dao.insert();
//		dao.update();
//		dao.delete();
//	}

//	public class OracleDao implements DataAccessObject {
//
//		@Override
//		public void insert() {System.out.println("Oracle DB에 삽입");}
//
//		@Override
//		public void update() {System.out.println("Oracle DB를 수정");}
//
//		@Override
//		public void select() {System.out.println("Oracle DB에서 검색");}
//
//		@Override
//		public void delete() {System.out.println("Oracle DB에서 삭제");}
//	}
//
//	public class MySqlDao implements DataAccessObject {
//
//		@Override
//		public void insert() {System.out.println("Mysql DB에 삽입");}
//
//		@Override
//		public void update() {System.out.println("Mysql DB를 수정");}
//
//		@Override
//		public void select() {System.out.println("Mysql DB에서 검색");}
//
//		@Override
//		public void delete() {System.out.println("Mysql DB에서 삭제");}
//	}
//	private static void printSound(Soundable soundable){System.out.println(soundable.sound());}
//	
//	public class Cat implements Soundable{@Override public String sound() {return "야옹";}}
//	
//	public class Dog implements Soundable{@Override public String sound() {return "멍멍";}}
}
