package source.objects.physics.physical;

import source.interfaces.IPhysical;
import source.objects.GameObject;
import source.objects.physics.GravityGameObject;

import java.awt.*;

public class PhysicalGravityGameObject extends GravityGameObject implements
        IPhysical {

    protected boolean isGrounded;
    protected float maxXVelocity = 2f;

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
        if(isGrounded)
            yVelocity = 0;
        if(xVelocity > maxXVelocity)
            xVelocity = maxXVelocity;
        super.update();

    }

    @Override
    public void update() {
        updatePhysics();
    }


    private boolean hit = false;
    @Override
    public boolean intersects(GameObject go) {
        isGrounded = super.intersects(go);
        if(isGrounded && !hit){
            y = go.getY() - height;
            hit = true;
        }else{
            hit = false;
        }
        return super.intersects(go);
    }
}
