package treesandgraph2;



public class maxdiffnodeancestor {
//Given a binary tree, we need to find maximum value we can get by subtracting value of node B from value of node A,
//where A and B are two nodes of the binary tree and A is an ancestor of B. 
	//http://www.geeksforgeeks.org/maximum-difference-between-node-and-its-ancestor-in-binary-tree/
	public static void main(String[] args) {
		Node n = new Node(10);
		n.left = new Node(8);
		n.left.left = new Node(1);
		n.right = new Node(3);
		n.right.right = new Node(7);
		n.right.left = new Node(10);
		System.out.println(maxDiff(n));
	}

	public static int maxDiff(Node root){
		int result = Integer.MIN_VALUE;
		return maxdiffUtil(root,result);
	}
	
	

	public static int maxdiffUtil(Node root, int result){
		   /* Returning Maximum int value if node is not there (one child case)  */
		if(root == null) return Integer.MAX_VALUE;
		
		
		 /* If leaf node then just return node's value  */
		if(root.left == null && root.right == null) return root.data;
		
		/* Recursively calling left and right subtree for minimum value  */
		int val = Math.min(maxdiffUtil(root.left,result), maxdiffUtil(root.right, result));
		
		/* Updating res if (node value - minimum value from subtree) is bigger than res  */
		result = Math.max(val, root.data);
		
		/* Returning minimum value got so far */
		return Math.min(val, root.data);
	}
	
	/*
	public static int maxDiff(Node root){
		Integer maxDiff = new Integer(Integer.MIN_VALUE);
		int m;
		Diff(root,root.data,maxDiff);
		m = maxDiff;
		return m;
	}
	*/
	
	public static void Diff(Node root, int a, int maxDiff){
		if(root != null){
			int diff;
			a = a > root.data ? a : root.data;
			
			if(root.left != null){
				diff = a - root.left.data;
				maxDiff = diff > maxDiff ? diff : maxDiff;
			}
			
			if(root.right != null){
				diff = a - root.right.data;
				maxDiff = diff > maxDiff ? diff : maxDiff;
			}
			
			Diff(root.left, a, maxDiff);
			Diff(root.right, a, maxDiff);	
		}
		
	}
}
