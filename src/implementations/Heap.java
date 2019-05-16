package implementations;

public class Heap {

	public static class Node {
		public int vertex;
		public int key;
	}

	public Node Heap[];
	public int capacity;
	public int pos, ind, count = 0;
	private static final int ROOT = 1;

	public Heap(int cap) {
		pos = 1;
		capacity = cap;
		Heap = new Node[capacity];
	}

	public void insert(Node n[]) {

		for (int i = 0; i < n.length; i++) {
			if (pos == capacity) {
				return;
			}
			Heap[pos++] = n[i];
		}
		minHeapify(1);
	}

	public void minHeapify(int pos) {

		int child = pos - 1;
		int parent = child / 2;

		while (parent > 0 && Heap[parent].key > Heap[child].key) {
			Node tmp = Heap[parent];
			Heap[parent] = Heap[child];
			Heap[child] = tmp;

			child = parent;
			parent = child / 2;
		}

	}

	public int searchHeap(Node n) {
		for (int i = 1; i < pos; i++) {
			if (n.vertex == Heap[i].vertex)
				return i;
		}
		return -1;
	}

	public boolean isEmpty() {
		for (int i = 1; i < pos; i++) {
			if (Heap[i] != null) {
				return false;
			}
		}
		return true;
	}

	public Node removeRoot() {
		if (pos == 1)
			return null;

		Node popped = Heap[ROOT];
		Heap[ROOT] = Heap[--pos];
		minHeapify(ROOT);
		return popped;
	}

	public void print() {
		for (int i = 1; i < pos; i++) {
			System.out.println("the new heap " + Heap[i].vertex + " key " + Heap[i].key);
		}
	}

}
