package trees;

public class HeightOfTree {
	// Root of the Binary Tree
	Node root;

	public HeightOfTree() {
		root = null;

	}

	public static void main(String args[]) {
		HeightOfTree tree = new HeightOfTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		System.out.println(height(tree.root));

	}

	public static int height(Node root) {
		if (root == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight) {
				// System.out.println(lheight);
				return (lheight + 1);
			} else
				return (rheight + 1);
		}
	}
}
/*class Node {
	int data;
	Node left, right;

	public Node(int item) {
		data = item;
		left = right = null;
	}
}*/