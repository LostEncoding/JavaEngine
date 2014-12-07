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

    public boolean isGrounded() {
        return isGrounded;
    }

    @Override
    public void update() {
        super.update();
        if (collideWithDynamticObject || isGrounded)
            yVelocity = 0;
        if (xVelocity > maxXVelocity)
            xVelocity = maxXVelocity;
    }


    private boolean hit = false;

    @Override
    public boolean intersects(GameObject go) {
        if (go.getTag().equals("ground")) {
            if (go.getY() >= y) {
                isGrounded = (super.intersects(go));
                hit = (isGrounded && !hit);
                if (hit)
                    y = go.getY() - height;
            }else{
                if(super.intersects(go)){
                    yVelocity = 0;
                    y = go.getY() + height+1;
                }
            }
        } else {
            collideWithDynamticObject = (super.intersects(go) && go.getTag().equals("npc"));
            if (collideWithDynamticObject) {
                y = go.getY() - height;
                isGrounded = true;
            }
        }
        return super.intersects(go);
    }
}
