package trees;

public class BinaryTree {
	Node root;

	public void AddNode(int key, String name) {
		Node newNode = new Node(key, name);
		if (root == null) {
			// set new node as the root
			root = newNode;

		} else {
			// Set root as the Node we will start
			// with as we traverse the tree

			Node focusNode = root;
			Node currentParent;
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

	public void inOrderTraversal(Node focusNode) {
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
			Node focusNode = root;
			Node currentParent;
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
	public int getHeight(Node focusNode){
        
	      //Write your code here
	        if (focusNode==null)
	        {
	            return 0;
	        }
	        else
	        {
	        int  ldepth= getHeight(focusNode.LeftChild);
	        int   rdepth = getHeight(focusNode.RightChild);
	            if(ldepth >rdepth)
	            {
	                return (ldepth+1);
	                
	            }
	            else
	            {
	                return (rdepth+1);
	            }
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree a1 = new BinaryTree();
		a1.AddNode(100, "president");
		a1.AddNode(80, " vice president");

		a1.AddNode(30, "employee");
		a1.AddNode(10, "helper");
		a1.AddNode(70, "manager");
		a1.inOrderTraversal(a1.root);
		System.out.println(a1.findNode(30));;
    System.out.println(a1.getHeight(a1.root));
	}

}

// Node creation is done here

class Node {
	int key;
	String name;
	Node LeftChild;
	Node RightChild;

	Node(int key, String name) {
		this.key = key;
		this.name = name;
	}
}