package stringII;

import java.util.Arrays;

/*
Given an array of elements, reorder it as follow:

{ N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }

{ N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }

Try to do it in place.

Assumptions

The given array is not null
Examples

{ 1, 2, 3, 4, 5, 6} → { 1, 4, 2, 5, 3, 6 }

{ 1, 2, 3, 4, 5, 6, 7, 8 } → { 1, 5, 2, 6, 3, 7, 4, 8 }

{ 1, 2, 3, 4, 5, 6, 7 } → { 1, 4, 2, 5, 3, 6, 7 }

   
 */
public class ReOrderArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReOrderArray case1 = new ReOrderArray();
		int[] array = {1,2,3,4,5,6};
		System.out.print(Arrays.toString(case1.reorder(array)));
	}
	public int[] reorder(int[] array) {
		if(array.length % 2 == 0) {
			reorder(array, 0, array.length - 1);
		}
		else {
			reorder(array, 0 , array.length - 2);
		}
		return array;
	}
	private void reorder(int [] array, int left, int right) {
		int length = right - left + 1;
		if (length <= 2) {
			return;
		}
		int mid = left + length / 2;
		int lmid = left +  length / 4;
		int rmid = left + length * 3 / 4;
		reverse(array, lmid, mid - 1);
		// length  = 6, left = 0, right = 5, mid = 2, lmid = 1, rmid = 4;
		// {1, 3 , 2, 4, 5, 6}
		reverse(array, mid, rmid - 1);
		// {1, 3, 4, 2, 5, 6}
		reverse(array, lmid, rmid - 1);
		// {1, 2, 4, 3, 5, 6}
		// half of the left partition's size = lmid - left
		reorder(array, left, left + (lmid - left) * 2 - 1);
		// reorder(array, 0, 1);
		reorder(array, left + (lmid - left) * 2, right);
		// reorder (array, 2, 5)
	}
	private void reverse(int[] array, int left, int right) {
		while(left < right) {
			int temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left ++;
			right --;
		}
	}
}
