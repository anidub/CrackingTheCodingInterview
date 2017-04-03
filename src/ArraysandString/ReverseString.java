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

}
