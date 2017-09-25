package Linkedlist;

public class DoublyLinkedList {
/*
 * https://codereview.stackexchange.com/questions/63171/implementation-of-a-doubly-linked-list-in-java
 * http://algorithms.tutorialhorizon.com/doubly-linked-list-complete-implementation/
 * http://java2novice.com/data-structures-in-java/linked-list/doubly-linked-list/
 * https://stackoverflow.com/questions/42322052/java-delete-node-from-doubly-linked-list
 * 
 */
	private static class Node{
		int data;
		Node next;
		Node prev;
		
		public Node(int data){
			this.data = data;			
		}
	}
	
	
	private Node head = null;
	private Node tail = null;
	
	public void addFirst(int data){
		Node newNode = new Node(data);
		if(isEmpty()){
			newNode.prev = null;
			newNode.next = null;
			head = newNode;
			tail = newNode;
		}else{
			head.prev = newNode;
			newNode.next = head;
			newNode.prev = null;
			head = newNode;
		}
	}
	
	public void addLast(int data){
		Node newNode = new Node(data);
		if(isEmpty()){
			newNode.prev = null;
			newNode.next = null;
			head = newNode;
			tail = newNode;
		}else{
			newNode.next = null;
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public Integer removeFirst(){
		if(!isEmpty()){
			Node temp = head;
			if(head.next == null){
				head = null;
				tail = null;
			}else{
				head = head.next;
				head.prev = null;
			}
			return temp.data;
		}
		return null;
	}
	
	public Integer removeLast(){
		if(!isEmpty()){
			Node temp = tail;
			if(tail.prev == null){
				tail = null;
				head = null;
			}else{
				tail = tail.prev;
				tail.next = null;
			}
			return temp.data;
		}
		return null;
	}
	
	public Node findNode(int data) {
	    Node current = head; // current is the cursor
	    while (current != null && current.data != data)
	        current = current.next;
	    return current;
	}
	
	/*
	 * delete random
	 */
	public void delete(Node node){
		Node current = findNode(node.data);	
		if(current == null) return;
		
		// get the next and previous node
		Node previous = current.prev;
		Node next = current.next;
		
		// current node is head
		if(previous == null){
			head = current.next;
			head.prev = null;
		}
		
		// current node is tail
		if(next == null){
			tail = tail.prev;
			tail.next = null;
		}
		
		if(previous != null || next != null){
			Node temp = current.prev;
			temp.next = current.next;
			temp = current.next;
			temp.prev = current.prev;
		}
	}
	public void iterateForward(){
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data + " <-> ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public void iterateBackward(){
		Node temp = tail;
		while(temp != null){
			System.out.print(temp.data + " <-> ");
			temp  = temp.prev;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.addFirst(1);
		dll.addFirst(2);
		dll.addLast(3);
		dll.addLast(4);
		dll.addFirst(5);
		dll.iterateForward();
		dll.iterateBackward();
		dll.removeFirst();
		dll.iterateForward();
		dll.removeLast();
		dll.iterateBackward();
	}
}