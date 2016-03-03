package jaffa.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame {

	private JPanel canvasPanel;
	private JPanel undoRedoPanel;
	private JPanel buttonPanel;

	private JButton pencilButton, ovalButton, boxButton, lineButton,
			bucketButton, colorButton;

	private JButton undoButton;
	private JButton redoButton;

	private Canvas canvas;
	private Color color;

	public PaintFrame() {
		setTitle("PAINT");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		// canvasPanel = new JPanel();
		undoRedoPanel = new JPanel();
		undoRedoPanel.setLayout(new FlowLayout());

		undoButton = new JButton(new ImageIcon("undoButton2.jpe"));
		undoButton.setPreferredSize(new Dimension(50, 50));
		undoButton.setBackground(Color.WHITE);
		undoButton.setEnabled(true);

		redoButton = new JButton(new ImageIcon("redo2.jpg"));
		redoButton.setPreferredSize(new Dimension(50, 50));
		redoButton.setBackground(Color.WHITE);
		redoButton.setEnabled(false);

		undoRedoPanel.add(undoButton);
		undoRedoPanel.add(redoButton);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());

		pencilButton = new JButton();
		pencilButton.setIcon(new ImageIcon(format(40, 30, "pencil2.png")));
		pencilButton.setPreferredSize(new Dimension(50, 50));
		pencilButton.setBackground(Color.WHITE);

		boxButton = new JButton();
		boxButton.setIcon(new ImageIcon(format(40, 30, "rectangle.jpe")));
		boxButton.setPreferredSize(new Dimension(50, 50));
		boxButton.setBackground(Color.WHITE);

		bucketButton = new JButton();
		bucketButton.setIcon(new ImageIcon(format(40, 30, "bucket2.png")));
		bucketButton.setPreferredSize(new Dimension(50, 50));
		bucketButton.setBackground(Color.WHITE);

		lineButton = new JButton();
		lineButton.setIcon(new ImageIcon(format(40, 30, "lineTool.png")));
		lineButton.setPreferredSize(new Dimension(50, 50));
		lineButton.setBackground(Color.WHITE);

		ovalButton = new JButton();
		ovalButton.setIcon(new ImageIcon(format(40, 30, "ovalTool.jpe")));
		ovalButton.setPreferredSize(new Dimension(50, 50));
		ovalButton.setBackground(Color.WHITE);

		colorButton = new JButton();
		colorButton.setIcon(new ImageIcon(format(40, 30, "color.jpg")));
		colorButton.setPreferredSize(new Dimension(50, 50));
		colorButton.setBackground(Color.WHITE);

		buttonPanel.add(pencilButton);
		buttonPanel.add(lineButton);
		buttonPanel.add(boxButton);
		buttonPanel.add(ovalButton);
		buttonPanel.add(bucketButton);
		buttonPanel.add(colorButton);

		this.color = Color.BLACK;

		canvas = new Canvas();
		add(canvas, BorderLayout.CENTER);
		add(undoRedoPanel, BorderLayout.PAGE_END);
		add(buttonPanel, BorderLayout.PAGE_START);

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

		pencilButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				PencilTool pencil = new PencilTool(color);
				canvas.setTool(pencil);
				undoButton.setEnabled(true);
			}

		});

		lineButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				LineTool line = new LineTool(color);
				canvas.setTool(line);
				undoButton.setEnabled(true);
			}

		});

		boxButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				BoxTool box = new BoxTool(color);
				canvas.setTool(box);
				undoButton.setEnabled(true);
			}

		});

		ovalButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				OvalTool oval = new OvalTool(color);
				canvas.setTool(oval);
				undoButton.setEnabled(true);
			}

		});

		bucketButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				BucketTool bucket = new BucketTool(color);
				canvas.setTool(bucket);
				undoButton.setEnabled(true);
			}

		});

		colorButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(colorButton, "Choose a color",
						color);
				if (color != null) {
					canvas.setColor(color);
				}
			}

		});

	}

	public Image format(int width, int height, String imageName) {
		ImageIcon icon = new ImageIcon(imageName);
		Image image = icon.getImage().getScaledInstance(width, height,
				java.awt.Image.SCALE_SMOOTH);
		return image;
	}

	public static void main(String[] args) {
		PaintFrame p = new PaintFrame();
		p.setVisible(true);
	}

}
