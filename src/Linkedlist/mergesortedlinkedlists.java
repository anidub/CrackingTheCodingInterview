package Linkedlist;

public class mergesortedlinkedlists {

	public static void main(String[] args) {
		Node n1 = new Node(1);
		n1.next = new Node(2);
		n1.next.next = new Node(3);
		n1.next.next.next = new Node(4);
		
		Node n2 = new Node(3);
		n2.next = new Node(6);
		n2.next.next = new Node(7);
		n2.next.next.next = new Node(8);
		 display(mergeRecursive(n1,n2));
	}
	
	public static void display(Node head){
		Node n = head;
		while(n != null){
			System.out.print(" --> " + n.data);
			n = n.next;
		}
	}
	
	public static Node mergeRecursive(Node n1, Node n2) {
	    if (n1 == null) return n2;
	    if (n2 == null) return n1;

	    if (n1.data < n2.data) {
	        n1.next = mergeRecursive(n1.next, n2);
	        return n1;
	    } else {
	        n2.next = mergeRecursive(n2.next, n1);
	        return n2;
	    }
	}
}
