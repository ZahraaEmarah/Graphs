package graphs;

import graphs.Graph.Edge;

public class MinHeap {

	private Edge[] Heap;
	private int size;
	private int maxsize;

	private static final int ROOT = 0;

	public MinHeap(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new Edge[this.maxsize + 1];
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
		Edge tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

	// Function to heapify the node at pos
	private void minHeapify(int pos) {

		// If the node is a non-leaf node and greater
		// than any of its child
		if (!isLeaf(pos)) {
			if (Heap[pos].weight > Heap[leftChild(pos)].weight || Heap[pos].weight > Heap[rightChild(pos)].weight) {

				// Swap with the left child and heapify
				// the left child
				if (Heap[leftChild(pos)].weight < Heap[rightChild(pos)].weight) {
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
		}
	}

	// Function to insert a node into the heap
	public void insert(Edge element) {
		if (size > maxsize) {
			return;
		}

		Heap[size] = element;
		int current = size;
		size++;

		while (Heap[current].weight < Heap[parent(current)].weight) {
			swap(current, parent(current));
			current = parent(current);
		}

	}

	// Function to print the contents of the heap
	public void print() {
		for (int i = 0; i <= size; i++) {
			System.out.print(" Heap is : " + Heap[i]);
			System.out.println();
		}
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
	public Edge GetRoot() {
		Edge popped = Heap[ROOT];
		Heap[ROOT] = Heap[size--];
		minHeapify(ROOT);
		return popped;
	}
}