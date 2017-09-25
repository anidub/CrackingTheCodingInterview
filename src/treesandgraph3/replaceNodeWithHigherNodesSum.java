package treesandgraph3;

import Treesandgrapgh.issymmetric.TreeNode;

public class replaceNodeWithHigherNodesSum {
/*
 * 
Given a BST, replace each node with the sum of the values of all the nodes that are greater than that node. 
Only constraint being that I was not allowed to use any global or static variable.
https://www.careercup.com/question?id=5687202134622208
Here is a solution that takes O(n) time: 
The idea is that we recurse the tree and we go updating every node's value. 
We pass a parameter called greater, which stores the sum of the values that are greater than the current node 
(and are coming from a different part of the tree). So when we call the recursion on a left subtree, 
we pass to it the sum of the nodes that a greater than it (but not part of this left subtree). 
Also, the recursive function returns the sum of the nodes in the tree, 
which we use to calculate the new values of the nodes.
 */
	public static void main(String[] args) {
		
	}
	
	public void change(TreeNode root){
		 changeValue(root, 0);
	}
	
	public int changeValue(TreeNode root, int greater){
		if(root == null) return 0;
		int temp = root.value;
		int right = changeValue(root.right, greater);
		if(right + greater > root.value){
			root.value = right + greater;
		}
		int left = changeValue(root.left, root.value + temp);
		return left + temp + right;
	}
}