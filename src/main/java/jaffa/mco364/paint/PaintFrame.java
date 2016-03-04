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

	private PaintProperties properties;
	private Tool tool;

	public PaintFrame() {
		setTitle("PAINT");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		properties = new PaintProperties();

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		// canvasPanel = new JPanel();
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

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());

		ActionListener listener = new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				ToolButton button = (ToolButton) event.getSource();
				canvas.setTool(button.getTool());
			}

		};

		ToolButton buttons[] = new ToolButton[] {
				new ToolButton(new PencilTool(properties), "/pencil2.png"),
				new ToolButton(new LineTool(properties), "/lineTool.png"),
				new ToolButton(new BoxTool(properties), "/rectangle.jpe"),
				new ToolButton(new OvalTool(properties), "/ovalTool.jpe"),
				new ToolButton(new BucketTool(properties), "/bucket2.png"), };

		for (ToolButton button : buttons) {
			buttonPanel.add(button);
			button.addActionListener(listener);
		}

		/*
		 * pencilButton = new ToolButton(new PencilTool(properties),
		 * "/pencil2.png"); pencilButton.setPreferredSize(new Dimension(50,
		 * 50)); pencilButton.setBackground(Color.WHITE);
		 * 
		 * boxButton = new ToolButton(new BoxTool(properties),
		 * "/rectangle.jpe"); boxButton.setPreferredSize(new Dimension(50, 50));
		 * boxButton.setBackground(Color.WHITE);
		 * 
		 * bucketButton = new ToolButton(new BucketTool(properties),
		 * "/bucket2.png"); bucketButton.setPreferredSize(new Dimension(50,
		 * 50)); bucketButton.setBackground(Color.WHITE);
		 * 
		 * lineButton = new ToolButton(new LineTool(properties),
		 * "/lineTool.png"); lineButton.setPreferredSize(new Dimension(50, 50));
		 * lineButton.setBackground(Color.WHITE);
		 * 
		 * ovalButton = new ToolButton(new OvalTool(properties),
		 * "/ovalTool.jpe"); ovalButton.setPreferredSize(new Dimension(50, 50));
		 * ovalButton.setBackground(Color.WHITE);
		 */

		colorButton = new JButton(new ImageIcon(getClass().getResource(
				"/color.jpg")));
		// colorButton.setIcon(new ImageIcon(format(40, 30, "color.jpg")));
		colorButton.setPreferredSize(new Dimension(50, 50));
		colorButton.setBackground(Color.WHITE);
		buttonPanel.add(colorButton);

		/*
		 * buttonPanel.add(pencilButton); buttonPanel.add(lineButton);
		 * buttonPanel.add(boxButton); buttonPanel.add(ovalButton);
		 * buttonPanel.add(bucketButton); buttonPanel.add(colorButton);
		 */

		this.color = Color.BLACK;

		canvas = new Canvas(properties);
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

		colorButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(colorButton, "Choose a color",
						color);
				if (color != null) {
					properties.setColor(color);
				}
			}

		});

		/*
		 * pencilButton.addActionListener(listener);
		 * lineButton.addActionListener(listener);
		 * boxButton.addActionListener(listener);
		 * ovalButton.addActionListener(listener);
		 * bucketButton.addActionListener(listener);
		 */

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
