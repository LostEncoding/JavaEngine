package source.objects.physics.physical.player;

import java.awt.Color;
import java.awt.event.KeyEvent;
import source.objects.physics.physical.PhysicalGravityGameObject;

public class PlayerController extends PhysicalGravityGameObject {

	public PlayerController(String name, float x, float y, int w, int h, Color c) {
		super(name, x, y, w, h, c);
	}

	public void move(KeyEvent ke) {
		switch (ke.getKeyCode()) {

		case KeyEvent.VK_D:
			x++;
			break;
		case KeyEvent.VK_A:
			x--;
			break;
		case KeyEvent.VK_W:

			break;
		case KeyEvent.VK_S:
			break;
		case KeyEvent.VK_SPACE:
			if (isGrounded)
				y -= 20;
			break;
		default:
			break;
		}
	}

}
