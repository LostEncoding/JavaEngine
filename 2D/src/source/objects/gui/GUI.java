package source.objects.gui;

import java.awt.Font;
import java.awt.Graphics2D;

public class GUI {
	protected static final Font normalFont = new Font("Dialog", Font.PLAIN, 14);

	public static void resetG2D(Graphics2D g2D) {
		g2D.setFont(normalFont);
		g2D.setPaint(null);
	}
}
