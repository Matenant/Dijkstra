package comparaison;

import astar.*;
import dijkstra.*;

public class Main {
	public static void main(String[] args) {
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
		Vertex s7 = new Vertex(7, "Sommet 7");
		g.addVertexe(s7);
		Vertex s8 = new Vertex(8, "Sommet 8");
		g.addVertexe(s8);
		Vertex s9 = new Vertex(9, "Sommet 9");
		g.addVertexe(s9);
		Vertex s10 = new Vertex(10, "Sommet 10");
		g.addVertexe(s10);
		Vertex s11 = new Vertex(11, "Sommet 11");
		g.addVertexe(s11);
		Vertex s12 = new Vertex(12, "Sommet 12");
		g.addVertexe(s12);
		Vertex s13 = new Vertex(13, "Sommet 13");
		g.addVertexe(s13);
		Vertex s14 = new Vertex(14, "Sommet 14");
		g.addVertexe(s14);
		Vertex s15 = new Vertex(15, "Sommet 15");
		g.addVertexe(s15);
		Vertex s16 = new Vertex(16, "Sommet 16");
		g.addVertexe(s16);
		
		
		Edge e1 = new Edge(1, s1, s2, 10);
		g.addEdge(e1);
		Edge e2 = new Edge(2, s1, s5, 10);
		g.addEdge(e2);
		Edge e3 = new Edge(3, s1, s6, 14);
		g.addEdge(e3);
		Edge e4 = new Edge(4, s2, s3, 10);
		g.addEdge(e4);
		Edge e5 = new Edge(5, s2, s6, 10);
		g.addEdge(e5);
		Edge e6 = new Edge(6, s2, s7, 14);
		g.addEdge(e6);
		Edge e7 = new Edge(7, s3, s4, 10);
		g.addEdge(e7);
		Edge e8 = new Edge(8, s3, s7, 10);
		g.addEdge(e8);
		Edge e9 = new Edge(9, s3, s8, 14);
		g.addEdge(e9);
		Edge e10 = new Edge(10, s4, s8, 10);
		g.addEdge(e10);
		Edge e11 = new Edge(11, s5, s6, 10);
		g.addEdge(e11);
		Edge e12 = new Edge(12, s5, s9, 10);
		g.addEdge(e12);
		Edge e13 = new Edge(13, s5, s10, 14);
		g.addEdge(e13);
		Edge e14 = new Edge(14, s6, s7, 10);
		g.addEdge(e14);
		Edge e15 = new Edge(15, s6, s10, 10);
		g.addEdge(e15);
		Edge e16 = new Edge(16, s6, s11, 14);
		g.addEdge(e16);
		Edge e17 = new Edge(17, s7, s8, 10);
		g.addEdge(e17);
		Edge e18 = new Edge(18, s7, s11, 10);
		g.addEdge(e18);
		Edge e19 = new Edge(19, s7, s12, 14);
		g.addEdge(e19);
		Edge e20 = new Edge(20, s8, s12, 10);
		g.addEdge(e20);
		Edge e21 = new Edge(21, s9, s10, 10);
		g.addEdge(e21);
		Edge e22 = new Edge(22, s10, s11, 10);
		g.addEdge(e22);
		Edge e23 = new Edge(23, s11, s12, 10);
		g.addEdge(e23);
		
		g.affichage();
		DijkstraAlgorithm da = new DijkstraAlgorithm(g);
		da.init(s1);
		long debut = System.currentTimeMillis();
		da.execute(s1);
		System.out.println(da.getPath(s6));
		System.out.println("Temps Dijkstra:");
		System.out.println(System.currentTimeMillis()-debut);
		
		
		Carte c = new Carte(4, 3);
		
		c.affiche();
		
		Node sourceNode = new Node(0, 0);
		Node targetNode = new Node(3, 2);
		
		debut = System.currentTimeMillis();
		c.findPath(sourceNode, targetNode);
		System.out.println(c.calcPath(sourceNode, targetNode));
		System.out.println("Temps A*:");
		System.out.println(System.currentTimeMillis()-debut);
		
	}
}
