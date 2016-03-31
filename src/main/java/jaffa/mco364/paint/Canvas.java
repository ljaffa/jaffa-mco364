package jaffa.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Stack;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JPanel;

@Singleton
public class Canvas extends JPanel {

	private Stack<BufferedImage> undo;
	private Stack<BufferedImage> redo;
	private BufferedImage buffer;
	private Tool tool;

	private PaintProperties properties;

	@Inject
	public Canvas(PaintProperties properties) {

		this.properties = properties;
		tool = new PencilTool(properties);

		undo = new Stack<BufferedImage>();
		redo = new Stack<BufferedImage>();

		buffer = properties.getImage();

		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent event) {

			}

			public void mouseEntered(MouseEvent event) {

			}

			public void mouseExited(MouseEvent arg0) {

			}

			public void mousePressed(MouseEvent event) {
				copyImage(undo);
				tool.mousePressed(buffer.getGraphics(), event.getX(),
						event.getY());
				repaint();
			}

			public void mouseReleased(MouseEvent event) {
				tool.mouseReleased(buffer.getGraphics(), event.getX(),
						event.getY());
				repaint();
			}
		});

		addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent event) {
				tool.mouseDragged(buffer.getGraphics(), event.getX(),
						event.getY());
				repaint();
			}

			public void mouseMoved(MouseEvent e) {

			}

		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(buffer, 0, 0, null);
		// only allowed to make changes and draw to graphic component in paint
		// component
		// thats why we have to put draw preview in this method.
		tool.drawPreview(g);
	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

	public void setColor(Color color) {
		properties.getColor();
	}

	public PaintProperties getProperties() {
		return properties;
	}

	public BufferedImage getBuffer() {
		return buffer;
	}

	public void undo() {
		if (!undo.isEmpty()) {
			copyImage(redo);
			buffer = undo.pop();
		}
		repaint();
	}

	public void redo() {
		if (!redo.isEmpty()) {
			buffer = redo.pop();
			copyImage(undo);
		}
		repaint();
	}

	public boolean undoIsEmpty() {
		return undo.isEmpty();
	}

	public boolean redoIsEmpty() {
		return redo.isEmpty();
	}

	public void copyImage(Stack<BufferedImage> stack) {
		BufferedImage copy = new BufferedImage(buffer.getWidth(),
				buffer.getHeight(), buffer.getType());
		Graphics2D g = copy.createGraphics();
		g.drawImage(buffer, 0, 0, null);
		g.dispose();
		stack.push(copy);
		// return copy;
	}
}