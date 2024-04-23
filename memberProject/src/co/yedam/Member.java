package co.yedam;

public class Member {
	// 필드 : 회원번호,이름,연락처,생일,성별
	private int No;
	private String name, phone, birth, gender;
	public void setNo(int empNo) {
		this.No = empNo;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getNo() {
		return No;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getBirth() {
		return birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%3d\t%-10s\t%-13s\t%-10s\t%s\n",this.getNo(),this.getName(),this.getPhone(),this.getBirth(),this.getGender());
	}
}
