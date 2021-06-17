package astarmvc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainGraphique extends JFrame implements Observer{
	private Panel pan = new Panel();
	
	private int height = 100;
	private int width = 70;
	
	private Node sourceNode;
	private Node targetNode;
	private Controler control;
	List<Node> ns;
	Carte c;
	
	public static void main(String[] args) {
		MainGraphique fen = new MainGraphique();
		fen.setTitle("A*");
		fen.setResizable(false);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.pack();
		fen.setVisible(true);
	}
		
	public MainGraphique() {
		
		/*
		 * Définit la taille de la fenetre
		 */
		c = new Carte(width, height);
		
		
		
		control = new Controler(c);
		
		
		
		sourceNode = new Node(0, 0);
		targetNode = new Node(24, 24);
		
		/*
		 * Le paramètre corresponds au pourcentage d'obstacle (environ)
		 */
		c.setObstacleAlea(25);
		
		/*
		 * Premier appelle a la fonction findpath et calcpath
		 * il faut passer les nodes source et target
		 * quand on clique sur l'écran on modifie juste le target
		 */
		c.findPath(sourceNode, targetNode);
		ns = c.calcPath(sourceNode, targetNode);
		
		pan.setPreferredSize(new Dimension(height*10, width*10));
		pan.addMouseListener(control);
		
		c.addObserver(this);
		
		this.add(pan);
	}
	
	class Panel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			for(int i = 0; i < width*10; i = i+10) {
				for(int j = 0; j < height*10; j = j+10) {
					if(c.getNode(i/10, j/10).equals(sourceNode) || c.getNode(i/10, j/10).equals(targetNode)) {
						g.setColor(Color.red);
						g.fillRect(j, i, 10, 10);
					}
					else if(ns.contains(c.getNode(i/10, j/10))) {
						g.setColor(Color.green);
						g.fillRect(j, i, 10, 10);
					}
					else if(c.getNode(i/10, j/10).isWalkable()) {
						g.setColor(Color.white);
						g.fillRect(j, i, 10, 10);
					}
					else {
						g.setColor(Color.black);
						g.fillRect(j, i, 10, 10);
					}
				}
			}
		}
	}



	@Override
	public void update(Observable o, Object arg) {
		Carte model = (Carte) o;
		targetNode = model.getTarget();
		
		c.findPath(sourceNode, targetNode);
		ns = c.calcPath(sourceNode, targetNode);
		repaint();
	}

}
