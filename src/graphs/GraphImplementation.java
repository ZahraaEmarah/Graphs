package graphs;

import java.util.LinkedList;
import java.util.List;

class Graph {
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

	boolean isConnected(int startingVertex, int endingVertex) {
		for (Edge i : G[startingVertex])
			if (i.vertex == endingVertex)
				return true;
		return false;
	}

	void addEdge(int startVertex, int endVertex, int weight) {
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

public class GraphImplementation {
	public static void main(String[] args) {
		Graph g = new Graph(4);
		PrimsAlgorithm p = new PrimsAlgorithm();

		g.addEdge(0, 1, 5);
		g.addEdge(0, 2, 11);
		g.addEdge(1, 0, 5);
		g.addEdge(1, 2, 10);
		g.addEdge(2, 3, 20);
		g.addEdge(2, 0, 11);
		g.addEdge(2, 1, 10);
		g.addEdge(0, 3, 13);
		g.addEdge(3, 1, 20);
		g.addEdge(3, 2, 13);

		/**
		 * MinHeap minHeap = new MinHeap(20); for (int j = 0; j < g.G.length; j++) { for
		 * (Edge i : g.G[j]) { minHeap.insert(i); } }
		 * 
		 * minHeap.minHeapify(); minHeap.print(); System.out.println("The Min val is " +
		 * minHeap.removeRoot());
		 */

		System.out.println(g);
		System.out.println(g.isConnected(0, 2));
		p.Prims(4, g);
	}
}
