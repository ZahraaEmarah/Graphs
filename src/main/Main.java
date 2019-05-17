package main;

import dijkstra.DijkstrasAlgorithm;
import implementations.Graph;
import prim.PrimsAlgorithm;

public class Main {

	public static void main(String[] args) {
		Graph g = new Graph(8);
		Graph dg = new Graph(8);
		Graph dgg = new Graph(8);
		Graph ggd = new Graph(8);
		PrimsAlgorithm p = new PrimsAlgorithm();
		DijkstrasAlgorithm d = new DijkstrasAlgorithm();

		dg.addEdge(0, 2, 6);
		dg.addEdge(1, 0, 1);
		dg.addEdge(1, 3, 6);
		dg.addEdge(2, 6, 3);
		dg.addEdge(3, 5, 2);
		dg.addEdge(4, 2, 4);
		dg.addEdge(6, 4, 1);
		dg.addEdge(6, 2, 4);
		dg.addEdge(6, 5, 8);
		dg.addEdge(6, 7, 7);

		dgg.addEdge(0, 3, 8);
		dgg.addEdge(1, 0, 1);
		dgg.addEdge(2, 4, 5);
		dgg.addEdge(3, 7, 7);
		dgg.addEdge(4, 2, 8);
		dgg.addEdge(5, 3, 1);
		dgg.addEdge(5, 7, 8);
		dgg.addEdge(6, 7, 6);

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

		ggd.addEdge(0, 4, 5);
		ggd.addEdge(0, 2, 4);
		ggd.addEdge(1, 6, 5);
		ggd.addEdge(2, 6, 6);
		ggd.addEdge(2, 5, 3);
		ggd.addEdge(2, 0, 4);
		ggd.addEdge(3, 7, 4);
		ggd.addEdge(4, 7, 4);
		ggd.addEdge(4, 0, 5);
		ggd.addEdge(5, 2, 3);
		ggd.addEdge(6, 2, 6);
		ggd.addEdge(6, 1, 5);
		ggd.addEdge(7, 4, 4);
		ggd.addEdge(7, 3, 4);
		/**
		 * g.addEdge(0, 1, 2); g.addEdge(0, 2, 6); g.addEdge(1, 0, 2); g.addEdge(1, 3,
		 * 9); g.addEdge(1, 6, 3); g.addEdge(2, 0, 6); g.addEdge(2, 6, 1); g.addEdge(3,
		 * 1, 9); g.addEdge(4, 7, 3); g.addEdge(5, 6, 7); g.addEdge(5, 7, 5);
		 * g.addEdge(6, 1, 3); g.addEdge(6, 2, 1); g.addEdge(6, 5, 7); g.addEdge(7, 4,
		 * 3); g.addEdge(7, 5, 5);
		 **/
		System.out.println(ggd);
		// pr.Prims(8, dgg, 0);
		p.Prims(8, 4, ggd);
		// d.Dijkstra(8, 0, dg);
	}
}
