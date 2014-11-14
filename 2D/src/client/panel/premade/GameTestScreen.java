package client.panel.premade;

import java.awt.Color;
import java.awt.event.KeyEvent;
import source.objects.physics.physical.PhysicalGameObject;
import source.objects.physics.physical.PhysicalGravityGameObject;
import client.Client;
import client.panel.KeyScreen;

public class GameTestScreen extends KeyScreen {

	private KeyEvent key;
	private boolean keyDown;

	public GameTestScreen(Color bg, Client c) {
		super(bg, c);
		keyDown = false;
		addPlayer("Zach", 60, 60, Color.green);
	}

	@Override
	public void loadObjects() {
		addStaticObject(new PhysicalGameObject("ground", 0, 500, 600, 10,
				Color.GREEN));
		addDynamicObject(new PhysicalGravityGameObject("test", 200, 0, 50, 30,
				Color.BLUE));
		addDynamicObject(new PhysicalGravityGameObject("test", 100, 0, 50, 30,
				Color.yellow));
		addDynamicObject(new PhysicalGravityGameObject("test", 0, 0, 50, 30,
				Color.red));
	}

	@Override
	public void loadUIObjects() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		if (key != null)
			player.move(key);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		key = e;
		keyDown = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		key = null;
		keyDown = false;
	}

}
