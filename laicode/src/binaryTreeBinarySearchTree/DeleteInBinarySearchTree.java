package binaryTreeBinarySearchTree;

import java.util.*;

public class DeleteInBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stubs
		DeleteInBinarySearchTree case1 = new DeleteInBinarySearchTree();
		TreeNode root1 = new TreeNode(5);
		root1.left = new TreeNode(3);
		root1.right = new TreeNode(8);
		root1.left.left = new TreeNode(1);
		root1.left.right = new TreeNode(4);
		root1.right.right = new TreeNode(11);
		System.out.println(case1.deleteTree(root1, 5).key);

	}

	public TreeNode deleteTree(TreeNode root, int key) {
		// find the key.
		// swap with the last right child
		// percolate down
		// base case
		
		if (root == null) {
			return null;
		}
		if (key == root.key) {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else if (root.right.left == null) {
				root.right.left = root.left;
				return root.right;
			} else {
				TreeNode newRoot = deleteSmallest(root.right);
				newRoot.left = root.left;
				newRoot.right = root.right;
				return newRoot;
			}
		}
		// recursive rule
		if (key < root.key) {
			root.left = deleteTree(root.left, key);
		} else if (key > root.key) {
			root.right = deleteTree(root.right, key);
		}
		return root;
	}

	private TreeNode deleteSmallest(TreeNode root) {
		while (root.left.left != null) {
			root = root.left;
		}
		TreeNode smallest = root.left;
		root.left = root.left.right;
		return smallest;
	}
}


