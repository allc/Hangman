import java.awt.*;

import javax.swing.*;

/**
 * 
 */

/**
 * @author Allen
 *
 */
public class HangmanGUI extends JFrame {
	
	public HangmanCanvas canvas;

	public HangmanGUI() {
		super("Hangman");
		
		init();
	}
	
	private void init() {
		// get container
		Container container = this.getContentPane();
		
		// canvas
		canvas = new HangmanCanvas();
		container.add(canvas);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	
}
