package source.objects.physics;

import java.awt.Color;

import source.objects.GameObject;

public class GravityGameObject extends GameObject{
	public static final float GRAVITY = 1;

	public GravityGameObject(String name, float x, float y, int w, int h,
			Color c) {
		super(name, x, y, w, h, c);
	}
	
	@Override
	public void update() {
		y+=GRAVITY;
	}
}
