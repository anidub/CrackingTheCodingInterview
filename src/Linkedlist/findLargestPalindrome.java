package Linkedlist;

public class findLargestPalindrome {

	public static void main(String[] args) {
		Node head = new Node (2);
	    head.next = new Node (4);
	    head.next.next = new Node (3);
	    head.next.next.next = new Node (4);
	    head.next.next.next.next = new Node (2);
	    head.next.next.next.next.next = new Node (15);
	    System.out.println(maxPalindrome(head));

	}

	public static int maxPalindrome(Node head){
		int result = 0;
		Node prev = null; Node current = head;
		Node next;
		while(current != null){
			 // The sublist from head to current reversed.
			next = current.next;
			current.next = prev;
			
			// check for odd length palindrome by finding longest common list elements
	        // beginning from prev and from next (We exclude curr)
			result = Math.max(result, 2*countCommon(prev, next)+1);
			
			// check for even length palindrome by finding longest common list elements
	        // beginning from curr and from next
			result = Math.max(result, 2*countCommon(current, next));
			prev = current;
			current = next;
		}
		return result;
	}
	public static int countCommon(Node a, Node b){
		int count = 0;
		while(a != null && b != null){
			if(a.data == b.data) count++;
			else break;
			a = a.next; b = b.next;
		}
		return count;
	}
}
