import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution
{
    public boolean isCousins(final TreeNode root, final int x, final int y)
    {
        final Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int xdepth = 0;
        int ydepth = 0;

        while (!q.isEmpty()) {
            final int levelNum = q.size();

            for (int i = 0; i < levelNum; i++) {
                if (q.peek().left != null) {
                    q.add(q.peek().left);
                }
                if (q.peek().right != null) {
                    q.add(q.peek().right);
                }
                if (q.peek().val == x) {

                    xdepth = levelNum;
                }
                if (q.peek().val == y) {
                    ydepth = levelNum;
                }
                q.remove();
            }

        }
        System.out.println(xdepth + "-->" + ydepth);
        return xdepth == ydepth;

    }
}