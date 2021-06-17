package dijkstra;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		//Graphique 1
		Graph g = new Graph();
		
		Vertex s1 = new Vertex(1, "Sommet 1");
		g.addVertexe(s1);
		Vertex s2 = new Vertex(2, "Sommet 2");
		g.addVertexe(s2);
		Vertex s3 = new Vertex(3, "Sommet 3");
		g.addVertexe(s3);
		Vertex s4 = new Vertex(4, "Sommet 4");
		g.addVertexe(s4);
		Vertex s5 = new Vertex(5, "Sommet 5");
		g.addVertexe(s5);
		Vertex s6 = new Vertex(6, "Sommet 6");
		g.addVertexe(s6);
		
		Edge e1 = new Edge(1, s1, s2, 3);
		g.addEdge(e1);
		Edge e2 = new Edge(2, s1, s3, 4);
		g.addEdge(e2);
		Edge e3 = new Edge(3, s1, s4, 2);
		g.addEdge(e3);
		Edge e4 = new Edge(4, s2, s3, 4);
		g.addEdge(e4);
		Edge e5 = new Edge(5, s2, s5, 2);
		g.addEdge(e5);
		Edge e6 = new Edge(6, s3, s5, 6);
		g.addEdge(e6);
		Edge e7 = new Edge(7, s4, s5, 1);
		g.addEdge(e7);
		Edge e8 = new Edge(8, s4, s6, 4);
		g.addEdge(e8);
		Edge e9 = new Edge(9, s5, s6, 2);
		g.addEdge(e9);
		
		System.out.println("Affichage du graphique:");
		g.affichage();
		System.out.println();
		System.out.println();
		System.out.println("Poids entre le sommet 1 et lui même: " + g.getDistance(s1, s1));
		System.out.println("Poids entre le sommet 1 et le sommet 3: " + g.getDistance(s1, s3));
		System.out.println("Poids entre le sommet 3 et le sommet 1: " + g.getDistance(s3, s1));
		System.out.println("Poids entre le sommet 1 et le sommet 6: " + g.getDistance(s1, s6));
	
		DijkstraAlgorithm da = new DijkstraAlgorithm(g);
		da.init(s1);
		
		System.out.println();
		System.out.println();
		System.out.println("Affichage de l'état des tableaux:");
		da.displayCurrentState();
		
		System.out.println();
		System.out.println();
		System.out.println("Affichage des voisins du sommet 1:");
		System.out.println(da.getNeighbors(s1));
		
		Set<Vertex> nodes = new HashSet<Vertex>();
		nodes.add(s1);
		nodes.add(s2);
		nodes.add(s3);
		System.out.println();
		System.out.println();
		System.out.println("Affichage du sommet avec la plus petite distance entre s1, s2 et s3:");
		System.out.println(da.getNodeWithLowestDistance(nodes));
		
		da.execute(s1);
		
		System.out.println();
		System.out.println();
		System.out.println("Résultat:");
		System.out.println(da.getPath(s6));
		
		System.out.println();
		System.out.println();
		System.out.println("Affichage de l'état des tableaux:");
		da.displayCurrentState();
		
		//Graphique 2
		Graph g2 = new Graph();
		
		Vertex D = new Vertex(1, "Sommet D");
		g2.addVertexe(D);
		Vertex B = new Vertex(2, "Sommet B");
		g2.addVertexe(B);
		Vertex E = new Vertex(3, "Sommet E");
		g2.addVertexe(E);
		Vertex C = new Vertex(4, "Sommet C");
		g2.addVertexe(C);
		Vertex F = new Vertex(5, "Sommet F");
		g2.addVertexe(F);
		Vertex A = new Vertex(6, "Sommet A");
		g2.addVertexe(A);
		
		Edge DB = new Edge(1, D, B, 3);
		g2.addEdge(DB);
		Edge DE = new Edge(2, D, E, 1);
		g2.addEdge(DE);
		Edge BE = new Edge(3, B, E, 1);
		g2.addEdge(BE);
		Edge BC = new Edge(4, B, C, 2);
		g2.addEdge(BC);
		Edge EC = new Edge(5, E, C, 3);
		g2.addEdge(EC);
		Edge EF = new Edge(6, E, F, 5);
		g2.addEdge(EF);
		Edge CF = new Edge(7, C, F, 1);
		g2.addEdge(CF);
		Edge CA = new Edge(8, C, A, 3);
		g2.addEdge(CA);
		Edge FA = new Edge(9, F, A, 1);
		g2.addEdge(FA);
		
		DijkstraAlgorithm da2 = new DijkstraAlgorithm(g2);
		da2.init(D);
		
		System.out.println();
		System.out.println();
		System.out.println("Affichage de l'état des tableaux:");
		da2.displayCurrentState();
		
		da2.execute(D);
		
		System.out.println();
		System.out.println();
		System.out.println("Résultat:");
		System.out.println(da2.getPath(A));
		
		System.out.println();
		System.out.println();
		System.out.println("Affichage de l'état des tableaux:");
		da2.displayCurrentState();
	}

}
