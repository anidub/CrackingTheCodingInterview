package Linkedlist;

import java.util.HashMap;
import java.util.Map;
// or just copy the linked list to another linkedlist and return the new linkedlist incase on singly linkedlist with no random pointer
public class cloneSinglyLinkedList {
	
	Node head;
	
	public cloneSinglyLinkedList(Node head){
		this.head = head;
	}

	// push method to put data always at the head
	// in the linked list.
	public void push(int data){
		Node node = new Node(data);
		node.next = this.head;
		this.head = node;
	}

	// Method to print the list.
	void print(){
		Node temp = head;
		while (temp != null){
		//	Node random = temp.random;
		//	int randomData = (random != null)? random.data: -1;
			System.out.println("Data = " + temp.data);//", Random data = "+ randomData);
			temp = temp.next;
		}
	}
	
	//use this
	public static Node clone(Node head){
		// Initialize two references, one with original list's head.

		Node origCurr = head, cloneCurr = null;

		// Hash map which contains node to node mapping of original and clone linked list.
		Map<Node, Node> map = new HashMap<Node, Node>();

		// Traverse the original list and make a copy of that in the clone linked list.
		while (origCurr != null){
			cloneCurr = new Node(origCurr.data);
			map.put(origCurr, cloneCurr);
			origCurr = origCurr.next;
		}

		// Adjusting the original list reference again.
		origCurr = head;
		cloneCurr = null;
		Node copied = null;
		// Traversal of original list again to adjust the next and random references of clone list using hash map.
		while (origCurr != null){			
			cloneCurr = map.get(origCurr);
			if(copied == null){
				copied = map.get(origCurr);
			}
			cloneCurr.next = map.get(origCurr.next);
			origCurr = origCurr.next;
		}

		//return the head reference of the clone list.
		return copied;
	}
	
	// Driver Class
	
			// Main method.
			public static void main(String[] args){
				// Pushing data in the linked list.
				cloneSinglyLinkedList list = new cloneSinglyLinkedList(new Node(5));
				list.push(4);
				list.push(3);
				list.push(2);
				list.push(1);

				// Setting up random references.
			/*	list.head.random = list.head.next.next;
				list.head.next.random =
					list.head.next.next.next;
				list.head.next.next.random =
					list.head.next.next.next.next;
				list.head.next.next.next.random =
					list.head.next.next.next.next.next;
				list.head.next.next.next.next.random =
					list.head.next;*/

				// Making a clone of the original linked list.
				cloneSinglyLinkedList clone = list.clone();

				// Print the original and cloned linked list.
				System.out.println("Original linked list");
				list.print();
				System.out.println("\nCloned linked list");
				clone.print();
				
				
				Node n = new Node(1);
				n.next = new Node(2);
				n.next.next = new Node(3);
				n.next.next.next = new Node(4);
				n.next.next.next.next = new Node(5);
				//cc(n);
			}
}
