package Treesandgrapgh;

import situations.trails.Node;
import situations.trails.TreeNode;

public class lowestcommonancestor {
//time complexity of the above solution is O(n)
	static class Node {
		int data;
		Node left, right;
		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	public static class BinaryTree {

		//Root of the Binary Tree
		Node root;

		Node findLCAUtil(boolean v1, boolean v2, int n1, int n2) {
			return findLCAUtil(root, v1, v2, n1, n2);
		}
		// This function returns pointer to LCA of two given values n1 and n2.
		// v1 is set as true by this function if n1 is found
	// v2 is set as true by this function if n2 is found
	Node findLCAUtil(Node node, boolean v1, boolean v2, int n1, int n2) {
			// Base case
			if (node == null) {
				return null;
			}

			// If either n1 or n2 matches with root's key, report the presence
			// by setting v1 or v2 as true and return root (Note that if a key
			// is ancestor of other, then the ancestor key becomes LCA)
			if (node.data == n1) {
				v1 = true;
				return node;
			}
			if (node.data == n2) {
				v2 = true;
				return node;
			}
			// Look for keys in left and right subtrees
			Node left_lca = findLCAUtil(node.left, v1, v2, n1, n2);
			Node right_lca = findLCAUtil(node.right, v1, v2, n1, n2);

			// If both of the above calls return Non-NULL, then one key
			// is present in once subtree and other is present in other,
			// So this node is the LCA
			if (left_lca != null && right_lca != null) {
				return node;
			}
			// Otherwise check if left subtree or right subtree is LCA
			return (left_lca != null) ? left_lca : right_lca;
		}

		// Returns true if key k is present in tree rooted with root
		boolean find(Node node, int k) {
			// Base Case
			if (root == null) {
				return false;
			}

			// If key is present at root, or in left subtree or right subtree,
			// return true;
			if (node.data == k || find(node.left, k) || find(node.right, k)) {
				return true;
			}

			// Else return false
			return false;
		}

		// This function returns LCA of n1 and n2 only if both n1 and n2 are present
		// in tree, otherwise returns NULL;
		Node findLCA(int n1, int n2) {
			return findLCA(root, n1, n2);
		}

		Node findLCA(Node node, int n1, int n2) {
			// Initialize n1 and n2 as not visited
			boolean v1 = false, v2 = false;

			// Find lca of n1 and n2 using the technique discussed above
			Node lca = findLCAUtil(v1, v2, n1, n2);

			// Return LCA only if both n1 and n2 are present in tree
			if (v1 && v2 || v1 && find(lca, n2) || v2 && find(lca, n1)) {
				return lca;
			}

			// Else return NULL
			return null;
		}
		/* Driver program to test above functions */

		public static void main(String args[]) {
			BinaryTree tree = new BinaryTree();
			tree.root = new Node(1);
			tree.root.left = new Node(2);
			tree.root.right = new Node(3);
			tree.root.left.left = new Node(4);
			tree.root.left.right = new Node(5);
			tree.root.right.left = new Node(6);
			tree.root.right.right = new Node(7);
			Node lca = tree.findLCA(4, 5);
			if (lca != null) {
				System.out.println("LCA(4, 5) = " + lca.data);
			} else {
				System.out.println("Keys are not present");
			}
			lca = tree.findLCA(4, 10);
			if (lca != null) {
				System.out.println("LCA(4, 10) = " + lca.data);
			} else {
				System.out.println("Keys are not present");
			}

		}
		
		//works///tested for all cases
		//http://stackoverflow.com/questions/1484473/how-to-find-the-lowest-common-ancestor-of-two-nodes-in-any-binary-tree/5000698#5000698
		//O(N)
		public static Node findLCA(Node root, Node p, Node q) {
			// no root no LCA.
			if (root == null) 	return null;
			// if either p or q is the root then root is LCA.
			if (root == p || root == q) return root;
			else {
				// get LCA of p and q in left subtree.
				Node l = findLCA(root.left, p, q);
				// get LCA of p and q in right subtree.
				Node r = findLCA(root.right, p, q);
				// if one of p or q is in left subtree and other is in right then root it the LCA.
				if (l != null && r != null) {
					return root;
				}
				// else if l is not null, l is LCA.
				else if (l != null) {
					return l;
				} else {
					return r;
				}
			}
		}
	}
	
	//iterative //http://articles.leetcode.com/lowest-common-ancestor-of-a-binary-tree-part-ii
	public static int getHeight(TreeNode p) {
		  int height = 0;
		  while (p != null) {
		    height++;
		    p = p.parent;
		  }
		  return height;
		}
		 
		// As root->parent is NULL, we don't need to pass root in.
		TreeNode LCA(TreeNode p, TreeNode q) {
		  int h1 = getHeight(p);
		  int h2 = getHeight(q);
		  // swap both nodes in case p is deeper than q.
		  if (h1 > h2) {
		    swap(h1, h2);
		    swap(p, q);
		  }
		  // invariant: h1 <= h2.
		  int dh = h2 - h1;
		  for (int h = 0; h < dh; h++)
		    q = q.parent;
		  while (p != null && q != null) {
		    if (p == q) return p;
		    p = p.parent;
		    q = q.parent;
		  }
		  return null;  // p and q are not in the same tree
		}

}
