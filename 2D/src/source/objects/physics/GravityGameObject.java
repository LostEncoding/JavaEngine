package source.objects.physics;

import source.objects.GameObject;

import java.awt.*;

public class GravityGameObject extends GameObject {
    public static final float GRAVITY = 1;
    public float yVelocity, xVelocity;

    public GravityGameObject(String name, float x, float y, int w, int h,
                             Color c) {
        super(name, x, y, w, h, c);
        yVelocity = 0;
        xVelocity = 0;
    }

    @Override
    public void update() {
        y += yVelocity;
        x += xVelocity;
        if (yVelocity < 10)
            applyYForce(GRAVITY);
    }

    public void applyYForce(float force) {
        yVelocity += force;
    }

    public void applyXForce(float force) {
        xVelocity += force;
    }
}
