
public class TwoByTwoMatrix {
	//fields
	private double topLeft, topRight, bottomLeft, bottomRight;
	
	//getters
	public double getTopLeft() 
	{
		return topLeft;
	}
	public double getTopRight() 
	{
		return topRight;
	}
	public double getBottomLeft() {
		return bottomLeft;
	}
	public double getBottomRight() {
		return bottomRight;
	}
	
	//setters - set a new value for a field
	public void setTopLeft(double topLeft) 
	{
		this.topLeft = topLeft;
	}
	public void setBottomLeft(double bottomLeft) {
		this.bottomLeft = bottomLeft;
	}
	
	public void setBottomRight(double bottomRight) {
		this.bottomRight = bottomRight;
	}
	public void setTopRight(double topRight) {
		this.topRight = topRight;
	}
	
	//constructors - used to set intial state of class
	public TwoByTwoMatrix(double topLeft, double topRight, double bottomLeft, double bottomRight) 
	{
		this.topLeft = topLeft;
		this.topRight = topRight;
		this.bottomLeft = bottomLeft;
		this.bottomRight = bottomRight;
	}
	
	//when you have 2 or more methods with the same name
	//but different parameter signatures - overloading
	public TwoByTwoMatrix() 
	{
		/*
		 * super(); 
		 * calling the "Object" constructor
		 */
	}
	
	//determinant 
	public double getDeterminant() 
	{
		return (topLeft * bottomRight) - (topRight * bottomLeft);
	}
	
	//addition - one paramete - other matrix
	//return - a matrix that is the sum of this and other
	public TwoByTwoMatrix addition(TwoByTwoMatrix other) 
	{
		return new TwoByTwoMatrix (topLeft + other.topLeft, topRight + other.topRight,
				bottomLeft + other.bottomLeft, bottomRight + other.bottomRight);
	}
	
	//multiply - one parameter - double factor
	//return - a new matrix where each value is multiplied by the factor
	public TwoByTwoMatrix multiply(double x) 
	{
		return new TwoByTwoMatrix(topLeft*x, topRight*x, bottomLeft*x, bottomRight*x);
	}
	
	//inverse - no parameters
	//return the inverse of a matrix (use the getDeterminant() method we wrote)
	public TwoByTwoMatrix getInverse() throws Exception 
	{
		//defensive programming - defense is the best offense
		if(getDeterminant() == 0)
			throw new Exception("Inverse doesn't exist");
		return new TwoByTwoMatrix
			(bottomRight, -topRight, -bottomLeft, topLeft).multiply(1/getDeterminant());
	}
	
	//overloading is when you 2 methods with the snae name and differnet parameters
	public TwoByTwoMatrix multiply(TwoByTwoMatrix other) 
	{
		return new TwoByTwoMatrix(
				topLeft*other.topLeft+topRight*other.bottomLeft, 
				topLeft*other.topRight+topRight*other.bottomRight,
				bottomLeft*other.topLeft + bottomRight*other.bottomLeft,
				bottomLeft*other.topRight+bottomRight*other.bottomRight
				);
	}
	
	@Override
	public boolean equals(Object other) 
	{
		//always add these first 2 conditions
				if (other == null) return false;
				if (other.getClass() != this.getClass()) return false;
				
				double p = 0.000001;
				TwoByTwoMatrix x = (TwoByTwoMatrix) other;
				return Math.abs(topLeft - x.topLeft) <= p && topRight == x.topRight &&
						bottomLeft == x.bottomLeft && bottomRight == x.bottomRight;
	}
	
	//overriding - when you have a method with the same name and same parameter 
	//signature as one in the parent class ( in this cas Object) and give it a new behavior
	//@Override lets you know if you messed up
	@Override
	public String toString() 
	{
		String str = "[" + topLeft + "\t" + topRight + "]\n" +
						"[" + bottomLeft + "\t"  + bottomRight + "]";
		return str;
	}
	
	
	
	
}
