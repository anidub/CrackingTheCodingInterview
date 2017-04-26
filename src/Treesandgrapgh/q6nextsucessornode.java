package Treesandgrapgh;

import Treesandgrapgh.q4.BNode;

public class q6nextsucessornode {
	/*
	public BSTNode inordersucc(BSTNode root){
	if(root == null)
		return null;
	if(root.right != null){
		return leftmostchild(root.right);
	}else {
		BSTNode p = root;
		BSTNode x = root.parent;
		while(x != null && x.left != p){
			p = x;
			x = x.parent;s
		}
		return true;
	}
	
	public BSTNode leftmostchild(BSTNode n){
		if( n == null)
			return null;
		while( n.left != null){
			n = n.left;
		}
		return n;
	}*/
	
	public class BNode{
		int data;
		BNode left;
		BNode right;
		BNode parent;
	BNode(int data){
		this.data = data;
	}
	BNode(int data, BNode left, BNode right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
	}
	BNode root;
	BNode test;

	void makeCustomTree3(){    
        //Test Case: 3
        root = new BNode(4);
        addChildren(root, new BNode(2), new BNode(5));
        test = new BNode(3);
        addChildren(root.left, null, test);
    }   
	void addChildren(BNode parent, BNode left, BNode right){
        parent.left = left;
        parent.right = right;
        if(left!=null) left.parent = parent;
        if(right!=null) right.parent = parent;
    }

	public BNode getInorderSuccessor(BNode node){
		if(node == null)
			return null;
		if(node.right != null){
			node = node.right;
			while(node.left != null){
				node = node.left;
			}
			return node;
		}
		
		BNode prev;
		prev = node;
		node = node.parent;
		while(node != null && prev != node.left){
			prev = node;
			node = node.parent;
		}
		return node;	
	}
	public static void main(String[] args) {
		  q6nextsucessornode tree = new q6nextsucessornode();  
		  	tree.makeCustomTree3();
	        System.out.println(tree.getInorderSuccessor(tree.test));
	}
	//http://www.programcreek.com/2014/05/leetcode-inorder-successor-in-bst-java/
	//Time is O(log(n)) and space is O(1).
	public static Node getInorder(Node root, Node find){
		if(root == null) return null;
		Node current = root;
		Node next = null; // this node will work like parent node
		while(current != null && current.data != find.data){
			if(find.data < current.data){
				next = current;
				current = current.left;
			}else{
				current = current.right;
			}			
		}
		
		if(current == null) return null;
		if(current.right == null) return current;
		current = current.right;
		while(current.left != null){
			current = current.left;
		}
		return current;
	}
}
