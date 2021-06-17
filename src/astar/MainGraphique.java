package astar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainGraphique extends JFrame implements MouseListener{
	private Panel pan = new Panel();
	private int height = 50;
	private int width = 50;
	private Node sourceNode;
	private Node targetNode;
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
		
		c = new Carte(width, height);
		
		sourceNode = new Node(0, 0);
		targetNode = new Node(10, 10);
		
		/*
		 * Le paramètre corresponds au pourcentage d'obstacle (environ)
		 */
		c.setObstacleAlea(25);
		
		c.findPath(sourceNode, targetNode);
		ns = c.calcPath(sourceNode, targetNode);
		
		pan.setPreferredSize(new Dimension(height*10, width*10));
		pan.addMouseListener(this);
		
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

	public void mouseClicked(MouseEvent e) {
		targetNode.setCoordinates(e.getY()/10, e.getX()/10);
		c.init();
		c.findPath(sourceNode, targetNode);
		ns = c.calcPath(sourceNode, targetNode);
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
