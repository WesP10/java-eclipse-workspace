package shapes;

public class Triangle extends Shape{

	public Triangle(double x, double y, double width, double height) {
		super(x, y, width, height, 3);
	}

	@Override
	public double getArea() {
		return getWidth()*getHeight()*0.5;
	}

	@Override
	public double getPerimeter() {
		return Math.hypot(getWidth(), getHeight()) + getWidth() + getHeight();
	}

	
}
