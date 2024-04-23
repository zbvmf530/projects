package Chap08;

public class SmartTelevision implements  Searchable{

	int volume;
	@Override
	public void search(String url) {
		// TODO Auto-generated method stub
		System.out.println(url + "을 검색합니다.");
	}

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("TV를 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		// TODO Auto-generated method stub
		if(volume>RemoteControl.MAX_VOLUME) {this.volume = RemoteControl.MAX_VOLUME;}
		else if(volume<RemoteControl.MIN_VOLUME) {this.volume = RemoteControl.MIN_VOLUME;}
		else {this.volume = volume;}
		System.out.println("현재 TV 볼륨: "+this.volume);
	}
	
}
