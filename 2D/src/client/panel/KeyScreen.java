package client.panel;

import java.awt.Color;
import java.awt.event.KeyListener;

import client.Client;

public abstract class KeyScreen extends Screen implements KeyListener{
	
	public KeyScreen(Color bg, Client c) {
		super(bg,c);
		addKeyListener(this);
	}

}
