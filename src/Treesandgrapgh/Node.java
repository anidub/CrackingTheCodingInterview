package Treesandgrapgh;

public class Node {
	
	Node left;
	Node right;
	int data;
	public Node parent;
	
	Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
}
	
	public void setData(int d){
		data = d;
	}
	public void setRight(Node right){
		right = right;
	}
	public void setLeft(Node left){
		left = left;
	}
	
	public int getData(){
		return data;
	}
	public Node getRight(){
		return right;
	}
	public Node getLeft(){
		return left;
	}

}
