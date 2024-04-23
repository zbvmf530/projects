package chap09;

public class A {
	// field
	class B{
		// A.B field
		int field1;
		static int field2;
		
		// A.B constructor
		B(){System.out.println("B 객체가 생성됨");}
		
		// A.B method
		void method1() {System.out.println("new A().new B().method1()");}
		static void method2() {System.out.println("A.B.method2()");}
	}
	
	static class C{
		// A.C field
		int field1;
		static int field2;
		
		// A.C constructor
		C(){System.out.println("C 객체가 생성됨");}
		
		// A.C method
		void method1() {System.out.println("new A().C.method1()");}
		static void method2() {System.out.println("A.C.method2()");}
	}
	
	// constructor
	A(){System.out.println("A 객체가 생성됨");}
	
	
	
	// method
	void method() {
		class D {
			// A().method->D field
			int field1;
			static int field2;

			// A().method->D constructor
			D() {System.out.println("D 객체가 생성됨");}

			// A().method->D method
			void method1() {System.out.println("new A().method()->new D().method1()");}

			static void method2() {System.out.println("new A().method()->D.method2()");}
		}
	D d = new D();
	d.field1 =3;
	D.field2 = 30;
	d.method1();
	D.method2();
	}
}
