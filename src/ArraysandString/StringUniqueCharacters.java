package ArraysandString;

import java.util.HashSet;

public class StringUniqueCharacters {

	//Program to find if string has unique charachters
	public static void main(String[] args) {
		String name = "Anish";
		boolean result = false;
		System.out.println(name);
		
		HashSet<Character> uniquecharset = new HashSet<Character>();//hashset accepts only unique characters
		for(int i = 0; i < name.length(); i++){
			
			result = uniquecharset.add(name.charAt(i));
			if(result == false)
				break;
			
		}
		System.out.println(result);

	}

}
