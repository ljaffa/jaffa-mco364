package jaffa.mco364.paint;

import java.awt.Graphics2D;

public class PencilTool extends Tool {

	private int x;
	private int y;

	public PencilTool(PaintProperties properties) {
		super(properties);
	}

	@Override
	public void mousePressed(Graphics2D g, int x, int y) {
		g.setColor(properties.getColor());
		g.fillOval(x, y, 1, 1);
		this.x = x;
		this.y = y;
	}

	@Override
	public void mouseReleased(Graphics2D g, int x, int y) {

	}

	@Override
	public void mouseDragged(Graphics2D g, int x, int y) {
		g.setColor(properties.getColor());
		g.drawLine(this.x, this.y, x, y);
		this.x = x;
		this.y = y;
	}

	@Override
	public void drawPreview(Graphics2D g) {

	}

}
