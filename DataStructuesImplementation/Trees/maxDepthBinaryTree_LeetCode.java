package trees;

public class maxDepthBinaryTree_LeetCode {
	Node root;
	maxDepthBinaryTree_LeetCode()
	{
		root=null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maxDepthBinaryTree_LeetCode tree = new maxDepthBinaryTree_LeetCode();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		System.out.println(maxDepth(tree.root));
	}
	
	public static int maxDepth(Node root) {
        if(root!=null)
        {
        return (1+ Math.max(maxDepth(root.left),maxDepth(root.right)));
                //1+Math.max(maxDepth(root.left),maxDepth(root.right));
        }
        return 0;
    }
}
