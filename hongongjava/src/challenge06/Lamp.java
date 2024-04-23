package challenge06;

public class Lamp {

	boolean isOn;
	
	void turnOn() {this.isOn = true;System.out.println("불을 켰습니다!");return;}
	void turnOff(){this.isOn = false;System.out.println("불을 껏습니다!");return;}
	void state() 
	{
		String state = "현재상태 ";
		state += this.isOn?"켜짐":"꺼짐";
		System.out.println(state);
	}
}
