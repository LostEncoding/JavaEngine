package client.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import source.Point;
import source.objects.GameObject;
import source.objects.gui.UIObject;
import client.Client;

public abstract class Screen extends JPanel {
	private Color backgroundColor;
	protected ArrayList<GameObject> objects;
	protected ArrayList<UIObject> ui;
	
	public Screen(Color bg) {
		super();
		objects = new ArrayList<GameObject>();
		ui = new ArrayList<UIObject>();
		backgroundColor = bg;
		setSize(Client.WIDTH, Client.HEIGHT);
		setVisible(true);
	}
	
	public abstract void loadObjects();
	public abstract void loadUIObjects();
	
	public Color getBackgroundColor(){
		return backgroundColor;
	}
	
	public void addObject(GameObject p){
		objects.add(p);
	}
	
	public void addUIObject(UIObject uio){
		ui.add(uio);
	}

	public void paint(Graphics g) {
		g.setColor(backgroundColor);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	public abstract void update(float deltaTime);

}
