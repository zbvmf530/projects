package chap0605;

public class HttpServeletExample 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		HttpServeletExample test = new HttpServeletExample();
		method(test.new LoginServlet());
		method(test.new FileDownloadServlet());
	}

	public static void method(HttpServlet servlet) {servlet.service();}

	public class LoginServlet extends HttpServlet {@Override public void service() {System.out.println("로그인합니다.");}}

	public class FileDownloadServlet extends HttpServlet {@Override public void service() {System.out.println("파일 다운로드합니다.");}}

}
