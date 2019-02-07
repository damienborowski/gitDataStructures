import java.util.Arrays;

public class CircularArrayQueue<E> implements Queue<E> {

	private E[] data;
	private int front = -1;
	private int rear = -1;
	private int size = 0;
	private int capacity;

	public CircularArrayQueue() {

	}

	public CircularArrayQueue(int capacity) {
		this.capacity = capacity;
		data = (E[]) new Object[this.capacity];
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
	public void enqueue(E e) {
		if (size == data.length) {
			throw new QueueFullException();
		} else {
			rear = (rear + 1) % data.length;
			data[rear] = e;
			size++;
			if (front == -1) {
				front = rear;
			}
		}
	}

	@Override
	public E front() {
		if (isEmpty()) {
			throw new QueueEmptyException();
		}
		return data[front];
	}

	@Override
	public E dequeue() {
		if (isEmpty()) {
			throw new QueueEmptyException();
		} else {
			E removedData = data[front];
			data[front] = null;
			front = (front + 1) % data.length;
			size--;
			return removedData;
		}
	}

	// Prints the current state of the queue
	public String toString() {
		return "Size " + size + " / Capacity " + capacity + " " + Arrays.toString(data) + "]";

	}
}
