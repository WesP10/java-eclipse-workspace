import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class SnapAuto {

	public static void main(String[] args) throws Exception {
		Thread.sleep(5000);
		Robot robot = new Robot();
		for(int i = 0; i < 100000; i++) {
			farmDiamonds(robot);
			robot.delay(1800);
		}
	}

	private static void farmDiamonds(Robot robot) {
		robot.mouseMove(625, 475);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(200);
		robot.mouseMove(800, 475);
		robot.delay(100);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(100);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);	
		robot.delay(100);
		robot.mouseMove(625, 450);
		robot.delay(100);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(100);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(100);
		robot.mouseMove(625, 345);
		robot.delay(100);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(100);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	
	private static void farmTree(Robot robot) throws Exception {
			robot.mouseMove(225, 550);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			for(int i = 0; i < 20; i++) {
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.delay(300);
				robot.mouseMove(200, 550);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot.delay(400);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseMove(380, 550);
				robot.delay(400);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			}
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			//Re-Orient
			robot.mouseMove(225, 600);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(800);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(200);
			//Click Re-grow
			robot.mouseMove(225, 550);
			robot.delay(100);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(100);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(9000);
			//Skip Add
			robot.mouseMove(300, 500);
			robot.delay(100);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(100);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);			
	}
}
