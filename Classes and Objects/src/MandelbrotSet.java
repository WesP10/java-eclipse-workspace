import java.util.ArrayList;

public class MandelbrotSet {
	
	private ArrayList<ComplexNumber> set;
	/**
	 * No parameter constructor - set will be
	 * based on (-2, 1) in the real plane
	 * and (-1, 1) in the imaginary plane
	 */
	public MandelbrotSet()
	{
		set = new ArrayList<ComplexNumber>();
		generateSet(-2.0, 1.0, 0.03, -1.0, 1.0, 0.03);
	}

	/**
	 * 6 parameter constructor
	 * @param lowR
	 * @param highR
	 * @param realInterval
	 * @param lowI
	 * @param highI
	 * @param imagInterval
	 */
	public MandelbrotSet(double lowR, double highR,
			double realInterval, double lowI, double highI,
			double imagInterval)
	{
		set = new ArrayList<ComplexNumber>();
		generateSet(lowR, highR, realInterval, 
				lowI, highI, imagInterval);
	}
	
	public void generateSet(double lr, double hr, double ri,
		double li, double hi, double ii)
	{
		for(double real = lr; real <= hr; real += ri)
		{
			for(double imag = li; imag <= hi; imag += ii)
			{
				ComplexNumber c = new ComplexNumber(real, imag);
				if(isInSet(c))
					set.add(c);
			}
		}
	}
	
	public boolean isInSet(ComplexNumber c)
	{
		ComplexNumber z0 = new ComplexNumber();
		ComplexNumber z1 = new ComplexNumber();
		int maxIterations = 100; //the higher this value the less
		//false positives
		int iteration = 0;
		while(iteration < maxIterations)
		{
			z1 = z0.times(z0).plus(c);
			z0 = z1; //save the value
			iteration++;
		}
		return z1.getModulus() <= 2;
//		if(z1.getModulus() <= 2)
//			return true;
//		else
//			return false;
	}
	
	public ArrayList<ComplexNumber> getSet()
	{
		return set;
	}
	
	
}
