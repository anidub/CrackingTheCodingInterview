package Linkedlist;
public class Methods {
	public Node mergeSortLL(Node head){
		if(head == null || head.next == null){
			return head;
		}
		Node slow = head;
		Node fast = head;
	  while (fast.next != null && fast.next.next != null){
	        fast = fast.next.next;
	        slow = slow.next;
	    }
		Node head2 = slow.next; 	  //Starting node of second half
		slow.next = null;  			  //Make last node of first half point to null
		head = mergeSortLL(head);
		head2 = mergeSortLL(head2);
		return merge(head, head2);
	}
//* --- Utility function for merging 2 sorted lists --- *	
	public Node merge(Node head1, Node head2){
		if(head1 == null){ return head2; }
		if(head2 == null){ return head1; }
		if(head1.data <= head2.data){
			head1.next = merge(head1.next, head2);
			return head1;
		}else{
			head2.next = merge(head1, head2.next);
			return head2;
		}
	}
//* --- Utility function to print the list ---- *	
	public void printList(Node head){
		while(head.next != null){
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.println(head.data);
	}
	public static void main(String args[]){
		Methods li = new Methods();
		//* Creating first linked list 'head1'	
		Node head1=new Node(2);
		head1.next=new Node(1);
		head1.next.next=new Node(4);
		head1.next.next.next=new Node(3);
		head1.next.next.next.next=new Node(6);
		head1.next.next.next.next.next=new Node(5);
		head1.next.next.next.next.next.next=new Node(8);
		head1.next.next.next.next.next.next.next=new Node(7);
 
		//* Testing merge sort on List 1 'head1'
		System.out.println("Before sorting: ");
		li.printList(head1);
 
		li.mergeSortLL(head1);
		System.out.println();
 
		System.out.println("After sorting: ");
		li.printList(head1);
		System.out.println("\n");
 
		//* Creating second linked list 'head2'
		Node head2=new Node(400);
		head2.next=new Node(200);
 
		//* Testing merge sort on List 2 'head2'
		System.out.println("Before sorting: ");
		li.printList(head2);
		li.mergeSortLL(head2);
		System.out.println("After sorting: ");
		li.printList(head2);
	}
}