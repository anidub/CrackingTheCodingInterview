package treesandgraph2;

import java.util.LinkedList;
import java.util.Queue;

public class printlevelnodesatseplevel {
///print nodes
	//http://algorithms.tutorialhorizon.com/level-order-traversal-print-each-level-in-separate-line/
	//Level Order Traversal, Print each level in separate line.

	public static void printlevel(Node root){
		if(root == null) return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			int nodecount = q.size();
			while(nodecount > 0){
				Node n = q.remove();
				if(n.left != null) q.add(n.left);
				if(n.right != null)q.add(n.right);
				System.out.print(n.data + " ");
				nodecount--;
			}
			System.out.println(" ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n = new Node(10);
		n.left = new Node(11);
		n.right = new Node(12);
		n.left.left = new Node(13);
		printlevel(n);
	}

}
