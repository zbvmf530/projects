package chap0605;

public class ShopService {
	// 필드
	static ShopService shopservice = new ShopService();
	// 생성자
	private ShopService() {}
	// 메소드
	static ShopService getInstance() {return shopservice;}
}
