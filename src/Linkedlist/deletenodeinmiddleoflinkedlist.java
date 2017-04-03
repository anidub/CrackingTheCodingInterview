package Linkedlist;

public class deletenodeinmiddleoflinkedlist {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.next = new Node(22);
		n.next.next= new Node(43);
		n.next.next.next = new Node(3);
		n.next.next.next.next = new Node(25);
		display(n);
		System.out.println();
		System.out.println("After deleteing middlenode : ");
		deletemiddlenode(n.next.next);
		display(n);
		//System.out.println(display(deletemiddlenode(n.next.next)));
	}
	public static void display(Node head){
		Node display = head;
		while(display != null){
			System.out.print("--> " + display.data);
			display= display.next;
		}
	}
	
	public static boolean deletemiddlenode(Node n){
		if(n == null || n.next == null){
			return false;
		}
		Node New = n.next;
		n.data = New.data;
		n.next = New.next;
		return true;
		
	}
}
