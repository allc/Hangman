import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author Allen
 *
 */
public class HangmanCanvas extends JPanel {

	private static final int WIDTH = 300;
	private static final int HEIGHT = 400;
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int ARM_HEIGHT = 44;
	private static final int ARM_WIDTH = 72;
	private static final int LEG_WIDTH = 28;
	private static final int LEG_HEIGHT = 108;

	private boolean[] isPartEnabled;
	private int currentPart = 0;

	public HangmanCanvas() {
		super();

		isPartEnabled = new boolean[6];
		for (int i = 0; i < 6; i++) {
			isPartEnabled[i] = false;
		}

		init();
	}

	private void init() {
		// set size
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// scaffold
		int scaffoldLeft = (WIDTH - BEAM_LENGTH - ARM_WIDTH) / 2;
		int scaffoldTop = (HEIGHT - SCAFFOLD_HEIGHT) / 2;
		g.drawLine(scaffoldLeft, scaffoldTop, scaffoldLeft, scaffoldTop + SCAFFOLD_HEIGHT); // vertical
																							// line
		int beamRight = scaffoldLeft + BEAM_LENGTH;
		g.drawLine(scaffoldLeft, scaffoldTop, beamRight, scaffoldTop); // beam
		int ropeBottom = scaffoldTop + ROPE_LENGTH;
		g.drawLine(beamRight, scaffoldTop, beamRight, ropeBottom); // rope

		// head
		int headDiameter = HEAD_RADIUS * 2;
		if (isPartEnabled[0]) {
			g.drawOval(beamRight - HEAD_RADIUS, ropeBottom, headDiameter, headDiameter);
		}

		// body
		int bodyTop = ropeBottom + headDiameter;
		int bodyBottom = bodyTop + BODY_LENGTH;
		if (isPartEnabled[1]) {
			g.drawLine(beamRight, bodyTop, beamRight, bodyBottom);
		}

		// left arm
		int armBottom = bodyTop + ARM_OFFSET_FROM_HEAD;

		if (isPartEnabled[2]) {
			g.drawLine(beamRight - ARM_WIDTH, armBottom - ARM_HEIGHT, beamRight, armBottom);
		}

		// right arm
		if (isPartEnabled[3]) {
			g.drawLine(beamRight + ARM_WIDTH, armBottom - ARM_HEIGHT, beamRight, armBottom);
		}

		// left leg
		if (isPartEnabled[4]) {
			g.drawLine(beamRight - LEG_WIDTH, bodyBottom + LEG_HEIGHT, beamRight, bodyBottom);
		}

		// right leg
		if (isPartEnabled[5]) {
			g.drawLine(beamRight + LEG_WIDTH, bodyBottom + LEG_HEIGHT, beamRight, bodyBottom);
		}
	}
	
	public void enablePart() {
		if (currentPart < 6) {
			isPartEnabled[currentPart] = true;
			this.repaint();
			currentPart++;
		}
	}

}
