package treesandgraph2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class printVerticalOrder {
//http://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
	//O(nlogn)
/*	Time Complexity of hashing based solution can be considered as O(n) under the assumption that we have good hashing function that allows insertion and retrieval operations in O(1) time.
	In the above C++ implementation, map of STL is used. 
	map in STL is typically implemented using a Self-Balancing Binary Search Tree where all operations take O(Logn) time.
	Therefore time complexity of above implementation is O(nLogn)*/
	public static void main(String[] args){
		  Node root = new Node(1);
	        Node node2 = new Node(2);
	        Node node4 = new Node(4);
	        Node node5 = new Node(5);
	        Node node3 = new Node(3);
	        Node node6 = new Node(6);
	        Node node7 = new Node(7);
	        Node node8 = new Node(8);
	        Node node9 = new Node(9);
	        root.left = node2;
	        root.right = node3;
	        node2.left = node4;
	        node2.right = node5;
	        node3.left = node6;
	        node3.right = node7;
	        node6.right = node8;
	        node7.right = node9;
	        // tree constructed
	        printVertical(root);
	}
	public static  void printVertical(Node n){
		Map<Integer, ArrayList<Integer>> hm = new TreeMap<Integer, ArrayList<Integer>> ();
		int horizontalDistance = 0;
		
		getVerticalOrder(n, hm , horizontalDistance);
		
		for(Entry<Integer, ArrayList<Integer>> entry : hm.entrySet()){
			ArrayList<Integer> list = entry.getValue();
			for(int i : list) System.out.print(i + " ");
			System.out.println();
		}
		
	}

	public static void getVerticalOrder(Node n, Map<Integer, ArrayList<Integer>> hm, int horizontalDistance){
		if(n != null){	
			ArrayList<Integer> list = hm.get(horizontalDistance);
			if(list == null){
				list = new ArrayList<Integer>();
				hm.put(horizontalDistance, list);
			}
				list.add(n.data);
			
			getVerticalOrder(n.left, hm, horizontalDistance - 1);
			getVerticalOrder(n.right, hm, horizontalDistance + 1);
		}
	}
}



