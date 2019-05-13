package main;

import prim.Graph;
import prim.PrimsAlgorithm;

public class Main {

	public static void main(String[] args) {
		Graph g = new Graph(8);
		PrimsAlgorithm p = new PrimsAlgorithm();

		g.addEdge(0, 1, 8);
		g.addEdge(0, 4, 2);
		g.addEdge(1, 0, 8);
		g.addEdge(1, 3, 9);
		g.addEdge(1, 6, 1);
		g.addEdge(2, 4, 1);
		g.addEdge(3, 1, 9);
		g.addEdge(3, 5, 4);
		g.addEdge(4, 0, 2);
		g.addEdge(4, 2, 1);
		g.addEdge(4, 6, 3);
		g.addEdge(5, 3, 4);
		g.addEdge(6, 1, 1);
		g.addEdge(6, 4, 3);
		g.addEdge(6, 7, 9);
		g.addEdge(7, 6, 9);

		/**
		 * g.addEdge(0, 1, 2); g.addEdge(0, 2, 6); g.addEdge(1, 0, 2); g.addEdge(1, 3,
		 * 9); g.addEdge(1, 6, 3); g.addEdge(2, 0, 6); g.addEdge(2, 6, 1); g.addEdge(3,
		 * 1, 9); g.addEdge(4, 7, 3); g.addEdge(5, 6, 7); g.addEdge(5, 7, 5);
		 * g.addEdge(6, 1, 3); g.addEdge(6, 2, 1); g.addEdge(6, 5, 7); g.addEdge(7, 4,
		 * 3); g.addEdge(7, 5, 5);
		 **/
		System.out.println(g);
		p.Prims(8, g);
	}
}
