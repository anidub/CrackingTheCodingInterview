package treesandgraph2;

import java.util.Iterator;
import java.util.Stack;

public class graphtopologicalsort {

	public void topological(){
		Stack stack = new Stack();
		boolean[] visited = new boolean[V];
		for(int i =0 ; i < V;i++){
			visited[i] = false;
		}
		for(int i = 0; i < V;i++){
			if(visited[i] == false){
				topoligicalsort(i,visited,stack);
			}
		}	
		while(!stack.isEmpty()){
			System.out.print(stack.pop() + " ");
		}
}
	
	public void topological(int v, boolean[] visited, Stack stack){
		int i;
		visited[v] = true;
		Iterator<Integer> it = adj[v].ListIterator();
		while(it.hasNext()){
			i = it.next();
			if(!visited[i]){
				topological(i,visited,stack);
			}
		}
		stack.push(v);
	}
	public static void main(String[] args) {


	}

}
