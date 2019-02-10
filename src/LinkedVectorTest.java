public class LinkedVectorTest {
	public static void main(String[] args) {
		Vector<String> vector = new LinkedVector<String>();

		testInsertAtRank();
		testRetrieveElement();
		testEmptyElemAtRank();
		testEmptyReplaceAtRank();
		testTestRemoveAtRank();
		
		//Other tests can be made to test RankOutOfBound for most methods, I didnt implement them as it would of been messy

		System.out.println("\n");
		vector.insertAtRank(0, "A");
		vector.insertAtRank(1, "B");
		vector.insertAtRank(2, "C");
		vector.insertAtRank(1, "D");
		vector.insertAtRank(1, "E");
		System.out.println(vector);
	}
	
	/**
	 * tests that calling the insertAtRank() method after insertion returns the correct size
	 */
	public static void testInsertAtRank() {
		Vector<String> vector = new LinkedVector<String>();

		vector.insertAtRank(0, "A");
		if(vector.size() == 1) {
			System.out.println("testInsertAtRank(): SUCCESS");
		}else {
			System.out.println("testInsertAtRank(): FAILURE");
			System.out.println("Expected vector size to be 1");
		}
	}
	
	/**
	 * tests that calling the elemAtRank() method works by inserting an element at a
	 * given rank and then retrieving it
	 */
	
	public static void testRetrieveElement() {
		Vector<String> vector = new LinkedVector<String>();

		vector.insertAtRank(0, "A");
		vector.insertAtRank(1, "B");
		vector.insertAtRank(2, "C");
		
		if(vector.elemAtRank(1) == "B") {
			System.out.println("testRetrieveElement(): SUCCESS");
		}else {
			System.out.println("testRetrieveElement(): FAILURES");
			System.out.println("Expected to return element 'B'");
		}
	}

	/**
	 * tests that calling the elemAtRank() method on an empty vector causes an error
	 */
	public static void testEmptyElemAtRank() {
		Vector<String> vector = new LinkedVector<String>();

		try {
			vector.elemAtRank(0);
			System.out.println("testEmptyElemAtRank(): FAILURE");
			System.out.println("Expected vector to be empty");
		} catch (VectorEmptyException e) {
			System.out.println("testEmptyElemAtRank(): SUCCESS");
			// e.printStackTrace();
		}
	}

	/**
	 * tests that calling the replaceAtRank() method on an empty vector causes an
	 * error
	 */
	public static void testEmptyReplaceAtRank() {
		Vector<String> vector = new LinkedVector<String>();

		try {
			vector.replaceAtRank(0, "E");
			System.out.println("testEmptyReplaceAtRank(): FAILURE");
			System.out.println("Expected vector to be empty");
		} catch (VectorEmptyException e) {
			System.out.println("testEmptyReplaceAtRank(): SUCCESS");
			// e.printStackTrace();
		}
	}

	/**
	 * tests that calling the removeAtRank() method on an empty vector causes an error
	 */
	public static void testTestRemoveAtRank() {
		Vector<String> vector = new LinkedVector<String>();

		try {
			vector.removeAtRank(0);
			System.out.println("testTestRemoveAtRank(): FAILURE");
			System.out.println("Expected vector to be empty");
		} catch (VectorEmptyException e) {
			System.out.println("testTestRemoveAtRank(): SUCCESS");
			// e.printStackTrace();
		}
	}
}
