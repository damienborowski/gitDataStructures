package trees;

import common.Position;

public class StandardLinkedBinaryTreeTest {
	public static void main(String args[]) {

		testAddRoot();
		testFullAddRoot();
		testInsertLeft();
		testFullInsertLeft();
		testInsertRight();
		testFullInsertLeft();
		testRemove();
	}

	/**
	 * Test to see if the method AddRoot() works
	 */
	public static void testAddRoot() {
		StandardLinkedBinaryTree<String> tree = new StandardLinkedBinaryTree<String>();

		try {
			Position<String> p0 = tree.addRoot("A");
			System.out.println("testAddRoot(): SUCCESS");

		} catch (InvalidPositionException e) {
			System.out.println("testAddRoot(): FAILURE");
			System.out.println("Expected to add root");
		}

	}

	/**
	 * Test to see if calling the method AddRoot() while a root node already exists
	 */
	public static void testFullAddRoot() {
		StandardLinkedBinaryTree<String> tree = new StandardLinkedBinaryTree<String>();

		Position<String> p0 = tree.addRoot("A");
		try {
			tree.addRoot("B");
			System.out.println("testFullAddRoot(): FAILURE");
			System.out.println("Expected to not be able to add a root node.");

		} catch (InvalidPositionException e) {
			System.out.println("testFullAddRoot(): SUCCESS");
		}

	}

	/**
	 * Test to see if the method insertLeft() works
	 */
	public static void testInsertLeft() {
		StandardLinkedBinaryTree<String> tree = new StandardLinkedBinaryTree<String>();

		Position<String> p0 = tree.addRoot("A");
		try {
			Position<String> p1 = tree.insertLeft(p0, "B");
			System.out.println("testInsertLeft(): SUCCESS");

		} catch (InvalidPositionException e) {
			System.out.println("testInsertLeft(): FAILURE");
			System.out.println("Expected to add a node on the left");
		}
	}

	/**
	 * Test to see if calling the method insertLeft() while a left node already
	 * exists
	 */
	public static void testFullInsertLeft() {
		StandardLinkedBinaryTree<String> tree = new StandardLinkedBinaryTree<String>();

		Position<String> p0 = tree.addRoot("A");
		Position<String> p1 = tree.insertLeft(p0, "B");
		try {
			tree.insertLeft(p1, "C");
			System.out.println("testFullInsertLeft(): FAILURE");
			System.out.println("A left node already exists");

		} catch (InvalidPositionException e) {
			System.out.println("testFullInsertLeft(): SUCCESS");
		}

	}

	/**
	 * Test to see if the method insertRight() works
	 */
	public static void testInsertRight() {
		StandardLinkedBinaryTree<String> tree = new StandardLinkedBinaryTree<String>();

		Position<String> p0 = tree.addRoot("A");
		try {
			tree.insertRight(p0, "B");
			System.out.println("testInsertRight(): SUCCESS");

		} catch (InvalidPositionException e) {
			System.out.println("testInsertRight(): FAILURE");
			System.out.println("Expected to add a node on the right");
		}
	}

	/**
	 * Test to see if calling the method insertRight() while a right node already
	 * exists
	 */
	public static void testFullInsertRight() {
		StandardLinkedBinaryTree<String> tree = new StandardLinkedBinaryTree<String>();

		Position<String> p0 = tree.addRoot("A");
		Position<String> p1 = tree.insertRight(p0, "B");
		try {
			tree.insertRight(p1, "B");
			System.out.println("testFullInsertRight(): FAILURE");
			System.out.println("A right node already exists");

		} catch (InvalidPositionException e) {
			System.out.println("testFullInsertRight(): SUCCESS");
		}

	}

	/**
	 * Test to see if the method remove() works
	 */
	public static void testRemove() {
		StandardLinkedBinaryTree<String> tree = new StandardLinkedBinaryTree<String>();

		Position<String> p0 = tree.addRoot("A");
		try {
			tree.remove(p0);
			System.out.println("testRemove(): SUCCESS");

		} catch (InvalidPositionException e) {
			System.out.println("testRemove(): FAILURE");
			System.out.println("Expected to remove a node");
		}
	}

}
