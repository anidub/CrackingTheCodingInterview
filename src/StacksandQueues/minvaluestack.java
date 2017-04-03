package StacksandQueues;
import  java.util.Stack;


public class minvaluestack {
			private static Stack<Integer> minvalue;
			private static Stack<Integer> s;
			
			public minvaluestack(){
				s = new Stack<Integer>();
				minvalue = new Stack<Integer>();
	
	}
			
			public static void push(int element){
				s.push(element);
				if(minvalue.empty() || element <= minvalue.peek()){
					minvalue.push(element);
				}
			}
			
			public static Integer pop(){
				int value = s.pop();
				 if (value == min()) {
				minvalue.pop();
				}
				 return value;
				}
				
			
			
			public static Integer min(){
				return minvalue.peek();
			}
			
			public static void traverse(){
				for(Integer x : s){
					System.out.println(x + " ");
				}
				System.out.println("Minvalues : ");
				for(Integer a : minvalue){
					System.out.println(a + " ");
				}
			}
	
	
	
	public static void main(String[] args) {
		
		minvaluestack stack = new minvaluestack();

		push(5);
		push(10);
		push(1);
		traverse();
		System.out.println("The minimum value is : " + min());
		int a = pop();
		System.out.println("Popped value : " + a);
		traverse();
		System.out.println("The minimum value is : " + min());
        
        
        
        /*System.out.println("min is "+ min());
        System.out.println(" ");
        push(6);
        traverse();
        System.out.println("min is "+ min());
        System.out.println(" ");
        push(3);
        traverse();
        System.out.println("min is "+ min());
        System.out.println(" ");
        push(7);
        traverse();
        System.out.println("min is "+ min());
        System.out.println(" ");
        int a = pop();
        System.out.println("pops " +a + ".");
        traverse();
        System.out.println("min is "+ min());
        System.out.println(" ");
        int b = pop();
        System.out.println("pops " +b + ".");
        traverse();
        System.out.println("min is "+ min());
        System.out.println(" ");
		
*/
	}

}
