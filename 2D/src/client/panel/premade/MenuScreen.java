package client.panel.premade;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import source.objects.gui.Button;
import source.objects.gui.Text;
import source.objects.gui.UIObject;
import client.Frame;
import client.panel.ClickScreen;

public class MenuScreen extends ClickScreen {

	public MenuScreen(Color bg, Frame c) {
		super(bg, c);
		setBackground(Color.gray);
	}

	@Override
	public void loadObjects() {
	}

	@Override
	public void loadUIObjects() {
		addUIObject(new Button("New Game", 0, 50, 50, 100, 50, Color.darkGray));
		addUIObject(new Text("Hello", Frame.WIDTH / 2, 50, 40, Color.GREEN,
				Color.black));
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		playerClick = new Rectangle(e.getX() - 5, e.getY() - 5, 10, 10);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		for (UIObject uio : ui) {
			if (uio instanceof Button)
				if (playerClick.intersects(uio.getBounds())) {
					switch (((Button) uio).getScreenId()) {
					case 0:
						client.changeScreen(new GameTestScreen(Color.DARK_GRAY,
								client));
						break;
					default:
						printError(this.getClass(), "Screen-Button id mismatch");
						break;
					}
				}
		}
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
	}

	@Override
	public void update() {
	}

}
