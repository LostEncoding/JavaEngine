package client.panel.premade;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import source.Point;
import source.objects.GameObject;
import source.objects.gui.Button;
import source.objects.gui.Text;
import source.objects.gui.UIObject;
import source.objects.physics.GravityGameObject;
import source.objects.physics.physical.PhysicalGameObject;
import source.objects.physics.physical.PhysicalGravityGameObject;
import source.objects.player.PlayerController;
import sun.misc.Cleaner;
import client.Client;
import client.panel.ClickScreen;

public class MenuScreen extends ClickScreen {

	public MenuScreen(Color bg) {
		super(bg);
		setBackground(Color.gray);
		loadUIObjects();
		loadObjects();
	}
	
	@Override
	public void loadObjects() {
		addObject( new PhysicalGameObject("ground", 0, 500, 600, 10, Color.GREEN));
		addObject( new PhysicalGravityGameObject("test", 100, 0, 50, 30, Color.BLUE));
	}

	@Override
	public void loadUIObjects() {
		addUIObject(new Button("New Game", 50, 50, 100, 50, Color.darkGray));
		addUIObject(new Text("Hello", Client.WIDTH / 2, 50, 40, Color.GREEN,
						Color.black));
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (UIObject b : ui) {
			b.paint(g);
		}
		for(GameObject p : objects){
				p.update(.016f);
		}
		for(GameObject go : objects){
			for(int j = 1; j < objects.size(); j++){
				if(go instanceof PhysicalGravityGameObject){
					if(((PhysicalGravityGameObject)go).intersects(objects.get(j))){
						((PhysicalGravityGameObject)go).setGrounded(true);
					}else{
						((PhysicalGravityGameObject)go).setGrounded(false);
					}
					
//					((PhysicalGravityGameObject)go).setGrounded(((PhysicalGravityGameObject)go).intersects(objects.get(j)) ? true : false);
				}
			}
		}
		for(GameObject p : objects){
			p.paint(g);
		}
	}

	@Override
	public void update(float deltaTime) {
		
	}

}
