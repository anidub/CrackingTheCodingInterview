package treesandgraph2;

import java.util.LinkedList;
import java.util.Queue;

public class maxinTree {

	public static int findMax(Node node){
		if(node == null) return -1;
		int max = Integer.MIN_VALUE;
		int leftmax = findMax(node.getleft());
		int rightmax = findMax(node.getright());
		if(leftmax > rightmax)
			max = leftmax;
		else
			max = rightmax;
		if(node.getdata() > max)
			max = node.data;
		return max;
	}
		
	public static void findmMaxIteration(Node node){
		if(node == null) return ;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		Node max = node;
		while(queue.size() != 0){
			Node temp = queue.remove();
			if(temp.getdata() > max.getdata())
				max = temp;
			if(temp.getleft() != null)
				queue.add(temp.getleft());
			if(temp.getright() != null)
				queue.add(temp.getright());
		}
		System.out.println(max.getdata());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
