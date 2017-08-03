package StacksandQueues;

public class ImplementQueue {
 /*
		protected static int[] Queue;
		protected static int front;
		protected static int rear;
		protected int size;
		protected static int len;
		
		//constructor
		public ImplementQueue(int n){
			front = -1;
			rear = -1;
			size = n;
			len = 0;
			Queue = new int[size];
		}
				
		public boolean isempty(){
			if(front == -1 && rear == -1)
				return true;
			else
				return false;
		}
		
		public boolean isfull(){
			if( front == 0 && rear == size -1)
				return true;
			else
				return false;
		}
				
		public int getsize(){
			return len;
		}
		
		public int peek(){
			if(isempty()){
				System.out.println(" Undeflow exception");
			}
			return Queue[front];
		}
		
		public void insert(int i){
			if (rear + 1 >= size){
				System.out.println(" Queue is full");
			}else if (front == -1 && rear == -1){
				front = 0;
				rear = 0;
				Queue[rear] = i;
		} else if (rear + 1 < size) {
			Queue[++rear] = i;
			len++;
		}
		
}
		
		public void remove(){
			if(isempty()){
				System.out.println(" The queue is empty");
			}else if( front == rear){
				front = -1;
				rear = -1;
			} else {
				front ++;
				//int temp = Queue[front];
				//return temp;
			}
		}
		
		public static void display(){
			if(len == 0){
				System.out.println("Queue is empty");
			} else
				for(int i = front; i <= rear; i++){
					System.out.println(Queue[i] + " ");
				}
		}
		
	*/
	
	int size;
	int len;
	static int[] Queue;
	static int front;
	static int rear;
	
	public ImplementQueue(int n){
		front = -1;
		rear = -1;
		size = n;
		len = 0;
		Queue = new int[size];
	}
	
	public static boolean isempty(){
		if(front == -1 && rear == -1)
			return true;
		else
			return false;
	}
	
	public boolean isfull(){
		if(front == 0 && rear == size -1)
			return true;
		else
			return false;
	}
	
	public int peek(){
		if(isempty()){
			System.out.println("Undeflow exception");
		}
		return Queue[front];
		
	}
	
	public void insert(int i){
		if(isfull()){
			System.out.println("The Queue is full");
		}else if(isempty()){
			front = 0;
			rear = 0;
			Queue[rear] = i;
		}else if(rear + 1 < size){
			Queue[++rear] = i;
			len++;
		}
	}
	
	public void remove(){
		if(isempty()){
			System.out.println("The Queue is empty");
		}else if(front == 0 && rear == 0){
			front = -1;
	    	rear = -1;
	}	
		else if(rear + 1 <= size)
			front++;
	}
	
	public static void display(){
		if(isempty()){
			System.out.println("The Queue is empty");
		}else
			for(int i = front; i <= rear; i++){
				System.out.println(Queue[i]+ "  ");
			}
	}	
	
	public static void main(String[] args) {
		ImplementQueue queue = new ImplementQueue(1);
		queue.insert(10);
		queue.insert(20);
		//queue.insert(30);
		//queue.insert(40);
		display();
		System.out.println();
		System.out.println("After remove : ");
		queue.remove();
		display();
	}
	
}
