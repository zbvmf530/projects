package chap11;

public class Student {

	
	private String studentNum="test";
	
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		return this.equals(this.studentNum.equals(obj));
	}
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.studentNum.hashCode();
	}
}
