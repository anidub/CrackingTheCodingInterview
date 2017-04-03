package Linkedlist;

public class insertInSortedLinkedList {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(6);
		n.next.next.next = new Node(8);
		int[] arr = {5,3,7};
		insert(n,arr);
	}
	
	public static void insert(Node n, int[] arr) {
		Node current = n;
		Node s = current;
		for (int i = 0; i < arr.length; i++) {
			int k = arr[i];
			if (n.data > k) {
				Node newN = new Node(k);
				newN.next = n;
			} else {
				while (current != null) {
					if (current.next.data > k) {
						Node newN = new Node(k);
						newN.next = current.next;
						current.next = newN;
						break;
					} else {
						current = current.next;
					}

				}
			}
		}
		while (s != null) {
			System.out.print("->" + s.data);
			s = s.next;
		}
	}	
}
