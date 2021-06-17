package astar;

public class Main {

	public static void main(String[] args) {
		Carte c = new Carte(10, 10);
		
		Node sourceNode = new Node(0, 0);
		Node targetNode = new Node(9, 9);
		
		c.setObstacle(0, 1);
		c.setObstacle(1, 1);
		c.setObstacle(2, 1);
		c.setObstacle(3, 1);
		c.setObstacle(4, 1);
		c.setObstacle(5, 1);
		
		c.setObstacle(4, 4);
		c.setObstacle(5, 4);
		c.setObstacle(6, 4);
		c.setObstacle(7, 4);
		c.setObstacle(8, 4);
		c.setObstacle(9, 4);
		
		c.affiche();
		
		System.out.println("Sommet adjacent au sommet 1,1:");
		System.out.println(c.getAdjacent(new Node(1, 1)));
		
		System.out.println("Retour de la fonction (1->chemin trouvé | 2->chemin introuvable):");
		System.out.println(c.findPath(sourceNode, targetNode));
		System.out.println("Chemin trouvé par la fonction:");
		System.out.println(c.calcPath(sourceNode, targetNode));
		
		c.affichageSolution(sourceNode, targetNode);

	}

}
