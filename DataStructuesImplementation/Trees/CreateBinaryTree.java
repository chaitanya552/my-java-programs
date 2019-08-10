package Trees;

import java.util.ArrayList;
// Java program to insert element in binary tree
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CreateBinaryTree
{

    /*
     * A binary tree node has key, pointer to
     * left child and a pointer to right child
     */

    static Node root;
    static Node temp = root;

    /* Inorder traversal of a binary tree */
    static void inorder(final Node temp)
    {
        if (temp == null) {
            return;
        }

        inorder(temp.left);
        System.out.print(temp.data + " ");
        inorder(temp.right);
    }

    /* function to insert element in binary tree */
    static void insert(Node temp, final int key)
    {
        final Queue<Node> q = new LinkedList<Node>();
        q.add(temp);

        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            }
            else {
                q.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            }
            else {
                q.add(temp.right);
            }
        }
    }

    private static List<List<Integer>> levelOrderTraversal(final Node root)
    {
        final Queue<Node> q = new LinkedList<Node>();

        final List<List<Integer>> list = new ArrayList<>();
        q.offer(root);
        int count = 0;
        while (!q.isEmpty()) {
            count++;
            final int size = q.size();
            final List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                // better write q.remove at start only so it applies for stack as well

                final Node qpeek = q.remove();
                if (qpeek.left != null) {
                    q.add(qpeek.left);
                }

                if (qpeek.right != null) {
                    q.add(qpeek.right);
                }
                subList.add(qpeek.data);
            }
            list.add(subList);
        }
        System.out.println(count + "depth of tree");
        return list;
    }

    // Driver code
    public static void main(final String args[])
    {
        root = new Node(1);
        /*
         * root.left = new Node(11);
         * root.left.left = new Node(7);
         * root.right = new Node(9);
         * root.right.left = new Node(15);
         * root.right.right = new Node(8);
         */
        for (int i = 0; i < 18; i++) {
            insert(root, i + 2);
        }

        /*
         * System.out.print("Inorder traversal before insertion:");
         * inorder(root);
         * final int key = 12;
         * insert(root, key);
         */

        System.out.print("\nInorder traversal after insertion:");
        inorder(root);
        System.out.println();
        System.out.println("level order" + levelOrderTraversal(root));
    }
}
// This code is contributed by Sumit Ghosh