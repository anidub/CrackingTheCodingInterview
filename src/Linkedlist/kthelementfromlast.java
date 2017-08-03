package Linkedlist;

public class kthelementfromlast {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.next = new Node(22);
		n.next.next= new Node(43);
		n.next.next.next = new Node(3);
		//n.next.next.next.next = new Node(11);
		int number = 2;
		System.out.println(kthelementfromlast(n,number));
	}

	public static int kthelementfromlast (Node head,int n){
		Node current = head;
		for(int i = 0; i < n; i++){
			current = current.next;
		}
		Node behind = head;
		while(current != null){
			current = current.next;
			behind = behind.next;
		}		
		return behind.data;		
	}
}
