package jaffa.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;

public class PencilTool implements Tool {

	private int x;
	private int y;

	public void mousePressed(Graphics g, int x, int y) {
		g.setColor(Color.MAGENTA);
		g.fillOval(x, y, 1, 1);
		this.x = x;
		this.y = y;
	}

	public void mouseReleased(Graphics g, int x, int y) {

	}

	public void mouseDragged(Graphics g, int x, int y) {
		g.setColor(Color.MAGENTA);
		g.drawLine(this.x, this.y, x, y);
		this.x = x;
		this.y = y;
	}

	public void drawPreview(Graphics g) {

	}

}