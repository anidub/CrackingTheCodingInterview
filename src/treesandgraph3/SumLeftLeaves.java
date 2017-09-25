package treesandgraph3;

import java.util.LinkedList;
import java.util.Queue;

import Treesandgrapgh.issymmetric.TreeNode;
/*
 * http://www.geeksforgeeks.org/find-sum-left-leaves-given-binary-tree/
 */
public class SumLeftLeaves {

	public static void main(String[] args) {
		System.out.println("hello");
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(9);
		root.right = new TreeNode(49);
		root.left.right = new TreeNode(12);
		root.left.left = new TreeNode(5);
		root.right.left = new TreeNode(23);
		root.right.right = new TreeNode(52);
		root.left.right.right = new TreeNode(12);
		root.right.right.left = new TreeNode(50);
		System.out.println(sumLeftIterative(root));
	}
	
	public static  boolean isLeaf(TreeNode node){
		if(node == null) return false;
		if(node.left == null && node.right == null)
			return true;
		return false;
	}
	
	public static int sumLeft(TreeNode node){
		int result = 0;
		if(node == null) return result;
		
		if(isLeaf(node.left))
			result += node.left.value;
		else
			result += sumLeft(node.left);
		
		result += sumLeft(node.right);
		return result;
	}
	
	public static int sumLeftIterative(TreeNode node){
		int result = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(node);
		
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			if(temp.left != null){
				if(isLeaf(temp.left))
					result += temp.left.value;
				else
					queue.add(temp.left);
			}
			if(temp.right != null){
				queue.add(temp.right);
			}			
		}
		return result;
	}
}