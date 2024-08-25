import java.awt.Color;
public class PowerfulTurtle extends Turtle{

	public PowerfulTurtle() {
		super();
	}
	public PowerfulTurtle(int width, int height) {
		super(true, width, height);
	}

public static void test1(Turtle T, double y) {
	Turtle t = new Turtle();
	t.penDown();
	for(int i = 0; i<=2; i++);
	t.move(y);
	t.turnLeft(180);
}
public void drawTriangle(double x) {
	this.showTurtle(false);
	for(int i = 0; i<=2; i++) {
		this.move(x);
		this.turnLeft(120);
	}
}
public void drawInvertedTriangle(double x) {
	this.turnLeft(60);
	this.move(x);
	this.turnLeft(120);
	this.move(x);
	this.turnLeft(120);
	this.move(x);
}
public void drawSquare(double x) {
	Turtle t = new Turtle();
	for(int g = 1; g<=4; g++) {
	t.move(x);
	t.turnLeft(90);
}
}
public void drawPentagon(double x) {
	Turtle t = new Turtle();
	for(int g = 0; g <= 4; g++) {
		t.move(x);
		t.turnLeft(72);
	}
}
public void drawPolygon(double x, double y) {
	Turtle t = new Turtle();
	for(int g = 1; g <= y; g++) {
	t.move(x);
	t.turnLeft(360.0/y);
}
}
public void switchToRandomColor() {
	int x = (int)(Math.random()*256);
	int y = (int)(Math.random()*256);
	int z = (int)(Math.random()*256);
	switchTo(new Color(x, y, z));
}
public void drawCube() {
	for(int i = 1; i <=6; i++) {
		drawHexagon(100);
		turnRight(60);
	}
}
public void turnRight(double d) {
	turnLeft(-d);
}
public void drawHexagon(double x) {
	for(int i = 0; i<=6; i++) {
	move(x);	
	turnLeft(60);
	}
}

public void positionApps() {
this.penUp();
this.turnLeft(90);
this.move(10);
this.turnLeft(90);
this.move(215);
this.turnLeft(180);
}
public void positionCursor() {
	this.penUp();
	this.turnRight(90);
	this.move(50);
	this.turnRight(90);
	this.move(150);
	this.penDown();
}
public void drawCircle(double x) {
	for(int i = 0; i<= 72; i++) {
		this.move(0.5);
		this.turnLeft(x);
	}
	
}
public void drawCamera() {
	positionCursor();
	//this circle is selfie camera on the phone
	drawCircle(5);
	//these lines of code put the turtle in the right place to draw the speaker
	this.turnLeft(180);
	this.penUp();
	this.move(50);
	this.penDown();
	drawSpeaker();
	
}
public void drawSpeaker() {
	//TRIPLE nested for loops make a cool shape for the speaker hole
	for(int d = 0; d<= 6; d++) {
	for(int g = 0; g<= 3; g++) {
	for(int i = 0; i<= 9; i++) {
		this.move(0.5);
		this.turnLeft(12);
	}
	this.move(0.5);
	}
	this.penUp();
	this.move(5);
	this.penDown();
	}
}

public void drawAppsInPhone(int numberOfApps) {
	//draws app and repositions cursor to draw next app
	drawApp(10);
	this.penUp();
	this.move(40);
	this.penDown();
	if(numberOfApps == 0) //base case tells us when to stop recursion
		return;
	//base case
	drawAppsInPhone(numberOfApps -1);
}
public void drawApp(int n) {
	//changes color of each app
	switchToRandomColor();
	//nested for loops to get shape to look complete
for(int g = 1; g<=4; g++) {
	//creates curved edges
	for(int i = 0; i<=44; i++) {
		this.move(0.3);
		this.turnLeft(2);
		}
	//moves forward a small amount to complete curved app shape
	this.move(n);
}
}
public void iPadFrame(double sideLength, double sideWidth) {
	//draws first box which would be the phone screen without a bezel
	for(int i = 0; i<=2; i++) {
	this.move(sideLength);
	this.turnLeft(90);
	this.move(sideWidth);
	this.turnLeft(90);
	}
	//moves turtle to edge of screen to start drawing bezel
	this.move(sideLength);
	//creates a gentle curve that your hand would love to hold
	curvedEdge();
	//moves a little to complete top bezel
	//I subtract 137 because that is the length of the 2 curves
	this.move(sideWidth-137);
	//draws second curve on top bezel
	curvedEdge();
	//brings turtle to bottom of the phone screen and adds a little extra for bottom bezel
	this.move(sideLength+sideLength/30);
	this.turnLeft(90);
	this.move(sideWidth);
	//rest of this code just gets turtle back to the begining
	this.turnLeft(90);
	this.move(sideLength+sideLength/30);
	this.turnLeft(90);
	this.move(sideWidth);
}
public void curvedEdge() {
	for(int i = 0; i<=17; i++) {
	this.move(6);
	this.turnLeft(5);
	}
}

public void drawFractualTriangle(double x, double y) {

	if(y == 0)
		drawTriangle(x);
	else {
	drawFractualTriangle(x/2, y-1);
	move(x/2);
	drawFractualTriangle(x/2, y-1);
	turnLeft(120);
	move(x/2);
	turnRight(120);
	drawFractualTriangle(x/2, y-1);
	turnRight(120);
	move(x/2);
	turnLeft(120);
	switchToRandomColor();
	}
}

}
