package ajay;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChar {
	
	/*
	 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.*
	 */
	public int lengthOfLongestSubstring(String s) {
		if(s==null || s.length() == 0) return 0;
		HashMap<Character,Integer> storeChar = new HashMap<>();
		int max = 0;
		for(int i=0,j=0;i<s.length();i++) {
			if(storeChar.containsKey(s.charAt(i)))
				j = Math.max(j, storeChar.get(s.charAt(i))+1);
			storeChar.put(s.charAt(i), i);
			max = Math.max(max,i-j+1);
		}
		return max;
    }
	
	public static void main(String args[]) {
		LongestSubstringWithoutRepeatingChar l = new LongestSubstringWithoutRepeatingChar();
		System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
	}
}
