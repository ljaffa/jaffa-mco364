package jaffa.mco364.paint;

import java.awt.Graphics2D;

public class OvalTool extends Tool {

	private int x1;
	private int y1;
	private int x2;
	private int y2;

	private int width;
	private int height;

	public OvalTool(PaintProperties properties) {
		super(properties);
	}

	@Override
	public void mousePressed(Graphics2D g, int x, int y) {
		g.setColor(properties.getColor());
		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;
		width = 0;
		height = 0;
	}

	@Override
	public void mouseReleased(Graphics2D g, int x, int y) {
		g.setColor(properties.getColor());
		x2 = x;
		y2 = y;
		width = Math.abs(x2 - x1);
		height = Math.abs(y2 - y1);
		g.drawOval(Math.min(x1, x2), Math.min(y1, y2), width, height);
	}

	@Override
	public void mouseDragged(Graphics2D g, int x, int y) {
		this.x2 = x;
		this.y2 = y;
		width = Math.abs(x2 - x1);
		height = Math.abs(y2 - y1);
	}

	@Override
	public void drawPreview(Graphics2D g) {
		g.setColor(properties.getColor());
		// width = x2 - x1;
		// height = y2 - y1;
		g.drawOval(Math.min(x1, x2), Math.min(y1, y2), width, height);
	}

}
