package client.panel;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import source.Particle;
import source.objects.GameObject;
import client.Client;

public abstract class Screen extends JPanel {

	public Screen(){
		super();
		setSize(Client.WIDTH, Client.HEIGHT);
		setVisible(true);
	}

	public abstract void paint(Graphics g);

}
