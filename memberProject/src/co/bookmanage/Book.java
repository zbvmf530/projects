package co.bookmanage;

public class Book {
	// 필드
	// 도서번호, 제목, 저자, 가격
	private int bookNo, price;
	private String title, author;
	
	// 메소드
	public void setBookNo(int bookNo) {this.bookNo = bookNo;}
	
	public void setPrice(int price) {this.price = price;}
	
	public void setTitle(String title) {this.title = title;}
	
	public void setAuthor(String author) {this.author = author;}
	
	public int getBookNo() {return bookNo;}
	
	public int getPrice() {return price;}
	
	public String getTitle() {return title;}
	
	public String getAuthor() {return author;}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
