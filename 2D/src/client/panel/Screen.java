package client.panel;

import client.Frame;
import source.objects.GameObject;
import source.objects.gui.UIObject;
import source.objects.physics.physical.player.PlayerController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Screen extends JPanel {
	private Color backgroundColor;
	protected float disX, disY;
	protected PlayerController player;
	protected ArrayList<GameObject> staticObjects, dynamicObjects;
	protected ArrayList<UIObject> ui;
	protected Frame client;

	public Screen(Color bg, Frame c) {
		super();
		client = c;
		disX = 0;
		disY = 0;
		dynamicObjects = new ArrayList<GameObject>();
		staticObjects = new ArrayList<GameObject>();
		ui = new ArrayList<UIObject>();
		backgroundColor = bg;
		setSize(Frame.WIDTH, Frame.HEIGHT);
		setVisible(true);
		loadUIObjects();
		loadObjects();
	}

	public abstract void loadObjects();

	public abstract void loadUIObjects();

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void addPlayer(String name, float x, float y, Color c) {
		player = new PlayerController(name, x, y, 10, 10, c);
	}

	public void addStaticObject(GameObject p) {
		staticObjects.add(p);
	}

	public void addDynamicObject(GameObject p) {
		dynamicObjects.add(p);
	}

	public void addUIObject(UIObject uio) {
		ui.add(uio);
	}

	public void checkCollisions() {
		for (GameObject sgo : staticObjects) {
			for (GameObject dgo : dynamicObjects) {
				dgo.intersects(sgo);
			}
		}
		for (GameObject sgo : staticObjects) {
			player.intersects(sgo);
		}
		for (GameObject dgo : dynamicObjects) {
			player.intersects(dgo);
		}
	}

	public void paint(Graphics g) {
		checkCollisions();
		g.setColor(backgroundColor);
		g.fillRect(0, 0, getWidth(), getHeight());
		if (player != null) {
			player.update();
			player.paint(g,disX,disY);
		}
		for (GameObject sgo : staticObjects) {
			sgo.update();
		}
		for (GameObject dgo : dynamicObjects) {
			dgo.update();
		}
		checkCollisions();
		for (UIObject b : ui) {
			b.paint(g,disX,disY);
		}
		for (GameObject sgo : staticObjects) {
			sgo.paint(g,disX,disY);
		}
		for (GameObject dgo : dynamicObjects) {
			dgo.paint(g,disX,disY);
		}
	}

	public abstract void update();

	public void printError(Class c, String message) {
		System.err.println("--------------------------------\nError: "
				+ c.getName() + "\n\t" + message
				+ "\n--------------------------------");
	}

}
