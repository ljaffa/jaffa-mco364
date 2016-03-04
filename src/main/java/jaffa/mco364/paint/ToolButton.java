package jaffa.mco364.paint;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ToolButton extends JButton {

	private Tool tool;

	public ToolButton(Tool tool, String iconName) {
		this.tool = tool;
		ImageIcon icon = new ImageIcon(getClass().getResource(iconName));
		// this.setIcon(new ImageIcon(getClass().getResource(iconName)));
		this.setIcon(icon);
	}

	public Tool getTool() {
		return tool;
	}

}
