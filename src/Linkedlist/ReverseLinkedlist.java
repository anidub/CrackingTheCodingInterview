package Linkedlist;

public class ReverseLinkedlist {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(3);
		n.next.next.next = new Node(4);
		n.next.next.next.next = new Node(5);
		
		//display(n);
		System.out.println();
		System.out.println("After reversing");
		//display(iterativereverse(n));
		//display(recursivereverse(n));
		//System.out.println(getData(n,2));
		pairWiseSwap(n);
	}
	
	public static void display(Node head){
		Node a = head;
		while(a != null){
			System.out.print("-->" + a.data);
			a = a.next;
		}
	}
	
	/*public static Node iterativereverse(Node head){
		Node current = head;
		Node previous = null;
		Node nextnode;
		
		while(current != null){
			nextnode = current.next;
			
			current.next = previous;
			
			previous = current;
			
			current = nextnode;
		}
		return previous;
	}*/
	
	public static Node recursivereverse(Node head){
		Node x = head;
		if(x == null || x.next == null)
			return x;
		
		Node remaining = recursivereverse(x.next);
		x.next.next = x;
		x.next = null;
		return remaining;
	}
	
	public static int getData(Node head, int index){
		if(head == null) return -1;
		int count = 1;
		Node temp = head;
		while(temp != null){			
			if(count == index) return temp.data;
			count++;
			temp = temp.next;
		}
		return -1;	
	}
	
	 /* Function to swap Nodes x and y in linked list by  changing links */
//	/http://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/
 public static void swapNodes(Node head,int x, int y){
     // Nothing to do if x and y are same
     if (x == y) return;

     // Search for x (keep track of prevX and CurrX)
     Node prevX = null, currX = head;
     while (currX != null && currX.data != x){
         prevX = currX;
         currX = currX.next;
     }

     // Search for y (keep track of prevY and currY)
     Node prevY = null, currY = head;
     while (currY != null && currY.data != y)   {
         prevY = currY;
         currY = currY.next;
     }

     // If either x or y is not present, nothing to do
     if (currX == null || currY == null)
         return;

     // If x is not head of linked list
     if (prevX != null)
         prevX.next = currY;
     else //make y the new head
         head = currY;

     // If y is not head of linked list
     if (prevY != null)
         prevY.next = currX;
     else // make x the new head
         head = currX;

     // Swap next pointers
     Node temp = currX.next;
     currX.next = currY.next;
     currY.next = temp;
     display(head);
 }
 
 /* Function to pairwise swap elements of a linked list */
 //http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list-by-changing-links/
 public static void pairWiseSwap(Node node) {
     // If linked list is empty or there is only one node in list
     if (node == null || node.next == null) {
         return ;//null;
     }
     // Initialize previous and current pointers
     Node prev = node;
     Node curr = node.next;
     node = curr;  // Change head before proceeeding
     // Traverse the list
     while (true) {
         Node next = curr.next;
         curr.next = prev; // Change next of current as previous node

         // If next NULL or next is the last node
         if (next == null || next.next == null) {
             prev.next = next;
             break;
         }
         // Change next of previous to next next
         prev.next = next.next;
         // Update previous and curr
         prev = next;
         curr = prev.next;
     }
     display(node);
     //return node;
 }
}
