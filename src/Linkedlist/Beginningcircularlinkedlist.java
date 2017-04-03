package Linkedlist;

public class Beginningcircularlinkedlist {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(3);
		n.next.next.next = new Node(4);
		n.next.next.next.next = new Node(5);
		n.next.next.next.next.next = n.next.next;//3
		//display(n);
		findbeginning(n);
		//System.out.println(findbeginning(n));
	}
	
	public static void display(Node head){
		Node a = head;
		while(a != null){
			System.out.print("-->" + a.data);
			a = a.next;
		}
	}
	
	public static Node findbeginning(Node head){
		Node tortoise = head;
		Node hare = head;
		
		while(tortoise.next != null || tortoise.next.next != null){
			tortoise = tortoise.next.next;
			hare = hare.next;
			
			if(tortoise == hare)
				break;
		}
		
		if(tortoise == null || tortoise.next == null)
			return null;
		hare = head;
		while(tortoise != hare){
			tortoise = tortoise.next;
			hare = hare.next;
		}
		System.out.println(hare.data);
		return hare;
		
	}
}
