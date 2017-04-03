package treesandgraph2;

import java.util.LinkedList;

public class graph {
	int v;
	LinkedList<Integer> adj[];
	
	public graph(int V){
		this.v = V;
		adj = new LinkedList[v];
		for(int i = 0; i < V; i++){
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
	}
}	
