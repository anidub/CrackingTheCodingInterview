package treesandgraph2;

import java.util.Iterator;
import java.util.LinkedList;

public class traverseagraph {

	private int v;
	LinkedList<Integer> adj[];
	
	public traverseagraph(int V) {
		v = V;
		//adj = new LinkedList<Integer>[V];	
		for(int i = 0; i < V;i++){
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int u, int w){
		adj[u].add(w);
	}
	
	public void traversegraph(int v){
		boolean[] visited = new boolean[v];
		dfsutil(v,visited);
	}
	
	public void dfsutil(int v, boolean[] visited){
		visited[v] = true;
		System.out.println(v + " ");
		Iterator<Integer> it = adj[v].listIterator();
		while(it.hasNext()){
			int n = it.next();
			if(!visited[n]){
				dfsutil(n,visited);
			}
		}
	}	
	public static void main(String args[])
    {
		traverseagraph g = new traverseagraph(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.traversegraph(2);
    }
}