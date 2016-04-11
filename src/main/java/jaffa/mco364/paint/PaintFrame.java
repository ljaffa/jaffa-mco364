package jaffa.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	private Canvas canvas;

	@Inject
	public PaintFrame(Canvas canvas, PaintToolbar toolbar) {
		setTitle("PAINT");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		this.canvas = canvas;

		add(canvas, BorderLayout.CENTER);
		add(toolbar, BorderLayout.NORTH);

		this.undoRedoPanel = new JPanel();
		undoRedoPanel.setLayout(new FlowLayout());

		undoButton = new JButton(new ImageIcon(getClass().getResource(
				"/undoButton2.jpe")));
		undoButton.setPreferredSize(new Dimension(50, 50));
		undoButton.setBackground(Color.WHITE);
		undoButton.setEnabled(true);
		undoButton.addActionListener(undoListener);

		redoButton = new JButton(new ImageIcon(getClass().getResource(
				"/redo2.jpg")));
		redoButton.setPreferredSize(new Dimension(50, 50));
		redoButton.setBackground(Color.WHITE);
		redoButton.setEnabled(false);
		redoButton.addActionListener(redoListener);

		undoRedoPanel.add(undoButton);
		undoRedoPanel.add(redoButton);

		add(undoRedoPanel, BorderLayout.PAGE_END);

		setVisible(true);
	}

	ActionListener undoListener = new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {
			canvas.undo();
			redoButton.setEnabled(true);
			if (canvas.undoIsEmpty()) {
				undoButton.setEnabled(false);
			}
		}

	};

	ActionListener redoListener = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			canvas.redo();
			undoButton.setEnabled(true);
			if (canvas.redoIsEmpty()) {
				redoButton.setEnabled(false);
			}
		}

	};

	public static void main(String[] args) {
		// changing log level
		Logger logger = Logger.getLogger("jaffa.mco364.paint");
		logger.setLevel(Level.FINE); // only displays fine and above
		Handler handler = new ConsoleHandler();
		handler.setLevel(Level.FINE);
		logger.addHandler(handler);

		Injector injector = Guice.createInjector(new PaintModule());
		PaintFrame p = injector.getInstance(PaintFrame.class);
	}
}
