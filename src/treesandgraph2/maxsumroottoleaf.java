package treesandgraph2;


//http://www.geeksforgeeks.org/find-the-maximum-sum-path-in-a-binary-tree/
//Time Complexity: Time complexity of the above solution is O(n) as it involves tree traversal two times.
//Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.

public class maxsumroottoleaf {
	static class Maximum{
		int max_no = Integer.MIN_VALUE;
	}
	// A wrapper class is used so that max_no  can be updated among function calls.
	 Node root;
	 int max = new Maximum().max_no;
	 Node target_leaf = null;
 	
	public  void getTargetLeaf(Node node, Maximum max_sum_ref, int curr_sum){
		if (node == null) return;

		// Update current sum to hold sum of nodes on path from root to this node
		curr_sum = curr_sum + node.data;
		int a = max_sum_ref.max_no;

		// If this is a leaf node and path to this node has maximum sum so far, the n make this node  target_leaf
		if (node.left == null && node.right == null){
			if (max_sum_ref.max_no < curr_sum )  {
				max_sum_ref.max_no = curr_sum;
				target_leaf = node;
			}
		}

		// If this is not a leaf node, then recur down to find the target_leaf
		getTargetLeaf(node.left, max_sum_ref, curr_sum);
		getTargetLeaf(node.right, max_sum_ref, curr_sum);
	}

	// Returns the maximum sum and prints the nodes on max sum path
	public  int maxSumPath(){
		// base case
		if (root == null)
			return 0;
		
		// find the target leaf and maximum sum
		getTargetLeaf(root, max, 0);

		// print the path from root to the target leaf
		printPath(root, target_leaf);
		return max.max_no; // return maximum sum
	}
	
	   // A utility function that prints all nodes on the
	 // path from root to target_leaf
   public  boolean printPath(Node node, Node target_leaf)
    {
        // base case
        if (node == null)
            return false;
 
        // return true if this node is the target_leaf or
        // target leaf is present in one of its descendants
        if (node == target_leaf || printPath(node.left, target_leaf) || printPath(node.right, target_leaf))  {
            System.out.print(node.data + " ");
            return true;
        }
 
        return false;
   	}
   
   public static void main(String args[]){
	   maxsumroottoleaf tree = new maxsumroottoleaf();
       tree.root = new Node(10);
       tree.root.left = new Node(-2);
       tree.root.right = new Node(7);
       tree.root.left.left = new Node(8);
       tree.root.left.right = new Node(-4);
       System.out.println("Following are the nodes "+
                       "on maximum sum path");
       int sum = maxSumPath();
       System.out.println("");
       System.out.println("Sum of nodes is : " + sum);
   }
   ///Output:
   //Following are the nodes on the maximum sum path
  // 7 10
  // Sum of the nodes is 17
}
