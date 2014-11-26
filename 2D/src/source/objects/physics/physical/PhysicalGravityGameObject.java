package source.objects.physics.physical;

import source.objects.GameObject;
import source.objects.physics.GravityGameObject;

import java.awt.*;

public class PhysicalGravityGameObject extends GravityGameObject {

    protected boolean isGrounded;
    protected boolean collideWithDynamticObject;
    protected float maxXVelocity = 2f;

    public PhysicalGravityGameObject(String name, float x, float y, int w,
                                     int h, Color c, String tag) {
        super(name, x, y, w, h, c, tag);
        isGrounded = false;
        collideWithDynamticObject = false;
    }

    @Override
    public void update() {
        if (isGrounded || collideWithDynamticObject)
            yVelocity = 0;
        if (xVelocity > maxXVelocity)
            xVelocity = maxXVelocity;
        super.update();
    }


    private boolean hit = false;

    @Override
    public boolean intersects(GameObject go) {
        if (go.getTag().equals("ground")) {
            isGrounded = (super.intersects(go));
            hit = (isGrounded && !hit);
            if (hit)
                y = go.getY() - height;
        } else {

            collideWithDynamticObject = (super.intersects(go) && go.getTag().equals("npc"));
            if (collideWithDynamticObject)
                y = go.getY() - (height*2)-1;
        }
        return super.intersects(go);
    }
}
