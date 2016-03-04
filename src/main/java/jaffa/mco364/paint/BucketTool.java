package jaffa.mco364.paint;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketTool extends Tool {

	private BufferedImage buffer;

	public BucketTool(PaintProperties properties) {
		super(properties);
		this.buffer = properties.getImage();
	}

	@Override
	public void mousePressed(Graphics g, int x, int y, BufferedImage image) {
		fillColor(x, y, buffer.getRGB(x, y), properties.getColor().getRGB(),
				buffer);
		// Image img = properties.getImage();
		// Color color = img.getRGB();
		// fillColor(x, y, properties.getImage().getRGB());
	}

	@Override
	public void mouseReleased(Graphics g, int x, int y) {

	}

	@Override
	public void mouseDragged(Graphics g, int x, int y) {

	}

	@Override
	public void drawPreview(Graphics g) {

	}

	private void fillColor(int x, int y, int srcColor, int targetColor,
			BufferedImage image) {
		Queue<Point> queue = new LinkedList<Point>();

		queue.add(new Point(x, y));

		// Point p;
		while (!queue.isEmpty()) {
			Point p = queue.remove();

			int x2 = p.getX();
			int y2 = p.getY();

			if (x2 > 0 && y2 > 0 && x2 < image.getWidth()
					&& y2 < image.getHeight() // if its in the frame
					&& image.getRGB(x2, y2) == srcColor) { // if that point has
				// the background
				// color
				// change that points color to the new color
				image.setRGB(x2, y2, targetColor);

				// add all points around this point to the queue
				queue.add(new Point(x2 - 1, y2));
				queue.add(new Point(x2 + 1, y2));
				queue.add(new Point(x2, y2 - 1));
				queue.add(new Point(x2, y2 + 1));
			}
		}
	}

}
