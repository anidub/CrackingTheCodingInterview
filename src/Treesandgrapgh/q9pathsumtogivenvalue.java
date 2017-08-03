package Treesandgrapgh;

import java.util.LinkedList;
//https://github.com/wzhishen/cracking-the-coding-interview/blob/master/src/chap04/Q9.java
public class q9pathsumtogivenvalue {
	public static class TreeNode{
		TreeNode right,left;
		int data;
	
	public TreeNode(){
		left = null;
		right = null;
		data = 0;
	}
	
	public TreeNode(int n ){
		data = n;
		left = null;
		right = null;
	}
	
	public void setRight(TreeNode n){
		right = n;
	}
	
	public void setLeft(TreeNode n){
		left = n;
	}
	
	public void setData(int n){
		data = n;
	}
	
	public int getdata(){
		return data;
	}
	
	public TreeNode getleft(){
		return left;
	}
	
	public TreeNode getright(){
		return right;
	}
		
	}
	//: O(n log n)
	public static LinkedList<LinkedList<TreeNode>> findSumPaths(TreeNode root, int target) {
        LinkedList<LinkedList<TreeNode>> result = new LinkedList<LinkedList<TreeNode>>();
        findSumPaths(root, target, new LinkedList<TreeNode>(), result);
        return result;
    }
	
	@SuppressWarnings("unchecked")
    private static void findSumPaths(TreeNode n, int target, LinkedList<TreeNode> path, LinkedList<LinkedList<TreeNode>> result) {
        if (n == null) return;
        path.add(n);
        int sum = 0;
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        for (int i = path.size() - 1; i >= 0; --i) {
            TreeNode node = path.get(i);
            nodes.add(node);
            sum += node.data;
            if (sum == target) {
                result.add((LinkedList<TreeNode>) nodes.clone());
            }
        }
        findSumPaths(n.left,  target, path, result);
        findSumPaths(n.right, target, path, result);

        // "Pop" recursion stack top.
        // Alternatively, clone path when passing it in recursive
        // calls, or use native array to hold path.
        path.removeLast();
    }	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1), 
				n2 = new TreeNode(2), n3 = new TreeNode(3),
                n4 = new TreeNode(4), n5 = new TreeNode(5), n6 = new TreeNode(6),
                n7 = new TreeNode(7), n8 = new TreeNode(8), n9 = new TreeNode(9);
       n4.left = n5; n4.right = n2; n5.left = n1; n5.right = n3; n1.right = n8;
       n3.left = n6; n2.right = n7; n7.left = n9;
   //   TreeNode.printTree(n4);
      System.out.println();
       LinkedList<LinkedList<TreeNode>> result = findSumPaths(n4, 9);
       printResult(result);
       //result = findSumPaths(n4, 6);
       //printResult(result);
		

	}
	
	 private static void printResult(LinkedList<LinkedList<TreeNode>> result) {
	        for (LinkedList<TreeNode> path : result) {
	            for (TreeNode n : path) {
	                System.out.print(n.data + " ");
	            }
	            System.out.println();
	        }
	        System.out.println();
	    }
}
