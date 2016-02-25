package jaffa.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class PaintFrame extends JFrame {

	public PaintFrame() {
		setTitle("PAINT");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		Canvas canvas = new Canvas();
		add(canvas, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		PaintFrame p = new PaintFrame();
		p.setVisible(true);
	}

}
