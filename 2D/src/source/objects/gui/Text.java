package source.objects.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import source.objects.GameObject;

public class Text extends UIObject {
	private Color colorEnd;
	private int size;

	public Text(String text, float x, float y, int size, Color c, Color c2) {
		super(text, x, y, 10, 10, c);
		this.size = size;
		colorEnd = c2;
	}

	@Override
	public void paint(Graphics g, float disX, float disY) {
		Font font = new Font("Dialog", Font.BOLD, size);
		FontMetrics fontMetrics = g.getFontMetrics(font);
		Graphics2D g2D = (Graphics2D) g;
		g2D.setFont(font);
		GradientPaint gp = new GradientPaint(x - fontMetrics.stringWidth(name)
				/ 2, x, color, fontMetrics.stringWidth(name),
				fontMetrics.getHeight(), colorEnd);
		g2D.setPaint(gp);
		g2D.drawString(name, x + disX - textWidth(g) / 2, y + disY);
		GUI.resetG2D(g2D);
	}

}
