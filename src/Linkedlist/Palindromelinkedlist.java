package Linkedlist;

import java.util.Stack;

public class Palindromelinkedlist {

	public static void main(String[] args) {
			Node n = new Node(1);
			n.next = new Node(2);
			n.next.next = new Node(3);
			n.next.next.next = new Node(2);
			n.next.next.next.next = new Node(1);
			display(n);
			System.out.println();
		//	System.out.println(ispalindrome(n));
			System.out.println(ispalindrome(n));
			
	}
	public static void display(Node head){
		Node n = head;
		while(n != null){
			System.out.print("-->" + n.data);
			n = n.next;
		}
	}
	
	
	//one method
	/*public static Boolean ispalindrome(Node head){
		Node fast = head;
		Node slow = head;
		Stack<Integer> stack = new Stack<Integer>();
		
		while(fast != null && fast.next != null){
			stack.push(slow.data);
			fast = fast.next.next;
			slow = slow.next;
		}
		
		if(fast != null)
			slow = slow.next;
		
		while(slow != null){
			int top = stack.pop();
			if(top != slow.data)
				return false;
			slow = slow.next;
			
		}
		return true;
		
	}*/
	
	
	//other method
	public static Boolean ispalindrome(Node head){
		Node fast = head;
		Node slow = head;
		
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		if(fast != null)
		slow = slow.next;
		
		Node righthead = reverse(slow);
		
		Node rightcurrent = righthead;
		Node leftcurrent = head;
		
		while(rightcurrent != null){
			if(rightcurrent.data != leftcurrent.data)
				return false;
			leftcurrent = leftcurrent.next;
			rightcurrent = rightcurrent.next;
		}
		
		//recover original list
		righthead  = reverse(righthead);
		
		return true;
	}
	
	public static Node reverse(Node head){
		Node previous = null;
		Node current = head;
		Node nextnode;
		while(current != null){
			nextnode = current.next;
			current.next = previous;
			previous = current;
			current = nextnode;
		}
		return previous;
	}
	
	/*public static boolean reverse(Node head){
			Node previous = null;
			Node current = head;
			Node nextnode;
			while(current != null){
				nextnode = current.next;
				current.next = previous;
				previous = current;
				current = nextnode;
			}
			
			
			while(previous != null && head != null){
				if(head.data != previous.data){
					return false;
				}
				previous = previous.next;
				head = head.next;
			}
				
			
			return true;
		}*/
}
