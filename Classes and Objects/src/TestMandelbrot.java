import processing.core.PApplet;

public class TestMandelbrot extends PApplet{
	private double lowReal = -2.0;
	private double highReal = 1.0;
	private double realInterval = 0.02;
	private double lowImag = -1.0;
	private double highImag = 1.0;
	private double imagInterval = 0.02;
	public static void main(String[] args)
	{
		PApplet.main("TestMandelbrot");
	}
	public void settings()
	{
		fullScreen();
		size(600, 600);
	}
	public void setup()
	{
		background(255);
		drawSet();
	}
	public void draw()
	{
		
	}
	public void drawSet()
	{
		background(255);
		MandelbrotSet m = new MandelbrotSet(lowReal, highReal,
				realInterval, lowImag, highImag, imagInterval);
		//for each loop
		stroke(0, 0, 255);
		for(ComplexNumber c : m.getSet())
			ellipse(transformX(c.getReal()), transformY(c.getImaginary()), 8, 8);
		
	}
	
	public float transformX(double number)
	{
		float newX = (float)((number - lowReal)
				*(width/(highReal-lowReal)));
		return newX;
	}
	
	public float transformY(double number)
	{
		float newY = (float)((number - lowImag)
				*(height/(highImag-lowImag)));
		return height - newY; //flip the y axis
	}
	
	public void zoomIn(float x, float y)
	{
		double xShift = (highReal - lowReal)/4.0;
		double yShift = (highImag - lowImag)/4.0;
		lowReal = x - xShift;
		highReal = x + xShift;
		realInterval /= 2.0;
		lowImag = y - yShift;
		highImag = y + yShift;
		imagInterval /= 2.0;
		drawSet();
	}
	
	public void zoomOut(float x, float y)
	{
		double xShift = (highReal-lowReal);
		double yShift = (highImag-lowImag);
		lowReal = x - xShift;
		highReal = x + xShift;
		realInterval *= 2;
		lowImag = y - yShift;
		highImag = y + yShift;
		imagInterval *= 2;
		drawSet();
	}
	
	public void mouseClicked()
	{
		float mouseXTransformed = (float)(((mouseX/(float)width)*
				(highReal-lowReal))+lowReal);
		float mouseYTransformed = (float)((((height-mouseY)/(float)height)*
				(highImag-lowImag))+lowImag);
		if(mouseButton == LEFT)
			zoomIn(mouseXTransformed, mouseYTransformed);
		else if (mouseButton == RIGHT)
			zoomOut(mouseXTransformed, mouseYTransformed);
	}
	
	public void increaseResolution()
	{
		realInterval /= 2.0;
		imagInterval /= 2.0;
		drawSet();
	}
	
	public void decreaseResolution()
	{
		realInterval *= 2.0;
		imagInterval *= 2.0;
		drawSet();
	}
	
	public void keyPressed()
	{
		if(key == 'z')
			increaseResolution();
		else if (key == 'x')
			decreaseResolution();
		else if (key == 'q')
			exit();
	}
	
	
	
}
