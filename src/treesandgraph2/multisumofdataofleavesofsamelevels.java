package treesandgraph2;

import java.util.LinkedList;
import java.util.Queue;

public class multisumofdataofleavesofsamelevels {
//Given a Binary Tree, return following value for it.
//	1) For every level, compute sum of all leaves if there are leaves at this level. Otherwise ignore it.
	//2) Return multiplication of all sums.
//http://www.geeksforgeeks.org/find-multiplication-of-sums-of-data-of-all-leaves-at-sane-levels/
	
	public static void main(String[] args) {
		
	}
	
	boolean isLeaf(Node node){
		return (node.left == null && node.right == null);	
	}
	
	public int sumandmultiplydata(Node root){
		if(root == null) return 0;
		int mul = 1;
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(root);
		while(true){
			int nodeCount = q.size();
			if(nodeCount == 0) break;
			int levelSum = 0;
			boolean leafFound = false;
			while(nodeCount > 0){
				Node node;
				node = q.poll();
				
				if(isLeaf(node)){
					leafFound = true;
					levelSum += node.data;
				}
				
				if(node.left != null){
					q.add(node.left);
				}
				if(node.right != null){
					q.add(node.right);
				}
				nodeCount--;
				
			}	
			if(leafFound){
				mul *= levelSum;
			}
		}
		return mul;
	}
}
