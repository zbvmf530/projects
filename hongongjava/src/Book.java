package challenge;

public class Book {
	private int num;
	private String title;
	private int price;
	public int getNum() {return num;}
	public String getTitle() {return title;}
	public int getPrice() {return price;}
	public void setNum(int num) {this.num = num;}
	public void setTitle(String title) {this.title = title;}
	public void setPrice(int price) {this.price = price;}
	
	
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("도서번호 : %d 가격 : %d원", num,price);
	}
}
