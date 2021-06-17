package dijkstra;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class DijkstraAlgorithm {
	private Graph graph;
	private Set<Vertex> open;
	private Set<Vertex> closed;
	private Map<Vertex, Integer> distance;
	private Map<Vertex, Vertex> parent;
	
	public DijkstraAlgorithm(Graph graph) {
		this.graph = graph;
		open = new HashSet<Vertex>();
		closed = new HashSet<Vertex>();
		distance = new HashMap<>();
		parent = new HashMap<>();
	}
	
	public void init(Vertex sourceNode) {
		open.add(sourceNode);
		for(Vertex v : graph.getVertexes()) {
			if(v.equals(sourceNode)) {
				distance.put(sourceNode, 0);
			}
			else {
				distance.put(v, Integer.MAX_VALUE);
			}
			parent.put(v, null);
		}
		
	}
	
	public void displayCurrentState() {
		System.out.println("Open= "+open);
		System.out.println("Closed= "+closed);
		System.out.println("Distance= "+distance);
		System.out.println("Parent= "+parent);
	}
	
	public List<Vertex> getNeighbors(Vertex node){
		List<Vertex> neighbors = new ArrayList<Vertex>();
		List<Edge> e = graph.getEdges();
		
		for(int i =0; i < e.size(); i++) {
			if(node.equals(e.get(i).getSource())) {
				if(!closed.contains(e.get(i).getDestination())){
					neighbors.add(e.get(i).getDestination());
				}
			}
		}
		return neighbors;
	}
	
	public Vertex getNodeWithLowestDistance(Set<Vertex> nodes) {
		int min = Integer.MAX_VALUE;
		Vertex minV = null;
		for(Vertex e : nodes) {
			if(distance.get(e) < min) {
				min = distance.get(e);
				minV = e;
			}
		}
		return minV;
	}
	
	public LinkedList<Vertex> getPath(Vertex target) {
		LinkedList<Vertex> chemin = new LinkedList<Vertex>();
		Vertex v = target;
		chemin.add(v);
		while(v != null) {
			v = parent.get(v);
			if(v != null) {
				chemin.addFirst(v);
			}
		}
		
		return chemin;
	}
	
	public void execute(Vertex sourceNode) {
		while(!open.isEmpty()) {
			Vertex current = getNodeWithLowestDistance(open);
			open.remove(current);
			closed.add(current);
			
			// On récupère la liste des voisins qui ne sont pas dans closed
			List<Vertex> voisins = getNeighbors(current);
			
			for(Vertex v : voisins) {
				if(!closed.contains(v)) {
					int tempDist = graph.getDistance(current, v) + distance.get(current);
					
					if(tempDist < distance.get(v)){
						distance.put(v, tempDist);
						open.add(v);
						parent.put(v, current);
					}
				}
			}
		}
	}
}
