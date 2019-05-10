package graphs;

import java.util.LinkedList;
import java.util.List;

class Graph {
	class Edge {
		int vertex, weight;

		public Edge(int v, int w) {
			this.vertex = v;
			this.weight = w;
		}

		@Override
		public String toString() {
			return "(" + vertex + "," + weight + ")";
		}
	}

	List<Edge> G[];

	public Graph(int vertexNo) {
		G = new LinkedList[vertexNo];
		for (int i = 0; i < G.length; i++)
			G[i] = new LinkedList<Edge>();
	}

	boolean isConnected(int startingVertex, int endingVertex) {
		for (Edge i : G[startingVertex])
			if (i.vertex == endingVertex)
				return true;
		return false;
	}

	void addEdge(int startingVertex, int endingVertex, int weight) {
		G[startingVertex].add(0, new Edge(endingVertex, weight));
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < G.length; i++)
			result += i + "=>" + G[i] + "\n";
		return result;
	}
}

public class GraphImplementation {
	public static void main(String[] args) {
		Graph g = new Graph(10);
		g.addEdge(0, 2, 10);
		g.addEdge(0, 5, 15);
		g.addEdge(2, 5, 10);
		g.addEdge(9, 3, 16);

		System.out.println(g);
		System.out.println(g.isConnected(0, 3));
	}
}
