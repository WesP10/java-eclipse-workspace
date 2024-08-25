package shapes;

//implements is for interfaces
//extends is for classes
public abstract class Shape implements Comparable<Shape>, Movable {
	private double x, y;
	private double width, height; //bounding box
	private int numSides;
	
	public Shape(double x, double y, double width, double height, int numSides) 
	{
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.numSides=numSides;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getNumSides() {
		return numSides;
	}
	//abstract method
	public abstract double getArea();
	
	public abstract double getPerimeter();
	
	public void printInfo() 
	{
		System.out.println("Number of Sides: " + numSides);
		System.out.println("Coordinates: (" + x + ", " + y +")");
		System.out.println("Area: " + getArea());
		System.out.println("Perimeter: " + getPerimeter());
	}
	
	@Override
	public int compareTo(Shape e) 
	{
		if(e == null) throw new NullPointerException("Object can't be null");
		
		double dif = this.getArea() - e.getArea();
		if(dif > 0) return 1;
		if(dif < 0) return -1;
					return 0;
	}
	
	@Override
	public void move(double newX, double newY) 
	{
		this.x=newX;
		this.y=newY;
	}
	
}
