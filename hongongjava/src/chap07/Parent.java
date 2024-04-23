package chap07;

public class Parent {
	public String Nation;
	
	public Parent() 
	{
		this("대한민국");
		System.out.println("Parent() call");
	}
	
	public Parent(String nation) 
	{
		this.Nation = nation;
		System.out.println("Parent(String nation) call");
	}
}
