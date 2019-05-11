package graphs;

import java.util.LinkedList;
import java.util.List;

import graphs.Graph.Edge;

class Graph {
	public class Edge {
		int Startvertex, Endvertex, weight;

		public Edge(int v1, int v2, int w) {
			this.Startvertex = v1;
			this.Endvertex = v2;
			this.weight = w;
		}

		@Override
		public String toString() {
			return "(" + Startvertex + "," + weight + "," + Endvertex + ")";
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
			if (i.Endvertex == endingVertex)
				return true;
		return false;
	}

	void addEdge(int startingVertex, int endingVertex, int weight) {
		G[startingVertex].add(0, new Edge(startingVertex, endingVertex, weight));
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

		System.out.println("The Min Heap is ");
		MinHeap minHeap = new MinHeap(10);
		for (Edge i : g.G[0]) {
			minHeap.insert(i);
		}
		minHeap.minHeap();
		minHeap.print();
		System.out.println("The Min val is " + minHeap.GetRoot());

		System.out.println(g);
		System.out.println(g.isConnected(0, 2));
	}
}
