package jaffa.mco364.paint;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class PaintProperties {

	private int width; // width and height of canvas
	private int height;
	private Color color;
	private int weight;
	private boolean fill;
	private BufferedImage image;

	public PaintProperties() {
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		color = Color.BLACK;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

}
