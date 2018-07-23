import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Health extends BaseObject{
	
	public int health = 100;
	
	public Health(int x, int y) {
		super(5, "Health", x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Comic Sans MS", Font.PLAIN, 32)); 
		
		g.drawString(String.valueOf(health), (int)x, (int)y);
	}
	
}
