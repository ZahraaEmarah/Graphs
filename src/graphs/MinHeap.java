package graphs;

public class MinHeap {

	static class HeapNode {
		int vertex;
		int key;
	}

	public Graph g;
	public HeapNode[] Heap;
	public int size;
	public int maxsize;

	private static final int ROOT = 0;

	public MinHeap(int maxsize) {

		this.maxsize = maxsize;
		this.size = 0;
		Heap = new HeapNode[this.maxsize];
		Heap[0] = new HeapNode();
		Heap[0].vertex = 0;
		Heap[0].key = Integer.MIN_VALUE;
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
	private void minHeapify(int pos) {

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
		}
	}

	// Function to insert a node into the heap
	public void insert(HeapNode element) {
		if (size > maxsize) {
			return;
		}

		Heap[size] = element;
		int current = size;
		size++;

		while (Heap[current].key < Heap[parent(current)].key) {
			swap(current, parent(current));
			current = parent(current);
		}

	}

	// Function to print the contents of the heap
	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.print(" Heap is : " + Heap[i].vertex + " " + Heap[i].key);
			System.out.println();
		}
	}

	// Function to build the min heap using
	// the minHeapify
	public void minHeapify() {
		for (int pos = (size / 2); pos >= 1; pos--) {
			minHeapify(pos);
		}
	}

	public int searchHeap(HeapNode n) {

		for (int i = 0; i <= size; i++) {
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

	public int isDuplicate(HeapNode n) {
		int count = 0;
		// System.out.println(Heap.length - 100);
		for (int i = 0; i < Heap.length - 100; i++) {
			if (n.vertex == Heap[i].vertex && n.vertex == Heap[i].vertex && n.key == Heap[i].key) {
				count++;
				removeNode(n);
				return count;
			}
		}
		return count;
	}

	// Function to remove and return the minimum
	// element from the heap
	public HeapNode removeRoot() {
		HeapNode popped = Heap[ROOT];
		Heap[ROOT] = Heap[--size];
		size = size - 1;
		minHeapify(ROOT);
		return popped;
	}

	public HeapNode removeNode(HeapNode n) {

		int index = searchHeap(n);
		// System.out.println(index);
		if (index != -1 && index != size - 1) {

			HeapNode popped = Heap[index];
			Heap[index] = Heap[--size];
			minHeapify(index);
			return popped;
		} else if (index == --size) {
			size = size - 1;
		}
		return null;
	}

}