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
        if(yAxisCollided)
            y = yPosWhenCollided;
        if(xAxisCollided)
            x = xPosWhenCollided;

    }

    private int xPosWhenCollided = 0,
                yPosWhenCollided = 0;
    protected boolean hit = false,
                    yAxisCollided = false,
                    xAxisCollided = false;

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
                System.out.println("----------------");
                System.out.println("Self:\n\tY: " + y  + "\n\tX: " + x + "\n\tBottom Y: " + y+height);
                System.out.println("Other:\n\tY: " + go.getY()  + "\n\tX: " + go.getX() + "\n\tBottom Y: " + (go.getY()+go.getBounds().height-1));
                if(y <= go.getY()) {
                    yVelocity = 0;
                    yAxisCollided = true;
                    yPosWhenCollided = (int) go.getY() - height;
                    isGrounded = true;
                }else if(y > go.getY() && !isGrounded){
                    yVelocity = 0;
                    y = go.getY()+go.getBounds().height;
                }else{
                    yAxisCollided = false;
                }
                if(y+height ==  go.getY()+go.getBounds().getHeight()-1){
                    if(!xAxisCollided) {
                        xAxisCollided = true;
                        xPosWhenCollided = (int) x;
                    }
                }else{
                    xAxisCollided = false;
                }
            }else{
                xAxisCollided = false;
                yAxisCollided = false;
            }
        }
        return super.intersects(go);
    }
}
