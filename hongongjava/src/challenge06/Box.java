package challenge06;

public class Box {

	int width;
	int height;
	int length;
	
	Box(){}
	Box(int width)
	{this(width,10,10);}
	
	Box(int width,int height)
	{this(width,height,10);}
	
	Box(int width,int height, int length)
	{this.width = width;this.height=height;this.length = length;}
	
	double volume() {return this.width*this.height*this.length;}
}
