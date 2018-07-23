import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	private JFrame f = new JFrame();
	
	
	public Window(int width, int height, String title, Game game, InputHandler iHandler) {
		f.setPreferredSize(new Dimension(width, height));
		f.setMaximumSize(new Dimension(width, height));
		f.setMinimumSize(new Dimension(width, height));
		f.setTitle(title);
		f.setResizable(true);
		f.setVisible(true);
		f.addKeyListener(iHandler);
		f.setFocusable(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(game);
	}
}
