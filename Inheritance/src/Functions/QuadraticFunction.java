package Functions;

public class QuadraticFunction implements Function{

	private int a, b, c;
	
	public QuadraticFunction(int a, int b, int c) 
	{
		this.a=a;
		this.b=b;
		this.c=c;
	}
	
	@Override
	public String toString() 
	{
		String f = a+"x^2";
		if(b > 0)
			f+="+"+b+"x";
		else
			f+="-"+Math.abs(b)+"x";
		if(c > 0)
			f+="+"+c;
		else
			f+="-"+Math.abs(c);
		return f;
	}

	@Override
	public int getValue(int x) {
		return a*x*x+b*x+c;
	}
	
}
