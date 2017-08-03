package Linkedlist;

public class finddeleteminelement {
	//deletes only one minimum
	public static void removeSmallest(Node head) {
		   Node smallest = head; 
		   Node temp = head;
		   Node prev = null;

		   while(temp != null) {
		      if(temp.next != null && temp.next.data > smallest.data){
		        smallest = temp.next;
		        prev = temp;
		      }
		     temp = temp.next;
		   }

		   if(smallest != head) { //First element is not min
		      prev.next = smallest.next;
		   } else {
		       head = head.next; //If first element is smallest, update the head
		   }
		   
		   display(head);
		}
	
	public static void display(Node head){
		Node a = head;
		while(a != null){
			System.out.print("-->" + a.data);
			a = a.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(-1);
		n.next.next.next = new Node(4);
		n.next.next.next.next = new Node(5);
		display(n);
		System.out.println();
		//removeSmallest(n);
		removemin(n);
		System.out.println();
		
	}
	
	
	public static void removemin(Node head){
		Node n = head;
		Node min = new Node(head.data);
		while(n != null){
			if(n.data < min.data){
				min.data = n.data;
			}
			n = n.next;
		}
		n = head;
		System.out.println(min.data);
		
		if(n.data == min.data){
			head = head.next;
		} else {
			while(n.next != null) {
				if (n.next.data == min.data) {
					n.next = n.next.next;
				}
				n = n.next;
			}
		}
		
		n = head;
		display(n);
	}
}
