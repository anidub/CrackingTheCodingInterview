package treesandgraph3;

import treesandgraph2.Node;

public class printNodesAtDistanceKFromNode {
/*
 * http://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
 * http://www.geeksforgeeks.org/print-nodes-distance-k-leaf-node/ : not covered
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 *  Recursive function to print all the nodes at distance k in tree (or subtree) rooted with given root.
	 */
	public void printKDown(Node root, int k){
		if(root == null || k < 0) return;
		if(k == 0){
			System.out.print(root.data);
			System.out.println(" ");
			return;
		}
		printKDown(root.left, k-1);
		printKDown(root.right, k-1);		
	}
	/*
	 * Prints all nodes at distance k from a given target node.The k distant nodes may be upward or downward.This function
 Returns distance of root from target node, it returns -1 if target node is not present in tree rooted with root.
	 */
	public int printKDistanceNode(Node root, Node target, int k){
		if(root == null) return -1;
		
		 // If target is same as root.  Use the downward function to print all nodes at distance k in subtree rooted with target or root
		if(root == target){
			printKDown(root, k);
		}		
		
		int dLeft = printKDistanceNode(root.right, target, k);
		   // Check if target node was found in left subtree
		if(dLeft != -1){
			  // If root is at distance k from target, print root.Note that dl is Distance of root's left child from target
			if(dLeft + 1 == k){
				System.out.print(root.data);
				System.out.println();
			}
            // Else go to right subtree and print all k-dl-2 distant nodes .Note that the right child is 2 edges away from left child
			else{
				printKDown(root.left, k - dLeft - 2);
			}
			// Add 1 to the distance and return value for parent calls
			return dLeft + 1;
		}
		
		int dRight = printKDistanceNode(root.right, target, k);
		if(dRight != -1){
			if(dRight + 1 == k){
				System.out.print(root.data);
				System.out.println(" ");
			}else{
				printKDown(root.left, k - dRight - 2);
			}
			return dRight + 1;
		}
		return -1;
	}

}
