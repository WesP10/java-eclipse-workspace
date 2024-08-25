
public class Character extends java.lang.Object{

	private Color color;
	private float size, x, y;
	
	
	
	public Color getColor() {
		return color;
	}



	public void setColor(Color color) {
		this.color = color;
	}



	public float getSize() {
		return size;
	}



	public void setSize(float size) {
		this.size = size;
	}



	public float getX() {
		return x;
	}



	public void setX(float x) {
		this.x = x;
	}



	public float getY() {
		return y;
	}



	public void setY(float y) {
		this.y = y;
	}



	public Character(float x, float y, float size, Color color) 
	{
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;
	}

	public void grow() 
	{
		size ++;
	}
	
	public boolean collidingWith(Circle circle){
	    double xDiff = x - circle.getX();
	    double yDiff = y - circle.getY();

	    double distance = Math.sqrt((Math.pow(xDiff, 2) + Math.pow(yDiff, 2)));

	    return distance < ((size/2) + (circle.getSize()/2));
	}
	
	public void moveCharacter(int mouseX, int mouseY) 
	{
		setX(mouseX);
		setY(mouseY);
	}	
}
