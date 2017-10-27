package ArraysandString;

public class ReverseString {

	public static void main(String[] args) {
		//reverse a string by characters
		
		/*String name = "Anish";
		String reverse = "";
		
		for(int i = name.length()-1; i >= 0; i--){
			reverse = reverse + name.charAt(i);
		}

		System.out.println(reverse);
		*/
		
		//reverse a string by words
		
		String original = "Cats like Dogs";
		String[] str = original.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i = str.length-1; i >=0; i--){
			sb.append(str[i] + " ");
			}
		
		System.out.println(original);
		System.out.println(sb.toString());
		
		/*String s = "Neil Peart rocks YYZ";
	    String[] str =s.split(" ");
	    StringBuffer buffer = new StringBuffer();
	    for(int i=str.length-1;i>=0;i--)
	    {
	        buffer.append(str[i]);
	        buffer.append(" ");
	    }
	    System.out.println("\nOriginal string: " + s);
	    System.out.println("Reverse word string:"+buffer.toString());
	*/
	}
	//https://www.youtube.com/watch?v=Q2S7CDuBTOc
	//without extra space
	public static String rev(char[] s){
		int i = 0;
		String result;
		for(int j = 0; j < s.length; i++){
			if(s[j] == ' '){
				reverse(s,i, j);
				i = j+1;
			}
		}
	    reverse(s, i, s.length-1);
	    
	    reverse(s, 0, s.length-1);
	}
	
	public static void reverse(char[] c, int i, int j){
		while( i < j){
			char temp = c[j];
			c[j] = c[i];
			c[i] = temp;
			i++;j--;
		}
	}

}
