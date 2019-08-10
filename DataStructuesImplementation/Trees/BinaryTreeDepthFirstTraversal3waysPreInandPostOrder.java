package Trees;

// Java program for different tree traversals using recursion
// Depth first traversals
/*
 * Class containing left and right child of current
 * node and key value
 */
/*
 * Input
 * 1
 * 2 3
 * under 2
 * 4 5
 */
/*
 * Output:
 * Preorder traversal of binary tree is
 * 1 2 4 5 3
 * Inorder traversal of binary tree is
 * 4 2 5 1 3
 * Postorder traversal of binary tree is
 * 4 5 2 3 1
 * Time Complexity: O(n)
 * Auxiliary Space : If we don’t consider size of stack for function calls then O(1) otherwise O(n).
 */

class BinaryTreeDepthFirstTraversal3waysPreInandPostOrder
{
    // Root of Binary Tree
    Node root;

    BinaryTreeDepthFirstTraversal3waysPreInandPostOrder()
    {
        root = null;
    }

    /*
     * Given a binary tree, print its nodes according to the
     * "bottom-up" postorder traversal.
     */
    int count = 0;

    void printPostorder(final Node node)
    {
        count++;
        if (node == null) {
            return;
        }

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.data + " ");
        if (node.data == 5) {
            System.out.println("level" + count);
        }
    }

    /* Given a binary tree, print its nodes in inorder */
    void printInorder(final Node node)
    {
        if (node == null) {
            return;
        }

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.data + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    /* Given a binary tree, print its nodes in preorder */
    void printPreorder(final Node node)
    {
        if (node == null) {
            return;
        }

        /* first print data of node */
        System.out.print(node.data + " ");

        /* then recur on left sutree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }

    // Wrappers over above recursive functions
    void printPostorder()
    {
        printPostorder(root);
    }

    void printInorder()
    {
        printInorder(root);
    }

    void printPreorder()
    {
        printPreorder(root);
    }

    // Driver method
    public static void main(final String[] args)
    {
        final BinaryTreeDepthFirstTraversal3waysPreInandPostOrder tree = new BinaryTreeDepthFirstTraversal3waysPreInandPostOrder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder();

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder();

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder();
    }
}
