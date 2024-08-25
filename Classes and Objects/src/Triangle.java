
public class Triangle {

	private double sideOne, sideTwo, sideThree;

	public double getSideOne() {
		return sideOne;
	}

	public void setSideOne(double sideOne) {
		this.sideOne = sideOne;
	}

	public double getSideTwo() {
		return sideTwo;
	}

	public void setSideTwo(double sideTwo) {
		this.sideTwo = sideTwo;
	}

	public double getSideThree() {
		return sideThree;
	}

	public void setSideThree(double sideThree) {
		this.sideThree = sideThree;
	}
	
	public Triangle(double sideOne, double sideTwo, double sideThree) 
	{
		if(sideOne <= 0 || sideTwo <= 0 || sideThree <= 0)
			System.out.println("Invalid side length");
		else
		{
		this.sideOne = sideOne;
		this.sideTwo = sideTwo;
		this.sideThree = sideThree;
		}
	}
	
	public String isAnIsoscelesTriangle() 
	{
		if(sideOne == sideTwo || sideTwo == sideThree || sideOne == sideThree) 
		return "IS ISOSCELES";
		else
		return "IS NOT ISOSCELES";
	}
	
	public String isARightTriangle() 
	{
		if(sideOne*sideOne + sideTwo*sideTwo == sideThree*sideThree 
				&& sideOne < sideThree && sideTwo < sideThree)
			return "Is a right triangle";
		else if(sideOne*sideOne == sideTwo*sideTwo + sideThree*sideThree 
				&& sideOne > sideThree && sideOne > sideThree)
			return "Is a right triangle";
		else if(sideOne*sideOne + sideThree*sideThree == sideTwo*sideTwo 
				&& sideOne < sideTwo && sideTwo > sideThree)
			return "Is a right triangle";
		else
			return "Is not a right triangle";
	}
	
	public double getArea() 
	{
		double s = (sideOne + sideTwo + sideThree)/2;
		double area = Math.sqrt(s*(s-sideOne)*(s-sideTwo)*(s-sideThree));
		return area;
	}
	
	public boolean isCongruent(Triangle other) 
	{
		if(sideOne/sideTwo == other.sideOne/other.sideTwo && 
			sideOne/sideThree == other.sideOne/other.sideThree &&
			sideTwo/sideThree == other.sideTwo/other.sideThree)
			return true;
		else
			return false;
	}
	
	//@Override
	public boolean equals(Triangle other) 
	{
		if(sideOne == other.sideOne && sideTwo == other.sideTwo && sideThree == other.sideThree)
			return true;
		else
			return false;
	}
	

}
