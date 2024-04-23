package chap0605;

public class Controller {

	
	int test = 0;
	
	public Service service;
	public void setService(Service service) {this.service = service;}
	
	
	
	public class Service
	{
		public void login() {System.out.println("로그인");}
		public Service(){};
	}
	public class MemberService extends Service
	{
		public MemberService(){};
	
		@Override
		public void login() {
			System.out.print("멤버 ");super.login();}
	}
	public class AService extends Service{
	
		public AService() {};
		@Override
		public void login() {System.out.print("A ");super.login();}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controller controller = new Controller();
		
		controller.setService(controller.new MemberService());
		controller.service.login();
		controller.setService(controller.new AService());
		controller.service.login();
	}

}
