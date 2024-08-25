package Functions;

public class LinearFunction implements Function{

	private int a, b;
	
	public LinearFunction(int a, int b) 
	{
	this.a=a;
	this.b=b;
	}
	
	@Override
	public String toString() 
	{
		String f = a+"x";
		if(b > 0)
			f+="+"+b;
		else
			f+="-"+Math.abs(b);
		return f;
	}
	
	@Override
	public int getValue(int x) {
		return a*x+b;
	}

	
}
