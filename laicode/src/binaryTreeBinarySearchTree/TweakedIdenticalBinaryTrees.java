package binaryTreeBinarySearchTree;

public class TweakedIdenticalBinaryTrees {
	public static void main(String[] args) {
		TweakedIdenticalBinaryTrees case1 = new TweakedIdenticalBinaryTrees();
		TreeNode root1 = new TreeNode(5);
		root1.left = new TreeNode(3);
		root1.right = new TreeNode(8);
		root1.left.left = new TreeNode(1);
		root1.left.right = new TreeNode(4);

		TreeNode root2 = new TreeNode(5);
		root2.left = new TreeNode(8);
		root2.right = new TreeNode(3);
		root2.right.left = new TreeNode(1);
		root2.right.right = new TreeNode(4);
		System.out.print(case1.isTweakedIdentical(root1, root2));
	}

	public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
		// base case
		// if and if else covers all the possible conditions that dealing with nulls
		if (one == null && two == null) {
			return true;
		}
		else if (one == null || two == null) {
			return false;
		} else if (one.key != two.key) {
			return false;
		}

		return isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right) || 
				isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left);
		// recursion rule
		// exchanged: call 1.left vs 2.right && 1.right vs 2.left
		// not exchanged call 1.left vs 2.left && 2.right vs 2.right
//		if (one.left == null && two.left == null && one.right == null && two.right == null)
//		if (one.left == null && two.left == null && one.right == null && two.right == null)

//		if (one.left != null && two.left != null && one.right != null && two.right != null) {
//			if (one.left == two.left && one.right == two.right) {
//				return isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right);
//			} else if (one.left == two.right && one.right == two.left) {
//				return isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left);
//			}
//		} else if (one.left == null && two.left == null && one.right != null && two.right != null) {
//			return isTweakedIdentical(one.right, two.right);
//		} else if (one.right == null && two.right == null && one.left != null && two.left != null) {
//			return isTweakedIdentical(one.left, two.left);
//		} else if (one.left == null && two.right == null && one.right != null && two.left != null) {
//			return isTweakedIdentical(one.right, two.left);
//		} else if (one.right == null && two.left == null && one.left != null && two.right != null) {
//			return isTweakedIdentical(one.left, two.right);
//		} 
//		
//		return true;

	}
}

class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int key) {
		this.key = key;
	}
}