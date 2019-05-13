package prim;

import java.util.LinkedList;
import java.util.List;

public class Graph {
	public class Edge {
		int vertex, weight;

		public Edge(int v, int w) {

			this.vertex = v;
			this.weight = w;
			boolean visited = false;
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

	public boolean isConnected(int startingVertex, int endingVertex) {
		for (Edge i : G[startingVertex])
			if (i.vertex == endingVertex)
				return true;
		return false;
	}

	public void addEdge(int startVertex, int endVertex, int weight) {
		G[startVertex].add(0, new Edge(endVertex, weight));
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < G.length; i++)
			result += i + "=>" + G[i] + "\n";
		return result;
	}
}
