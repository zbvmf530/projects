package challenge06;

public class Car {
	
	String color;
	int gear=1;
	int speed=0;
	
	Car()
	{
		this.color="black";
		this.gear = 1;
		this.speed = 0;
	}
	void changeGear() 
	{
		this.gear+=1;
	}
	
	void speedUp() {
		this.speed +=10;
	}
	void speedDown() {this.speed -= 10;}
}
