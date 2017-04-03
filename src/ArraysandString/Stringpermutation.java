package ArraysandString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Stringpermutation {

	public static void main(String[] args) {
	
		System.out.println(isPermutation("ABCDE","ABDEC"));
		System.out.println(isPermutation("aaabbbb","aabbbbb"));
		
	}
		
	public static boolean isPermutation(String a, String b) {
		if (a.length() != b.length()) // length check
			return false;
		if (a == null || b == null) // null check
			return false;
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		for (char c : a.toCharArray()) { // put alphabets in map
			if (!hm.containsKey(c))
				hm.put(c, 1);
			else
				hm.put(c, hm.get(c) + 1);
		}
		for (int i = 0; i < b.length(); ++i) { // for checking
			char c = b.charAt(i);
			if (!hm.containsKey(c)) // if original string does not contain the letter from new string
				return false;
			else {
				int count = hm.get(c);
				if (count == 0)
					return false;
				else {
					hm.put(c, count - 1);
				}
			}
		}
		return true;
	}		
}
