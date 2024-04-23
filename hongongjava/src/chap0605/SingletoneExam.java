package chap0605;

public class SingletoneExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Singleton sing = new Singleton();
//		Singleton st = Singleton.getInstance();
//		Singleton st2 = Singleton.getInstance();
//		
//		if(st == st2)
//		{
//			System.out.println("같음!");
//			System.out.println("주소값(st) : "+st);
//			System.out.println("주소값(st2) : "+st2);
//		}
//		else
//		{System.out.println("다름! 주소값은 "+st);}
		ShopService obj1 = ShopService.getInstance();
		ShopService obj2 = ShopService.getInstance();
		
		if(obj1==obj2){System.out.println("같은 ShopService 객체입니다.");}
		else{System.out.println("다른 ShopService 객체입니다.");}
	}

}
