package StacksandQueues;
import java.util.Stack;

public class sortstack {
	public static Stack<Integer> sort(Stack<Integer> s){
		Stack<Integer> sorted = new Stack<Integer>();
		while (!s.isEmpty()) {
			int temp = s.pop();
			if (!sorted.isEmpty() && temp < sorted.peek()) {
				s.push(sorted.pop());
			}
			sorted.push(temp);
		}
		while(!sorted.isEmpty()){
			System.out.println(sorted.pop());
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(10);
		stack.push(5);
		stack.push(20);
		sort(stack);
		
	}

}
