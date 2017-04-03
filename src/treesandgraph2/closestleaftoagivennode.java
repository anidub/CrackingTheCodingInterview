	package treesandgraph2;

public class closestleaftoagivennode {
//Given a Binary Tree and a node x in it, 
//	find distance of the closest leaf to x in Binary Tree. If given node itself is a leaf, then distance is 0.
//http://www.geeksforgeeks.org/closest-leaf-to-a-given-node-in-binary-tree/	
	//http://ideone.com/JyUKcr
	//Time Complexity of this above solution is O(n) as it does at most two traversals of given Binary Tree.
	//Result stores the leaf node
	
	public static void findLeafDown(Node root, int lev, int minDistance,Node result){
		if(root == null) return;
		if(root.left == null && root.right == null){
			if(lev < minDistance){
				minDistance = lev;
				return;
			}
		}
		
		Node result1 = null, result2 = null;
		int ld = Integer.MAX_VALUE, rd = Integer.MAX_VALUE;
		if(ld <= rd) {
			if(ld < minDistance) {
				minDistance = ld;
				result = result1;
			}
		}
		else {
			if(rd < minDistance) {
				minDistance = rd;
				result = result2;
			}
		}
		findLeafDown(root.left, lev + 1, minDistance,result);
		findLeafDown(root.right, lev + 1, minDistance,result);
	}
	
	public static int findThroughParent(Node root, Node x, int minDistance,Node result){
		if(root == null) return -1;
		if(root == x) return 0;
		
		int l = findThroughParent(root.left,x,minDistance,result);
		if(l != -1){
			// Find closest leaf in right subtree
			findLeafDown(root.right, l+2,minDistance,result);
			return l+1;
		}
		
		int r = findThroughParent(root.right, x, minDistance,result);
		if(r != -1){
			findLeafDown(root.left, r+2, minDistance,result);
			return r+1;
		}
		return -1;
			
	}

	public static 	int minimumDistance(Node root, Node x,Node result){
		int minDistance = Integer.MAX_VALUE;
		findLeafDown(x,0, minDistance,result);
		findThroughParent(root, x, minDistance,result);
		return minDistance;
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
	    
	    Node result = null;
	    System.out.println(minimumDistance(root, x,result));
	
	}

}
