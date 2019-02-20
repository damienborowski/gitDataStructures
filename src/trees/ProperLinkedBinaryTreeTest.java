package trees;

public class ProperLinkedBinaryTreeTest {
	public static void main(String args[]) {

		testExpandExternal();
		testExpandNotExternal();
		testCollapseInternal();
		testCollapseNotInternal();

	}

	/**
	 * Test to see if calling the method ExpandExternal() makes an internal node by
	 * adding 2 children
	 */
	public static void testExpandExternal() {
		ProperLinkedBinaryTree<String> tree = new ProperLinkedBinaryTree<String>();

		try {
			tree.expandExternal(tree.root());

			// Check if the children exist
			if (tree.hasLeft(tree.root()) && tree.hasRight(tree.root())) {
				System.out.println("testExpandExternal(): SUCCESS");
			} else {
				System.out.println("testExpandExternal(): FAILURE");
				System.out.println("Expanding node didnt create 2 children");
			}

		} catch (InvalidPositionException e) {
			System.out.println("testExpandExternal(): MAJOR FAILURE");
			System.out.println("Expected to make internal node");
		}
	}

	/**
	 * Test to see if calling the method ExpandExternal() with a non external root
	 * throws an error
	 */
	public static void testExpandNotExternal() {
		ProperLinkedBinaryTree<String> tree = new ProperLinkedBinaryTree<String>();
		tree.expandExternal(tree.root());
		try {
			tree.expandExternal(tree.root());
			System.out.println("testExpandNotExternal(): FAILURE");
			System.out.println("Attempt to expand Internal node");
		} catch (InvalidPositionException e) {
			System.out.println("testExpandNotExternal(): SUCCESS");
		}
	}

	/**
	 * Test to see if calling the method CollapseInternal() makes 2 children an
	 * external node
	 */
	public static void testCollapseInternal() {
		ProperLinkedBinaryTree<String> tree = new ProperLinkedBinaryTree<String>();
		tree.expandExternal(tree.root());
		try {
			tree.collapseInternal(tree.root());
			// Check if the children exist
			if (tree.hasLeft(tree.root()) && tree.hasRight(tree.root())) {
				System.out.println("testExpandExternal(): FAILURE");
				System.out.println("Expanding node didnt create 2 children");
			} else {
				System.out.println("testExpandExternal(): SUCCESS");
			}
			System.out.println("testCollapseInternal(): SUCCESS");
		} catch (InvalidPositionException e) {
			System.out.println("testCollapseInternal(): FAILURE");
			System.out.println("Expected to make external node");
		}
	}

	/**
	 * Test to see if calling the method CollapseInternal() with a external root
	 * throws an error
	 */
	public static void testCollapseNotInternal() {
		ProperLinkedBinaryTree<String> tree = new ProperLinkedBinaryTree<String>();

		try {
			tree.collapseInternal(tree.root());
			System.out.println("testCollapseNotInternal(): FAILURE");
			System.out.println("Attempt to collapse external node");
		} catch (InvalidPositionException e) {
			System.out.println("testCollapseNotInternal(): SUCCESS");
		}
	}
}
