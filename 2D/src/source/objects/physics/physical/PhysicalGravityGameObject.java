package source.objects.physics.physical;

import source.objects.GameObject;
import source.objects.physics.GravityGameObject;

import java.awt.*;

public class PhysicalGravityGameObject extends GravityGameObject {

    protected boolean isGrounded;
    protected float maxXVelocity = 2f;

    public PhysicalGravityGameObject(String name, float x, float y, int w,
                                     int h, Color c,String tag) {
        super(name, x, y, w, h, c,tag);
        isGrounded = false;
    }

    public void setGrounded(boolean tf) {
        isGrounded = tf;
    }

    @Override
    public void update() {
        if(isGrounded)
            yVelocity = 0;
        if(xVelocity > maxXVelocity)
            xVelocity = maxXVelocity;
        super.update();

    }


    private boolean hit = false;
    @Override
    public boolean intersects(GameObject go) {
      isGrounded = (super.intersects(go) && go.getTag().equals("ground"));
        if(isGrounded && !hit){
            y = go.getY() - height;
            hit = true;
        }else{
            hit = false;
        }
        return super.intersects(go);
    }
}
