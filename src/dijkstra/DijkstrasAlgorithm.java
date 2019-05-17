package dijkstra;

import implementations.Graph;
import implementations.Graph.Edge;
import implementations.MinHeap;
import implementations.MinHeap.HeapNode;

public class DijkstrasAlgorithm {

	int distance = 0;
	HeapNode SHP[];

	public void Dijkstra(int verticesNo, int start, Graph g) {

		HeapNode[] heapnode = new HeapNode[verticesNo]; /// Heapnode for every vertex
		HeapNode Adjacent[] = new HeapNode[verticesNo]; /// Heapnode for adjacent vertices of a specific vertex
		HeapNode tmp; /// temporary heapnode for storing the extracted node
		SHP = new HeapNode[verticesNo]; /// Heapnode for visited vertices
		MinHeap minHeap = new MinHeap(verticesNo);
		int Dijkstra = 0;

		for (int i = 0; i < verticesNo; i++) {
			heapnode[i] = new HeapNode();
			heapnode[i].vertex = i;
			heapnode[i].key = Integer.MAX_VALUE;

			Adjacent[i] = new HeapNode();
			Adjacent[i].vertex = i;
			Adjacent[i].key = Integer.MAX_VALUE;

			SHP[i] = new HeapNode();
			SHP[i].vertex = Integer.MIN_VALUE;
			SHP[i].key = Integer.MIN_VALUE;
			SHP[i].source = -1;
		}

		int vertex_in_spotlight;
		heapnode[start].key = 0;
		heapnode[start].source = -1;

		for (int i = 0; i < verticesNo; i++) { /// Inserting vertices in the heap
			minHeap.insert(heapnode[i]);
		}

		while (!minHeap.isEmpty()) {

			minHeap.display();
			tmp = minHeap.extractMin();
			if (tmp.key == Integer.MAX_VALUE)
				break;

			Dijkstra = tmp.key;
			System.out.println("Disjkstra " + Dijkstra);
			vertex_in_spotlight = tmp.vertex;

			/// Mark the extracted node as visited
			SHP[vertex_in_spotlight].vertex = vertex_in_spotlight;
			SHP[vertex_in_spotlight].key = Dijkstra;
			SHP[vertex_in_spotlight].source = tmp.source;

			int c = 0;
			for (Edge i : g.G[vertex_in_spotlight]) {
				if (!isMST(SHP, i.vertex)) {
					Adjacent[c].key = i.weight; /// Populating the Adjacent array with all the adjacent vertices to the
					Adjacent[c].vertex = i.vertex; /// extracted node
					c++;
				}
			}

			for (int k = 0; k < c; k++) { /// comparing each adjacent vertex key with its old one
				int ind = minHeap.searchHeap(Adjacent[k].vertex);
				if (Adjacent[k].key + Dijkstra < minHeap.mH[ind].key) {
					decreaseKey(minHeap, Adjacent[k].key, Adjacent[k].vertex, Adjacent[k].source); // decrease in heap
					heapnode[Adjacent[k].vertex].key = Dijkstra + Adjacent[k].key; // update heapnode array
					heapnode[Adjacent[k].vertex].source = vertex_in_spotlight;
				}
			}

			for (int k = 0; k < c; k++) {
				System.out.println(Adjacent[k].vertex + " - " + Adjacent[k].key + " - " + Adjacent[k].source);
			}
			System.out.println("");
		}

		/// Printing Dijkstra's path for every vertex
		String str = Integer.toString(start);
		for (int i = 0; i < verticesNo; i++) {
			str = ShortestPath(i, 0);
			if (str.compareTo(Integer.toString(i)) != 0 || str.compareTo(Integer.toString(start)) == 0)
				System.out.println(str);
			else {
				System.out.println("No Path");
			}

		}
	}

	public boolean isMST(HeapNode arr[], int vertex) {
		for (int i = 0; i < arr.length; i++) {
			if (vertex == arr[i].vertex)
				return true;
		}
		return false;
	}

	public String ShortestPath(int vertex, int startvertex) {
		String path = Integer.toString(vertex); /// initializing the path with the start vertex
		if (vertex == startvertex) {
			path = Integer.toString(startvertex);
			return path;
		} else {
			for (int i = 0; i < SHP.length; i++) {
				if (vertex == SHP[i].vertex) {
					if (SHP[i].source != -1) {
						path = path + " " + ShortestPath(SHP[i].source, startvertex);
						distance = SHP[i].key;
					}
				}
			}
			return path;
		}
	}

	public void decreaseKey(MinHeap minHeap, int newKey, int vertex, int source) {

		int index = minHeap.searchHeap(vertex);

		HeapNode node = minHeap.mH[index];
		node.key = newKey;
		node.source = source;
		minHeap.bubbleUp(index);
	}

	public int getdistancet() {
		return distance;
	}

	public HeapNode[] getSHP() {
		return SHP;
	}

}
