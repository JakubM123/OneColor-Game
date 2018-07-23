import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy extends BaseObject{

	public Enemy(int x, int y) {
		super(3, "Enemy", x, y);
		
		velX = 5;
		velY = 5;
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle ((int)x, (int)y, 16, 16);
		
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 32) velY *=  -1;
		if(x <= 0 || x >= Game.WIDTH - 16) velX *=  -1;

	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}

}
