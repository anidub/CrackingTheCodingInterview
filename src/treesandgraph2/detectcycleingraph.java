package treesandgraph2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class detectcycleingraph {
/*	It means exactly what it sounds like. In a directed graph, 
	direction matters. i.e. edge 2->3 means that edge is directed.
	There is only an edge from 2 to 3 and no edge from 3 to 2. T
	herefore you can go from vertex 2 to vertex 3 but not from 3 to 2.
	In undirected graph 2-3 means the edge has no direction, i.e.
	2-3 means you can go both from 2 to 3 and 3 to 2.
	Note that in the representation of your graph, if you are using an adjacency matrix,
	directed 2->3 means adj[2][3]=true but adj[3][2]=false. In undirected it means adj[2][3]=adj[3][2]=true.*/	
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
		//@recStack recursion stack, to check which all nodes are present on the stack
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
//http://www.geeksforgeeks.org/detect-cycle-undirected-graph/	
	public boolean isCyclicUndirected(graph graph){
		int size = graph.adj.length;
		boolean[] visited = new boolean[size];
		for(int i = 0; i < size; i++){
			if (!visited[i])
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
			/*	For every visited vertex ‘v’, if there is an adjacent ‘u’ such that u is 
				already visited and u is not parent of v, then there is a cycle in graph. 
				If we don’t find such an adjacent for any vertex, we say that there is no cycle. */
				else if(n != parent)
					return true;
			}
			return false;
	}
}
