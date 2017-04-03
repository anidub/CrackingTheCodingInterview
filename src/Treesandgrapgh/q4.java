package Treesandgrapgh;

import java.util.ArrayList;
import java.util.LinkedList;

import Treesandgrapgh.q4createlinkedlisteachdepth.BNode;

public class q4 {
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
	
	public ArrayList<LinkedList<BNode>> getNodesatDepthDFS(){
		ArrayList<LinkedList<BNode>> r = new ArrayList<LinkedList<BNode>>();
		makeListDFS(root, r);
		return r;
	}
	
	public int makeListDFS(BNode node, ArrayList<LinkedList<BNode>> r){
		if(node == null)
			return 0;
		int left = makeListDFS(node.left, r) + 1;
		int right = makeListDFS(node.right, r) + 1;
		int height = Math.max(left,right);
		LinkedList<BNode> ll;
		if(height == r.size() + 1){
			ll = new LinkedList<>();
			r.add(ll);
		}else
			ll = r.get(height - 1);
		ll.add(node);
		return height;	
	}
	
	public ArrayList<LinkedList<BNode>> getNodesatDepthBFS(){
		ArrayList<LinkedList<BNode>> r = new ArrayList<LinkedList<BNode>>();
		if(root == null) return r;
		LinkedList<BNode> parent = new LinkedList<>();
		parent.add(root);	
		while(!parent.isEmpty()){
			LinkedList<BNode> temp = parent;
			r.add(parent);
			parent = new LinkedList<>();
			for(BNode child : temp){
				if(child.left != null) parent.add(child.left);
				if(child.right != null) parent.add(child.right);
				
			}
		}
		return r;
	}
	
	public void insert(){
		root = new BNode(1);
		root.left = new BNode(2);
		root.left.right = new BNode(2);
		root.left.left = new BNode(2);
		root.right.left = new BNode(2);
		root.right.right = new BNode(2);	
	}

	public static void main(String[] args) {
		q4 node = new q4();
		node.insert();
		//dfs
		ArrayList<LinkedList<BNode>> list =  node.getNodesatDepthDFS();
		
		ArrayList<LinkedList<BNode>> list1 = node.getNodesatDepthBFS();
 	}

}
