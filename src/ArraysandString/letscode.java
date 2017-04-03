package ArraysandString;

public class letscode {

	public static void main(String[] args) {
		int a = 1, b = 1, x = 2, y = 2;
		MakeTheNumbersMatch(a,b,x,y);
		System.out.println(a);
		System.out.println(b);
		System.out.println(x);
		System.out.println(y);

	}
	public static void MakeTheNumbersMatch(int a, int b, int x, int y)
    {
        while(a!=x && b!=y)
        {
            if(a> x)
            {
                a--;
            }
            else
            {
                a++;
            }
            if(b>y)
            {
                b--;
            }
            else
            {
                b++;
            }
        }
        System.out.println(a);
		System.out.println(b);
		System.out.println(x);
		System.out.println(y);
    }

}
