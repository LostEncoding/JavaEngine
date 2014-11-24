package source.objects;

import source.Particle;
import source.interfaces.IUpdatable;

import java.awt.*;

public class GameObject extends Particle implements IUpdatable {
	protected int width, height;
	protected String tag;

	public GameObject(String name, float x, float y, int w, int h, Color c, String tag) {
		super(name, x, y, c);
		this.tag = tag;
		width = w;
		height = h;
	}

	@Override
	public void paint(Graphics g, float disX, float disY) {
		g.setColor(color);
		g.fillRect((int) x + (int) disX, (int) y + (int) disY, width, height);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, width + 1, height + 1);
	}

	public String getTag(){
		return tag;
	}

	public boolean intersects(GameObject go) {
		return this != go && go.getBounds().intersects(getBounds());
	}

	@Override
	public void update() {
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameObject other = (GameObject) obj;
		if (height != other.height)
			return false;
        return width == other.width;
    }

}
