package treesandgraph2;

import java.util.LinkedList;

public class NumberofNodes {

	//https://www.zybuluo.com/xmruibi/note/56634

	//number of nodes

	public int findnumberofNodes(Node root){
			if(root == null) return 0;
			int nodecount = 0;
			
			LinkedList<Node> q = new LinkedList<Node>();
			q.add(root);
			
			while(!q.isEmpty()){
				Node node = q.pop();
				nodecount++;
				if(node.left != null){
					q.add(node.left);
				}
				if(node.right != null){
					q.add(node.right);
				}
			}
			return nodecount;
				
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
