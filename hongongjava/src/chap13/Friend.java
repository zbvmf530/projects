package chap13;

public class Friend {

	private String name,tel,addr;
	Friend(){}
	Friend(String name, String tel, String addr){this.name=name;this.tel=tel;this.addr=addr;}
	
	
	@Override
	public String toString() {
	
		return "이름: " + this.name+"\t전화번호: " + this.tel+"\t주소: "+this.addr;
	}
}
