package implementations;

public class Oldheap {

	public static class OldNode {
		public int vertex;
		public int key;
	}

	// THIS IS THE MAX HEAP
	int heapsize;
	private OldNode heap[];

	public void Buildheap(OldNode arr[]) {
		double i = java.lang.Math.floor(arr.length) / 2;
		for (; i >= 1; i--) {

			arr = MaxHeapify(arr, (int) i);
		}
		setHeap(arr);

	}

	public OldNode[] MaxHeapify(OldNode arr[], int i) {
		int l = (2 * i);
		int r = 2 * i + 1;
		i = i - 1;
		l = l - 1;
		r = r - 1;
		int largest = i;
		heapsize = arr.length;
		if (l < heapsize && arr[l].key > arr[i].key) {

			largest = l;
		}
		if (r < heapsize && arr[r].key > arr[largest].key) {

			largest = r;
		}

		if (largest != i) {
			OldNode temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			largest = largest + 1;
			MaxHeapify(arr, largest);
		}

		return arr;
	}

	public OldNode getHeap(int i) {
		return heap[i];
	}

	public void setHeap(OldNode heap[]) {
		this.heap = heap;
	}

	public void printHeap() {
		// OldNode[] res = new OldNode[heapsize];
		for (int i = 0; i < heapsize; i++) {
			System.out.println(heap[i].key + ",");
		}

	}

}
