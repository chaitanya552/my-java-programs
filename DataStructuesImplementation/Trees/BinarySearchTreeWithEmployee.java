package trees;

public class BinarySearchTreeWithEmployee {
	NodeT root;

	public void AddNode(int key, String name) {
		NodeT newNode = new NodeT(key, name);
		if (root == null) {
			// set new node as the root
			root = newNode;

		} else {
			// Set root as the Node we will start
			// with as we traverse the tree

			NodeT focusNode = root;
			NodeT currentParent;
			// Future parent for our new Node
			// recursive loop to go to the left most child or right most child
			// where it is null
			while (true) {
				currentParent = focusNode;
				if (key < focusNode.key) {
					focusNode = focusNode.LeftChild;
					if (focusNode == null) {
						currentParent.LeftChild = newNode;
						return;
					}
				} else {
					focusNode = focusNode.RightChild;
					if (focusNode == null) {
						currentParent.RightChild = newNode;
						return;
					}
				}
			}
		}

	}

	public void inOrderTraversal(NodeT focusNode) {
		if (focusNode != null) {
			inOrderTraversal(focusNode.LeftChild);
			System.out.println(focusNode.key + focusNode.name);
			inOrderTraversal(focusNode.RightChild);

		}
	}

	public String findNode(int key) {

		if (key == root.key) {
			System.out.println("found is root");

			return root.name;
		} else {
			NodeT focusNode = root;
			NodeT currentParent;
			// Future parent for our new Node
			// recursive loop to go to the left most child or right most child
			// where it is null
			while (true) {
				currentParent = focusNode;
				if (key < focusNode.key) {
					focusNode = focusNode.LeftChild;
					if (key == focusNode.key) {
						return currentParent.LeftChild.name;

					}
				} else {
					focusNode = focusNode.RightChild;
					if (key == focusNode.key) {
						return currentParent.RightChild.name;
					}
				}
			}
		}

	}

	public int getHeight(NodeT focusNode) {

		// Write your code here
		// height of single node binary tree is 0
		// hence base case should be -1 and wen we iterate -1 +1 gives 0
		// as height for single node binay tree
		if (focusNode == null) {
			return -1;
		} else {
			int ldepth = getHeight(focusNode.LeftChild);
			int rdepth = getHeight(focusNode.RightChild);
			if (ldepth > rdepth) {
				return (ldepth + 1);

			} else {
				return (rdepth + 1);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTreeWithEmployee a1 = new BinarySearchTreeWithEmployee();
		a1.AddNode(100, "president");
		a1.AddNode(80, " vice president");
		a1.AddNode(30, "employee");
		a1.AddNode(10, "helper");
		a1.AddNode(70, "manager");
		a1.inOrderTraversal(a1.root);
		System.out.println(a1.findNode(30));
		;
		System.out.println(a1.getHeight(a1.root));
	}

}

// Node creation is done here

class NodeT {
	int key;
	String name;
	NodeT LeftChild;
	NodeT RightChild;

	NodeT(int key, String name) {
		this.key = key;
		this.name = name;
	}
}