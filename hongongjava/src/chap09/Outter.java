package chap09;

public class Outter {

	// field
	String field = "Outter-field";
	class Nested{
		String field = "Nested-field";
		
		void method() {System.out.println("Nested-method");}
		void print() 
		{
			System.out.println(this.field);
			this.method();
			System.out.println(Outter.this.field);
			Outter.this.method();
		}
	}
	
	
	
	
	
	
	// method
	void method() {System.out.println("Outter-method");}
	
	
}
