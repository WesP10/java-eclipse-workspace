
public class Branch {

	private float baseX, baseY, angle, length;

	public float getBaseX() {
		return baseX;
	}

	public void setBaseX(float baseX) {
		this.baseX = baseX;
	}

	public float getBaseY() {
		return baseY;
	}

	public void setBaseY(float baseY) {
		this.baseY = baseY;
	}

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public float getEndX() 
	{
		return (float)(Math.cos(Math.toRadians(angle))*length)+baseX;
	}
	
	public float getEndY() 
	{
		return (float)(Math.sin(Math.toRadians(angle))*length)+baseY;
	}
	
	public Branch(float baseX, float baseY, float angle, float length) {
		super();
		this.baseX = baseX;
		this.baseY = baseY;
		this.angle = angle;
		this.length = length;
	}
	
	
}
