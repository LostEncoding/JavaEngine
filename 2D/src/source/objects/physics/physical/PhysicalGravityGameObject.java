package source.objects.physics.physical;

import java.awt.Color;

import source.interfaces.IPhysical;
import source.objects.GameObject;
import source.objects.physics.GravityGameObject;

public class PhysicalGravityGameObject extends GravityGameObject implements
		IPhysical {

	protected boolean isGrounded;

	public PhysicalGravityGameObject(String name, float x, float y, int w,
			int h, Color c) {
		super(name, x, y, w, h, c);
		isGrounded = false;
	}

	public void setGrounded(boolean tf) {
		isGrounded = tf;
	}

	@Override
	public void updatePhysics() {
		if (!isGrounded) {
			y += GRAVITY;
		}
	}

	@Override
	public void update() {
		updatePhysics();
	}
	
	@Override
	public boolean intersects(GameObject go) {
		isGrounded = super.intersects(go);
		return super.intersects(go);
	}
}
