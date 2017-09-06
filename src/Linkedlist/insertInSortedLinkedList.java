package Linkedlist;

public class insertInSortedLinkedList {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(6);
		n.next.next.next = new Node(8);
		int[] arr = {5,3,7};
		display(insert(n,arr));
	}
	
	//imp to understand ref..line 28
	public static Node insert(Node head, int[] arr){
		if(head == null || arr.length == 0) return head;
		Node current = head;
		Node display = new Node(-10);
		display.next = current;
		for(int i = 0; i < arr.length; i++){
			int k = arr[i];
			if(k < head.data){
				Node newNode = new Node(k);
				newNode.next = head;
				head = newNode;
			}else{
				current = head;
				while(current != null){
					if(k < current.next.data){
						Node newNode = new Node(k);
						newNode.next = current.next;
						current.next = newNode;
						break;
					}else{
						current = current.next;
					}
				}
			}
		}
		return head;
	}
	
	public static void display(Node head){
		while(head != null){
			System.out.print(head.data + " ");
			head = head.next;
		}		
	}
}