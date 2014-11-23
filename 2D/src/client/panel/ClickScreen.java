package client.panel;

import client.Frame;

import java.awt.*;
import java.awt.event.MouseListener;

public abstract class ClickScreen extends Screen implements MouseListener{
	protected Rectangle playerClick;
	
	public ClickScreen(Color bg, Frame c){
		super(bg,c);
		playerClick = new Rectangle();
		addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(playerClick.x, playerClick.y, playerClick.width,
				playerClick.height);
	}

}
