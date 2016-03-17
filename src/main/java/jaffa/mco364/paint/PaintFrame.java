package jaffa.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class PaintFrame extends JFrame {

	private JPanel undoRedoPanel;
	private JButton undoButton;
	private JButton redoButton;

	@Inject
	public PaintFrame(final Canvas canvas, PaintToolbar toolbar) {
		setTitle("PAINT");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		add(canvas, BorderLayout.CENTER);
		add(toolbar, BorderLayout.PAGE_START);

		setVisible(true);

		undoRedoPanel = new JPanel();
		undoRedoPanel.setLayout(new FlowLayout());

		undoButton = new JButton(new ImageIcon(getClass().getResource(
				"/undoButton2.jpe")));
		undoButton.setPreferredSize(new Dimension(50, 50));
		undoButton.setBackground(Color.WHITE);
		undoButton.setEnabled(true);

		redoButton = new JButton(new ImageIcon(getClass().getResource(
				"/redo2.jpg")));
		redoButton.setPreferredSize(new Dimension(50, 50));
		redoButton.setBackground(Color.WHITE);
		redoButton.setEnabled(false);

		undoRedoPanel.add(undoButton);
		undoRedoPanel.add(redoButton);

		add(undoRedoPanel, BorderLayout.PAGE_END);

		undoButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				canvas.undo();
				redoButton.setEnabled(true);
				if (canvas.undoIsEmpty()) {
					undoButton.setEnabled(false);
				}
			}

		});

		redoButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				canvas.redo();
				undoButton.setEnabled(true);
				if (canvas.redoIsEmpty()) {
					redoButton.setEnabled(false);
				}
			}

		});

		setVisible(true);

	}

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new PaintModule());
		PaintFrame p = injector.getInstance(PaintFrame.class);
	}
}
