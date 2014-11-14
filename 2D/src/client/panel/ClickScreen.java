package client.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseListener;

import client.Client;

public abstract class ClickScreen extends Screen implements MouseListener{
	protected Rectangle playerClick;
	
	public ClickScreen(Color bg, Client c){
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
