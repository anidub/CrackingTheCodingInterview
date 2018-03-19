package Treesandgrapgh;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import TreeGeeks.TreeNode;

public class iterativeTraversals {
	
	private Node root;

	//level order traversal
	public void byLevel(Node root){
	     Queue<Node> level  = new LinkedList<>();
	     level.add(root);
	     while(!level.isEmpty()){
	         Node node = level.poll();
	         System.out.print(node.data + " ");
	         if(node.left!= null)
	         level.add(node.left);
	         if(node.right!= null)
	         level.add(node.right);
	     }
	}
	

	//preorder iterative
	/** Iteratively traverses the binary tree in pre-order 
	/* Pop all items one by one. Do following for every popped item
	       a) print it
	       b) push its right child
	       c) push its left child
	    Note that right child is pushed first so that left is processed first */
	public void preorder() {
		if (root == null)
			return;

		Stack<Node> stack = new Stack<Node>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node current = stack.pop();
			if (current.right != null)
				stack.push(current.right);
			if (current.left != null)
				stack.push(current.left);
			System.out.print(current.data + " ");
		}
	}

		//inorder iterative
/**	Create an empty stack s and Initialize current node as root
	Push the current node to s and set currentNode = currentNode.left until currentNode is NULL
	If currentNode is NULL and s is not empty then
	Pop the top node from stack and print it
	 set currentNode = currentNode.right
	go to step 2
	If stack is empty and currentNode is also null then we are done with it*/
	/** Iteratively traverses the binary tree in in-order */
	@SuppressWarnings("unused")
	public void inorder() {
		Node node = root;
		Stack<Node> stack = new Stack<Node>();
		while (!stack.isEmpty() && node != null) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				System.out.print(node.data + " ");
				node = node.right;
			}
		}
	}

		//postorder
	/*Create an empty stack s and set currentNode =root.
	while currentNode is not NULL Do following
	Push currentNode 's right child and then currentNode to stack.
	Set currentNode =currentNode .left
	Pop an node from stack and set it as root and set it to currentNode 
	If the popped node has a right child and the right child is at top of stack, then remove the right child from stack, 
	push the current node back and set currentNode as currentNode 's right child.
	Else print currentNode 's data and set currentNode as NULL.
	Repeat steps 2 and 3 while stack is not empty.*/
	public void postorder() {
		if (root == null) return;

		Stack<Node> stack = new Stack<Node>();
		Node current = root;

		while (true) {
			if (current != null) {
				if (current.right != null)
					stack.push(current.right);
				stack.push(current);
				current = current.left;
				continue;
			}
			if (stack.isEmpty())
				return;
			current = stack.pop();
			if (current.right != null && !stack.isEmpty() && current.right == stack.peek()) {
				stack.pop();
				stack.push(current);
				current = current.right;
			} else {
				System.out.print(current.data + " ");
				current = null;
			}
		}
	}
	
	
	//use this
	public List<Integer> postorderTraversal(Node root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) return res;
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node temp = stack.peek();
			if (temp.left == null && temp.right == null) {
				Node pop = stack.pop();
				res.add(pop.data);
			} else {
				if (temp.right != null) {
					stack.push(temp.right);
					temp.right = null;
				}
				if (temp.left != null) {
					stack.push(temp.left);
					temp.left = null;
				}
			}
		}
		return res;
	}
	
	//http://www.geeksforgeeks.org/iterative-postorder-traversal/
	public static void postOrderIterative(Node root){
	        // Create two stacks
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
	 
	        if (root == null) return;
	 
	        // push root to first stack
	        s1.push(root);
	         
	        // Run while first stack is not empty
	        while (!s1.isEmpty()) {
	            // Pop an item from s1 and push it to s2
	        	Node temp = s1.pop();
	            s2.push(temp);
	         
	            // Push left and right children of removed item to s1
	            if (temp.left != null)
	                s1.push(temp.left);
	            if (temp.right != null)
	                s1.push(temp.right);
	        }
	 
	        // Print all elements of second stack
	        while (!s2.isEmpty())  {
	        	Node temp = s2.pop();
	            System.out.print(temp.data + " ");
	        }
	    }
	/*
	 * random node
	 */
	public static void printInorderRec(TreeNode root){
		if(root == null) return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(stack.isEmpty() && root != null){
			if(root.left != null){
				stack.push(root.left);
			}else{
				root = stack.pop();
				System.out.print("[ " + root.data);
				if(root.random != null){
					System.out.print(" " + root.random.data + " ], ");
				}else{
					System.out.print(" Null], ");
				}
				root = root.right;
			}
		}
		printInorder(root.left);
		System.out.print("[ " + root.data);
		if(root.random != null){
			System.out.print(" " + root.random.data + " ], ");
		}else{
			System.out.print(" Null], ");
		}
		System.out.println();
		printInorder(root.right);
	}
	
	/*
	 * https://www.geeksforgeeks.org/reverse-level-order-traversal/
	 * Print reverse Level Order
	 * There are 2 Methods : 1 -> use Queue like above and store elements in stack. print stack
	 * 2-> find height and print Time complexity : O(n2)
	 */
	public static void printReverseLevelOrder(Node root){
		int height = getHeight(root);
		for(int i = height; i >= 1; i--){
			printReverseLevel(root, height);
		}
	}
	
	public static void printReverseLevel(Node root, int level){
		if(root == null) return;
		if(level == 1){
			System.out.println(root.data);
		}else if(level > 1){
			printReverseLevel(root.left, level-1);
			printReverseLevel(root.right, level+1);
		}
	}
	public static int getHeight(Node root){
		if(root == null) return 0;
		int left = getHeight(root.right);
		int right = getHeight(root.right);
		return Math.max(left, right) + 1;
	}
}