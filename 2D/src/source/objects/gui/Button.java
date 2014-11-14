package source.objects.gui;

import java.awt.*;

public class Button extends UIObject {
	private int screenId;
	public Button(String name, int screenId, float x, float y, int w, int h, Color c) {
		super(name, x, y, w, h, c);
		this.screenId = screenId;
	}

	@Override
	public void paint(Graphics g, float disX, float disY) {
		int stringWidth = textWidth(g);
		g.setColor(Color.black);
		g.drawRect((int) x + (int) disX, (int) y + (int) disY, width+1, height+1);
		g.setColor(color);
		g.fillRect((int) x + (int) disX+1, (int) y + (int) disY+1, width, height);
		g.setColor(Color.black);
		g.drawString(name, (int) x + (int) disX+1+stringWidth/4, (int) y+1  + height
				/ 2);
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x,(int)y,width,height);
	}
	
	public int getScreenId(){
		return screenId;
	}
	
}
