package treesandgraph2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//wrong code

public class longestroottoleafpath {

	static Node root;
	static ArrayList<int[]> allpaths= new ArrayList<int[]>();
	
	public static void main(String[] args) {
		longestroottoleafpath tree = new longestroottoleafpath();
		
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(2);
		tree.root.right.left.left = new Node(22);
		tree.printPaths(root);
			//for(int i = 0; i < allpaths.size(); i++){
		//	for(int j = 0; j < allpaths.get(i).length; j++){
		//		System.out.print(allpaths.get(i)[j]);
		//	}
		//	System.out.println();
		//}
		/*for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}*/
		
	}

	public void printPaths(Node root){
		//int[] paths = new int[10];
		ArrayList<Integer> paths = new ArrayList<>();
		printPathsRecur(root, paths,0);
	}
	
	public void printPathsRecur(Node root, ArrayList<Integer> paths,int pathlen){
		if(root == null) return;
		int[] array = new int[10];
		Queue<Node> q =  new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node n = q.poll();
			array[pathlen] = n.data;
			pathlen++;
			if(n.left == null && n.right == null){	
				printArray(array,pathlen);
			}
			if(n.left != null) q.add(n.left);
			if(n.right != null) q.add(n.right);
		}
	}
		
	public void printArray(int[] paths, int pathlen){
		int i;
		//allpaths.add(paths) ; 
		for(i = 0; i < pathlen; i++){
			System.out.print(paths[i] + " ");
		}
		System.out.println();
		
	}
}
