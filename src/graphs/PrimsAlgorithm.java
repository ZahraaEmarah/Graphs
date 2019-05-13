package graphs;

import graphs.Graph.Edge;
import graphs.MinHeap.HeapNode;

public class PrimsAlgorithm {

	public void Prims(int verticesNo, Graph g) {

		HeapNode[] heapnode = new HeapNode[verticesNo];
		int MST[] = new int[verticesNo];
		HeapNode Adjacent[] = new HeapNode[verticesNo];
		int index = 0;

		for (int i = 0; i < verticesNo; i++) {
			heapnode[i] = new HeapNode();
			heapnode[i].vertex = i;
			heapnode[i].key = Integer.MAX_VALUE;

			Adjacent[i] = new HeapNode();
			Adjacent[i].vertex = i;
			Adjacent[i].key = Integer.MAX_VALUE;
		}

		int minKey;
		boolean visited = false;
		minKey = heapnode[0].key = 0;
		HeapNode tmp = heapnode[0];
		// heapnode[3].key = -1;

		MinHeap minHeap = new MinHeap(verticesNo);
		// add all the vertices to priority queue
		for (int i = 0; i < verticesNo; i++) {
			minHeap.insert(heapnode[i]);
		}
		minHeap.minHeapify();
		minHeap.print();

		for (int i = 0; i < minHeap.Heap.length; i++) {
			if (minHeap.Heap[i].key < minKey) {

				minKey = minHeap.Heap[i].key;
				tmp = minHeap.Heap[i];
			}

		}
		System.out.println(minKey + "z" + tmp.vertex);

		for (int i = 0; i < index; i++) {
			if (tmp.vertex == MST[i])
				visited = true;
		}

		if (visited == false) {
			MST[index] = tmp.vertex;
			index++;
			// System.out.println(MST[index - 1]);
		}

		minHeap.removeNode(tmp);
		minHeap.print(); ////////// VERIFIED
		minKey = Integer.MAX_VALUE;

		int c = 0;
		for (Edge i : g.G[tmp.vertex]) {

			if (!isMST(MST, i.vertex)) {
				System.out.println("yay"); ///// VERIFIED
				Adjacent[c].key = i.weight;
				Adjacent[c].vertex = i.vertex;
				System.out.println(Adjacent[c].key + " " + Adjacent[c].vertex);
				c++;
			}

		}

		for (int y = 0; y < c; y++) {

			int ind = minHeap.searchHeap(Adjacent[y]); /// opss infinte here

			if (Adjacent[y].key < minHeap.Heap[ind].key) {
				minHeap.Heap[ind].key = Adjacent[y].key;
			}

		}
		minHeap.minHeapify();
		minHeap.print();
	}

	public boolean isMST(int arr[], int vertex) {
		for (int i = 0; i < arr.length; i++) {
			if (vertex == arr[i])
				return true;
		}
		return false;
	}

}
