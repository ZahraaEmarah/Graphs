package dijkstra;

import prim.Graph;
import prim.Graph.Edge;
import prim.MinHeap;
import prim.MinHeap.HeapNode;

public class DijkstrasAlgorithm {

	public void Prims(int verticesNo, Graph g) {

		HeapNode[] heapnode = new HeapNode[verticesNo];
		HeapNode Adjacent[] = new HeapNode[verticesNo];
		HeapNode tmp;
		int MST[] = new int[verticesNo];
		int index = 0;
		int cost = 0;

		for (int i = 0; i < verticesNo; i++) {
			heapnode[i] = new HeapNode();
			heapnode[i].vertex = i;
			heapnode[i].key = Integer.MAX_VALUE;

			Adjacent[i] = new HeapNode();
			Adjacent[i].vertex = i;
			Adjacent[i].key = Integer.MAX_VALUE;
		}

		int minKey;
		int vertex_in_spotlight;
		heapnode[0].key = 0;
		MinHeap minHeap = new MinHeap(verticesNo);

		for (int i = 0; i < verticesNo; i++) {
			minHeap.insert(heapnode[i]);
		}
		minHeap.buildminHeap();

		while (!minHeap.isEmpty()) {

			tmp = minHeap.removeRoot();
			if (tmp == null)
				break;

			cost = cost + tmp.key;
			minKey = tmp.key;
			vertex_in_spotlight = tmp.vertex;
			minHeap.buildminHeap();
			MST[index++] = vertex_in_spotlight;

			int c = 0;
			for (Edge i : g.G[vertex_in_spotlight]) {

				if (!isMST(MST, i.vertex)) {

					Adjacent[c].key = i.weight;
					Adjacent[c].vertex = i.vertex;
					c++;

					for (int y = 0; y < c; y++) {
						int ind = minHeap.searchHeap(Adjacent[y]);
						if (ind > -1) {
							//// Insert Dijkstra here
						}
					}

					minHeap.buildminHeap();

				}
			}

			minHeap.buildminHeap();
		}

	}

	public boolean isMST(int arr[], int vertex) {
		for (int i = 0; i < arr.length; i++) {
			if (vertex == arr[i])
				return true;
		}
		return false;
	}

}
