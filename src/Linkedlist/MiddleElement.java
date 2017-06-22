package Linkedlist;

public class MiddleElement {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(3);
		n.next.next.next = new Node(4);
		n.next.next.next.next = new Node(5);
		n.next.next.next.next.next = new Node(6);
		MiddleElement(n);
	}

	public static void MiddleElement(Node node) {
		if (node != null) {
			Node Fastpointer = node;
			Node Slowpointer = node;
			while (Fastpointer != null && Fastpointer.next != null) {
				Fastpointer = Fastpointer.next.next;
				Slowpointer = Slowpointer.next;
			}
			System.out.println("Middle element is : " + Slowpointer.data);
		}
	}
}