package astarmvc;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controler extends MouseAdapter {

	Carte model;
	
	public Controler(Carte c) {
		model = c;
	}

	public void mouseClicked(MouseEvent e) {
		Node targetNode = new Node(e.getY()/10, e.getX()/10);
		model.modifier(targetNode);
	}
}
