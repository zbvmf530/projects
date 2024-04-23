package chap2;

public class Exam107 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1번
		/*
		 * byte byteValue = 10; char charValue = 'A';
		 * 
		 * int intValue = byteValue; int intValue2 = charValue; short shortValue =
		 * (short)charValue;
		 */
		/*
		 * // 2번 String strValue="A"; char var = (char)strValue;
		 */
		
		// 3번
		/*
		 * byte byteValue =10; float floatValue = 2.5f; double doubleValue = 5.7; float
		 * result = 5+floatValue; double dresult = 5+doubleValue; byte bresult =
		 * (byte)(byteValue+byteValue); // 정수 연산 최소단위 : int // 4번 short s1=1;short s2=2;
		 * short sresult = (short)(s1+s2);
		 * 
		 * // 5번 char c1='a'; char c2 = (char)(c1+1); System.out.println(c2); // 6번 int
		 * x=5;int y=2; double xresult = x/y; System.out.println(xresult);
		 */
		// 7번
		/*
		 * int x= 5; int y = 2; float result = (float)x/y; System.out.println(result);
		 */
		// 8번
		
		// 9번
		long var1 = 2L;
		float var2 = 1.8f;
		double var3 = 2.5;
		String var4= "3.9";
		int result = (int)(var1+var2+var3)+(int)(Double.parseDouble(var4));
		System.out.println(result);
		
		
		/*
		 * //10번 byte value = Byte.parseByte("10"); int value2 =
		 * Integer.parseInt("1000"); float value3 = Float.parseFloat("10"); double
		 * value4 = Byte.parseByte("10");
		 */
	}

}
