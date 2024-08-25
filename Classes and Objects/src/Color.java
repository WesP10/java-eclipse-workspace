
public class Color extends java.lang.Object{

	private int red, green, blue;

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}
	
	public boolean equals(Object other) 
	{
		if (other == null) return false;
		if (other.getClass() != this.getClass()) return false;
		
		double p = 0.000001;
		Color x = (Color) other;
		return Math.abs(this.red - x.red) <= p && Math.abs(this.green - x.green) <= p && Math.abs(this.blue - x.blue) <= p;
	}
	
	public Color(int red, int green, int blue) 
	{
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public Color() 
	{
		this.red = 255;
		this.green = 255;
		this.blue = 255;
	}

	
}
