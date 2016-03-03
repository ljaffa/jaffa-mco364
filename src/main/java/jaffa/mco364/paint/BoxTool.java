package jaffa.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class BoxTool implements Tool {

	private int x1;
	private int y1;
	private int x2;
	private int y2;

	private int width;
	private int height;

	private Color color;

	public BoxTool(Color color) {
		this.color = color;
	}

	public void mousePressed(Graphics g, int x, int y, BufferedImage image) {
		g.setColor(color);
		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;
	}

	public void mouseReleased(Graphics g, int x, int y) {
		g.setColor(color);
		width = x - x1;
		height = y - y1;
		g.drawRect(x1, y1, width, height);
	}

	public void mouseDragged(Graphics g, int x, int y) {
		this.x2 = x;
		this.y2 = y;
	}

	public void drawPreview(Graphics g) {
		g.setColor(color);
		width = x2 - x1;
		height = y2 - y1;
		g.drawRect(x1, y1, width, height);
	}

	public void setColor(Color c) {
		this.color = c;
	}

}
