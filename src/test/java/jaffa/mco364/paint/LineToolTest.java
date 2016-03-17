package jaffa.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;

import org.junit.Test;
import org.mockito.Mockito;

public class LineToolTest {

	@Test
	public void testMouseReleased() {

		PaintProperties properties = Mockito.mock(PaintProperties.class);

		Mockito.when(properties.getColor()).thenReturn(Color.RED);

		LineTool tool = new LineTool(properties);

		Graphics g = Mockito.mock(Graphics.class);
		tool.mousePressed(g, 5, 5);
		tool.mouseReleased(g, 10, 10);

		// check to make sure g.drawLine(5, 5, 10, 10) was called
		Mockito.verify(g).setColor(Color.RED);
		Mockito.verify(g).drawLine(5, 5, 10, 10);
	}

	@Test
	public void testDrawPreview() {

		PaintProperties properties = Mockito.mock(PaintProperties.class);

		Mockito.when(properties.getColor()).thenReturn(Color.RED);

		LineTool tool = new LineTool(properties);

		Graphics g = Mockito.mock(Graphics.class);

		tool.mousePressed(g, 6, 1);
		tool.mouseDragged(g, 9, 7);
		tool.drawPreview(g);

		Mockito.verify(g).setColor(Color.RED);
		Mockito.verify(g).drawLine(6, 1, 9, 7);

	}

}
