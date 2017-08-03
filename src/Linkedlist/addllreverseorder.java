package Linkedlist;

public class addllreverseorder {

	public static Node add(Node n1, Node n2){
		if(n1 == null && n2 != null)
			return n2;
		if(n1 != null && n2 == null)
			return n1;
		Node p1 = n1;
		Node p2 = n2;
		Node result = new Node(0);
		Node p3 = result;
		int carry = 0;
		//while both lists exist
		while(p1 != null || p2 != null){
			if(p1 != null){
				carry += p1.data;
				p1 = p1.next;
			}
			if(p2 != null){
				carry += p2.data;
				p2 = p2.next;
			}
			
			p3.next = new Node(carry%10);
			carry = carry/10;
			p3 = p3.next;
		}
		
		if(carry == 1)
			p3.next = new Node(1);
		return result.next;
	}
	
	public static void print(Node n1){
		Node head = n1;
		while(head != null){
			System.out.print("->" + head.data);
			head = head.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Node n1 = new Node(9);
		Node n2 = new Node(9);
		
		n1.next = new Node(3);
		print(n1);
		print(n2);
		print(add(n1,n2));
		
	}

}
