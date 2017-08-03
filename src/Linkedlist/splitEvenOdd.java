package Linkedlist;

public class splitEvenOdd {

	public static void main(String[] args) {
		
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(3);
		n.next.next.next = new Node(4);
		n.next.next.next.next = new Node(5);
		n.next.next.next.next.next = new Node(6);
		n.next.next.next.next.next.next = new Node(7);
		split(n);
	}

	public static void split(Node n) {
		Node even = null;
		Node odd = null;
		Node eventail = null;
		Node oddtail = null;
		Node h = n;
		while (h != null) {
			if (h.data % 2 == 0) {
				if (even == null) {
					even = eventail = h;
				} else {
					eventail.next = h;
					eventail = eventail.next;
				}
			} else {
				if (odd == null) {
					odd = oddtail = h;
				} else {
					oddtail.next = h;
					oddtail = oddtail.next;
				}
			}
			Node nextNode = h.next;
			h.next = null;
			h = nextNode;
		}
		Node e = even;
		Node o = odd;
		while (e != null) {
			System.out.print(e.data + " ");
			e = e.next;
		}
		System.out.println();
		while (o != null) {
			System.out.print(o.data + " ");
			o = o.next;
		}
	}
}