package treesandgraph2;

import java.util.LinkedList;
import java.util.Queue;

public class CommonAncestorofMultipleNodes {
//find the least common ancestor of a set of nodes..career cup //https://www.careercup.com/question?id=12174686
	
	public static void main(String[] args) {
		Node n = new Node(1);
		n.left = new Node(2);
		n.left.left = new Node(4);
		n.left.right = new Node(8);
		n.left.right.right = new Node(18);
		n.right = new Node(3);
		n.right.left = new Node(10);
		n.right.right = new Node(11);
		display(n);
		int[] key = {18,8,4};
		Node ca = findCA(n,key);
		System.out.println("the ca is : " + ca.data);
	}
	
	public static void display(Node n){
		Queue<Node> q = new LinkedList<Node>();
		q.add(n);
		while(!q.isEmpty()){
			int nodecount = q.size();
			while(nodecount > 0){
				Node node = q.remove();
				System.out.print(node.data+" ");
				if(node.left != null) q.add(node.left);
				if(node.right != null) q.add(node.right);
				nodecount--;
			}
			System.out.println(" ");
		}
	}
	
	public static Node findCA(Node n, int[] key){
		if(n == null) return n;
		int i,j;
		for(i = 0; i < key.length; i++){
			if(!contains(n.left,key[i])) break;
		}
		if(i == key.length) return findCA(n.left,key);
		for(j = 0; j < key.length;j++){
			if(!contains(n.right,key[j])) break;
		}
		if(j == key.length) return findCA(n.right,key);
		return n;
		
	}
	
	public static boolean contains(Node n, int k){
		if(n == null) return false;
		if(n.data == k) return true;
		return contains(n.left,k) || contains(n.right,k);
	}

}
