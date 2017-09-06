package Linkedlist;

public class addllforwardorder {
	public static Node newnode;
	public static int carry = 0;

	public static Node addforward(Node n1, Node n2){
		if(n1 != null && n2 == null)
			return n1;
		if(n2 != null && n1 == null)
			return n2;
		int l1 = getlength(n1);
		int l2 = getlength(n2);
		int diff = 0;
		Node newnode = new Node(0);
		if(l1 > l2){
			diff = l1 - l2;
			while (diff > 0) {
				newnode.next = n2;
				n2 = newnode;
				diff--;
				newnode = new Node(0);
			}
		}
		if(l2 > l1){
			diff = l2 - l1;
			while (diff > 0) {
				newnode.next = n1;
				n1 = newnode;
				diff--;
				newnode = new Node(0);
			}
		}
		
		return add(n1,n2);
	}
	
	public static Node add(Node n1, Node n2){
		if(n1 == null && n2 == null)
			return null;
		
		
		add(n1.next, n2.next);
		int a = n1.data + n2.data + carry;
		carry = 0;
		if(a > 9){
			carry = 1;
			a = a%10;
		}
		Node result = new Node(a);
		if(newnode == null){
			newnode = result;
		}else{
			result.next = newnode;
			newnode = result;
		}
		return newnode;
	}
	
	
	public static int getlength(Node n){
		Node head = n;
		int len = 0;
		while(head != null){
			head = head.next;
			len++;
		}
		return len;
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
		Node n1 = new Node(1);
		 n1.next = new Node(2);
		 n1.next.next = new Node(3);
		
		Node n2 = new Node(9);
		print(n1);
		print(n2);
		print(addforward(n1, n2));
	}
}
