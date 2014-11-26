package source.objects.physics.physical.player;

import source.objects.GameObject;
import source.objects.physics.physical.PhysicalGravityGameObject;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PlayerController extends PhysicalGravityGameObject {
    private final int JUMP_LIMIT = 1,
            JUMP_POWER = 20,
            MOVEMENT_SPEED = 2,
            SLAM_SPEED = 5;

    public PlayerController(String name, float x, float y, int w, int h, Color c) {
        super(name, x, y, w, h, c, "player");
    }

    private int jumpCount = 0;

    public void move(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_D:
                x += MOVEMENT_SPEED;
                break;
            case KeyEvent.VK_A:
                x -= MOVEMENT_SPEED;
                break;
            case KeyEvent.VK_W:
                break;
            case KeyEvent.VK_S:
                y += SLAM_SPEED;
                break;
            case KeyEvent.VK_SPACE:
                if (jumpCount < JUMP_LIMIT) {
                    isGrounded = false;
                    collideWithDynamticObject = false;
                    jumpCount++;
                    yVelocity -= JUMP_POWER;
                    update();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void update() {
        System.out.println(yVelocity);
        super.update();
    }

    @Override
    public boolean intersects(GameObject go) {
        if (isGrounded || collideWithDynamticObject)
            jumpCount = 0;

        return super.intersects(go);
    }
}
