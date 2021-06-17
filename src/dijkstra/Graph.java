package dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private List<Vertex> vertexes;
	private List<Edge> edges;
	
	public Graph() {
		vertexes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
	}

	public List<Vertex> getVertexes() {
		return vertexes;
	}

	public void addVertexe(Vertex vertexe) {
		vertexes.add(vertexe);
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void addEdge(Edge edge) {
		edges.add(edge);
	}
	
	public void affichage() {
		for(int i = 0; i < edges.size(); i++) {
			System.out.println();
			System.out.println("L'arrete d'id: "+edges.get(i).getId());
			System.out.println("Le sommet source: "+edges.get(i).getSource());
			System.out.println("A pour poids: "+edges.get(i).getWeight());
			System.out.println("Et va jusqu'au sommet destination: "+edges.get(i).getDestination());
		}
	}
	
	public int getDistance(Vertex node, Vertex target) {
		if(node.equals(target)) {
			return 0;
		}
		for(int i = 0; i < edges.size(); i++) {
			//Graphes orienté donc une seul condition de source vers destination et pas l'inverse
			if(node.equals(edges.get(i).getSource())) {
				if(target.equals(edges.get(i).getDestination())) {
					return edges.get(i).getWeight();
				}
			}
		}
		return -1;
	}
}
