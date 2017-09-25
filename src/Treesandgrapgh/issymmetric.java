package Treesandgrapgh;

import java.util.LinkedList;
import java.util.Queue;

public class issymmetric {
	
	public static class TreeNode{
		public int value;
		public TreeNode left; public TreeNode right;
		
		public TreeNode(int value){
			this.value = value;
		}
		public TreeNode(TreeNode right, TreeNode left, int value){
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	public static boolean isSymmetric(TreeNode root){
		if(root == null)
			return true;
		return isSymmetric(root.left,root.right);
	}
	
	public static boolean isSymmetric(TreeNode left, TreeNode right){
		if(left == null && right == null) return true;
		if(left == null || right == null) return false;
		if(left.value != right.value)
			return false;
		if(!isSymmetric(left.left,right.right))
			return false;
		if(!isSymmetric(left.right, right.left))
			return false;
		
		return true;
	}
	
	TreeNode root;
	
	public static boolean isSymmetricIterative(TreeNode root){
		boolean result = false;
		if(root == null) return result = true;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root.left);
		queue.offer(root.right);
		while(!queue.isEmpty()){
			TreeNode left = queue.poll();
			TreeNode right = queue.poll();
			if(left == null && right == null){
				result = true;
			}else if(left == null || right == null || left.value != right.value){
				result = false;
				break;
			}else if(left != null && right != null){
				queue.offer(left.left);
				queue.offer(right.right);
				
				queue.offer(left.right);
				queue.offer(right.left);
			}
		}
		return result;
	}
		
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1), n2 = new TreeNode(2), n3 = new TreeNode(3), n4 = new TreeNode(4), n5 = new TreeNode(5); 
		n1.left = n2;
		n2.right = n3;
		n1.right = n4;
		n2.left = n5;
		boolean issymetric = isSymmetric(n1);
	}
}