package challenge06;

public class Tv {

	int channel = 7;
	int Volume = 30;
	boolean onOff;
	
	void print() 
	{
		if(this.isTvOn()) 
		{
			System.out.println("tv 채널은"+this.channel+", "+"볼륨은 "+this.Volume+" 입니다.");
		}
		else 
		{System.out.println("tv가 꺼져있습니다.");}
		return;
	}

	void channelUp() 
	{
		if(this.isTvOn())
		{
			this.channel+=1;
			this.getChannel();
		}
		return;
	}
	
	void channelDown() 
	{
		if(this.isTvOn())
		{
			this.channel-=1;
			this.getChannel();
		}
		return;
	}
	
	void setChannel(int channelNo) 
	{
		if(this.isTvOn())
		{
			this.channel=channelNo;
			this.getChannel();
		}
		return;
	}
	
	void volumeUp() 
	{
		if(this.isTvOn())
		{
			this.Volume+=1;
			this.getVolume();
		}
		return;
	}
	
	void volumeDown() 
	{
		if(this.isTvOn())
		{
			this.Volume-=1;
			this.getVolume();
		}
		return;
	}
	
	void getChannel() 
	{
		System.out.println();
		System.out.println("=====================");
		System.out.println("채널 : "+ this.channel);
		System.out.println("=====================");
		System.out.println();
		
	}
	void getVolume() 
	{
		System.out.println();
		System.out.println("=====================");
		System.out.println("볼륨 : "+ this.Volume);
		System.out.println("=====================");
		System.out.println();
	}
	void turnOnOff() 
	{
		if(this.isTvOn()){this.onOff=!this.onOff;}
		else {this.onOff=!this.onOff;this.getTvInfo();}
		
		return;
	}
	void getTvInfo() 
	{
		System.out.println();
		System.out.println("==========LG=========");
		this.getChannel();
	}
	boolean isTvOn() {return this.onOff;}
	
}
