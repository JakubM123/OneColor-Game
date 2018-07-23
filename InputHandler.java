import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InputHandler extends KeyAdapter implements MouseListener{
	
	public void mouseClicked(MouseEvent e) {
		for(BaseObject o : MainHandler.mainHandler.objects) {
			o.mouseClicked(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
		for(BaseObject o : MainHandler.mainHandler.objects) {
			o.mouseEntered(e);
		}
	}

	public void mouseExited(MouseEvent e) {
		for(BaseObject o : MainHandler.mainHandler.objects) {
			o.mouseExited(e);
		}
	}

	public void mousePressed(MouseEvent e) {
		for(BaseObject o : MainHandler.mainHandler.objects) {
			o.mousePressed(e);
		}
	}

	public void mouseReleased(MouseEvent e) {
		for(BaseObject o : MainHandler.mainHandler.objects) {
			o.mouseReleased(e);
		}
	}

	public void keyPressed(KeyEvent e) {
		
		
		for(BaseObject o : MainHandler.mainHandler.objects) {
			o.keyPressed(e);
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(BaseObject o : MainHandler.mainHandler.objects) {
			o.keyReleased(e);
		}
	}

}
