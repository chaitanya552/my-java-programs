package trees;
public class SameTree_LeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// give two trees as input
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.right = new TreeNode(3);
		p.left.left = new TreeNode(4);
		p.left.right = new TreeNode(5);
		p.right.left = new TreeNode(6);
		p.right.right = new TreeNode(7);
		

		TreeNode q = new TreeNode(1);
		q.left = new TreeNode(2);
		q.right = new TreeNode(3);
		q.left.left = new TreeNode(4);
		q.left.right = new TreeNode(5);
		q.right.left = new TreeNode(6);
		q.right.right = new TreeNode(7);
		boolean ans = isSameTree(p, q);
		System.out.println(ans);
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.val == q.val) {
		
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		return false;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		this.left=null;
		this.right=null;
	}
}
