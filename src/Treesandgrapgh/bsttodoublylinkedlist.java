package Treesandgrapgh;

import java.util.LinkedList;
import java.util.Queue;

public class bsttodoublylinkedlist {
	
	//this program is binary tree to doubly linkedlist

	public static Node btreetodll(Node root){
		Node head = btreetodllutil(root);
		while(head.left != null){
			head = head.left;
		}
		
		return head;
	}
	
	public static Node btreetodllutil(Node root){
		if(root == null) return root;
		if(root.left != null){
			Node leftnode = btreetodllutil(root.left);
			while(leftnode.right != null){
				leftnode = leftnode.right;
			}
			leftnode.right = root;
			root.left = leftnode;
			
		}
		
		if(root.right != null){
			Node rightnode = btreetodllutil(root.right);
				while(rightnode.left != null){
					rightnode = rightnode.left;
				}
				rightnode.left = root;
				root.right = rightnode;
		}
		return root;
	}
 
    public static void printLL(Node root){
        while(root != null){
            System.out.println("Data : " + root.data);
            root = root.right;
        }
    } 
    public static void main(String args[]){
 
        Node root = new Node(10);
 
        Node l = new Node(12);
        Node r = new Node(15);
 
        Node ll = new Node(25);
        Node lr = new Node(30);
 
        Node rl = new Node(36);
 
        root.setLeft(l);
        root.setRight(r);
 
        l.setLeft(ll);
        l.setRight(lr);
 
        r.setLeft(rl);
 
        printLL(btreetodll(root)); 
    }
    
    //http://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
    // O(n) 
    // head --> Pointer to head node of created doubly linked list
    Node head;
      
    // Initialize previously visited node as NULL. This is static so that the same value is accessible in all recursive calls
    
    static Node prev = null;
    void BinaryTree2DoubleLinkedList(Node root) {
        // Base case
        if (root == null)   return;
  
        // Recursively convert left subtree
        BinaryTree2DoubleLinkedList(root.left);
  
        // Now convert this node
        if (prev == null) 
            head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;  
        // Finally convert right subtree
        BinaryTree2DoubleLinkedList(root.right);
    }
}