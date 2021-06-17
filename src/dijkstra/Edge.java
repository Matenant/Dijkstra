package dijkstra;

public class Edge {
	private int id;
	private Vertex source;
	private Vertex destination;
	private int weight;
	
	public Edge(int id, Vertex s, Vertex d, int w) {
		this.id = id;
		source = s;
		destination = d;
		weight = w;
	}

	public int getId() {
		return id;
	}

	public Vertex getSource() {
		return source;
	}

	public Vertex getDestination() {
		return destination;
	}

	public int getWeight() {
		return weight;
	}
}
