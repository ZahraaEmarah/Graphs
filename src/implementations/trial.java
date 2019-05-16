package implementations;

import implementations.Oldheap.OldNode;

public class trial {

	public void Dijkstra(int verticesNo, Graph g) {

		OldNode[] heapnode = new OldNode[verticesNo];
		OldNode Adjacent[] = new OldNode[verticesNo];
		OldNode tmp;
		int MST[] = new int[verticesNo];
		Oldheap minHeap = new Oldheap();
		int index = 0;
		int cost = 0;
		int Dijkstra = 0;

		for (int i = 0; i < verticesNo; i++) {
			heapnode[i] = new OldNode();
			heapnode[i].vertex = i;
			heapnode[i].key = Integer.MAX_VALUE;

			Adjacent[i] = new OldNode();
			Adjacent[i].vertex = i;
			Adjacent[i].key = Integer.MAX_VALUE;
		}

		int vertex_in_spotlight;
		heapnode[0].key = 0;

		// for (int i = 0; i < verticesNo; i++) {
		minHeap.setHeap(heapnode);
		minHeap.Buildheap(heapnode);
		// }
		minHeap.printHeap();

	}

	public boolean isMST(int arr[], int vertex) {
		for (int i = 0; i < arr.length; i++) {
			if (vertex == arr[i])
				return true;
		}
		return false;
	}

	public void DijkstrasPath(int arr[], int vertex) {
		int index = 0;
		int Notfound = 1;

		for (int i = 0; i < arr.length; i++) {
			{
				if (vertex == arr[i]) {
					index = i;
					Notfound = 0;
				}
			}
		}
		if (Notfound == 0) {
			System.out.print("Path of vertex " + vertex + " is: ");
			for (int i = index; i >= 0; i--) {
				System.out.print(arr[i] + " ");
			}
		} else {
			System.out.println("No Path !");
		}
		System.out.println("");
	}

}
