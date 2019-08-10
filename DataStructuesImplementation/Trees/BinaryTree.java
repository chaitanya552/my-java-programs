package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// A Java program to introduce Binary Tree
public class BinaryTree
{
    // Root of Binary Tree
    Node root;

    // Constructors
    /*
     * BinaryTree(int key)
     * {
     * root = new Node(key);
     * }
     */

    BinaryTree()
    {
        root = null;
    }

    static BinaryTree tree2 = new BinaryTree();

    public static void main(final String[] args)
    {

        final BinaryTree tree = new BinaryTree();
        /* create root */
        tree.root = new Node(1);

        /*
         * following is the tree after above statement
         * 1
         * / \
         * null null
         */

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        /*
         * 2 and 3 become left and right children of 1
         * 1
         * / \
         * 2 3
         * / \ / \
         * null null null null
         */

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(7);
        /*
         * 4 becomes left child of 2
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 null null null
         * / \
         * null null
         */
        // level order traversal

        // create tree iterativey using array and level order insertion
        System.out.println("manual way" + levelOrderTraversal(tree.root));
        final int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        final Node root = new Node(array[0]);
        makeBinaryTreeFromArray(root, array);

        System.out.println("iterative way" + levelOrderTraversal(root));
    }

    private static void makeBinaryTreeFromArray(final Node root, final int[] array)
    {
        // final Node root = new Node(array[0]);
        for (int i = 1; i < array.length; i++) {
            insert(root, array[i]);
        }

    }

    static void insert(final Node root, final int key)
    {
        final Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            final Node temp = q.peek();
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
        while (!q.isEmpty()) {
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
        return list;
    }
}

/*
 * Class containing left and right child of current
 * node and key value
 */
