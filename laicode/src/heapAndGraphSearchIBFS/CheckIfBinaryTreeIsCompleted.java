package heapAndGraphSearchIBFS;

import java.util.*;

public class CheckIfBinaryTreeIsCompleted {

	public static void main(String[] args) {
		CheckIfBinaryTreeIsCompleted case1 = new CheckIfBinaryTreeIsCompleted();
		TreeNode root1 = new TreeNode(5);
		root1.left = new TreeNode(3);
		root1.right = new TreeNode(8);
		root1.left.left = new TreeNode(1);
		root1.left.right = new TreeNode(4);
		System.out.print(case1.isCompleted(root1));
		
		TreeNode root2 = new TreeNode(5);
		root2.left = new TreeNode(3);
		root2.right = new TreeNode(8);
		root2.left.left = new TreeNode(1);
		root2.left.right = new TreeNode(4);
		root2.right.right = new TreeNode(11);
		System.out.print(case1.isCompleted(root2));

	}

	public boolean isCompleted(TreeNode root) {
		if (root == null) {
			return true;
		}
		// BFS
		Queue<TreeNode> BFS = new ArrayDeque<>();
		BFS.offer(root);
		// after detecting the first node that misses one child, then check
		// whether all following nodes expanded to see whether they have any nodes
		// generated
		// use a flag to flag that the first node missing child, when there is one
		// the flag will be set to be true, any further missed child will indicate
		// the tree is not completed.
		boolean flag = false;
		while (!BFS.isEmpty()) {
			TreeNode cur = BFS.poll();
			// left child:
			if (cur.left == null) {
				flag = true;
			} else if (flag == true) {
				return false;
			} else {
				BFS.offer(cur.left);
			}

			// right child:
			if (cur.right == null) {
				flag = true;
			} else if (flag == true) {
				return false;
			} else {
				BFS.offer(cur.right);
			}
		}
		return true;

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
