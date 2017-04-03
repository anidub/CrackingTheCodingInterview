package treesandgraph2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class detectcycleingraph {
//Time Complexity of this method is same as time complexity of DFS traversal which is O(V+E).
	public static void main(String[] args) {
		graph graph = new graph(4);
		 graph.addEdge(0, 1);
		 graph.addEdge(0, 2);
		 graph.addEdge(1, 2);
		 //graph.addEdge(2, 0);
		 graph.addEdge(2, 3);
		 graph.addEdge(3, 3);
		 System.out.println(isCyclic(graph));

	}
	
	public static boolean isCyclic(graph graph){
		int size = graph.adj.length;

		boolean[] visited = new boolean[size];
		//@recStack recursion stack, to check which all nodes are present 
				//on the stack
		Set<Integer> recStack = new HashSet<Integer>();
		
		for(int i = 0; i < size; i++){
			if(isCyclicUtil(graph,i,visited,recStack)) 
				return true;
		}
			return false;
	}
	
	public static boolean isCyclicUtil(graph graph,int v, boolean[] visited, Set<Integer> recStack){
		System.out.println("v : " + v + " Set : " + recStack);
		
		//if we have not visited the vertex v yet 
				//then visit the vertex v and all its adjacent vertices
		if(!visited[v]){
			//mark the vertex v to be visited
			visited[v] = true;
			recStack.add(v);
			Iterator<Integer> i;
			i = graph.adj[v].listIterator();
			while(i.hasNext()){
				int n = i.next();
				//if the adjacent node is not visited yet
				if(!visited[n]){
					if(isCyclicUtil(graph, n, visited, recStack))
						return true;
				}
				//if the node is already present on the recursion stack
				//then there is cycle add return true
				else if(recStack.contains(n))
					return true;
			}
		
		}
		//remove the node from the recursion stack
			recStack.remove(v);
			return false;
		
	}

//	Time Complexity: The program does a simple DFS Traversal of graph and graph is represented using adjacency list. So the time complexity is O(V+E)
	public boolean isCyclicUndirected(graph graph){
		int size = graph.adj.length;
		boolean[] visited = new boolean[size];
		for(int i = 0; i < size; i++){
			if(isCyclicUndirectedUtil(graph,i,visited,-1)) 
				return true;
		}
		return false;
	}
	
	public boolean isCyclicUndirectedUtil(graph graph,int v, boolean[] visited,  int parent){
		
			visited[v] = true;
			Iterator<Integer> i;
			i = graph.adj[v].listIterator();
			while(i.hasNext()){
				int n = i.next();
				// If an adjacent is not visited, then recur for that
	            // adjacent
				if(!visited[n]){
					if(isCyclicUndirectedUtil(graph,  n,visited,v))
						return true;
				}
				// If an adjacent is visited and not parent of current
	            // vertex, then there is a cycle.
				else if(n != parent)
					return true;
			}
			return false;
	}
}
