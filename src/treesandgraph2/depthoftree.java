package treesandgraph2;

import java.util.LinkedList;
import java.util.Queue;

public class depthoftree {
	
	public int depth(Node root) {
		if (root == null)
			return 0;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		int height = 0;

		while (true) {
			int nodecount = q.size();
			if (nodecount == 0) {
				return height;
			}
			height++;

			while (nodecount > 0) {
				Node node = q.peek();
				q.remove();
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
				nodecount--;
			}
		}
	}
	
	public static int heightRecursive(Node root){
		int left = heightRecursive(root.left);
		int right = heightRecursive(root.right);
		return Math.max(left, right) + 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
