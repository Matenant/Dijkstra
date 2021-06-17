package astar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Carte {
	private int width;
	private int height;
	private Node[][] nodes;
	private Set<Node> openList;
	private Set<Node> closedList;
	
	public Carte(int width, int height) {
		this.width = width;
		this.height = height;
		nodes = new Node[width][height];
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				nodes[i][j] = new Node(i, j);
			}
		}
		openList = new HashSet<Node>();
		closedList = new HashSet<Node>();
	}
	
	public void init() {
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				if(nodes[i][j].isWalkable()) {
					nodes[i][j] = new Node(i, j);
				}
			}
		}
		openList = new HashSet<Node>();
		closedList = new HashSet<Node>();
	}
	
	public void setObstacle(int x, int y) {
		nodes[x][y].setWalkable(false);
	}
	
	public void setObstacleAlea(int pour) {
		
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				int r = (int) (Math.random()*100);
				if(r <= pour) {
					setObstacle(i, j);
				}
			}
		}
		
	}
	
	public void affiche() {
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				if(nodes[i][j].isWalkable()) {
					System.out.print("1|");
				}
				else {
					System.out.print("0|");
				}
			}
			System.out.println();
		}
	}
	
	public void affichageSolution(Node source, Node fin) {
		List<Node> ns = calcPath(source, fin);
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				if(ns.contains(nodes[i][j])) {
					System.out.print("2|");
				}
				else if(nodes[i][j].isWalkable()) {
					System.out.print("1|");
				}
				else {
					System.out.print("0|");
				}
			}
			System.out.println();
		}
	}
	
	public Node getNode(int x, int y) {
		return nodes[x][y];
	}
	
	public Node getNodeWithLowestCost() {
		Node min = null;
		int minV = Integer.MAX_VALUE;
		for(Node n : openList) {
			if(minV > n.getfCosts()) {
				minV = n.getfCosts();
				min = n;
			}
		}
		return min;
	}
	
	public Set<Node> getAdjacent(Node current) {
		Set<Node> nodes = new HashSet<Node>();
		
		for(int y = current.getyPosition()-1; y <= current.getyPosition()+1; y++) {
			
			for(int x = current.getxPosition()-1; x <= current.getxPosition()+1; x++) {

				if(x != current.getxPosition() || y != current.getyPosition()) {
					
					if(x >= 0 && x < width) {
						
						if(y >= 0 && y < height) {
							
							if(this.nodes[x][y].isWalkable()) {
								
								if(!closedList.contains(this.nodes[x][y])) {
									
									Node n = new Node(x, y);
									
									if(x == current.getxPosition()-1 && y == current.getyPosition()-1 || 
										x == current.getxPosition()+1 && y == current.getyPosition()+1 ||
										x == current.getxPosition()-1 && y == current.getyPosition()+1 ||
										x == current.getxPosition()+1 && y == current.getyPosition()-1) {
										n.setIsDiagonaly(true);
									}
									
									nodes.add(n);
								}
							}
						}
					}
				}
			}
		}
		return nodes;
	}
	
	public int findPath(Node sourceNode, Node targetNode) {
		
		openList.add(sourceNode);
		
		while(true) {
			Node current = getNodeWithLowestCost();
			openList.remove(current);
			closedList.add(current);
			
			if(current.equals(targetNode)) {
				return 1;
			}
			
			Set<Node> adjacentNodes = getAdjacent(current);
			
			//on modifier les nodes dans notre tableaux sinon ils ne sont pas enregistré.
			for(Node neighbour : adjacentNodes) {
				if(!openList.contains(neighbour)) {
					nodes[neighbour.getxPosition()][neighbour.getyPosition()].setPrevious(nodes[current.getxPosition()][current.getyPosition()]);
					
					nodes[neighbour.getxPosition()][neighbour.getyPosition()].sethCosts(nodes[targetNode.getxPosition()][targetNode.getyPosition()]);
					
					nodes[neighbour.getxPosition()][neighbour.getyPosition()].setgCosts(nodes[current.getxPosition()][current.getyPosition()]);
					
					openList.add(nodes[neighbour.getxPosition()][neighbour.getyPosition()]);
				}
				else {
					if(neighbour.getgCosts() > neighbour.calculategCosts(current)) {
						nodes[neighbour.getxPosition()][neighbour.getyPosition()].setPrevious(nodes[current.getxPosition()][current.getyPosition()]);
						
						nodes[neighbour.getxPosition()][neighbour.getyPosition()].setgCosts(nodes[current.getxPosition()][current.getyPosition()]);
					}
				}
			}
			if(openList.isEmpty()) {
				return 0;
			}
		}
	}
	
	public List<Node> calcPath(Node sourceNode, Node targetNode){
		List<Node> chemin = new ArrayList<Node>();
		targetNode = nodes[targetNode.getxPosition()][targetNode.getyPosition()];
		chemin.add(targetNode);
		while(targetNode != null) {
			targetNode = targetNode.getPrevious();
			if(targetNode != null) {
				chemin.add(targetNode);
			}
		}
		Collections.reverse(chemin);
		return chemin;
	}
}
