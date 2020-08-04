package binarySearch;

import java.util.Arrays;

public class SearchInSortedMatrixI {
	public static void main(String[] args) {
		int[][] matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} };
		int target = 7;
		SearchInSortedMatrixI case1 = new SearchInSortedMatrixI();
		System.out.println(Arrays.toString(case1.search(matrix, target)));
	}
	public int[] search(int[][] matrix, int target) {
		int left = 0;
		int right = matrix.length * matrix[0].length - 1;
		int[] res = new int[2];
		res[0] = -1;
		res[1] = -1;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			int midx = mid / matrix[0].length;
			int midy = mid % matrix[0].length;
			if (matrix[midx][midy] == target) {
				res[0] = midx;
				res[1] = midy;
				return res;
			} else if(matrix[midx][midy] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return res;
	}

}
