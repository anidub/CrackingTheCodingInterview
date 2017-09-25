package treesandgraph2;

import java.util.LinkedList;
import java.util.Queue;

public class swap2nodes {

	public class MyTree{
		Node root;
		public boolean swapSubTrees(Node n1, Node n2){
			if(n1 == root || n2==root)
				return false;
			
			//search for parents/
			LinkedList<Node> queue = new LinkedList<Node>();
			Node p1=null, p2=null;
			Node current=root;
			if(current!=null)
				queue.add(current);
			else
				return false;
			
			while(!queue.isEmpty()){
				Node cur = queue.remove();
				if(cur.left == n1 || cur.right == n1) p1=cur;
				if(cur.left == n2 || cur.right == n2) p2=cur;
				if(p1 == null || p2 == null){
					if(cur.left != null)
						queue.add(cur.left);
					if(cur.right != null)
						queue.add(cur.right);
				}
				else break;
			}
			
			if(p1==null || p2==null)return false;
			else{
				if(p1.left == n1)
					p1.left = n2;
				else 
					p1.right = n2;
				if(p2.left == n2)
					p2.left = n1;
				else
					p2.right = n1;
			}
			return true;
	       }
		public class TreeNode<K,V>{
			K key;
			V val;
			TreeNode left;
			TreeNode right;
			/* Assume appropriate constructors and insert fns exist*/
	        }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
