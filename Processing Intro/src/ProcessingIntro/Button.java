package ProcessingIntro;

import org.w3c.dom.css.RGBColor;

import processing.core.PApplet;

public class Button {

	private int x, y, width, height, r, stroke;
	private float red, green, blue, textRed, textGreen, textBlue;
	private String text;
	
	public Button() {
		x = 0;
		y = 0;
		width = 100;
		height = 50;
		text = "";
		r = 30;
	}
	public Button(int X, int Y, int Width, int Height) {
		x = X;
		y = Y;
		width = Width;
		height = Height;
		text = "";
		r = 30;
	}
	public Button(int X, int Y, int Width, int Height, String Text) {
		x = X;
		y = Y;
		width = Width;
		height = Height;
		text = Text;
		r = 30;
	}
	public Button(int X, int Y, int Width, int Height, int R, String Text) {
		x = X;
		y = Y;
		width = Width;
		height = Height;
		text = Text;
		r = R;
	}
	public Button(int X, int Y, int Width, int Height, int R) {
		x = X;
		y = Y;
		width = Width;
		height = Height;
		text = "";
		r = R;
	}
	public Button(int X, int Y, int Width, int Height, int[] points) {
		
	}
	public void draw(PApplet window) {
		//Save Fill and Stroke Weight
		int fill = window.getGraphics().fillColor;
		float strokeWeight = window.getGraphics().strokeWeight;
		//Draw Rectangle with no fill and given stroke weight
		if(red!=0 || green!=0 || blue!=0)window.fill(red, green, blue); else window.noFill();
		if(stroke != 0) window.strokeWeight(stroke);
		window.rect(x, y, width, height, r);
		//Set text Size and Color and get text width
		window.textSize(width/5);
		window.fill(textRed, textGreen, textBlue);
		float tw = window.textWidth(text);
		//Draw Text
		window.text(text, (x+width/2)-tw/2, y+2*height/3);
		//Reset fill and stroke weight
		window.fill(fill);
		window.strokeWeight(strokeWeight);
	}
	public boolean clicked(int mouseX, int mouseY) {
		return mouseX>x && mouseX<x+width && mouseY>y && mouseY<y+height;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void setStroke(int size) {
		if(size <= 0) return;
		stroke = size;
	}
	public void setBackground(float r, float g, float b) {
		if(r < 0 || g < 0 || b < 0) return;
		red = r;
		green = g;
		blue = b;
	}
	public void setBackground(float[] rbg) {
		if(rbg.length != 3) return;
		red = rbg[0];
		green = rbg[1];
		blue = rbg[2];
	}
	public void setTextColor(float r, float g, float b) {
		if(r < 0 || g < 0 || b < 0) return;
		textRed = r;
		textGreen = g;
		textBlue = b;
	}
}
