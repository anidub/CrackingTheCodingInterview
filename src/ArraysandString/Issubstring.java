package ArraysandString;

public class Issubstring {

	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "terbottlewa";
		System.out.println(isboolean(s1,s2));
	}
	
	static Boolean isboolean(String s1, String s2){
		
		return(s1.length() == s2.length()) && ((s1+s1).indexOf(s2) != -1);
				
	}

}
