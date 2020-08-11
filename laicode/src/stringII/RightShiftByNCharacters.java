package stringII;


/*

Right shift a given string by n characters.

Assumptions

The given string is not null.
n >= 0.
Examples

"abc", 4 -> "cab"
 
*/
// I love yahoo
// break by k mod input.length
public class RightShiftByNCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RightShiftByNCharacters case1 = new RightShiftByNCharacters();
		String input = "abc";
		System.out.println(case1.rightShift(input, 1));
	}
	public String rightShift(String input, int n) {
		if (input.length() <= 1) {
			return input;
		}
		int k = n % input.length();
		// reverse all
		char[] inputa = input.toCharArray();
		reverse(inputa, 0, inputa.length - 1);
		reverse(inputa, 0, k - 1);
		reverse(inputa, k, inputa.length - 1);
		return new String(inputa);
	}
	private void reverse (char[] array, int left, int right) {
		while(left < right) {
			char temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left ++;
			right --;
		}
	}

}
