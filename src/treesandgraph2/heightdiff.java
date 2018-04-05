package treesandgraph2;

import java.util.LinkedList;
import java.util.Queue;

import Linkedlist.Linkedlist;

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
		int diff = Math.abs(getheightiterative(root, node1) - getheightiterative(root, node2));
		int a1 = getheightiterative(root, node1) ;
		int a2 = getheightiterative(root, node2) ;
		System.out.println(diff);
		int d1 = GetHeight(root, node1, 0);
		int d2 = GetHeight(root, node2, 0);
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
	
	public static int getheightiterative(Node root, Node node){
		if(root == null || node == null) return -1;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int height = 0;
		while(!queue.isEmpty()){
			int nodecount = queue.size();
			if(nodecount == 0) return height;
			height++;
			while(nodecount > 0){
				Node temp = queue.poll();
				if(temp == node) return height;
				if(temp.left != null) queue.add(temp.left);
				if(temp.right != null) queue.add(temp.right);
				nodecount--;
			}
		}
		return height;
	}
}
