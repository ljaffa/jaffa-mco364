package jaffa.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public interface Tool {

	void mousePressed(Graphics g, int x, int y, BufferedImage image);

	void mouseReleased(Graphics g, int x, int y);

	void mouseDragged(Graphics g, int x, int y);

	void drawPreview(Graphics g);

	void setColor(Color c);

}
