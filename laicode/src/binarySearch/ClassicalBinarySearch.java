package binarySearch;

public class ClassicalBinarySearch {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		int target = 5;
		ClassicalBinarySearch case1 = new ClassicalBinarySearch();
		System.out.println(case1.binarySearch(array, target));
		
	}
	public int binarySearch(int[] array, int target) {
		if (array == null) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while(left <= right) {
			int mid = left + (right - left)/2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				right = mid + 1;
			} else {
				left = mid - 1;
			}
		}
		return -1;
	}
}
