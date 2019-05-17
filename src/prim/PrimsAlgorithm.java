package prim;

import implementations.Graph;
import implementations.Graph.Edge;
import implementations.MinHeap;
import implementations.MinHeap.HeapNode;

public class PrimsAlgorithm {

	int cost = 0; /// total weight of the minimum spanning tree
	int MST[]; /// array to store visited vertices
	int index = 0;
	String mst = " ";

	public void Prims(int verticesNo, int startpoint, Graph g) {

		HeapNode[] heapnode = new HeapNode[verticesNo]; /// Heapnode for every vertex
		HeapNode Adjacent[] = new HeapNode[verticesNo]; /// Heapnode for adjacent vertices of a specific vertex
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

		for (int i = 0; i < verticesNo; i++) { /// Inserting the vertices in the heap
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

			cost = cost + tmp.key; // update total weight
			vertex_in_spotlight = tmp.vertex;
			MST[index++] = vertex_in_spotlight; // add extracted node to the visited vertices array

			int c = 0;
			for (Edge i : g.G[vertex_in_spotlight]) { // Inserting adjacent vertices to extracted node in adjacent array
				if (!isMST(MST, i.vertex)) {
					Adjacent[c].key = i.weight;
					Adjacent[c].vertex = i.vertex;
					c++;
				}
			}

			for (int k = 0; k < c; k++) { /// comparing each adjacent vertex key with its old one
				int ind = minHeap.searchHeap(Adjacent[k].vertex);
				if (Adjacent[k].key < minHeap.mH[ind].key) {
					decreaseKey(minHeap, Adjacent[k].key, Adjacent[k].vertex);
					heapnode[Adjacent[k].vertex].key = Adjacent[k].key; // updating heapnode array
				}
			}

			for (int k = 0; k < c; k++) {
				System.out.println(Adjacent[k].vertex + " - " + Adjacent[k].key);
			}
			System.out.println("");
		}

		// Printing minimum spanning tree
		System.out.print("The Minimum spanning Tree is : ");
		for (int i = 0; i < index; i++) {
			mst = mst + " " + Integer.toString(MST[i]);

		}
		System.out.print(mst + " ");

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

		int index = minHeap.indexes[vertex];

		HeapNode node = minHeap.mH[index];
		node.key = newKey;
		minHeap.bubbleUp(index);
	}

	public int getweight() {
		return cost;
	}

	public String getMST() {
		return mst;
	}

}
