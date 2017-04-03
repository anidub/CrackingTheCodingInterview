package StacksandQueues;

public class circularQueue {
/*	Circular queue is not a different Data type.
 * enqueue - O(1) [as we insert element at Rear in Circular Queue]
dequeue - O(1) [as we remove element from front in Circular Queue]
	Circular queue is just one of the efficient ways to implement Queue.When you insert and element you increment the Rear pointer and store the element at the last position, 
	and when you remove an element you remove it from front and increment the Front pointer. Note that in both the cases you are incrementing the pointers.
	 So if you keep inserting and removing the elements into a queue, the queue would keep moving inside the memory, in the above figure toward right. Which is not efficient.
So how Queue is usually implemented (For instance in STL) is we connect the Rear node back to the front of the queue and make it circular.
That way when you push in and remove element the queue just moves inside that loop and doesn't require extra allocation of memory. 
Of course how big the loop has to be is again a variable factor but that is a different problem all together, and how we normally 
handle it is by doubling the size of the Data structure every time a overflow occurs and reallocating memory for it. */
	private static final int capacity = 5;
    private Object[] Q;
    private final int N; // capacity
    private int f = 0;
    private int r = 0;
     
    public circularQueue(int capacity){
        N = capacity;
        Q = new Object[N];
    }
 
    public int size() {
        if(r > f)
            return r - f;
        return N - f + r;
    }
 
    public boolean isEmpty() {
        return (r == f) ? true : false;
    }
 
    public boolean isFull() {
        int diff = r - f; 
        if(diff == -1 || diff == (N -1))
            return true;
        return false;
    }
 
    public void enqueue(Object obj)  {
        if(isFull()){
            System.out.println("Queue is Full."); return;
        }else{
            Q[r] = obj;
            r = (r + 1) % N;
        }
    }
 
    public Object dequeue() {
        Object item; 
        if(isEmpty()){
        	System.out.println("Queue is empty"); return null;
  
        }else{
            item = Q[f];
            Q[f] = null;
            f = (f + 1) % N;
        }
       return item;
    }

	public static void main(String[] args) {
		circularQueue queue = new circularQueue(5);
        
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        //queue.enqueue("E");
        System.out.println("Size : " + queue.size());
        System.out.println("Dequeue " + queue.dequeue());
        System.out.println("Enqueu : " + "E");
        queue.enqueue("E");
        System.out.println("Size : " + queue.size());
        //queue.enqueue("F");
        System.out.println("Dequeue " + queue.dequeue());
        System.out.println( "Size : " + queue.size());
	}

}
