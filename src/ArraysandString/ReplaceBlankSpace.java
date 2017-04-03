package ArraysandString;

public class ReplaceBlankSpace {

	
	//replace blank space with %20
	public static void main(String[] args) {
		String input = " a B c";
		System.out.println(replace(input));
		
	}
		public static String replace(String input){
			String output = new String();
			for(int i = 0; i < input.length(); i++){
				output = output + (input.charAt(i) == ' ' ? "%20": input.charAt(i));
			}
			
		return output;
		
		}
		
	}


