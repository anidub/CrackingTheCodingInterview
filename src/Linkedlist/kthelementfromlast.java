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

	public static int kthelementfromlast(Node head, int n) {
		if (head == null || n < 1) 	return -1;
		Node current = head;
		Node nBehindCurrent = head;

		for (int i = 0; i < n - 1; i++) {
			current = current.next;
			if (current == null) {
				return -1;
			}
		}
		while (current.next != null) {
			nBehindCurrent = nBehindCurrent.next;
			current = current.next;
		}
		return nBehindCurrent.data;
	}
}
