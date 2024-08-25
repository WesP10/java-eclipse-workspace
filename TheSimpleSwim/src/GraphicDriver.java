import java.util.ArrayList;

import ProcessingIntro.Button;
import processing.core.PApplet;
import processing.core.PImage;

public class GraphicDriver extends PApplet{
	public static void main(String[] args) { PApplet.main("GraphicDriver");	}

	private final int HEIGHT=1200, WIDTH=600, PLAYER_SIZE=64;
	private int screenY, gameState;
	private Button button;
	private ButtonSwitch switcher;
	private Swimmer swimmer;
	private PImage backPImage;
	private Fish[] fishs;

	private PImage escapeImage;
	private Player player;
	
	public void settings() {
		size(WIDTH, WIDTH);
		button = new Button(WIDTH/2-150, WIDTH-175, WIDTH/2, WIDTH/5, "Swim");
	}
	public void setup() {
		strokeWeight(5);
		gameState = 0;
		switcher = new ButtonSwitch();
		button.setBackground(130, 230, 75);
		swimmer = new Swimmer(WIDTH/2-PLAYER_SIZE, HEIGHT, PLAYER_SIZE, this);
		fishs = genFish();
		screenY = swimmer.getY()-height;
		backPImage = loadImage("Background.png");
		backPImage.resize(600, 1600);
		
		escapeImage = loadImage("EscapeBackground.png");
		player = new Player(0, 0, PLAYER_SIZE, this);
	}
	public void draw() {
		if(gameState==0)
			swimState();
		if(gameState==1)
			escapeState();;
	}
	public void mousePressed() {
		if(button.clicked(mouseX,mouseY))
			if(switcher.isGreen())
				swimmer.swimUp();
			else
				gameState = 1;		
	}
	private void drawBackground() {
		screenY = swimmer.getY()-height/2;
		copy(backPImage, 0, screenY, width, height, 0, 0, width, height);
//		System.out.println("screenY: "+screenY);
	}
	private Fish[] genFish() {
		Fish[] tFishs = new Fish[8];
		for(int i = 0; i < tFishs.length; i++)
			tFishs[i] = new Fish((int)(Math.random()*550), 550+(i*100), (int)(Math.random()*4), this);
		return tFishs;
	}
	private void swimState() {
		drawBackground();
		button.setBackground(switcher.getColor(frameCount));
		button.draw(this);
		swimmer.draw(this);
		swimmer.gravity();
		for(int i = 0; i < fishs.length; i++) {
			fishs[i].draw(this, screenY);
			fishs[i].update();
			if(fishs[i].contact(WIDTH/2-PLAYER_SIZE, PLAYER_SIZE, height/2, PLAYER_SIZE, screenY))
				System.out.println("HIT "+i);
		}
	}
	private void escapeState() {
		//Draws whole map
		image(backPImage, 0, 0);
		//Draws player that is controlled with arrow keys
		player.draw(this);
		//Checks if on ground and if gravity should be applied
		player.update();
	}
}
	
