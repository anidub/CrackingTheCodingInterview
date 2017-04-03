package Treesandgrapgh;

import java.util.ArrayList;
import java.util.LinkedList;

import Treesandgrapgh.q3sortedarraytobst.BNode;

public class q4createlinkedlisteachdepth {
	class BNode{
		BNode left,right;
		int data;
		
		
		BNode(int d){
			left = null;
			right = null;
			data = d;
		}
		
		public void setLeft(BNode n){
			left = n;
		}
		//function to set right node
		public void setRight(BNode n){
			right = n;
		}
		//function to get left node
		public BNode getLeft(){
			return left;
		}
		//function to get right node
		public BNode getRight(){
			return right;
		}
		//function to set data to node
		public void setData(int d){
			data = d;
		}
		//function to get data from node
		public int getData(){
			return data;
		}
		
	}
	
	BNode root;
	public void createlinkedlist(BNode root, ArrayList<LinkedList<BNode>> lists, int level){
		if(root == null)
			return ;
		LinkedList<BNode> list = null;
		if(lists.size() == level){
			lists.add(list);
		}else{
			list = lists.get(level);
		}
		
		list.add(root);
		createlinkedlist(root.left, lists, level + 1);
		createlinkedlist(root.right, lists,level + 1);
	}
	
	
	public ArrayList<LinkedList<BNode>> createlinkedlist(BNode node){
		ArrayList<LinkedList<BNode>> lists = new ArrayList<LinkedList<BNode>>();
		 createlinkedlist(node,lists,0);
		 return lists;
	}
	public void insert(){
		root = new BNode(1);
		root.left = new BNode(2);
		root.right = new BNode(6);
		root.left.right = new BNode(9);
		root.left.left = new BNode(21);
		root.right.left = new BNode(33);
		
		
		
	}

	
	//method to find depth or height
	int maxDepth(BNode node) {
	    if (node == null) {
	        return (0);
	    } else {
	        // compute the depth of each subtree
	        int lDepth = maxDepth(node.left);
	        int rDepth = maxDepth(node.right);
	        // use the larger one
	        if (lDepth > rDepth)
	            return (lDepth + 1);
	        else
	            return (rDepth + 1);
	    }
	}

	public static void main(String[] args) {
		q4createlinkedlisteachdepth node = new q4createlinkedlisteachdepth();
		node.insert();
		ArrayList<LinkedList<BNode>> r = new ArrayList<LinkedList<Node>>();
		
		

	}

}
