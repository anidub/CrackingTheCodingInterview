package treesandgraph3;
/*
 * https://www.careercup.com/question?id=13307664
 * A node of a binary tree has two pointers left and right and two data fields- left count and right count. left count specifies the number of nodes 
 * in left of the node and right specifies the number of nodes in right of the node. Write an algorithm to populate the data fields of all the nodes of the tree.
 */
public class populateLeftAndRightCountOfNode {

	protected class Node{
		int data;
		int leftCount; int rightCount;
		Node left; Node right;
		
		public Node(int data){
			this.data = data;			
		}
		public Node(Node right, Node left, int data){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void populate(Node root){
		if(root == null) return;
		populate(root.left);
		populate(root.right);
		if(root.left != null)
			root.leftCount = root.left.leftCount + root.left.rightCount + 1;
		else
			root.leftCount = 0;
		
		if(root.right != null)
			root.rightCount = root.right.leftCount + root.right.rightCount + 1;
		else
			root.rightCount = 0;
	}
}