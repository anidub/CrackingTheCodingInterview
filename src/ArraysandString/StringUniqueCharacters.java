package ArraysandString;

import java.util.HashSet;

public class StringUniqueCharacters {

	//Program to find if string has unique charachters
	public static void main(String[] args) {
		getLongestUnique("abcdeduhiqplkz");
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
	
	//get longest unique substring in a string
	//http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
	//https://stackoverflow.com/questions/9734474/find-longest-substring-without-repeating-characters
	//	https://leetcode.com/articles/longest-substring-without-repeating-characters/
	public static String getLongestUnique(String s){
		String result = null;
		if(s == null || s.length() == 0) return result;
		int[] arr = new int[256];
		int currstart = 0;
		int unique = 0;
		int maxLength = 0;
		String temp = "";
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(arr[c] == 0){
				unique++;
				arr[c]++;
			}else{
				temp = s.substring(currstart, i+1);
				if(temp.length() > maxLength) result = temp;
				while(currstart < s.length() && s.charAt(currstart) != c){
					arr[s.charAt(currstart)] = 0;
					currstart++;
				}
				arr[s.charAt(currstart)] = 0;
				currstart++;
			}			
		}
		temp =  s.substring(currstart, s.length()-1);
		if(temp.length() > maxLength){
			result = temp;
		}
		return result;		
	}

}
