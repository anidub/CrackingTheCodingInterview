package treesandgraph2;

import java.util.LinkedList;
import java.util.Queue;


public class mirror {

	public static void main(String[] args) {
		Node a = new Node(1);	
		a.left = new Node(2);
		a.right = new Node(3);
		a.left.left = new Node(5);
		a.left.right = new Node(4);

		Node b = new Node(1);
		b.left = new Node(3);
		b.right = new Node(2);
		b.right.left = new Node(5);
		b.right.right = new Node(4);
		System.out.println(isMirror(a, b));

	}

	public static boolean isMirror(Node a, Node b) {
		Queue<Node> q = new LinkedList<Node>();
		/*q.add(a.left);
		q.add(b.right);*/
		q.add(a);q.add(b);
		boolean result = true;
		while (q.size() > 0) {
			Node aa = q.poll();
			Node bb = q.poll();
			if (aa == null && bb == null) result = true;
			if (aa.data != bb.data || aa == null || bb == null) {
				result = false;
				break;
			}
			
			if (aa.left != null)
				q.add(aa.left);
			if (bb.right != null)
				q.add(bb.right);
			if (aa.right != null)
				q.add(aa.right);
			if (bb.left != null)
				q.add(bb.left);
		}
		return result;
	}
}
