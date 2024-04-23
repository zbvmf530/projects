package chap07;

public class DmbExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DmbCellPhone334 myPhone = new DmbCellPhone334("갤럭시s23", "크림", 7);
		
		myPhone.powerOn();
		myPhone.turnOnDmb();
		myPhone.bell();
		myPhone.sendVoice("여보세요");
		myPhone.receiveVoice("안녕하세요. 서울지검 OOO형사입니다. 고객님의 계좌에서 돈이 빠져나갔습니다.");
		myPhone.sendVoice("보이스피싱 작작하세요.끊습니다.");
		myPhone.hangUp();
		
		myPhone.changeChannel(10);
		myPhone.turnOffDmb();
	}

}
