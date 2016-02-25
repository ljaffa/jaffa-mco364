package jaffa.mco364.paint;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	private BufferedImage buffer;
	private Tool tool;

	public Canvas() {

		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		tool = new OvalTool();

		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent event) {
				// TODO Auto-generated method stub

			}

			public void mouseEntered(MouseEvent event) {
				// TODO Auto-generated method stub

			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent event) {
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
		// thtas why we have to put draw preview in this method.
		tool.drawPreview(g);
	}
}