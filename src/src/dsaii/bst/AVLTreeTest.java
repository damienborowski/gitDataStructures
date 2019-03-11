package dsaii.bst;

public class AVLTreeTest {
	public static void main(String[] args) {

		testInsertion();
		
		testExternalChildrenRemoval();
		testExternalRightChildRemoval();
		testExternalLeftChildRemoval();
		testInternalChildrenRemoval();
		testFindValue();
		testNoFindValue();

		// Extra tests
		System.out.println("\n---Extra Tests---");
		testSingleLeft();
		testSingleRight();
		testDoubleLeftRight();
		testDoubleRightLeft();
		
		System.out.println(basicTree().toString());
		
	}

	private static void testSingleLeft() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.insert(7);
		tree.insert(5);
		tree.insert(2);

		if (tree.tree.root().element() == 5 && tree.tree.left(tree.tree.root()).element() == 2
				&& tree.tree.right(tree.tree.root()).element() == 7) {
			System.out.println("testSingleLeft(): SUCCESS");
		} else {
			System.out.println("testSingleLeft(): FAILURE");
			System.out.println("method was meant to restructure the tree using SingleLeft");
		}
	}

	private static void testSingleRight() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.insert(7);
		tree.insert(9);
		tree.insert(10);

		if (tree.tree.root().element() == 9 && tree.tree.left(tree.tree.root()).element() == 7
				&& tree.tree.right(tree.tree.root()).element() == 10) {
			System.out.println("testSingleRight(): SUCCESS");
		} else {
			System.out.println("testSingleRight(): FAILURE");
			System.out.println("method was meant to restructure the tree using SingleRight");
		}
	}

	private static void testDoubleLeftRight() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.insert(7);
		tree.insert(9);
		tree.insert(8);

		if (tree.tree.root().element() == 8 && tree.tree.left(tree.tree.root()).element() == 7
				&& tree.tree.right(tree.tree.root()).element() == 9) {
			System.out.println("testDoubleLeftRight(): SUCCESS");
		} else {
			System.out.println("testDoubleLeftRight(): FAILURE");
			System.out.println("method was meant to restructure the tree using DoubleLeftRight");
		}
	}

	private static void testDoubleRightLeft() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.insert(7);
		tree.insert(5);
		tree.insert(6);

		if (tree.tree.root().element() == 6 && tree.tree.left(tree.tree.root()).element() == 5
				&& tree.tree.right(tree.tree.root()).element() == 7) {
			System.out.println("testDoubleRightLeft(): SUCCESS");
		} else {
			System.out.println("testDoubleRightLeft(): FAILURE");
			System.out.println("method was meant to restructure the tree using testDoubleRightLeft");
		}
	}

	private static void testNoFindValue() {
		AVLTree<Integer> tree = basicTree();
		Integer value = tree.find(15);
		if (value != null) {
			System.out.println("testNoFindValue(): FAILURE");
			System.out.println("method was meant to return null, but it returned: " + value);
		} else {
			System.out.println("testNoFindValue(): SUCCESS");
		}
	}

	private static void testFindValue() {
		AVLTree<Integer> tree = basicTree();
		Integer value = tree.find(2);
		if (value != 2) {
			System.out.println("testNoFindValue(): FAILURE");
			System.out.println("method was meant to return 2, but it returned: " + value);
		} else {
			System.out.println("testFindValue(): SUCCESS");
		}
	}

	private static AVLTree<Integer> basicTree() {
		AVLTree<Integer> tree = new AVLTree<Integer>();

		tree.insert(7);
		tree.insert(5);
        tree.insert(2);
        tree.insert(9);
        tree.insert(12);
        tree.insert(6);
        tree.insert(3);
        tree.insert(1);
        tree.insert(4);
		return tree;
	}

	/**
	 * tests that calling the push() method on a stack puts the item into the stack
	 */
	public static void testInsertion() {
		AVLTree<Integer> tree = basicTree();

		if (tree.size() != 9) {
			System.out.println("testInsertion(): FAILURE");
			System.out.println("Expected tree to contain 9 values, but it contains: " + tree.size());
		} else {
			System.out.println("testInsertion(): SUCCESS");
		}
	}

	public static void testExternalChildrenRemoval() {
		AVLTree<Integer> tree = basicTree();
		do_remove(tree, 2, "testExternalChildrenRemoval");
	}

	public static void testExternalRightChildRemoval() {
		AVLTree<Integer> tree = basicTree();
		do_remove(tree, 5, "testExternalRightChildRemoval");
	}

	public static void testExternalLeftChildRemoval() {
		AVLTree<Integer> tree = basicTree();
		do_remove(tree, 9, "testExternalLeftChildRemoval");
	}

	public static void testInternalChildrenRemoval() {
		AVLTree<Integer> tree = basicTree();
		do_remove(tree, 12, "testInternalChildrenRemoval");
	}

	private static void do_remove(AVLTree<Integer> tree, Integer value, String method) {
		Integer result = tree.remove(value);
		if (!value.equals(result)) {
			System.out.println(method + "(): FAILURE");
			System.out.println("method did not return " + value + " but: " + result);
		} else {
			System.out.println(method + "(): SUCCESS");
		}
	}
}
