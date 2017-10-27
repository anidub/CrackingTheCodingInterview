package treesandgraph2;

import java.util.ArrayList;

public class normaltreetoBST {
	ArrayList<Node> store = new ArrayList<Node>();
	public Node treetoBST(Node root){
		storeNode(root);
		int size = store.size();
		Node n = treetoBSTutil(store,0,size-1);
		return n;
	}
	
	public void storeNode(Node root){
		if(root == null) return;
		storeNode(root.left);
		store.add(root);
		storeNode(root.right);
	}
	
	public Node treetoBSTutil(ArrayList<Node> store, int start, int end){
		if(store == null) return null;
		if(start > end) return null;
		int mid = (end-start)/2;
		Node n = store.get(mid);
		n.left = treetoBSTutil(store, start,mid-1);
		n.right = treetoBSTutil(store,mid+1,end);
		return n;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}