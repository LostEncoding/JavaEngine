package source.objects.gui;

import java.awt.Color;
import java.awt.Graphics;

import source.objects.GameObject;

public class Button extends GameObject {

	public Button(String name, float x, float y, int w, int h, Color c) {
		super(name, x, y, w, h, c);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.drawRect((int) x, (int) y, width, height);
		g.setColor(color);
		g.fillRect((int) x, (int) y, width, height);
		g.setColor(Color.black);
		g.drawString(name, (int) x, (int) y + height / 2);
	}

}
