package chap11;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class ApiExam {

	public static void main(String[] args) throws IOException {
//		String str = "api 연습";
//		System.out.println(str);
//		
//		Object obj1 = new Object();
//		Object obj2 = new Object();
//		
//		if(obj1.equals(obj2)) {System.out.println("같음");}
//		else {System.out.println("다름");}
//		
//		
//		if(obj1==obj2) {System.out.println("같음");}
//		else {System.out.println("다름");}
//		
//		System.out.println(obj1.hashCode());
//		System.out.println(obj2.hashCode());
//		System.out.println();
//		System.out.println(obj1.getClass());
//		System.out.println(obj2.getClass());
//		System.out.println();
//		System.out.println(obj1.toString());
//		System.out.println(obj2.toString());
		
//		SmartPhone mp = new SmartPhone("구글", "안드로이드");
//		
//		System.out.println(mp.toString());
		
//		double time = System.currentTimeMillis();
//		
//		double sum = 0;
//		
//		for(long i=1; i<=10000000000l;i+=1)
//		{sum+=i;}
//		double time2 = System.currentTimeMillis();
//		
//		System.out.printf("소요 시간 : %.10f초",(time2-time)/1000);
		
		
		// 바이트 -> 스트링 변환
//		byte[] bytes = {72,101,108,108,111,32,74,97,118,97};
//		
//		String str1= new String(new byte[] {bytes[2],bytes[4],bytes[8],bytes[1]});
//		System.out.println(str1);
//		
//		
//		String str2= new String(bytes,6,4);
//		System.out.println(str2);
//		
//		byte[] bytes2 = new byte[100];
//		
//		System.out.print("입력: ");
//		int readByteNo = System.in.read(bytes2);
//		
//		String str3 = new String(bytes2,0,readByteNo-2);
//		System.out.println(str3);
		
		// byte 배열 
//		String str = "안녕하세요";
//		byte[] bytes1 = str.getBytes();
//		System.out.println("bytes1.length: "+bytes1.length);
//		String str1 = new String(bytes1);
//		System.out.println("bytes1->String: "+str1);
//		
//		try {
//			byte[] bytes2 = str.getBytes("EUC-KR");
//			System.out.println("bytes2.length: "+bytes2.length);
//			String str2 = new String(bytes2,"EUC-KR");
//			System.out.println("bytes2->String: "+str2);
//			
//			byte[] bytes3 = str.getBytes("MS949");
//			System.out.println("bytes3.length: "+bytes2.length);
//			String str3 = new String(bytes3,"MS949");
//			System.out.println("bytes3->String: "+str3);
//			
//		}catch(UnsupportedEncodingException e) {e.printStackTrace();}
		
//		Integer obj1=100;
//		Integer obj2=100;
//		Integer obj3=300;
//		Integer obj4=300;
//		
//		System.out.println(obj1==obj2);
//		System.out.println(obj3==obj4);
		
//		ApiExam Ax = new ApiExam();
//		ApiExam.Member member =  Ax.new Member("blue", "이파란");
//		System.out.println(member);
		
//		byte[] bytes = {73,32,108,111,118,101,32,121,111,117};
//		String str = new String(bytes);
//		System.out.println(str);
		
//		String str = "모든 프로그램은 자바 언어로 개발될 수 있다.";
//		int index = str.indexOf("자바");
//		if(index == -1) {System.out.println("자바 문자열이 포함되어 있지 않다.");}else {System.out.println("자바 문자열이 포함되어 있습니다.");str=str.replace("자바","Java");System.out.println("-->"+str);}
//		Student st1=new Student(),st2=new Student();
//		
//		if()
	}

	public class Member{
		
		private String id;
		private String name;
		
		public Member(String id, String name) {this.id=id;this.name=name;}
		@Override
		public String toString() {
			return this.id+": "+this.name;
		}
	}
}
