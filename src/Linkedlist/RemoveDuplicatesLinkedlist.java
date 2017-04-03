package Linkedlist;

import java.util.Hashtable;
import java.util.Scanner;


public class RemoveDuplicatesLinkedlist {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(3);
		n.next.next.next = new Node(4);
		n.next.next.next.next = new Node(2);
		n.next.next.next.next.next = new Node(3);
		n.next.next.next.next.next.next = new Node(5);
		
		System.out.println("Original List : ");
		RemoveDuplicatesLinkedlist rm = new RemoveDuplicatesLinkedlist();
		rm.display(n);
		System.out.println();
		System.out.println(" After removing duplicates : ");
		Node x = rm.removedup(n);
		rm.display(x);
		System.out.println();
		System.out.println("After removing duplicates without buffer : ");
	//	Node y = rm.Removewithoutbuffer(n);
		Removewithoutbuffer(n);
		rm.display(n);
	}

	public void display(Node head){
		Node n = head;
		while(n != null){
			System.out.print(" --> " + n.data);
			n = n.next;
		}
	}
	
	public Node removedup(Node head){
		Hashtable ht = new Hashtable();
		if(head == null || head.next == null){
			return head;
		}
		Node Currnode = head.next;
		Node Prevnode = head;
		int count = 0;
		while(Currnode != null){
			int data = Currnode.data;
			if(ht.contains(data)){ // contains refers to ContainsValue
				Prevnode.next = Currnode.next;
				Currnode = Currnode.next;
				
			}else{
				ht.put(count, data);
				count++;
				Prevnode = Currnode;
				Currnode = Currnode.next;
			}
		}
		return head;
	}
	
	public static void Removewithoutbuffer(Node head){
		while(head.next != null){
		Node pointer = head;
		while(pointer.next != null){
			if(head.data == pointer.next.data){
				pointer.next = pointer.next.next;
			}
			else
				pointer = pointer.next;
			}
		head = head.next;
		
		}
		//return head;
	}
	
}

