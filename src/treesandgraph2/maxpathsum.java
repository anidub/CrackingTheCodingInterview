package treesandgraph2;

public class maxpathsum {
//Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.
	//http://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
/*	For each node there can be four ways that the max path goes through the node:
		1. Node only
		2. Max path through Left Child + Node
		3. Max path through Right Child + Node
		4. Max path through Left Child + Node + Max path through Right Child

		The idea is to keep trace of four paths and pick up the max one in the end. 
		An important thing to note is, 	root of every subtree need to return maximum path sum such that 
		at most one child of root is involved. This is needed for parent function call.*/
	//Time Complexity: O(n) 
	public int maxPathSum(Node root) {
		int max[] = new int[1]; 
		max[0] = Integer.MIN_VALUE;
		calculateSum(root, max);
		return max[0];
	}
	 
	public int calculateSum(Node root, int[] max) {
		if (root == null)
			return 0;
	 //  // l and r store maximum path sum going through left and right child of root respectively
		int left = calculateSum(root.left, max);
		int right = calculateSum(root.right, max);
		
	 // Max path for parent call of root. This path must  include at-most one child of root
		int current = Math.max(root.data, Math.max(root.data + left, root.data + right));
	 
		// Max Top represents the sum when the Node under consideration is the root of the maxsum path and no ancestors of root are there in max sum path
		int maxtop = Math.max(current, left + root.data + right);
		max[0] = Math.max(max[0], maxtop);
	 
		return current;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
