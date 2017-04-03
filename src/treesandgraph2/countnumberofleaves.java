package treesandgraph2;

import java.util.LinkedList;
import java.util.Queue;

public class countnumberofleaves {
	
	public int countleaves(Node root){
		if(root == null)
			return 0;	
			
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		int leafcount = 0;
		while(q.size() != 0){
			Node node = q.pop();
			if(node.left != null){
				q.add(node.left);
			}
			if(node.right != null){
				q.add(node.right);
			}
			if(node.left == null && node.right == null)
			leafcount++;
		}
		return leafcount;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
