package source.objects.gui;

import source.objects.GameObject;
import java.awt.*;

public class UIObject extends GameObject {

	public UIObject(String name, float x, float y, int w, int h, Color c) {
		super(name, x, y, w, h, c,"UI");
	}

	public void setText(String s) {
		name = s;
	}

	public String getText() {
		return name;
	}

	public int textWidth(Graphics g) {
		return g.getFontMetrics().stringWidth(name);
	}

	public int stringWidth(Graphics g, String string) {
		return g.getFontMetrics().stringWidth(string);
	}
}
