package 정수범;

public class Student implements Comparable<Student>{
	// Field
	private int id,score;
	private String name;
	
	// Constructor
	Student(){}
	Student(int id, String name, int score){this.id=id;this.name=name;this.score=score;}
	
	// Method
	public int getId() {return id;}
	public int getScore() {return score;}
	public String getName() {return name;}
	public void setId(int id) {this.id = id;}
	public void setScore(int score) {this.score = score;}
	public void setName(String name) {this.name = name;}
	
	public String toString() {return String.format("%d 학번 점수: %d점", id,score);}
	@Override
	public int compareTo(Student o) {return (this.score > o.score) ? 1 : -1;}
}
