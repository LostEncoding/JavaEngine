package client;

import java.awt.Color;

import client.panel.Screen;
import client.panel.premade.GameTestScreen;
import client.panel.premade.MenuScreen;

import javax.swing.*;

public class Client extends JFrame implements Runnable {
	public static final int WIDTH = 800, HEIGHT = 600;
	private boolean running;
	protected static Screen currScreen;

	public Client(String title) {
		super(title);
		currScreen = new MenuScreen(Color.BLACK, this);
		running = true;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		add(currScreen);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		new Thread(this).run();
	}

	@Override
	public void run() {
		while (running) {
			currScreen.update();
			currScreen.repaint();
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void changeScreen(Screen s){
		getContentPane().removeAll();
		getContentPane().add(s);
		currScreen = s;
		currScreen.repaint();
		currScreen.requestFocus();
		revalidate();
        repaint();
	}

}
