public class LinkedStack<T> implements Stack<T> {

	// Creating a node
	public static class Node<T> {
		private T element;
		private Node<T> next;

		public Node(T element, Node<T> next) {
			this.element = element;
			this.next = next;
		}
	}

	private Node<T> front; // Points to the bottom of the stack
	private Node<T> rear; // Points to the top of the stack
	private int size;

	// Default constructor
	public LinkedStack() {
		front = null;
		rear = null;
		size = 0;
	}

	// Adds an element to the stack
	@Override
	public void push(T object) {
		Node<T> node = new Node<T>(object, null);

		if (isEmpty()) {
			front = node;
			rear = node;
		} else {
			rear.next = node;
			rear = node;
		}
		size++;
	}

	// Returns and removes the element at the top of the stack
	@Override
	public T pop() {
		if (isEmpty()) {
			throw new StackEmptyException();
		} else if (front.element == rear.element) {
			size--;
			return front.element;
		} else {
			Node<T> temp = front;
			while (temp.next != rear) {
				temp = temp.next;
			}
			rear = temp;
			size--;
			return temp.next.element;
		}
	}

	// Returns the element on top of the stack without removing it
	@Override
	public T peek() {
		if (isEmpty()) {
			throw new StackEmptyException();
		}
		return rear.element;
	}

	// Returns the size of the stack
	@Override
	public int size() {
		return size;
	}

	// Returns true if stack is empty
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	// Prints the current state of the stack
	public String toString() {
		if (isEmpty()) {
			return " Stack is empty";
		} else {
			String result = " ";
			result = "Size " + size + " : ";
			Node<T> temp = front;
			while (temp != null) {
				result = result + " " + temp.element.toString();
				temp = temp.next;
			}
			return result;
		}
	}
}