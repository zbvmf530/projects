package chap13;

public class Student {

	public int studentNum;
	public String name;
	
	public Student(int studentNum, String name) {this.studentNum=studentNum;this.name=name;}
	
	
	@Override
	public int hashCode() {
		return studentNum;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student)
		{
			Student inputStudent = (Student)obj;
			return studentNum==inputStudent.studentNum;
		}
		
		else{return false;}
	}
	@Override
	public String toString() {
		return String.format("%d:%s", studentNum,name);
	}
}
