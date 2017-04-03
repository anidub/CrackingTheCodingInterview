package StacksandQueues;
import java.util.LinkedList;
import java.util.Stack;

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
		
		public void add(int element){
			newest.push(element);
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
		
		public int peek(){
			shiftstacks();
			return oldest.peek();
		}
		
		public static void display(){
			shiftstacks();
			System.out.println("Output of a queue would be :");
			while(!oldest.empty()){
				System.out.println(oldest.pop());
			}
		}

	public static void main(String[] args) {
		
			Implementqueueusing2stacks queue = new Implementqueueusing2stacks();
			for(int i = 1; i <= 4; i++){
				queue.add(i);
			}
			display();
		
	}
	
	
	public void implementStackUsingQueues(){
		LinkedList<Integer> queue1 = new LinkedList<Integer>();
	    LinkedList<Integer> queue2 = new LinkedList<Integer>();
	 
	    // Push element x onto stack.
	    public void push(int x) {
	        if(isempty()){
	            queue1.offer(x);
	        }else{
	            if(queue1.size()>0){
	                queue2.offer(x);
	                int size = queue1.size();
	                while(size>0){
	                    queue2.offer(queue1.poll());
	                    size--;
	                }
	            }else if(queue2.size()>0){
	                queue1.offer(x);
	                int size = queue2.size();
	                while(size>0){
	                    queue1.offer(queue2.poll());
	                    size--;
	                }
	            }
	        }
	    }
	 
	    // Removes the element on top of the stack.
	    public void pop() {
	        if(queue1.size()>0){
	            queue1.poll();
	        }else if(queue2.size()>0){
	            queue2.poll();
	        }
	    }
	 
	    // Get the top element.
	    public int top() {
	       if(queue1.size()>0){
	            return queue1.peek();
	        }else if(queue2.size()>0){
	            return queue2.peek();
	        }
	        return 0;
	    }
	 
	    // Return whether the stack is empty.
	    public boolean isempty() {
	        return queue1.isEmpty() && queue2.isEmpty();
	    }
		
	}

}
