package treesandgraph2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class allpathsfromroottoleaf {
//Time Complexity: O(nlog(n))
	 static Node root;
/*Given a binary tree, print out all of its root-to-leaf  paths, one per line. Uses a recursive helper to do the work.*/
	 //http://www.geeksforgeeks.org/given-a-binary-tree-print-all-root-to-leaf-paths/
	 //https://www.interviewbit.com/problems/root-to-leaf-paths-with-sum/
	 public static void printPaths(Node node) {
		 ArrayList<Integer> path = new ArrayList<>();
		 printPathsRecur(node, path);
   }
/* Recursive helper function -- given a node, and an array containing the path from the root node up to but not including this node, print out all the root-leaf paths.*/
	 public static void printPathsRecur(Node node, ArrayList<Integer> path) {
	        if (node == null) {
	            return;
	        }	 
	        /* append this node to the path array */
	        path.add(node.data);
	 
	        /* it's a leaf, so print the path that led to here  */
	        if (node.left == null && node.right == null) {
	            printArray(path);
	        } else {
	            /* otherwise try both subtrees */
	            printPathsRecur(node.left, new ArrayList(path));
	            printPathsRecur(node.right, new ArrayList(path));
	        }
	    }
	 
	    /* Utility function that prints out an array on a line. */
  public static void printArray(ArrayList<Integer> path) {
 		for (int i : path) {
           System.out.print(i + " ");
       }
       System.out.println("");
   }
	public static void main(String[] args) {
		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);
		n.left.left = new Node(4);
		printPaths(n);
		 printAllPathToLeafNonRecursive(n);
	}
	
	void printPaths(Node node, String str) {
		if (node == null)	return;
		if (node.left == null && node.right == null) {
			System.out.print(str + " " + node.data);
			System.out.println();
			return;
		}
		printPaths(node.left, str + " " + node.data);
		printPaths(node.right, str + " " + node.data);
	}
	
	//works
	/*public static void RoottoPathPrint(Node root) {
	    Stack<Object> stack = new Stack<Object>();
	    if (root == null)
	        return;
	    stack.push(root.getdata() + "");
	    stack.push(root);
	    while (!stack.isEmpty()) {
	        Node temp = (Node) stack.pop();
	        String path = (String) stack.pop();

	        if (temp.getright() != null) {
	            stack.push(path + temp.getright().getdata());
	            stack.push(temp.getright());
	        }
	        if (temp.getleft() != null) {
	            stack.push(path + temp.getleft().getdata());
	            stack.push(temp.getleft());
	        }
	        if (temp.getleft() == null && temp.getright() == null) {
	            System.out.println(path);
	        }
	    }
	}*/
	
	
	public static void printAllPathToLeafNonRecursive(Node root) {
		if (root == null) {			
			return;		
		}

		Queue<Object> q = new LinkedList<Object>();
		q.add(root);
		q.add(root.data + "");

		while (!q.isEmpty()) {
			Node head = (Node) q.poll();
			String headPath = (String) q.poll();

			if (head.left == null && head.right == null) {
				System.out.println(headPath);
				continue;
			}

			if (head.left != null) {
				String leftStr = headPath + "->" + head.left.data;
				q.add(head.left);
				q.add(leftStr);
			}

			if (head.right != null) {
				String rightStr = headPath + "->" + head.right.data;
				q.add(head.right);
				q.add(rightStr);
			}
		}
	}
}
