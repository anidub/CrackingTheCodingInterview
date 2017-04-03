package StacksandQueues;
import java.util.Stack;

public class maxvaluestack {
	
	     static Stack<Integer> maxvalue;
		static Stack<Integer> s;

		
		public maxvaluestack(){
			s = new Stack<Integer>();
			maxvalue = new Stack<Integer>();
			}
		
		public static void push(int element){
			s.push(element);
			if(maxvalue.empty() || element > maxvalue.peek()){
				maxvalue.push(element);
		}
		}
		
		public static int pop(){
			int value = s.pop();
			maxvalue.pop();
			if(value == max()){
				maxvalue.pop();
			}
			return value;
		}
		
		public static Integer max(){
			return maxvalue.peek();
			/*if(!maxvalue.empty()){
	            return maxvalue.peek();
	        }else{
	            return Integer.MAX_VALUE;
	        }
	    }*/
		}
		
		public static void display(){
			for(Integer x : s){
				System.out.println(x + " ");
			}
			System.out.println("Stack peek : " + s.peek());
			System.out.println();
			System.out.println("Maxvalues : ");
			for(Integer a : maxvalue){
				System.out.println(a + " ");
				}
			System.out.println();
		
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			maxvaluestack stack = new maxvaluestack();
			push(10);
			push(20);
			push(30);
			//push(5);
			display();
			System.out.println("The max value is " + max());
			System.out.println();
			pop();
			display();
			System.out.println("The max value is " + max());
			
	}

}
