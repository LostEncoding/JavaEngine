package client.panel.premade;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import source.objects.GameObject;
import source.objects.gui.Button;
import client.panel.ClickScreen;

public class MenuScreen extends ClickScreen{
	private ArrayList<Button> buttons;
 	
	public MenuScreen() {
		super();
		setBackground(Color.gray);
		buttons = new ArrayList<Button>();
		buttons.add(new Button("New Game", 50, 50, 100, 50, Color.WHITE));
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
		for(Button b : buttons){
			b.paint(g);
		}
	}

}
