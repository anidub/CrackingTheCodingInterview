package Linkedlist;
//You are given a Double Link List with one pointer of each node pointing to the next node just like in a single link list. 
//The second pointer however CAN point to any node in the list and not just the previous node. 
//Now write a program in O(n) time to duplicate this list.
//That is, write a program which will create a copy of this list.
public class cloneLLwith2pointers {
//http://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
	//http://code.geeksforgeeks.org/j5is5q
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		node1.arbitrary = node3;
		node2.arbitrary = node4;
		node3.arbitrary = node1;
		node4.arbitrary = node2;

		node4.next = null;

		Node head = node1;
		display(head);
		head = cloneList(node1);
		System.out.println("\n---- Cloned Linked List ----");
		display(head);
	}
	
	public static Node cloneList(Node root) {
		Node head = root;
		while (head != null) {
			head.next = new Node<Integer>(head.data, head.next);
			head = head.next.next;
		}
		head = root;
		while (head != null) {
			head.next.arbitrary = head.arbitrary.next;
			head = head.next.next;
		}

		Node copy = root.next;
		Node copyTemp = copy;
		head = root;
		while (head != null) {
			head.next = head.next.next;
			if (copyTemp.next != null)
				copyTemp.next = copyTemp.next.next;
			head = head.next;
			copyTemp = copyTemp.next;
		}
		return copy;
	}
	
	public static void display(Node head){
		Node n = head;
		while(n != null){
			System.out.print("-->" + n.data);
			n = n.next;
		}
	}
	
	/**
	 * Definition for singly-linked list with a random pointer.
	 * class RandomListNode {
	 *     int label;
	 *     RandomListNode next, random;
	 *     RandomListNode(int x) { this.label = x; }
	 * };
	 */
	/*public class Solution {
	    
	    private HashMap<RandomListNode, RandomListNode> hashMap;
	    
	    public RandomListNode copyRandomList(RandomListNode head) {
	        
	        RandomListNode node, newHead, newNode;
	        hashMap = new HashMap<>();
	        
	        node = head;
	        newHead = null;
	        
	        while (node != null) {
	            
	            newNode = new RandomListNode(node.label);
	            
	            if (newHead == null)
	                newHead = newNode;
	            
	            hashMap.put(node, newNode);
	            
	            node = node.next;
	            
	        }
	        
	        for (Map.Entry<RandomListNode, RandomListNode> entry : hashMap.entrySet()) {
	            
	            node = entry.getKey();
	            newNode = entry.getValue();
	            
	            if (node.next != null) {
	                newNode.next = hashMap.get(node.next);
	            }
	            
	            if (node.random != null) {
	                newNode.random = hashMap.get(node.random);
	            }
	            
	        }
	        
	        
	        return newHead;
	        
	    }
	}*/
}
