package jaffa.mco364.paint;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Tool {

	protected PaintProperties properties;

	public Tool(PaintProperties properties) {
		this.properties = properties;
	}

	abstract void mousePressed(Graphics g, int x, int y, BufferedImage image);

	abstract void mouseReleased(Graphics g, int x, int y);

	abstract void mouseDragged(Graphics g, int x, int y);

	abstract void drawPreview(Graphics g);

	// void setColor(Color c);

}
