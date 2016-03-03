package jaffa.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketTool implements Tool {

	private Color color;

	public BucketTool(Color c) {
		this.color = c;
	}

	public void mousePressed(Graphics g, int x, int y, BufferedImage image) {
		fillColor(x, y, image.getRGB(x, y), color.getRGB(), image);
	}

	public void mouseReleased(Graphics g, int x, int y) {

	}

	public void mouseDragged(Graphics g, int x, int y) {

	}

	public void drawPreview(Graphics g) {

	}

	private void fillColor(int x, int y, int oldColor, int newColor,
			BufferedImage image) {
		Queue<Point> queue = new LinkedList<Point>();

		queue.add(new Point(x, y));

		Point p;
		while (!queue.isEmpty()) {
			p = queue.remove();

			int x2 = p.getX();
			int y2 = p.getY();

			if (x2 > 0 && y2 > 0 && x2 < image.getWidth()
					&& y2 < image.getHeight() // if its in the frame
					&& image.getRGB(x2, y2) == oldColor) { // if that point has
				// the background
				// color
				// change that points color to the new color
				image.setRGB(x2, y2, newColor);

				// add all points around this point to the queue
				queue.add(new Point(x2 - 1, y2));
				queue.add(new Point(x2 + 1, y2));
				queue.add(new Point(x2, y2 - 1));
				queue.add(new Point(x2, y2 + 1));
			}
		}
	}

	public void setColor(Color c) {
		this.color = c;
	}

}
