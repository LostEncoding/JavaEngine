package source.objects.physics.physical;

import java.awt.Color;
import source.interfaces.IPhysical;
import source.objects.physics.GravityGameObject;

public class PhysicalGravityGameObject extends GravityGameObject implements
		IPhysical {

	private boolean isGrounded;

	public PhysicalGravityGameObject(String name, float x, float y, int w,
			int h, Color c) {
		super(name, x, y, w, h, c);
		isGrounded = false;
	}

	public void setGrounded(boolean tf) {
		isGrounded = tf;
	}

	@Override
	public void updatePhysics(float deltaTime) {
		if (!isGrounded) {
			y += GRAVITY;
		}
	}

	@Override
	public void update(float deltaTime) {
		updatePhysics(deltaTime);
	}

}
