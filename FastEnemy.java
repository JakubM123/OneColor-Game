import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends BaseObject{
	
	private static final String FastEnemy = null;
	
	private MainHandler handler;

	public FastEnemy(int x, int y) {
		super(5, FastEnemy, x, y);
		
		velX = 2;
		velY = 9;
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 32)velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16)velX *= -1;
		
		handler(x, y, Color.cyan, 16, 16, 0.05f);
	}
	
	private void handler(float x, float y, Color cyan, int i, int j, float f) {
		
	}

	public void render(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect((int)x, (int)y, 16, 16);
	}

}
