package implementations;

public class Heap {

	public static class HeapNode {
		public int vertex;
		public int key;
	}

	public HeapNode[] Heap;
	private int size;
	private int maxsize;

	private static final int FRONT = 1;

	public Heap(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new HeapNode[this.maxsize + 1];
		// Heap[0].key = Integer.MIN_VALUE;
	}

	// Function to return the position of
	// the parent for the node currently
	// at pos
	private int parent(int pos) {
		return pos / 2;
	}

	// Function to return the position of the
	// left child for the node currently at pos
	private int leftChild(int pos) {
		return (2 * pos);
	}

	// Function to return the position of
	// the right child for the node currently
	// at pos
	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	// Function that returns true if the passed
	// node is a leaf node
	private boolean isLeaf(int pos) {
		if (pos >= (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}

	// Function to swap two nodes of the heap
	private void swap(int fpos, int spos) {
		HeapNode tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

	// Function to heapify the node at pos
	public void minHeapify(int pos) {

		// If the node is a non-leaf node and greater
		// than any of its child
		if (!isLeaf(pos)) {
			if (Heap[pos].key > Heap[leftChild(pos)].key || Heap[pos].key > Heap[rightChild(pos)].key) {

				// Swap with the left child and heapify
				// the left child
				if (Heap[leftChild(pos)].key < Heap[rightChild(pos)].key) {
					swap(pos, leftChild(pos));
					minHeapify(leftChild(pos));
				}

				// Swap with the right child and heapify
				// the right child
				else {
					swap(pos, rightChild(pos));
					minHeapify(rightChild(pos));
				}
			}
		} else {

			if (pos > 1 && Heap[pos].key < Heap[parent(pos)].key) {
				// Swap with the right child and heapify
				// the right child
				swap(pos, parent(pos));
				minHeapify(pos);

			}
		}
	}

	// Function to insert a node into the heap
	public void insert(HeapNode element) {
		if (size >= maxsize) {
			return;
		}
		Heap[++size] = element;
		int current = size;

		while (size > 1 && Heap[current].key < Heap[parent(current)].key) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	// Function to print the contents of the heap
	public void print() {
		for (int i = 1; i <= size; i++) {
			System.out.print(" PARENT : " + Heap[i].vertex + " " + Heap[i].key);
			System.out.println();
		}
		/**
		 * for (int i = 1; i <= size / 2; i++) { if (2 * i + 1 <= size) {
		 * System.out.print(" PARENT : " + Heap[i].key + " LEFT CHILD : " + Heap[2 *
		 * i].key + " RIGHT CHILD :" + Heap[2 * i + 1].key); System.out.println(); } }
		 **/
	}

	// Function to build the min heap using
	// the minHeapify
	public void minHeap() {
		for (int pos = (size / 2); pos >= 1; pos--) {
			minHeapify(pos);
		}
	}

	// Function to remove and return the minimum
	// element from the heap
	public HeapNode remove() {
		HeapNode popped = Heap[FRONT];
		Heap[FRONT] = Heap[size];
		size = size - 1;
		minHeapify(FRONT);
		minHeap();
		minHeapify(size);
		minHeap();
		return popped;
	}

	public int searchHeap(HeapNode n) {

		for (int i = 1; i <= size; i++) {
			if (n.vertex == Heap[i].vertex)
				return i;
		}
		return -1;
	}

	public boolean isEmpty() {

		for (int i = 0; i < Heap.length; i++) {

			if (Heap[i] != null) {
				return false;
			}
		}
		return true;
	}

}
