
public class ButtonSwitch {

	private boolean red;
	private int count, delay;
	
	public ButtonSwitch() {
		red = false;
		setDelay();
	}
	
	public boolean isGreen() {
		return !red;
	}
	public float[] getColor(int frameCount) {
		if(red)
			return red(frameCount);
		else
			return green(frameCount);
	}
	private float[] red(int frameCount) {
		float[] switchColor={130, 230, 75}, sameColor={230, 30, 15};
		int countGap = frameCount - count;
		//If countGap is not high enough to switch color
		if(countGap < 60)
			return sameColor;
		//When switching
		count = frameCount;
		red = !red;
		return switchColor;
	}
	private float[] green(int frameCount) {
		float[] switchColor={230, 30, 15}, sameColor={130, 230, 75};
		int countGap = frameCount - count;
		if(countGap < delay)
			return sameColor;
		count = frameCount;
		red = !red;
		setDelay();
		return switchColor;
	}
	private void setDelay() {
		delay = (int)(Math.random()*650+20);
	}
}
