package chap09;

import javax.swing.ButtonModel;

public class MessageListener implements Button.OnClickListener{

	@Override
	public void onClick() {System.out.println("메시지를 보냅니다.");}

}
