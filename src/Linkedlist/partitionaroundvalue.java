package Linkedlist;

public class partitionaroundvalue {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.next = new Node(8);
		n.next.next= new Node(9);
		n.next.next.next = new Node(3);
		n.next.next.next.next = new Node(2);
		n.next.next.next.next.next = new Node(10);
		int partitionvalue = 9;
		display(n);
		System.out.println("\nAfter partitioning : ");
		display(partition(n, partitionvalue));
		
	}
	
	public static Node partition(Node head, int x){
		Node lefthead = new Node(0);
		Node righthead = new Node(0);
		Node cur1 = lefthead;
		Node cur2 = righthead;
		Node cur = head;
		while(cur != null){
			if(cur.data < x){
				cur1.next = cur;
				cur = cur.next;
				cur1 = cur1.next;
			}else{
				cur2.next = cur;
				cur = cur.next;
				cur2 = cur2.next;
			}
		}
			cur2.next = null;
			cur1.next = righthead.next;
			return lefthead.next;
		
	}
	
	public static void display(Node head){
		Node a = head;
		while (a != null){
			System.out.print("-->" + a.data);
			a = a.next;
		}
	}	
}
