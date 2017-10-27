package ArraysandString;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PushPopOperations {
	public static void main(String[] args){
		String[] operations = {"push", "push", "push","pop"};
		int[] x = {1,2,3,1};
		getProduct(operations, x);
	}
	
	public static int[] getProduct(String[] operations, int[] x){
		if(operations == null || x == null || operations.length == 0 || x.length == 0) return null;
		int[] result = new int[x.length];
		PriorityQueue<Integer> minQ = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 0; i < x.length; i++){
			if(operations[i] == "push"){
				queue.add(x[i]);
				minQ.add(x[i]);
				maxQ.add(x[i]);
			}else{
				int pop = queue.poll();
				if(pop == minQ.peek()) minQ.poll();
				if(pop == maxQ.peek()) maxQ.poll();
			}
			if(!queue.isEmpty()){
				int product = minQ.peek() * maxQ.peek();
				result[i] = product;
			}			
		}
		return result;
	}

}
