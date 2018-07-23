import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class MainHandler {
	public ArrayList<BaseObject> objects;
	
	public static MainHandler mainHandler = new MainHandler();
	
	public MainHandler() {
		this.objects = new ArrayList<>();
		addObject(new Player(0, 0, 0));
		addObject(new Enemy(0, 0));
		addObject(new FastEnemy(0, 0));
		addObject(new Health(25, 50));
	}
	
	public void tick() {
		for(BaseObject o : MainHandler.mainHandler.objects) {
			o.tick();
		}
	}
	
	public void render(Graphics g) {
		for(BaseObject o : MainHandler.mainHandler.objects) {
			o.render(g);
		}
	}
	
	public void addObject(BaseObject obj) {
        this.objects.add(obj);
    }
	
	public void removeObject(BaseObject obj) {
		this.objects.remove(obj);
	}

	public void addobject(float x, float y, Color cyan, int i, int j, float f, MainHandler handler) {
		// TODO Auto-generated method stub
		
	}

}
