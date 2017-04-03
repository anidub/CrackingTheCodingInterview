package Treesandgrapgh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

	public class practise{

		public static Node findlca(int n1, int n2){
			return findlca(n,n1,n2);
		}
		
		private static Node findlca(Node n, int n1,int n2){
			if(n == null) return n;
			boolean v1 = false;
			boolean v2 = false;
			
			Node lca = findlcautil(v1,v2,n1,n2);
			
			if(v1 &&  v2 || v1 &&find(lca,n2) || v2 && find(lca,n1)){
				return lca;
			}
			return null;
		}
		
		public static boolean find(Node n, int k){
			if(n == null) return false;
			
			if(n.data == k || find(n.left,k ) || find(n.right, k)){
			return true;
			}
			return false;
		}
		
		public static Node findlcautil(boolean v1, boolean v2, int n1, int n2){
			return findlcautil(n, v1, v2, n1, n2);
		}
		
		public static Node findlcautil(Node n,boolean v1, boolean v2, int n1 , int n2){
			if(n.data == n1){
				v1 = true;
				return n;
			}
			if(n.data == n2){
				v2 = true;
				return n;
			}
			
			Node leftlca = findlcautil(n.left, v1, v2, n1, n2);
			Node rightlca = findlcautil(n.right, v1, v2, n1, n2);
			
			if(leftlca != null && rightlca != null)
				return n;
			if(leftlca != null)
				return leftlca;
			return rightlca;
		}
	static Node n;
	
	
	public static LinkedList<LinkedList<Node>> findsumpath(Node root, int target){
		LinkedList<LinkedList<Node>> result = new LinkedList<LinkedList<Node>>();
		findsum(root, target, new LinkedList<Node>(), result);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public static void findsum(Node root, int target, LinkedList<Node> path, LinkedList<LinkedList<Node>> result){
		if(root == null) return;
		path.add(root);
		LinkedList<Node> nodes = new LinkedList<Node>();
		int sum = 0;
		for(int i = path.size() - 1; i >= 0; --i){
			Node node = path.get(i);
			nodes.add(node);
			sum = sum + node.data;
			if(sum == target){
				result.add((LinkedList<Node>) nodes.clone());
			}
		}
		findsum(root.left, target, path,result);
		findsum(root.right, target, path, result);
		
		path.removeLast();
	}
	
	
	
	
	public boolean isSymmetric(Node node){
		if(node == null) return true;
		boolean result = false;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(node.left);
		queue.offer(node.right);
		
		while(!queue.isEmpty()){
			Node left = queue.poll();
			Node right = queue.poll();
			
			if(left == null && right == null) result = true;
			else if(left == null || right == null || left.data != right.data){ result = false; break;}
			
			else if(left != null && right != null){
				queue.offer(left.left);
				queue.offer(right.right);
				
				queue.offer(left.right);
				queue.offer(right.left);
			}
			
		}
		return result;
	}
	
	public Node closest(Node root, int value){
		if(root == null) return null;
		int minDistance = Integer.MIN_VALUE;
		Node closest = null;
		Node node = root;
		while(node != null){
			int distance = Math.abs(node.data - value);
			if(minDistance < distance){
				minDistance = distance;
				closest = node;
			}
			if(distance == 0) break;
			if(node.data > value) node = node.left;
			else if(node.data < value) node = node.right;
		}
		return closest;
	}
	

	

	
	public static void main(String args[])
	{
		Node n = new Node(1);
		
		practise practise = new practise();
		ArrayList<LinkedList<Node>> r = new ArrayList<LinkedList<Node>>();
		//r = practise.makelistnodesatdfs(n);
				
		
	}
		
	

}
