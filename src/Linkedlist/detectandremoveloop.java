package Linkedlist;

public class detectandremoveloop {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(3);
		n.next.next.next = new Node(4);
		n.next.next.next.next = new Node(5);
		n.next.next.next.next.next = n.next.next;
		//display(n);
		detectandremoveloop(n);
		display(n);
		

	}

	public static void display(Node head){
		Node display = head;
		while(display != null){
			System.out.print("--> " + display.data);
			display= display.next;
		}
	}
	
	public static void detectandremoveloop(Node n){
		Node fast = n;
		Node slow = n;
		
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			//slow = slow.next.next;
			slow = slow.next;
			
			if(fast == slow)
				break;
		}
		
		if(slow == fast){
			slow = n;
			while( slow != fast.next){
				fast = fast.next;
				slow = slow.next;
			}
		}
		fast.next = null;
	}
}
