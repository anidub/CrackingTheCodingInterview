package Linkedlist;

public class subtractfirstfromlast {
	//Given a singly linked list you have to subtract the value of first node from the last node and so on until you reach the middle node.
	public static void main(String[] args) {
		Node n1 = new Node(5);
		n1.next = new Node(4);
		n1.next.next = new Node (3);
		n1.next.next.next = new Node (2);
		n1.next.next.next.next = new Node (1);
		display(n1);
		display(subtract(n1));	
	}
	
	public static void display(Node n1){
		Node head  = n1;
		while(head != null){
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static Node subtract(Node head){
		Node n = head;
		Node fast = n;
		Node slow = n;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		if(fast != null){
			slow = slow.next;
		}
		Node righthead = reverse(slow);
	//	return righthead;
		Node lefthead = head;
		while(righthead != null){
			lefthead.data = Math.abs(lefthead.data - righthead.data);
			righthead = righthead.next;
			lefthead = lefthead.next;
			
		}
		righthead = reverse(slow);
		return head;		
	}
	
	public static Node reverse(Node head){
		Node newnode;
		Node previous = null;
		Node current = head;
		while(current != null){
			newnode = current.next;
			current.next = previous;
			previous = current;
			current = newnode;
		}
		return previous;
	}	
}
