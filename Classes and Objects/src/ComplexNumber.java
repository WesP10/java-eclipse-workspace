

public class ComplexNumber {

	//instance variables
	private double Real, Imaginary;
	//gettters and setters
	public double getReal() {
		return Real;
	}

	public void setReal(double real) {
		this.Real = real;
	}

	public double getImaginary() {
		return Imaginary;
	}

	public void setImg(double Imaginary) {
		this.Imaginary = Imaginary;
	}
	//constructor for normal complex numbers
	public ComplexNumber(double Real, double Imaginary) 
	{
		this.Real = Real;
		this.Imaginary = Imaginary;
	}
	/*constructor for when no numbers are given
	 * sets real and imaginary number == 0 
	 * overloading is happening
	 */
	public ComplexNumber() 
	{
		Real = 0;
		Imaginary = 0;
	}
	
	//Re-assigning toString method to print in a+bi form
	@Override
	public String toString() 
	{
		String x;
		if(Imaginary < 0)
			x = "";
		else
			x = "+";
		
		String num = String.format("%.2f",Real) + x + String.format("%.2f",Imaginary) + "i";
		return num;
	}
	//adds two complex numbers
	public ComplexNumber plus(ComplexNumber complex)
	{
		return new ComplexNumber(this.Real + complex.Real, this.Imaginary + complex.Imaginary);
	}
	//multiplies two complex numbers
	public ComplexNumber times(ComplexNumber complex) 
	{
		return new ComplexNumber((this.Real*complex.Real) - (this.Imaginary*complex.Imaginary), (this.Real*complex.Imaginary) + (this.Imaginary*complex.Real));
	}
	//multiplies a complex number and a real number
	public ComplexNumber times(double n) 
	{
		return new ComplexNumber(Real*n, Imaginary*n);
	}
	//divides a complex number by a complex number
	public ComplexNumber dividedBy(ComplexNumber complex) 
	{
		//dividing by 0 isn't possible, this throws an exception if dividing by 0 is attempted
		if(complex.Real == 0 || complex.Imaginary == 0)
			throw  new  IllegalArgumentException();
		
		double numeratorR = (this.Real*complex.Real) - (this.Imaginary*(complex.Imaginary*-1));
		double numeratorI =  (this.Imaginary*(complex.Real)) + (this.Real*(complex.Imaginary*-1));
		double denomenator = (complex.Real*complex.Real) + (complex.Imaginary*complex.Imaginary);;
		
		float rn = (float)(numeratorR / denomenator);
		float in = (float)(numeratorI / denomenator);
		return new ComplexNumber(rn, in);
	}
	//raises a complex number to a whole number power
	public ComplexNumber pow(int x) 
	{
		ComplexNumber n = new ComplexNumber();
		n = this;
		if(x <= 0)
			throw new IllegalArgumentException();
		for(int j = 1; j < x; j++) 
		{
			n = this.times(n);
		}
		
		return n;
	}
	//returns the modulus of a complex number
	public double getModulus() 
	{
		return Math.sqrt((Real*Real)+(Imaginary*Imaginary));
	}
	//returns the conjugate of a complex number
	public ComplexNumber getConjugate() 
	{
		double in;
		if(Imaginary < 0)
			in = Math.abs(Imaginary);
		else
			in = -1*Imaginary;
		return new ComplexNumber(Real, in);
	}
	/*Overriding equals method
	 * first checks if there are 2 objects
	 * then checks if the two objects are from the same class
	 * then checks if the objects are of equal value
	 */
	@Override
	public boolean equals(Object x) 
	{
		if (x == null) return false;
		if (x.getClass() != this.getClass()) return false;
		
		double p = 0.000001;
		ComplexNumber X = (ComplexNumber) x;
		return Math.abs(this.Real - X.Real) <= p && Math.abs(this.Imaginary - X.Imaginary) <= p;
	}

	public ComplexNumber pow(ComplexNumber b) 
	{
		double e = Math.E;
		double r = Math.sqrt(Imaginary*Imaginary+Real*Real);
		double theta = Math.tanh(Imaginary/Real);
		double loge = Math.log(r);
		ComplexNumber p1 = b.times(loge);
		ComplexNumber p2 = b.times(new ComplexNumber(0, theta));
		return p1.plus(p2);
	}
	
	
	
}
