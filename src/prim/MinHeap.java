package prim;

public class MinHeap {

	public static class HeapNode {
		public int vertex;
		public int key;
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

	private int parent(int pos) {
		return pos / 2;
	}

	private int leftChild(int pos) {
		return (2 * pos);
	}

	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	private boolean isLeaf(int pos) {
		if (pos >= (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}

	private void swap(int fpos, int spos) {
		HeapNode tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

	private void minHeapify(int pos) {

		if (!isLeaf(pos)) {
			if (Heap[pos].key > Heap[leftChild(pos)].key || Heap[pos].key > Heap[rightChild(pos)].key) {

				if (Heap[leftChild(pos)].key < Heap[rightChild(pos)].key) {
					swap(pos, leftChild(pos));
					minHeapify(leftChild(pos));
				}

				else {
					swap(pos, rightChild(pos));
					minHeapify(rightChild(pos));
				}
			}
		}
	}

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

	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.print(" Heap is : " + Heap[i].vertex + " " + Heap[i].key);
			System.out.println();
		}
	}

	public void buildminHeap() {
		for (int pos = (size / 2); pos >= 0; pos--) {
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

	public HeapNode removeRoot() {

		if (size == 0)
			return null;

		HeapNode popped = Heap[ROOT];
		Heap[ROOT] = Heap[size - 1];
		size = size - 1;
		minHeapify(ROOT);
		return popped;
	}

	public HeapNode removeNode(HeapNode n) {

		int index = searchHeap(n);
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