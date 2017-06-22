package Linkedlist;

public class intersectionointoftwolinkedlists {
/*//http://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
	//Time complexity of this method is O(m+n) and used Auxiliary space is O(1)
	There are two singly linked lists in a system. By some programming error the end node of one of the linked list got linked into the second list,
forming a inverted Y shaped list. Write a program to get the point where two linked list merge.
Time Complexity: O(m+n)
Auxiliary Space: O(1)	*/
	public static void main(String[] args) {
		Node n1 = new Node(3);
		n1.next = new Node(6);
		n1.next.next = new Node(15);
		n1.next.next.next = new Node(15);
		n1.next.next.next.next = new Node(30);		
		
		Node n2 = new Node(6);
		n2.next = new Node(15);
		n2.next.next = new Node(25);
		//n2.next.next.next = new Node(30);
		
		//System.out.println(getNode(n1,n2));isLinkedListContains
		System.out.println(oneLinkedListContainsAnother(n1,n2));
	}
	
	public static int getNode(Node n1, Node n2){
		if(n1 == null) return -1;
		if(n2 == null) return -1;
		
		int c1 = getCount(n1);
		int c2 = getCount(n2);
		int d = 0;
		if(c1 > c2){
			d = c1 - c2;
			return intersectionNode(d, n1, n2);
		}
		if(c2 > c1){
			d = c2 - c1;
			return intersectionNode(d, n2, n1);
		}
		return -1;
	}
	
	public static int intersectionNode(int d, Node n1, Node n2){
		for(int i = 0; i < d; i++){
			n1 = n1.next;
		}
		Node current1 = n1; Node current2 = n2;
		while(current1 != null && current2 != null){
			if(current1.data == current2.data){
				return current1.data;
			}
				current1 = current1.next;
				current2 = current2.next;
		}
		return -1;
	}
	
	public static int getCount(Node n){
		Node current = n;
		int count = 0;
		while(current != null){
			count++;
			current = current.next;
		}
		return count;
	}
		
	public static boolean oneLinkedListContainsAnother(Node n1, Node n2){
		// in case if we dont know which one in longer
		int c1= getCount(n1);
		int c2 = getCount(n2);
		
		boolean contains = cc(n1,n2);
		return contains;
	}
	
	public static boolean cc(Node n1, Node n2){
		Node h1 = n1;
		Node h2 = n2;
		while(h1 != null){
			if(h1.data == h2.data){
				h1 = h1.next;h2 = h2.next;
				while(h2 != null){
					if(h1.data != h2.data) return false;
					h1 = h1.next; h2 = h2.next;
				}
				return true;
			}
			h1 = h1.next;
		}
		return false;
	}
	public int getcou(Node n){
		Node current = n;
		int count = 0;
		while(n.next != null){
			count++;
			n = n.next;
		}
		return count;
	}
}