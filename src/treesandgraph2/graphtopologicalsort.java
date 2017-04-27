package treesandgraph2;

import java.util.Iterator;
import java.util.Stack;

public class graphtopologicalsort {
//http://www.geeksforgeeks.org/topological-sorting/
/*	Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that 
	for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for
	a graph is not possible if the graph is not a DAG.
	For example, a topological sorting of the following graph is “5 4 2 3 1 0”. There 
	can be more than one topological sorting for a graph. For example, another topological sorting 
	of the following graph is “4 5 2 3 1 0”. The first vertex in topological sorting is always
	a vertex with in-degree as 0 (a vertex with no in-coming edges).	*/
	public void topological(graph graph){
		Stack stack = new Stack();
		int size = graph.adj.length;
		boolean[] visited = new boolean[size];
		for(int i =0 ; i < size;i++){
			visited[i] = false;
		}
		for(int i = 0; i < size;i++){
			if(visited[i] == false){
				topoligicalsort(i,graph, visited,stack);
			}
		}	
		while(!stack.isEmpty()){
			System.out.print(stack.pop() + " ");
		}
}
	
	public void topoligicalsort(int v, graph graph, boolean[] visited, Stack stack){
		int i;
		visited[v] = true;
		Iterator<Integer> it = graph.adj[v].listIterator();
		while(it.hasNext()){
			i = it.next();
			if(!visited[i]){
				topoligicalsort(i,graph, visited,stack);
			}
		}
		stack.push(v);
	}
	public static void main(String[] args) {


	}

}
