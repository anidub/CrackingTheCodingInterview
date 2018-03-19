package treesandgraph2;

import java.util.LinkedList;
import java.util.Queue;

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
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.right = new Node(4);
		System.out.println(getCount(root.right));

	}
	
	
	public static Integer getCount(Node root){
		  if(root == null)
		    return 0;
		  int count = 0;
		  Queue<Node> queue = new LinkedList<Node>();
		  queue.add(root);
		  while(!queue.isEmpty()){
		    Node node = queue.poll();
		    count++;
		    if(node.left != null){
		      queue.add(node.left);
		    }
		    if(node.right != null){
		      queue.add(node.right);
		    }
		  }
		  return count;
		}

}
