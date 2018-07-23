import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends BaseObject{

	private static Enemy enemy;
	
	public Player(int x, int y, int dx) {
		super(1, "Player", x, y);
		
		velX = 0;
		velY = 0;
	
	}
	
	public Rectangle getBounds() {
		return new Rectangle ((int)x, (int)y, 50, 50);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 32) velY = 0;
		if(x <= 0 || x >= Game.WIDTH - 16) velX = 0;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int) x, (int) y, 50, 50);
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT) {
			velX = -2;
		}
		else if(key == KeyEvent.VK_RIGHT) {
			velX = 2;
		}
		if(key == KeyEvent.VK_UP) {
			velY = -2;
		}
		else if(key == KeyEvent.VK_DOWN) {
			velY = 2;
		}	
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT) {
			velX = 0;
		}
		else if(key == KeyEvent.VK_RIGHT) {
			velX = 0;
		}
		if(key == KeyEvent.VK_UP) {
			velY = 0;
		}
		else if(key == KeyEvent.VK_DOWN) {
			velY = 0;
		}	
	}
			    
			    	
}