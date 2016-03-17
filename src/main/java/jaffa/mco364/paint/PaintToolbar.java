package jaffa.mco364.paint;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

@Singleton
public class PaintToolbar extends Container {

	private JPanel canvasPanel;

	private JButton pencilButton, ovalButton, boxButton, lineButton,
	bucketButton, colorButton;

	private Color color;

	@Inject
	public PaintToolbar(final Canvas canvas, final PaintProperties properties) {
		setLayout(new FlowLayout());

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
			add(button);
			button.addActionListener(listener);
		}

		colorButton = new JButton(new ImageIcon(getClass().getResource(
				"/color.jpg")));
		colorButton.setPreferredSize(new Dimension(50, 50));
		colorButton.setBackground(Color.WHITE);
		add(colorButton);

		this.color = Color.BLACK;

		colorButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(colorButton, "Choose a color",
						color);
				if (color != null) {
					properties.setColor(color);
				}
			}

		});

		// canvasPanel = new JPanel();

	}

}
