public class LinkedVector<T> implements Vector<T> {

	// Creating a node
	public static class Node<T>{
		private T element;
		private Node<T> next;
		private Node<T> previous;

		public Node(T element, Node<T> previous, Node<T> next) {
			this.element = element;
			this.previous = previous;
			this.next = next;
		}
	}

	private Node<T> front;
	private Node<T> rear;
	private int size;

	public LinkedVector() {
		front = null;
		rear = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public T elemAtRank(int rank) {

		// If vector is empty
		if (isEmpty())
			throw new VectorEmptyException();

		// If trying to access index out of bounds
		if (rank < 0 || rank > size - 1)
			throw new RankOutOfBoundsException();

		Node<T> tempNode = atRank(rank);
		return tempNode.element;
	}

	@Override
	public T replaceAtRank(int rank, T element) {
		// If vector is empty
		if (isEmpty())
			throw new VectorEmptyException();

		// If trying to access index out of bounds
		if (rank < 0 || rank > size - 1)
			throw new RankOutOfBoundsException();

		Node<T> newNode = new Node<T>(element, null, null);
		Node<T> tempNode = atRank(rank);

		tempNode.element = newNode.element;

		return tempNode.element;
	}

	public void insertAtRank(int rank, T element) {
		// If trying to access index out of bounds
		if (rank < 0 || rank > size)
			throw new RankOutOfBoundsException();

		if (isEmpty()) {
			Node<T> newNode = new Node<T>(element, null, null);
			rear = front = newNode;
			size++;
		} else {
			Node<T> newNode = new Node<T>(element, null, null);
			Node<T> tempNode = atRank(rank);
			size++;

			if (rank == size - 1) {
				newNode.next = null;
				newNode.previous = tempNode;
				tempNode.next = newNode;
				rear = newNode;
			} else if (rank == 0) {
				tempNode.previous = newNode;
				newNode.previous = null;
				newNode.next = tempNode;
				front = newNode;
			} else {
				newNode.next = tempNode;
				newNode.previous = tempNode.previous;
				tempNode.previous.next = newNode;
				tempNode.previous = newNode;
			}
		}
	}

	@Override
	public T removeAtRank(int rank) {

		// If vector is empty
		if (isEmpty())
			throw new VectorEmptyException();

		if (rank < 0 || rank > size())
			throw new RankOutOfBoundsException();

		Node<T> newNode = atRank(rank);
		newNode.previous.next = newNode.next;
		newNode.next.previous = newNode.previous;
		newNode.next = null;
		newNode.previous = null;

		size--;

		return newNode.element;
	}

	// Iterate through linked list
	public Node<T> atRank(int rank) {
		Node<T> newNode = new Node<T>(null, null, null);

		if (rank < 0 || rank > size())
			throw new RankOutOfBoundsException();

		if (rank <= size / 2) {
			newNode = front;

			for (int i = 0; i < rank; i++) {
				newNode = newNode.next;
			}
		} else {
			newNode = rear;

			for (int i = 1; i < size() - rank; i++) {
				newNode = newNode.previous;
			}
		}
		return newNode;
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return " Vector is empty";
		} else {
			String output = new String("<size: " + size + "> : ");
			Node<T> temp = front;
			while (temp != null) {
				output += temp.element + " "; // concatenates each value to the string
				temp = temp.next; // goto next node
			}
			output += "\n";
			return output;
		}
	}
}