package treesandgraph2;

import java.util.LinkedList;
import java.util.Queue;
public class longestroottoleafpath {
	static Node root;	
	public static void main(String[] args) {
		longestroottoleafpath tree = new longestroottoleafpath();		
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(2);
		tree.root.right.left.left = new Node(22);
		tree.longest(root);
	}
	
	public static void longest(Node root){
		Queue<Object> queue = new LinkedList<>();
		queue.add(root);
		queue.add(root.data+" ");
		int maxlen = 0;
		String longestpath = "";
		while(!queue.isEmpty()){
			Node node = (Node) queue.poll();
			String headstring = (String) queue.poll();
			
			if(node.left == null && node.right == null){
				//System.out.println(headstring);
				if(maxlen < headstring.length()){
					maxlen = headstring.length();
					longestpath = headstring;
				}
				continue;
			}
			
			if(node.left != null){
				String leftstring = headstring + node.left.data + " ";
				queue.add(node.left);
				queue.add(leftstring);
			}
			
			if(node.right != null){
				String rightstring = headstring + node.right.data + " ";
				queue.add(node.right);
				queue.add(rightstring);
			}
		}
		System.out.println(longestpath);
	}
}
