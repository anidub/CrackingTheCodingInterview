package Linkedlist;

import java.util.Hashtable;

public class findanddeletemiddle {
	 
	public static void main(String[] args) {
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(3);
		n.next.next.next = new Node(4);
		n.next.next.next.next = new Node(3);

		findanddeletemiddle prac = new findanddeletemiddle();
		prac.display(n);
		
		delete(n);
		System.out.println();
		prac.display(n);	
	}
	
	public void display(Node head){
		Node n = head;
		while(n != null){
			System.out.print(" --> " + n.data);
			n = n.next;
		}
	}
	
	public static Node delete (Node n){
		Node temp = n;
		Node slow = n;
		Node fast = n;
		int len = 0;
		while(temp != null){
			len++;
			temp = temp.next;
		}
		temp = n;
		int middleposition = 1;
		
		while(fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			middleposition++;
		}
		
		int middle = slow.data;
		System.out.println();
		System.out.println(middleposition);
		
		Node newnode = slow.next;
		slow.data = newnode.data;
		slow.next = newnode.next;
		
		return n;	
	}
}
