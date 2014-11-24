package source.objects.physics.physical.player;

import source.objects.physics.physical.PhysicalGravityGameObject;
import java.awt.*;
import java.awt.event.KeyEvent;

public class PlayerController extends PhysicalGravityGameObject {

    public PlayerController(String name, float x, float y, int w, int h, Color c) {
        super(name, x, y, w, h, c,"player");
    }

    public void move(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_D:
                x++;
                break;
            case KeyEvent.VK_A:
                x--;
                break;
            case KeyEvent.VK_W:
                break;
            case KeyEvent.VK_S:
                break;
            case KeyEvent.VK_SPACE:
                System.out.println(isGrounded);
                if (isGrounded) {
                    setGrounded(false);
                    System.out.println("jump");
                    yVelocity -= 20;
                    update();
                }
                break;
            default:
                break;
        }
    }

}
