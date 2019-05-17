package prim;

import implementations.Graph;
import implementations.Graph.Edge;
import implementations.MinHeap;
import implementations.MinHeap.HeapNode;

public class PrimsAlgorithm {

	int cost = 0;
	int MST[];
	int index = 0;

	public void Prims(int verticesNo, int startpoint, Graph g) {

		HeapNode[] heapnode = new HeapNode[verticesNo];
		HeapNode Adjacent[] = new HeapNode[verticesNo];
		HeapNode tmp;
		MST = new int[verticesNo];
		MinHeap minHeap = new MinHeap(verticesNo);

		for (int i = 0; i < verticesNo; i++) {
			heapnode[i] = new HeapNode();
			heapnode[i].vertex = i;
			heapnode[i].key = Integer.MAX_VALUE;

			Adjacent[i] = new HeapNode();
			Adjacent[i].vertex = i;
			Adjacent[i].key = Integer.MAX_VALUE;
		}

		int vertex_in_spotlight;
		heapnode[startpoint].key = 0;

		for (int i = 0; i < verticesNo; i++) {
			minHeap.insert(heapnode[i]);
		}
		for (int i = 0; i < MST.length; i++) {
			MST[i] = Integer.MIN_VALUE;
		}

		while (!minHeap.isEmpty()) {

			minHeap.display();
			tmp = minHeap.extractMin();

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
					int destination = i.vertex;
					c++;
				}
			}

			for (int k = 0; k < c; k++) {
				int ind = minHeap.searchHeap(Adjacent[k].vertex);
				if (Adjacent[k].key < minHeap.mH[ind].key) {
					decreaseKey(minHeap, Adjacent[k].key, Adjacent[k].vertex);
					heapnode[Adjacent[k].vertex].key = Adjacent[k].key;
				}
			}

			for (int k = 0; k < c; k++) {
				System.out.println(Adjacent[k].vertex + " - " + Adjacent[k].key);

			}
			System.out.println("");
		}

		System.out.print("The Minimum spanning Tree is : ");
		for (int i = 0; i < index; i++) {
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

	public void decreaseKey(MinHeap minHeap, int newKey, int vertex) {

		// get the index which distance's needs a decrease;
		int index = minHeap.searchHeap(vertex);

		// get the node and update its value
		HeapNode node = minHeap.mH[index];
		node.key = newKey;
		minHeap.bubbleUp(index);
	}

	public int getweight() {
		return cost;
	}

	public int[] getMST() {
		return MST;
	}

}
