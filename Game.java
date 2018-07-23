import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{
	public static int WIDTH = 800;
	public static int HEIGHT = 800; 
	public static String title = "One Color Game";
	
	private boolean running = false;
	private Thread thread;
	
	public Game() {
		new Window(WIDTH, HEIGHT, title, this, new InputHandler());
		new MainHandler();
		this.addKeyListener(new InputHandler());
		start();
	}
	
	private synchronized void start() {
		if(running) return;
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	private synchronized void stop() {
		if(!running) return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		running = false;
	}

	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
		stop();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		for(BaseObject o : MainHandler.mainHandler.objects) {
			o.render(g);
		}
		
		bs.show();
		g.dispose();
	}

	private void tick() {
		for(BaseObject o : MainHandler.mainHandler.objects) {
			o.tick();
		}
	}

	public static void main(String args[]) {
		new Game();
	}
}
