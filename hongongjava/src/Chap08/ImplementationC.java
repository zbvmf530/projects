package Chap08;

public class ImplementationC implements InterfaceC{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ImplementationC impl = new ImplementationC();
		
		InterfaceA ia = impl; ia.methodA();
		System.out.println();
		InterfaceB ib = impl; ib.methodB();
		System.out.println();
		
		InterfaceC ic = impl;
		ic.methodA();
		ic.methodB();
		ic.methodC();
	}

	@Override
	public void methodA() {
		// TODO Auto-generated method stub
		System.out.println("ImplementationC-methodA() 실행");
	}

	@Override
	public void methodB() {
		// TODO Auto-generated method stub
		System.out.println("ImplementationC-methodB() 실행");
	}

	@Override
	public void methodC() {
		// TODO Auto-generated method stub
		System.out.println("ImplementationC-methodC() 실행");
	}

}
