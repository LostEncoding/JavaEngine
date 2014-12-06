package client.panel;

import client.Frame;
import java.awt.*;
import java.awt.event.KeyListener;

public abstract class KeyScreen extends Screen implements KeyListener{

	public KeyScreen(Color bg, Frame c) {
		super(bg,c);
		addKeyListener(this);
	}

}
