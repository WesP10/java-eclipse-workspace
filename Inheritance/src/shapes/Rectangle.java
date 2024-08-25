package shapes;

public class Rectangle extends Shape{

	public Rectangle(double x, double y, double width, double height) {
		super(x, y, width, height, 4);
	}

	@Override
	public double getArea() {
		return getWidth()*getHeight();
	}

	@Override
	public double getPerimeter() {
		return 2*(super.getWidth()+super.getHeight());
	}

	
}
