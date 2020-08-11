package binaryTreeBinarySearchTree;

import java.util.*;

/*
 * Get the list of keys in a given binary search tree in a given range[min, max] 
 * in ascending order, both min and max are inclusive.

Examples

        5

      /    \

    3        8

  /   \        \

 1     4        11

get the keys in [2, 5] in ascending order, result is  [3, 4, 5]

Corner Cases

What if there are no keys in the given range? Return an empty list in this case.
How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4
 */

public class GetKeysInBinarySearchTreeInGivenRange {
	public static void main(String[] args) {
		GetKeysInBinarySearchTreeInGivenRange case1 = new GetKeysInBinarySearchTreeInGivenRange();
		TreeNode root1 = new TreeNode(5);
		root1.left = new TreeNode(3);
		root1.right = new TreeNode(8);
		root1.left.left = new TreeNode(1);
		root1.left.right = new TreeNode(4);
		root1.right.right = new TreeNode(11);

		System.out.println(case1.getRange(root1, 2, 5).toString());
	}

	public List<Integer> getRange(TreeNode root, int min, int max) {
		List<Integer> res = new ArrayList<>();
		getRange(root, min, max, res);
		return res;
	}

	private void getRange(TreeNode root, int min, int max, List<Integer> res) {
		// base case
		if (root == null) {
			return;
		}
		// recursive rules: 3 cases
		if (root.key > min) {
			getRange(root.left, min, max, res);
		}
		if (root.key >= min && root.key <= max) {
			res.add(root.key);
		}
		if (root.key < max) {
			getRange(root.right, min, max, res);
		}

	}
}


