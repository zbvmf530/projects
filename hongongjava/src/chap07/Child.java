package chap07;

public class Child extends Parent{

	private String name;
	private Parent parent;
	public Child()
	{
//		parent = super.getClass().clo;
		this("홍길동");
		System.out.println("Child() call");
		
	}
	
	public Child(String name)
	{
		this.name=name;
		System.out.println("Child(String name) call");
	}
}
