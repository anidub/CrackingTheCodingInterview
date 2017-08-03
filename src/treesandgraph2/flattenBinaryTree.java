package treesandgraph2;

import java.util.Stack;
//http://n00tc0d3r.blogspot.com/2013/03/flatten-binary-tree-to-linked-list-in.html
public class flattenBinaryTree {
	
	public static void flatten(Node root) {		 
	    if (root == null) return;
	    Node node = root;
	    while (node != null) {
	        // Attatches the right sub-tree to the rightmost leaf of the left sub-tree:
	        if (node.left != null) {
	        	Node rightMost = node.left;
	            while (rightMost.right != null) {
	                rightMost = rightMost.right;
	            }
	            rightMost.right = node.right;
	            // Makes the left sub-tree to the right sub-tree:
	            node.right = node.left;
	            node.left = null;
	        }
	        // Flatten the rest of the tree:
	        node = node.right;
	    }     
	}
	
	 public Node flattenRecursive(Node root) {  
		  if (root == null) return root;  
		  Node rtree = root.right;  
		   if (root.left != null) {  
		     root.right = root.left;  
		     root.left = null;  
		     root = flattenRecursive(root.right);  
		   }  
		   if (rtree != null) {  
		     root.right = rtree;  
		     root = flattenRecursive(root.right);  
		   }  
		   return root;   
		 } 
	 
	 public void flattenNonRecursiveWithStack(Node root) {  
		 Node cur = root;  
		   Stack<Node> rtrees = new Stack<Node>();  
		   while (cur != null) {  
		     while (cur.left != null) {  
		       if (cur.right != null) rtrees.push(cur.right);  
		       cur.right = cur.left;  
		       cur.left = null;  
		       cur = cur.right;  
		     }  
		     if (cur != null && cur.right == null && !rtrees.isEmpty()) {  
		       cur.right = rtrees.pop();  
		     }  
		     cur = cur.right;  
		   }  
		 }  

	 //studied -->	 
	 public void flattenIterative(Node root) {  
		   Node cur = root;  
		   while (cur != null) {  
		     if (cur.left != null) {  
		       if (cur.right != null) { // if we need to prune a right subtree
		         Node next = cur.left;  
		         while (next.right != null) next = next.right;  
		         next.right = cur.right;  
		       }
		       cur.right = cur.left;  
		       cur.left = null;  
		     }  
		     cur = cur.right;  
		   }  
	}
	 
	public static void main(String[] args) {
		Node treeNode = new Node(5);
		Node treeNode1 = new Node(3);
		Node treeNode2 = new Node(4);
		treeNode.left = treeNode1;
		treeNode.right = treeNode2;
		//treeNode.flattenBinaryTree(treeNode);
		flatten(treeNode);
		System.out.print(treeNode.data + " ");
		while(treeNode.right != null){
			System.out.print(treeNode.right.data + " ");
			treeNode = treeNode.right;
		}
	}
}
