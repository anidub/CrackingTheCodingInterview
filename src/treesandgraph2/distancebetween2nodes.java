package treesandgraph2;

public class distancebetween2nodes {
//Find the distance between two keys in a binary tree, no parent pointers are given.
	//Distance between two nodes is the minimum number of edges to be traversed to reach one node from other.
	//http://www.geeksforgeeks.org/find-distance-two-given-nodes/
	// Time complexity of the above solution is O(n) as the method does a single tree traversal.
		public static void main(String[] args) {

		}
		
		public static int findDistance(Node root, int n1, int n2){
			if(root == null) return -1;
			int d1 = -1;
			int d2 = -1;
			int dist = -1;
			
			Node lca = findDisUtil(root,n1,n2,d1,d2,dist,1);
			if(d1 != -1 && d2 != -1){
				return dist;
			}
			// If n1 is ancestor of n2, consider n1 as root and find level 
		    // of n2 in subtree rooted with n1
			if(d1 != -1){
				dist = findLevel(lca, n2, 0);
				return dist;
			}

		    // If n2 is ancestor of n1, consider n2 as root and find level 
		    // of n1 in subtree rooted with n2
			if(d2 != -1){
				dist = findLevel(lca, n1, 0);
				return dist;
			}
			return -1;
		}

		
		public static Node findDisUtil(Node root, int n1, int n2, int d1, int d2, int dist, int lvl){
			if(root == null) return null;
			if(root.data == n1){
				d1 = lvl;
				return root;
			}
			if(root.data == n2){
				d2 = lvl;
				return root;
			}
			
			Node leftLca = findDisUtil(root.left, n1, n2, d1, d2, dist, lvl+1);
			Node rightLca = findDisUtil(root.right, n1, n2, d1, d2, dist, lvl+1);
			if(leftLca != null && rightLca != null){
				dist = d1 + d2 - 2*lvl;
				return root;
			}
			
			return leftLca != null ? leftLca : rightLca;
		}
		
		public static int findLevel(Node root, int k, int level){
			if(root == null) return -1;
			if(root.data == k) return level;
			int l = findLevel(root.left, k , level+1);
			return l != -1 ? l : findLevel(root.right, k, level+1);
		}
		
}
