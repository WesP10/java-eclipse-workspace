
public class Circle extends java.lang.Object{

	private int height, width;
	private float x, y, vx, vy, size;
	private Color color;
	
	public double densityOfSpawning = 0.25;
	public double circleSpeed = 3;
	public float circleSizeM = 2;
	public int circleColorOffset = 1;
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
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
	public float getVx() {
		return vx;
	}
	public void setVx(float vx) {
		this.vx = vx;
	}
	public float getVy() {
		return vy;
	}
	public void setVy(float vy) {
		this.vy = vy;
	}
	public float getSize() {
		return size;
	}
	public void setSize(float size) {
		this.size = size;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void move() 
	{
		setX(getX()+getVx());
		setY(getY()+getVy());
	}
	
	public void respawn(float playerSize) 
	{
		float max = playerSize - (playerSize/circleSizeM);
		float min = playerSize + (playerSize/circleSizeM);
		setSize((float)(Math.random()*(max - min)+min));
	}
	
	public void respawn() 
	{
		int r = (int)(Math.random()*254+circleColorOffset);
		int g = (int)(Math.random()*254+circleColorOffset);
		int b = (int)(Math.random()*254+circleColorOffset);
		Color c = new Color(r, g, b);
		int rd = (int)(Math.random()*4+1);
		//left
		if(rd == 1) 
		{
			setVx((float)(Math.random()*(circleSpeed-1)+1));
			setVy((float)(Math.random()*(circleSpeed*2)-(circleSpeed)));
			
			setX((float)(Math.random()*(densityOfSpawning*width)-(densityOfSpawning*width)));
			setY((float)Math.random()*height);
			setColor(c);
		}
		
		//right
		else if(rd == 2) 
		{
			setVx((float)((Math.random()*(circleSpeed-1)+1)*-1));
			setVy((float)(Math.random()*(circleSpeed*2)-(circleSpeed)));
			
			setX((float)(Math.random()*(densityOfSpawning*width)+(width)));
			setY((float)Math.random()*height);
			setColor(c);
		}
		
		//top
		else if(rd == 3) 
		{
			setVy((float)(Math.random()*(circleSpeed-1)+1));
			setVx((float)(Math.random()*(circleSpeed*2)-(circleSpeed)));
			
			setY((float)(Math.random()*(densityOfSpawning)*(height)-(densityOfSpawning*height)));
			setX((float)Math.random()*width);
			setColor(c);
		}
		
		//bottom
		else if(rd == 4) 
		{
			setVy((float)((Math.random()*(circleSpeed-1)+1)*-1));
			setVx((float)(Math.random()*(circleSpeed*2)-(circleSpeed)));
			
			setY((float)(Math.random()*(densityOfSpawning*height)+(height)));
			setX((float)Math.random()*width);
			setColor(c);
		}
	}
	
	public void checkBoundary() 
	{
		if(getX() < (-1*densityOfSpawning*width)/2 || getX() > width+(densityOfSpawning*width)/2 || getY() < (-1*densityOfSpawning*height)/2 || getY() > height+(densityOfSpawning*height)/2) 
		{
			respawn();
		}
	}
	
	public void update() 
	{
		move();
		checkBoundary();
	}
	
	public Circle(int width, int height) 
	{
		this.width = width;
		this.height = height;
		int rd = (int)(Math.random()*4+1);
		//left
		if(rd == 1) 
		{
			setVx((float)(Math.random()*(circleSpeed-1)+1));
			setVy((float)(Math.random()*(circleSpeed*2)-(circleSpeed)));
			
			setX((float)(Math.random()*(densityOfSpawning*width)+(-1*densityOfSpawning*width)));
			setY((float)Math.random()*height);
		}
		
		//right
		else if(rd == 2) 
		{
			setVx((float)((Math.random()*(circleSpeed-1)+1)*-1));
			setVy((float)(Math.random()*(circleSpeed*2)-(circleSpeed)));
			
			setX((float)(Math.random()*(densityOfSpawning*width)+(width)));
			setY((float)Math.random()*height);
		}
		
		//top
		else if(rd == 3) 
		{
			setVy((float)(Math.random()*(circleSpeed-1)+1));
			setVx((float)(Math.random()*(circleSpeed*2)-(circleSpeed)));
			
			setY((float)(Math.random()*(densityOfSpawning)*(height)-(densityOfSpawning*height)));
			setX((float)Math.random()*width);
		}
		
		//bottom
		else if(rd == 4) 
		{
			setVy((float)((Math.random()*(circleSpeed-1)+1)*-1));
			setVx((float)(Math.random()*(circleSpeed*2)-(circleSpeed)));
			
			setY((float)(Math.random()*(densityOfSpawning*height)+(height)));
			setX((float)Math.random()*width);
		}
		size = (float)(Math.random()*(circleSizeM*35)+10);
		int r = (int)(Math.random()*254+circleColorOffset);
		int g = (int)(Math.random()*254+circleColorOffset);
		int b = (int)(Math.random()*254+circleColorOffset);
		Color c = new Color(r, g, b);
		this.color = c;
	}
	
	public Circle(int width, int height, float x, float y, float vx, float vy, float size, Color color) 
	{
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		this.size = size;
		this.color = color;
	}
	
	
}
