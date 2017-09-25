package Treesandgrapgh;
public class morrisInorderTraversal {	
	/* Function to traverse binary tree without recursion and without stack */
/*	http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
		Using Morris Traversal, we can traverse the tree without using stack and recursion using O(1) of space.
Time Complexity : how many times a tree node will be traversed. As it is constant(3 times for a binary tree).O(n).*/
	public static void MorrisTraversal(Node root) {
		Node current, pre;
		if (root == null)
			return;
		current = root;
		while (current != null) {
			if (current.left == null) {
				System.out.print(current.data + " ");
				current = current.right;
			} else {
				/* Find the inorder predecessor of current */
				pre = current.left;
				while (pre.right != null && pre.right != current)
					pre = pre.right;

				/* Make current as right child of its inorder predecessor */
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				}
				// Revert the changes made in if part to restore the original
				// tree i.e.,fix the right child of predecssor
				else {
					pre.right = null;
					System.out.print(current.data + " ");
					current = current.right;
				} /* End of if condition pre->right == NULL */

			} /* End of if condition current->left == NULL */
		} /* End of while */
	}
	
		public static void main(String[] args){
			Node root = new Node(1);
			root.left = new Node(2);
			root.left.left = new Node(4);
			root.left.right = new Node(5);
			root.right = new Node(3);
			MorrisTraversal(root);
		}
}
