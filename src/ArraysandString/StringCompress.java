package ArraysandString;

public class StringCompress {
	//Implement a method to perform basic string compression using the counts of
    //repeated characters. For example, the string aabcccccaaa would become
    //a2blc5a3. If the "compressed" string would not become smaller than the original
    //string, your method should return the original string.
	 public static void main(String[] args) {
		 
		 System.out.println(compress("abbcccccddee"));
		 System.out.println(compress("aabbcc"));
	       
	    }

		public static String compress(String s){
			if(s == null || s.isEmpty())
			return s;		
			char prev = s.charAt(0);
			StringBuffer sb = new StringBuffer();
			int count = 1;
			sb.append(prev);		
			for(int i = 1; i< s.length();++i){
				if(s.charAt(i) == prev){
					++count;
				}
				else{
					prev = s.charAt(i);
					sb.append(count).append(prev);
					count = 1;
				}
			}		
			sb.append(count);
			return sb.toString().length() >= s.length() ? s : sb.toString();
	}	
}

