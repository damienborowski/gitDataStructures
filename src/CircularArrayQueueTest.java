
public class CircularArrayQueueTest {
	public static void main(String[] args) {
		testEmptyQueue();
		testenqueue();
		testdequeue();
		testdequeueEmptyQueue();
		testFrontEmptyQueue();
		
		Queue<String> queue = new CircularArrayQueue<String>(5);
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		//queue.dequeue();
		
		System.out.println(queue);
	}

	/**
	 * tests that calling the isEmpty() method on an empty queue returns true
	 */
	public static void testEmptyQueue() {
		Queue<String> queue = new CircularArrayQueue<String>();

		try {
			if (!queue.isEmpty()) {
				System.out.println("testEmptyQueue(): FAILURE");
				System.out.println("Expected queue to be empty");
			} else {
				System.out.println("testEmptyQueue(): SUCCESS");
			}
		} catch (RuntimeException e) {
			System.out.println("testEmptyQueue(): MAJOR FAILURE");
			e.printStackTrace();
		}
	}

	/**
	 * tests that calling the enqueue() method on a queue puts the item into the queue
	 */
	public static void testenqueue() {
		Queue<String> queue = new CircularArrayQueue<String>(5);
		queue.enqueue("A");

		try {
			if (!queue.front().equals("A")) {
				System.out.println("testenqueue(): FAILURE");
				System.out.println("Expected A to be at the front of the queue");
			} else {
				System.out.println("testenqueue(): SUCCESS");
			}
		} catch (RuntimeException e) {
			System.out.println("testenqueue(): MAJOR FAILURE");
			e.printStackTrace();
		}
	}

	/**
	 * tests that calling the dequeue() method on a non-empty queue removes the first item
	 * from the queue
	 */
	public static void testdequeue() {
		Queue<String> queue = new CircularArrayQueue<String>(5);

		try {
			String element = "A";
			queue.enqueue(element);
			if (element.equals(queue.dequeue())) {
				System.out.println("testdequeue(): SUCCESS");
			} else {
				System.out.println("testdequeue(): FAILURE");
				System.out.println("Expected A to be removed from the queue");
			}
		} catch (RuntimeException e) {
			System.out.println("testdequeue(): MAJOR FAILURE");
			e.printStackTrace();
		}
	}

	/**
	 * tests that calling the dequeue() method on an empty queue causes an exception
	 */
	public static void testdequeueEmptyQueue() {
		
		Queue<String> queue = new CircularArrayQueue<String>(0);
		try {		
			queue.dequeue();
			System.out.println("testdequeueEmptyQueue(): FAILURE");
			System.out.println("Expected Exception was not thrown when queue.dequeue() is called on an empty queue");
		} catch (QueueEmptyException e) {
			System.out.println("testdequeueEmptyQueue(): SUCCESS");
		}
	}

	/**
	 * tests that calling the front() method on an empty queue causes an exception
	 */
	public static void testFrontEmptyQueue() {
		Queue<String> queue = new CircularArrayQueue<String>();
		try {
			queue.front();
			System.out.println("testFrontEmptyQueue(): FAILURE");
			System.out.println("Expected Exception was not thrown when queue.front() is called on an empty queue");
		} catch (QueueEmptyException e) {
			System.out.println("testFrontEmptyQueue(): SUCCESS");
		}
	}
}
