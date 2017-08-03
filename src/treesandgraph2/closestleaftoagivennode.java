package treesandgraph2;

public class closestleaftoagivennode {
//Given a Binary Tree and a node x in it, 
//	find distance of the closest leaf to x in Binary Tree. If given node itself is a leaf, then distance is 0.
//http://www.geeksforgeeks.org/closest-leaf-to-a-given-node-in-binary-tree/	
	//http://ideone.com/JyUKcr
	//Time Complexity of this above solution is O(n) as it does at most two traversals of given Binary Tree.
	//Result stores the leaf node
	
	public static void findLeafDown(Node root, int lev,  Distance minDistance){
		if(root == null) return;
		if(root.left == null && root.right == null){
			if(lev < minDistance.minDis){
				res = root.data;
				minDistance.minDis = lev;
				return;
			}
		}
		findLeafDown(root.left, lev + 1, minDistance);
		findLeafDown(root.right, lev + 1, minDistance);
	}
	
	public static int findThroughParent(Node root, Node x, Distance minDistance){
		if(root == null) return -1;
		if(root == x) return 0;
		
		int l = findThroughParent(root.left,x,minDistance);
		if(l != -1){
			// Find closest leaf in right subtree
			findLeafDown(root.right, l+2,minDistance);
			return l+1;
		}
		
		int r = findThroughParent(root.right, x, minDistance);
		if(r != -1){
			findLeafDown(root.left, r+2, minDistance);
			return r+1;
		}
		return -1;			
	}

	private static class Distance {
	    int minDis = Integer.MAX_VALUE;
	}
	static int res;
	
	public static int minimumDistance(Node root, Node x/*,Node result)*/){
		  // Initialize result (minimum distance from a leaf)
        Distance d = new Distance();  
		findLeafDown(x,0, d);
		findThroughParent(root, x, d);	
		return d.minDis;
	}
		
	
	public static void main(String[] args) {
		Node root  = new Node(1);
	    root.left  = new Node(12);
	    root.right = new Node(13);
	 
	    root.right.left   = new Node(14);
	    root.right.right  = new Node(15);
	 
	    root.right.left.left   = new Node(21);
	    root.right.left.right  = new Node(22);
	    root.right.right.left  = new Node(23);
	    root.right.right.right = new Node(24);
	 
	    root.right.left.left.left  = new Node(1);
	    root.right.left.left.right = new Node(2);
	    root.right.left.right.left  = new Node(3);
	    root.right.left.right.right = new Node(4);
	    root.right.right.left.left  = new Node(5);
	    root.right.right.left.right = new Node(6);
	    root.right.right.right.left = new Node(7);
	    root.right.right.right.right = new Node(8);
	 
	    Node x = root.right;
	    System.out.println("Distance : " + minimumDistance(root, x));	 
	    System.out.println("Leaf :" + res);	
	}
	
}
