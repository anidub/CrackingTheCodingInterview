package StacksandQueues;
import java.util.NoSuchElementException;
import java.util.Stack;
//http://algs4.cs.princeton.edu/13stacks/QueueWithTwoStacks.java.html
public class Implementqueueusing2stacks {
		static Stack<Integer> newest;
		static Stack<Integer> oldest;
		
		public Implementqueueusing2stacks(){
			newest = new Stack<Integer>();
			oldest = new Stack<Integer>();
		}
		
		public int size(){
			return newest.size() + oldest.size();	
		}

		 // is the queue empty?
	    public boolean isEmpty() {
	        return oldest.isEmpty() && newest.isEmpty();
	    }
	    
		// return the item least recently added to the queue.
	    public int peek() {
	        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
	        if (oldest.isEmpty()) shiftstacks();
	        return oldest.peek();
	    }

	    // add the item to the queue
	    public void enqueue(int item) {
	    	newest.push(item);
	    }

	    // remove and return the item on the queue least recently added
	    public int dequeue() {
	        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
	        if (oldest.isEmpty()) shiftstacks();
	        return oldest.pop();
	    }
	    
		public static void display(){
			shiftstacks();
			System.out.println("Output of a queue would be :");
			while(!oldest.empty()){
				System.out.println(oldest.pop());
			}
		}
		
		public static void shiftstacks(){
			while(oldest.isEmpty()){
				while(!newest.isEmpty()){
					oldest.push(newest.pop());
				}
			}			
			//alternate
			/* if(value.isEmpty()){
		            value.push(x);
		        }else{
		            while(!value.isEmpty()){
		                temp.push(value.pop());
		            }
		 
		            value.push(x);
		 
		            while(!temp.isEmpty()){
		                value.push(temp.pop());
		            }    
		        }*/
		}		

	public static void main(String[] args) {		
			Implementqueueusing2stacks queue = new Implementqueueusing2stacks();
			for(int i = 1; i <= 4; i++){
				queue.enqueue(i);
			}
			display();		
	}
}