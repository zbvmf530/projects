package chap09;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
//		A a = new A();
//		
//		A.B b = a.new B();
//		b.field1 = 3;
//		b.method1();
//		A.B.field2 = 20;
//		A.B.method2();
//		
//		
//		
//		A.C c = new A.C();
//		A.C c2 = new A.C();
//		c.field1 =3;
//		System.out.println(c.field1);
//		c2.field1 = 5;
//		System.out.println(c.field1);
//		c.method1();
//		A.C.field2 = 25;
//		A.C.method2();
//		
//		a.method();
		
//		Outter outter = new Outter();
//		Outter.Nested nested = outter.new Nested();
//		nested.print();
		
//		Button btn = new Button();
//		
//		btn.setOnClickListener(new CallListener());
//		btn.touch();
//		
//		btn.setOnClickListener(new MessageListener());
//		btn.touch();
		
		Anonymous anony = new Anonymous();
		
		anony.field.wake();
		
		anony.method1();
		
		anony.method2(
				new Person() 
				{
					void study() {System.out.println("공부합니다.");}
					
					@Override
					void wake() {System.out.println("8시에 일어납니다.");study();};
				}		
				);
	}

}
