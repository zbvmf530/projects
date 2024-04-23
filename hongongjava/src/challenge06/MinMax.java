package challenge06;

public class MinMax {


	double getMin(double[] arr) 
	{
		double result = 100.0;
		for(double i : arr)
		{
			result = result>i?i:result;
		}
		return result;
	}
	
}
