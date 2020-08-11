package stringII;

import java.util.*;
/*
Given an original string input, and two strings S and T, 
from left to right replace all occurrences of S in input with T.

Assumptions

input, S and T are not null, S is not empty string
Examples

input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
input = "laicode", S = "code", T = "offer", input becomes "laioffer"
 */

public class StringReplace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringReplace case1 = new StringReplace();
		String input1 = "laicodelaicodeissodamngood";
		String source1 = "code";
		String target1 = "offer";
		System.out.println(case1.replace(input1, source1, target1));
		
	}
	public String replace(String input, String source, String target) {
		StringBuilder sb = new StringBuilder();
		int fromindex = 0;
		int matchindex = input.indexOf(source);
		while (matchindex != -1) {
			sb.append(input, fromindex, matchindex);
			sb.append(target);
			fromindex = matchindex + source.length();
			matchindex = input.indexOf(source, fromindex);
		}
		sb.append(input, fromindex, input.length());
		return sb.toString();
	}

}
