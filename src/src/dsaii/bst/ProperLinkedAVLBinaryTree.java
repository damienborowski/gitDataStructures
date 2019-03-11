package dsaii.bst;

import dsaii.common.Position;

public class ProperLinkedAVLBinaryTree<T> extends ProperLinkedBSTBinaryTree<T> {
	public Position<T> singleLeft(Position<T> _a, Position<T> _b, Position<T> _c) {
		Node<T> c = toNode(_c);
		Node<T> b = toNode(_b);

		c.left = b.right;

		if (c == root) {
			b.right.parent = c;
			b.right = c;
			root = b;
		} else {
			b.right = c;

			if (c.parent.left == c) {
				c.parent.left = b;
			} else {
				c.parent.right = b;
			}
			b.parent = b.parent.parent;
		}

		c.parent = b;

		return b;
	}

	public Position<T> singleRight(Position<T> _a, Position<T> _b, Position<T> _c) {
		Node<T> c = toNode(_a);
		Node<T> b = toNode(_b);

		c.right = b.left;

		if (c == root) {
			b.left.parent = c;
			b.left = c;
			root = b;
		} else {
			b.left = c;

			if (c.parent.right == c) {
				c.parent.right = b;
			} else {
				c.parent.left = b;
			}
			b.parent = b.parent.parent;
		}

		c.parent = b;

		return b;
	}

	public Position<T> doubleLeftRight(Position<T> _a, Position<T> _b, Position<T> _c) {

		Node<T> a = toNode(_a);
		Node<T> b = toNode(_b);
		Node<T> c = toNode(_c);

		singleLeft(a, b, c);
		singleRight(a, b, c);
		
		//There is 2 ways to get the doubleLeftRight, One shown above and one shown below

		/*
 		Node<T> a = toNode(_a); 
 		Node<T> b = toNode(_b); 
 		Node<T> c = toNode(_c);

		c.left = b.right; 
		a.right = b.left; 
		b.right = c;
		b.left = a;
		  
		if (a == root) { 
			root = b; 
		} else { 
			a.parent.right = b; 
		}
		 */
		return b;
	}

	public Position<T> doubleRightLeft(Position<T> _a, Position<T> _b, Position<T> _c) {
		Node<T> a = toNode(_c);
		Node<T> b = toNode(_b);
		Node<T> c = toNode(_a);

		singleRight(c, b, a);		
		singleLeft(c, b, a);

		//There is 2 ways to get the doubleRightLeft, One shown above and one shown below
		
		/*
		c.right = b.left;
		a.left = b.right;
		b.left = c;
		b.right = a;

		if (a == root) {
			root = b;
		} else {
			a.parent.left = b;
		}
*/
		return b;
	}
}
