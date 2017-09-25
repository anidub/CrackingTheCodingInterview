   package Treesandgrapgh;

import Treesandgrapgh.issymmetric.TreeNode;

public class nodeclosesttoagivenvalue {

	//find the closest node to a given value in a BST
	//http://www.geeksforgeeks.org/find-closest-leaf-binary-tree/
	
	public TreeNode getClosestNode(TreeNode root, int value){
		if(root == null) return null;
		int minDistance = Integer.MAX_VALUE;
		TreeNode closest = null;
		TreeNode node = root;
		while(node != null){
			int distance = Math.abs(node.value - value);
			if(minDistance < distance){
				minDistance = distance;
				closest = node;
			}
			if(distance == 0)
				break;
			if(node.value > value){
				node = node.left;
			}else if(node.value < value)
				node = node.right;
		}
		return closest;
	}
	
	public static void main(String[] args) {
		
	}
}