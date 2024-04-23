package Chap08;

public interface RemoteControl {
	// 상수
	public int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0;
	
	// 추상메소드
	public abstract void turnOn();
	public abstract void turnOff();
	public abstract void setVolume(int volume);
}
