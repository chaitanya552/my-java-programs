package trees;
/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 * 1 / \ 2 2 / \ / \ 3 4 4 3
 * 
 * //left.left=right.right && left.right=right.left Definition for a binary tree
 * node. public class TreeNode { int val; TreeNode left; TreeNode right;
 * TreeNode(int x) { val = x; } }
 */
public class SymmetricTree_LeetCode {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// give two trees as input
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.right = new TreeNode(2);
		p.left.left = new TreeNode(4);
		p.left.right = new TreeNode(5);
		p.right.left = new TreeNode(5);
		p.right.right = new TreeNode(4);

		boolean ans = isSymmetric(p);
		System.out.println(ans);
	}

	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;

		}
		return isMirror(root.left, root.right);

	}

	private static boolean isMirror(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		return (left.val == right.val) && isMirror(left.left, right.right)
				&& isMirror(left.right, right.left);
	}
}

/*
 * class TreeNode { int val; TreeNode left; TreeNode right;
 * 
 * TreeNode(int x) { val = x; this.left=null; this.right=null; } }
 */