package Linkedlist;

public class Linkedlistmergesort {

	 public static void main(String[] args){
		 Node n = new Node(3);
		 n.next = new Node(4);
		 n.next.next = new Node(2);
		 display(n);
		 Node head = mergesort(n);
		 System.out.println("After using merge sort : ");
		 display(head);
}
	 public static void display(Node head){
		 Node n = head;
		 while(n != null){
			 System.out.println("-->" + n.data);
			 n = n.next;
		 }
	 }
	 
	 public static Node mergesort(Node head){
		 if(head == null || head.next == null)
			 return head;
		 Node first = head;
		 Node middle = findmiddle(head);
		 Node second = middle.next;
		 middle.next = null;
		 return merge(mergesort(first),mergesort(second));
	 }
	 
	 public static Node findmiddle(Node head){
		 Node fast = head;
		 Node slow = head;
		 while(fast.next != null && fast.next.next != null){
			 fast = fast.next.next;
			 slow = slow.next;
		 }
		 return slow;
	 }
	 
	 public static Node merge(Node first, Node second){
		 Node newhead = new Node(-1);
		 Node current = newhead;
		while (first != null && second != null) {
			if (first.data <= second.data) {
				current.next = first;
				first = first.next;
			} else {
				current.next = second;
				second = second.next;
			}
			current = current.next;
		}
		 if(first == null){
			 current.next = second;
		 }else{
			 current.next = first;
		 }
		 return newhead.next;
	 }
}