package chap07;

public class DmbCellPhone334 extends CellPhone333{

	int channel;
	
	DmbCellPhone334(String model,String color, int channel){super(model,color);this.channel=channel;}
	DmbCellPhone334(String model,String color, int number, int channel){super(model,color,number);this.channel=channel;}
	@Override
	void bell() {
		// TODO Auto-generated method stub
		super.bell();
	}
	@Override
	void hangUp() {
		// TODO Auto-generated method stub
		super.hangUp();
	}
	void changeChannel(int channelnum) {this.channel = channelnum;System.out.println(this.channel+"번 채널로 변경했습니다.");}
	void turnOffDmb() {System.out.println("dmb송출 종료");}
	void turnOnDmb() {System.out.println("dmb송출 시작. 채널 : "+this.channel);}
}
