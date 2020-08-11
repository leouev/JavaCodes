package stringII;
import java.util.*;

public class AllPermutationsII {
	public static void main(String[] ags) {
		AllPermutationsII case1 = new AllPermutationsII();
		String input1 = "abb";
		System.out.println(case1.permutations(input1));
	}
	public List<String> permutations(String input){
		List<String> res = new ArrayList<>();
		if(input == null) {
			return res;
		}
		char[] inputc = input.toCharArray();
		permute(inputc, 0, res);
		return res;
	}
	private void permute(char[] array, int index, List<String> res) {
		// base case: reach the bottom
		if(index == array.length) {
			res.add(new String(array));
			return;
		}
		Set<Character> used = new HashSet<Character>();
		for(int i = index; i < array.length; i ++) {
			if(used.add(array[i])) {
				swap(array, i, index);
				permute(array, index + 1, res);
				swap(array, i, index);
			}
		}
		
		
	}
	private void swap(char[] array, int left, int right) {
		char temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}
