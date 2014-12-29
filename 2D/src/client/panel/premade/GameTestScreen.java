package client.panel.premade;

import client.Frame;
import client.panel.KeyScreen;
import source.objects.physics.physical.PhysicalGameObject;
import source.objects.physics.physical.PhysicalGravityGameObject;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameTestScreen extends KeyScreen {

    private KeyEvent key;
    private boolean keyDown;

    public GameTestScreen(Color bg, Frame c) {
        super(bg, c);
        keyDown = false;
        addPlayer("Zach", 60, 60, Color.black);
    }

    @Override
    public void loadObjects() {
        addStaticObject(new PhysicalGameObject("ground", 0, 500, 600, 10,
                Color.GREEN,"ground"));
        addDynamicObject(new PhysicalGravityGameObject("test", 300, 0, 50, 30,
                Color.YELLOW,"npc"));
        addDynamicObject(new PhysicalGravityGameObject("test", 200, 0, 50, 30,
                Color.BLUE,"npc"));
        addDynamicObject(new PhysicalGravityGameObject("test", 0, 30, 50, 30,
                Color.red,"npc"));
    }

    @Override
    public void loadUIObjects() {

    }

    @Override
    public void update() {
        if (key != null)
            player.move(key);

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() != KeyEvent.VK_SPACE) {
            key = e;
            keyDown = true;
        }else{
            player.move(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() != KeyEvent.VK_SPACE) {
            key = null;
            keyDown = false;
        }
    }

}
