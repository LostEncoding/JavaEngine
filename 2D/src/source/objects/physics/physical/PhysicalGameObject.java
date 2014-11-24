package source.objects.physics.physical;

import source.objects.GameObject;

import java.awt.*;

public class PhysicalGameObject extends GameObject {

	public PhysicalGameObject(String name, float x, float y, int w, int h,
			Color c, String tag) {
		super(name, x, y, w, h, c, tag);
	}

	@Override
	public boolean intersects(GameObject go) {
		return super.intersects(go);
	}

}
