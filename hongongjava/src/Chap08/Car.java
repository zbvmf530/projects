package Chap08;

public class Car {
  public Tire frontLeftTire = new HankookTire(); 
  public Tire frontRightTire = new HankookTire(); 
  public Tire backLeftTire = new HankookTire(); 
  public Tire backRightTire = new HankookTire();
  
  void run() 
  {
//	  frontLeftTire = tire[0];
//	  frontRightTire = tire[1];
//	  backLeftTire = tire[2];
//	  backRightTire = tire[3];

	  this.frontLeftTire.roll();
	  this.frontRightTire.roll();
	  this.backLeftTire.roll();
	  this.backRightTire.roll();
  }
}
