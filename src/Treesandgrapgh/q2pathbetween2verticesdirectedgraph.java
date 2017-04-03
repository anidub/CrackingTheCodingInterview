package Treesandgrapgh;

import java.util.Iterator;
import java.util.LinkedList;

public class q2pathbetween2verticesdirectedgraph {
	private int V;
	private LinkedList<Integer> adj[];

	q2pathbetween2verticesdirectedgraph(int v) {
		// graph(int v){
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i) {
			adj[i] = new LinkedList();
		}
	}

	public void addedge(int v, int w) {
		adj[v].add(w);
	}

	public boolean isreachable(int s, int d) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[V];
		visited[s] = true;
		queue.add(s);
		Iterator<Integer> i;
		while (queue.size() != 0) {
			s = queue.poll();
			int n;
			i = adj[s].listIterator();
			while (i.hasNext()) {
				n = i.next();
				if (n == d) {
					return true;
				}
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		q2pathbetween2verticesdirectedgraph g = new q2pathbetween2verticesdirectedgraph(4);
		g.addedge(0, 1);
		g.addedge(0, 2);
		g.addedge(1, 2);
		g.addedge(2, 0);
		g.addedge(2, 3);
		g.addedge(3, 3);
		System.out.println("The size is : " + g.adj.length);
		int u = 1;
		int v = 3;
		if (g.isreachable(u, v)) {
			System.out.println("There exists a path from : " + u + " " + v);
		} else {
			System.out.println("no");
		}
		u = 3;
		v = 1;
		if (g.isreachable(u, v))
			System.out.println("There is a path from " + u + " to " + v);
		else
			System.out.println("There is no path from " + u + " to " + v);
		;
	}
}
