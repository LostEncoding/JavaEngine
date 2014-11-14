import client.Client;
import client.panel.premade.MenuScreen;


public class Run {
	public static void main(String[] args) {
		Client c = new Client("TEST", new MenuScreen(Color.BLACK));
	} 
}
