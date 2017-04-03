package treesandgraph2;

//https://www.careercup.com/question?id=5670909168844800
/*Find the height difference between two nodes in a binary tree.


1
	2		3
4	     5    6	     7
			8	  9
				10
For example: For a given tree above, what would be the height difference between node 4 and node 10?*/


public class heightdiff {
	public static void main(String[] args) {
		Node a = new Node(1);	
		a.left = new Node(2);
		a.right = new Node(3);
		a.left.left = new Node(5);
		a.left.right = new Node(4);
		a.left.left.left = new Node(6);		
		System.out.println(GetHeightDifference(a, a.left,a.left.left));

	}

	public static int GetHeightDifference(Node root, Node node1, Node node2) {
		return Math.abs(GetHeight(root, node1, 0) - GetHeight(root, node2, 0));
	}

	///Return -1 if node wasn't found in tree
	public static int GetHeight(Node root, Node node, int depth) {
		if (root == null || node == null)
			return -1;
			
		if (root==node)
			return depth;
		
		return Math.max(GetHeight(root.left, node, depth+1),GetHeight(root.right, node, depth+1));
	}

}
