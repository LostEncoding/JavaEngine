package source.objects.physics.physical;

import java.awt.Color;

import source.interfaces.IPhysical;
import source.objects.GameObject;

public class PhysicalGameObject extends GameObject implements IPhysical {

	public PhysicalGameObject(String name, float x, float y, int w, int h,
			Color c) {
		super(name, x, y, w, h, c);
	}

	@Override
	public void updatePhysics(float deltaTime) {
		update(deltaTime);
	}


}
