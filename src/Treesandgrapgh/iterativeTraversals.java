package Treesandgrapgh;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

import situations.Node;

public class iterativeTraversals {
	
	private Node root;

	//level order traversal
	public void byLevel(Node root){
	     Queue<Node> level  = new LinkedList<>();
	     level.add(root);
	     while(!level.isEmpty()){
	         Node node = level.poll();
	         System.out.print(node.item + " ");
	         if(node.leftChild!= null)
	         level.add(node.leftChild);
	         if(node.rightChild!= null)
	         level.add(node.rightChild);
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
/*	Create an empty stack s and Initialize current node as root
	Push the current node to s and set currentNode = currentNode.left until currentNode is NULL
	If currentNode is NULL and s is not empty then
	Pop the top node from stack and print it
	 set currentNode = currentNode.right
	go to step 2
	If stack is empty and currentNode is also null then we are done with it*/
	/** Iteratively traverses the binary tree in in-order */
	public void inorder() {
		Node node = root;
		Stack<Node> stack = new Stack<Node>();
		while (!stack.isEmpty() || node != null) {
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
	public List<Integer> postorderTraversal(TreeNode root) {
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
}
