package jaffa.mco364.paint;

import java.awt.Graphics2D;
import java.util.logging.Logger;

public class LineTool extends Tool {

	// every class gets its own logger
	// arg should be unique name for the class
	// loggers will get you the messages
	private static final Logger LOG = Logger
			.getLogger(LineTool.class.getName());

	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public LineTool(PaintProperties properties) {
		super(properties);
	}

	@Override
	public void mousePressed(Graphics2D g, int x, int y) {
		this.x1 = x;
		this.y1 = y;
		// when we first pressed mouse it called repaint in Canvas class and
		// drew a line from x2, y2 which is 0, 0
		// we have to reset it to be x and y
		this.x2 = x;
		this.y2 = y;
	}

	@Override
	public void mouseReleased(Graphics2D g, int x, int y) {
		g.setColor(properties.getColor());
		g.drawLine(this.x1, this.y1, x, y);
	}

	@Override
	public void mouseDragged(Graphics2D g, int x, int y) {
		this.x2 = x;
		this.y2 = y;
	}

	@Override
	public void drawPreview(Graphics2D g) {
		g.setColor(properties.getColor());
		g.drawLine(x1, y1, x2, y2);

		String logMessage = String.format("x1 = %d, y1 = %d, x2 = %d, y2 = %d",
				x1, y1, x2, y2);
		LOG.info(logMessage); // supplies info to console
	}

}
