package jaffa.mco364.paint;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PaintProperties {

	private int width; // width and height of canvas
	private int height;
	private Color color;
	private int weight;
	private boolean fill;
	private BufferedImage image;

	// private BasicStroke stroke;

	@Inject
	public PaintProperties() {
		this.width = 800;
		this.height = 600;
		this.image = new BufferedImage(this.width, this.height,
				BufferedImage.TYPE_INT_ARGB);
		this.color = Color.BLACK;
		this.weight = 2;
		// this.stroke = new BasicStroke(1);
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

	/*
	 * public BasicStroke getStroke() { return stroke; }
	 * 
	 * public void setStroke(BasicStroke stroke) { this.stroke = stroke; }
	 */

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

}
