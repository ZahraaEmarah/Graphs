package prim;

import implementations.Graph;
import implementations.Graph.Edge;
import implementations.Heap;
import implementations.Heap.HeapNode;

public class PrimsAlgorithm {

	public void Prims(int verticesNo, Graph g) {

		HeapNode[] heapnode = new HeapNode[verticesNo];
		HeapNode Adjacent[] = new HeapNode[verticesNo];
		HeapNode tmp;
		int MST[] = new int[verticesNo];
		Heap minHeap = new Heap(verticesNo);
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

		int vertex_in_spotlight;
		heapnode[0].key = 0;

		for (int i = 0; i < verticesNo; i++) {
			minHeap.insert(heapnode[i]);
		}

		while (!minHeap.isEmpty()) {

			tmp = minHeap.remove();
			if (tmp == null)
				break;
			if (tmp.key == Integer.MAX_VALUE)
				break;

			cost = cost + tmp.key;
			vertex_in_spotlight = tmp.vertex;
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
							if (Adjacent[y].key < minHeap.Heap[ind].key) {
								minHeap.Heap[ind].key = Adjacent[y].key;
								minHeap.minHeapify(ind);
								minHeap.minHeap();
							}
						}
					}
				}
			}

			minHeap.minHeapify(1);
			minHeap.minHeap();
			minHeap.print();
			System.out.println("");
		}

		System.out.print("The Minimum spanning Tree is : ");
		for (int i = 0; i < MST.length; i++) {
			System.out.print(MST[i] + " ");
		}

		System.out.println("\n" + "The weight of the graph is   : " + cost);
	}

	public boolean isMST(int arr[], int vertex) {
		for (int i = 0; i < arr.length; i++) {
			if (vertex == arr[i])
				return true;
		}
		return false;
	}

}
