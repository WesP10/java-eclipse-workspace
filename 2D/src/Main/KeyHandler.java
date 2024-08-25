package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

	public boolean up, down, left, right;
	
	@Override
	public void keyTyped(KeyEvent e) {	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int kCode = e.getKeyCode();
		checkKeyPress(kCode);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int kCode = e.getKeyCode();
		checkKeyRelease(kCode);
	}

	public void checkKeyPress(int code) 
	{
		if(code == KeyEvent.VK_W) 
			up = true;
		if(code == KeyEvent.VK_S) 
			down = true;
		if(code == KeyEvent.VK_A) 
			left = true;
		if(code == KeyEvent.VK_D) 
			right = true;
	}
	
	public void checkKeyRelease(int code) 
	{
		if(code == KeyEvent.VK_W) 
			up = false;
		if(code == KeyEvent.VK_S) 
			down = false;
		if(code == KeyEvent.VK_A) 
			left = false;
		if(code == KeyEvent.VK_D) 
			right = false;
	}
}
